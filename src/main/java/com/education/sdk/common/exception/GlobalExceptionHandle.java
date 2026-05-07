package com.education.sdk.common.exception;

import com.education.sdk.common.ReturnMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常处理
 * @author: wuming
 * @create: 2025-02-28 10:20:21
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ReturnMsg handle(Exception e) {
        e.printStackTrace();
        return ReturnMsg.error(e.getMessage());
    }

}
