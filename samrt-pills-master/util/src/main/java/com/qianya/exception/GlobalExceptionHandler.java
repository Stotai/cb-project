package com.qianya.exception;

import com.alibaba.fastjson.JSONObject;
import com.qianya.common.JsonResult;
import com.qianya.util.*;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

public class GlobalExceptionHandler {

	private static String errorContent="服务器闭关中，请稍后再试";

	private static MongoTemplate mongoTemplate;
	/**
	 * 
	 * @Title: errorHandler 
	 * @Description: 服务层异常处理
	 * @author Sunt.
	 * @time 2019年12月8日 下午5:43:25
	 * @return JsonResult    返回类型 
	 * @throws
	 */
	public static JsonResult errorHandler(MongoTemplate newMongoTemplate,HttpServletRequest request, Exception e) throws Exception {
		if (mongoTemplate==null){
			mongoTemplate=newMongoTemplate;
		}
	    String timestampStr = "";
        String timestamp = request.getHeader("request_timestamp");
        if (StringUtil.isNotEmpty(timestamp)) {
            timestamp = timestamp.replace(".", "");
            timestampStr = String.valueOf(System.currentTimeMillis()-Long.parseLong(timestamp));
        }
		if (e instanceof NoHandlerFoundException) {
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			return commonReturnError(JsonResult.CODE_404, "你访问的东西不存在",request,e,true);
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			HttpRequestMethodNotSupportedException ex = (HttpRequestMethodNotSupportedException) e;
			String msg = "不支持["+ex.getMethod()+"]请求";
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			LogUtil.info(GlobalExceptionHandler.class, msg);
			return commonReturnError(JsonResult.CODE_400, msg,request,e,true);
		} else if (e instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException ex = (MissingServletRequestParameterException) e;
			String msg = "参数["+ex.getParameterName()+"]不能为空";
			LogUtil.info(GlobalExceptionHandler.class, msg);
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			return commonReturnError(JsonResult.CODE_400, msg,request,e,true);
		} if (e instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException) e;
            String needName = ex.getRequiredType().getName();
            String msg = "参数["+ex.getName()+"]类型转换错误,需要的类型为："+needName.substring(needName.lastIndexOf(".")+1)+",值为："+ex.getValue();
            LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
            LogUtil.info(GlobalExceptionHandler.class, msg);
            return commonReturnError(JsonResult.CODE_400, msg,request,e,true);
        } else if (e instanceof ClientAbortException) {
            ClientAbortException ex = (ClientAbortException) e;
            String needName = ex.getMessage();
            LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                LogUtil.info(GlobalExceptionHandler.class, name + "\t--->\t" + request.getParameter(name));
            }
            LogUtil.info(GlobalExceptionHandler.class, "客户端终止连接："+needName);
            return commonReturnError(JsonResult.CODE_500, errorContent,request,e,true);
        } else if (e instanceof CustomException) {
			CustomException ex = (CustomException) e;
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                LogUtil.info(GlobalExceptionHandler.class, name + "\t--->\t" + request.getParameter(name));
            }
            LogUtil.info(GlobalExceptionHandler.class, "自定义异常处理："+ex.getInMsg());
            return commonReturnError(JsonResult.CODE_500, StringUtil.isEmpty(ex.getOutMsg()) ? errorContent : ex.getOutMsg(),request,e,ex.getIsEmail());
        } else {
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			Enumeration<String> names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				LogUtil.info(GlobalExceptionHandler.class, name + "\t--->\t" + request.getParameter(name));
			}
			LogUtil.error(GlobalExceptionHandler.class, errorContent, e);
			return commonReturnError(JsonResult.CODE_500, errorContent,request,e,true);
		}
	}

	/***
	 * 公用返回错误
	 * @param code
	 * @param errorContent
	 * @param e
	 * @return
	 */
	public static JsonResult commonReturnError(Integer code,String errorContent,HttpServletRequest request,Exception e,Boolean isMail){
		if (isMail){
			MailUtil.sendEmail(mongoTemplate,"异常-服务器ip："+IpUtils.getServiceIp(),"请求路径:"+request.getRequestURI()+"<br>参数:"+JSONObject.toJSONString(request.getParameterNames())+"<br>token:"+request.getHeader("token")+"<br>请求方式："+request.getMethod()+"<br>请求格式："+request.getHeader("Content-Type")+"<br>"+request+getMessage(e));
		}
		return JsonResult.error(code, errorContent);
	}

	public static String errorHandlerWeb(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {

        String timestampStr = "";
        String timestamp = request.getHeader("request_timestamp");
        if (StringUtil.isNotEmpty(timestamp)) {
            timestamp = timestamp.replace(".", "");
            timestampStr = String.valueOf(System.currentTimeMillis()-Long.parseLong(timestamp));
        }
		LogUtil.error(GlobalExceptionHandler.class,"异常2捕获："+e.getMessage(),e);
        if (e instanceof NoHandlerFoundException) {
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			return dealMsg(request, response, JsonResult.error(JsonResult.CODE_404, "你访问的东西不存在"), "error/404");
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			HttpRequestMethodNotSupportedException ex = (HttpRequestMethodNotSupportedException) e;
			String msg = "不支持["+ex.getMethod()+"]请求";
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			LogUtil.info(GlobalExceptionHandler.class, msg);
			return dealMsg(request, response, JsonResult.error(JsonResult.CODE_400, msg), "error/500");
		} else if (e instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException ex = (MissingServletRequestParameterException) e;
			String msg = "参数["+ex.getParameterName()+"]不能为空";
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			LogUtil.info(GlobalExceptionHandler.class, msg);
			return dealMsg(request, response, JsonResult.error(JsonResult.CODE_400, msg), "error/500");
		} if (e instanceof MethodArgumentTypeMismatchException) {
			MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException) e;
			String needName = ex.getRequiredType().getName();
			String msg = "参数["+ex.getName()+"]类型转换错误,需要的类型为："+needName.substring(needName.lastIndexOf(".")+1)+",值为："+ex.getValue();
			LogUtil.info(GlobalExceptionHandler.class, msg);
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			return dealMsg(request, response, JsonResult.error(JsonResult.CODE_400, msg), "error/500");
		} else if (e instanceof CustomException) {
			CustomException ex = (CustomException) e;
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			Enumeration<String> names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				LogUtil.info(GlobalExceptionHandler.class, name + "\t--->\t" + request.getParameter(name));
			}
			LogUtil.info(GlobalExceptionHandler.class, "自定义异常处理："+ex.getInMsg());
			return dealMsg(request, response, JsonResult.error(JsonResult.CODE_400, StringUtil.isEmpty(ex.getOutMsg()) ? errorContent : ex.getOutMsg()), "error/500");
		} else if (e instanceof ClientAbortException) {
            ClientAbortException ex = (ClientAbortException) e;
            String needName = ex.getMessage();
            LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                LogUtil.info(GlobalExceptionHandler.class, name + "\t--->\t" + request.getParameter(name));
            }
            LogUtil.info(GlobalExceptionHandler.class, "客户端终止连接："+needName);
            return dealMsg(request, response, JsonResult.error(JsonResult.CODE_500, errorContent), "error/500");
        } else {
			LogUtil.info(GlobalExceptionHandler.class, "请求地址：" + request.getRequestURI() + "\t耗时："+ timestampStr + "\t参数如下：");
			Enumeration<String> names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				LogUtil.info(GlobalExceptionHandler.class, name + "\t--->\t" + request.getParameter(name));
			}
			LogUtil.error(GlobalExceptionHandler.class, errorContent, e);
			return dealMsg(request, response, JsonResult.error(JsonResult.CODE_500, errorContent), "error/500");
		}
	}
	 
	private static String dealMsg(HttpServletRequest request, HttpServletResponse response, JsonResult result, String page) {
		request.setAttribute("errorMsg", result.getMsg());
		if (AjaxUtil.isAjax(request)) {
			AjaxUtil.printAjax(response, JSONObject.toJSONString(result));
			return null;
		}
		return page;
	}
	/**
	 * 打印异常栈信息
	 */
	public static String getMessage(Exception e) {
		String swStr = null;
		try (StringWriter sw = new StringWriter();
			 PrintWriter pw = new PrintWriter(sw)) {
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			swStr = sw.toString();
		} catch (Exception ex) {
			LogUtil.info(GlobalExceptionHandler.class,ex.getMessage());
		}
		return swStr;
	}
}