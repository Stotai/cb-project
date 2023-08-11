package com.qianya.aop;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qianya.common.JsonResultT;
import com.qianya.util.LogUtil;
import com.qianya.util.annotation.ParamDict;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 把内容替换为param表里的内容
 * @author Lhl
 * @Date 2020年6月15日 上午11:51:53
 */
@Aspect
//@Component
@Slf4j
public class BeforeAspect {
    private static int paramCount=0;
    // 定义切点Pointcut
    @Pointcut("execution(public * com.qianya.web.service..*.*(..))")
    public void service() {
    }

    //@Before("service()")
    public void doBefore(JoinPoint pjp) throws Throwable {
		LogUtil.info(getClass(),"开始切入.....");
    }
	//@Around("service()")
	public void doAround(ProceedingJoinPoint pjp) throws Throwable {
		LogUtil.info(getClass(),"切入中.....");
	}

	//@After("service()")
	public void doAfter(JoinPoint pjp) throws Throwable {
		LogUtil.info(getClass(),"切入完成....");
	}
	//@AfterThrowing("service()")
	public void doThrow(JoinPoint pjp) throws Throwable {
		LogUtil.info(getClass(),"方法异常了...");
	}
	//@AfterReturning("service()")
	public void doReturn(JoinPoint pjp) throws Throwable {
		LogUtil.info(getClass(),"方法完成返回了....");
	}

}
