package com.qianya.exception;

import com.qianya.common.JsonResult;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class MyExceptionHandler {
    @Autowired
    private MongoTemplate mongoTemplate;

    @ExceptionHandler(Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        return GlobalExceptionHandler.errorHandler(mongoTemplate,request, e);
    }

    @ExceptionHandler(ClientAbortException.class)
    public void ClientAbortErrorHandler(HttpServletRequest request, ClientAbortException e) throws Exception {
        GlobalExceptionHandler.errorHandler(mongoTemplate,request, e);
    }
}