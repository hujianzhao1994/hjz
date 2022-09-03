package com.hu.notice.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author blyp
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        //log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return e.getMessage();
    }

}
