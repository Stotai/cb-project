package com.qianya.exception;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice
public class MyWebExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        return GlobalExceptionHandler.errorHandlerWeb(request, response, e);
    }

    @ExceptionHandler(ClientAbortException.class)
    public void ClientAbortErrorHandler(HttpServletRequest request, ClientAbortException e) throws Exception {
        GlobalExceptionHandler.errorHandler(null,request, e);
    }
}