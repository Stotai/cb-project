package com.qianya.aspect;

import com.alibaba.fastjson.JSONObject;
import com.qianya.annotations.Log;
import com.qianya.cbEnum.BusinessStatus;
import com.qianya.common.JWTUtil;
import com.qianya.constant.MgConstant;
import com.qianya.entity.mongo.SysOperLogMoEntity;
import com.qianya.exception.CustomException;
import com.qianya.util.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
public class SysLogAspect {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private IdWorker idWorker;
    private static final Logger log = LoggerFactory.getLogger(SysLogAspect.class);

    public SysLogAspect() {
    }

    @Pointcut("@annotation(com.qianya.annotations.Log)")
    public void logPointCut() {
    }

    @AfterReturning(
            pointcut = "logPointCut()",
            returning = "jsonResult"
    )
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        this.handleLog(joinPoint, (Exception)null, jsonResult);
    }

    @AfterThrowing(
            value = "logPointCut()",
            throwing = "e"
    )
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        this.handleLog(joinPoint, e, (Object)null);
    }

    protected void handleLog(JoinPoint joinPoint, Exception e, Object jsonResult) {
        try {
            Log controllerLog = this.getAnnotationLog(joinPoint);
            if (controllerLog == null) {
                return;
            }
            BaseCommon baseCommon = new BaseCommon();
            HttpServletRequest request = baseCommon.getRequest();
            String token = request.getHeader("token");
            if (StringUtil.isEmpty(token)){
                return;
            }
            Integer userId = JWTUtil.getUserId(token);
            String username = JWTUtil.getUsername(token);
            if (StringUtil.isEmpty(username)){
                username=token;
            }
            SysOperLogMoEntity operationLog = new SysOperLogMoEntity();
            operationLog.setStatus(BusinessStatus.SUCCESS.value());
            String ip = IpUtils.getIpAddr(request);
            operationLog.setOperIp(ip);
            operationLog.setJsonResult(JSONObject.toJSONString(jsonResult));
            operationLog.setOperUrl(request.getRequestURI());
            operationLog.setOperUserName(username);
            operationLog.setOperUserId(userId);
            operationLog.setOperTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
            if (e != null) {
                operationLog.setStatus(BusinessStatus.FAIL.value());
                operationLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }

            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operationLog.setMethod(className + "." + methodName + "()");
            operationLog.setRequestMethod(request.getMethod());
            this.getControllerMethodDescription(joinPoint, controllerLog, operationLog);
            operationLog.setOperId(idWorker.nextId());
            mongoTemplate.insert(operationLog, MgConstant.SYS_OPER_LOG);
        } catch (Exception var10) {
            log.error("==前置通知异常==");
            log.error("异常信息:{}", var10.getMessage());
            var10.printStackTrace();
        }

    }

    public void getControllerMethodDescription(JoinPoint joinPoint, Log log, SysOperLogMoEntity operationLog) {
        operationLog.setBusinessType(log.businessType().ordinal());
        operationLog.setOperService(log.service());
        operationLog.setOperatorType(log.operatorType().ordinal());
        if (log.isSaveRequestData()) {
            this.setRequestValue(joinPoint, operationLog);
        }

    }

    private void setRequestValue(JoinPoint joinPoint, SysOperLogMoEntity operationLog) {
        BaseCommon baseCommon = new BaseCommon();
        HttpServletRequest request = baseCommon.getRequest();
        String requestMethod = operationLog.getRequestMethod();
        if (!HttpMethod.PUT.name().equals(requestMethod) && !HttpMethod.POST.name().equals(requestMethod)) {
            Map<?, ?> paramsMap = (Map)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            operationLog.setOperParam(StringUtils.substring(paramsMap.toString(), 0, 1000));
        } else {
            String contentType = request.getContentType();
            String params;
            if (!TUtils.isEmpty(contentType) && contentType.startsWith("multipart/form-data")) {
                params = "FILE";
            } else {
                try {
                    params = this.argsArrayToString(joinPoint.getArgs());
                } catch (IOException var7) {
                    params="参数拼装失败";
                }
            }

            operationLog.setOperParam(StringUtils.substring(params, 0, 2000));
        }

    }

    private Log getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method method = methodSignature.getMethod();
        return method != null ? (Log)method.getAnnotation(Log.class) : null;
    }

    private String argsArrayToString(Object[] paramsArray) throws IOException {
        StringBuilder params = new StringBuilder();
        if (paramsArray != null && paramsArray.length > 0) {
            Object[] var3 = paramsArray;
            int var4 = paramsArray.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Object o = var3[var5];
                if (!this.isFilterObject(o)) {
                    params.append(JSONObject.toJSONString(o)).append(" ");
                }
            }
        }

        return params.toString().trim();
    }

    public boolean isFilterObject(Object o) {
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
    }
}