package com.jianlinsheng.myline.handler;



import com.jianlinsheng.myline.constant.MessageConstant;
import com.jianlinsheng.myline.exception.BaseException;
import com.jianlinsheng.myline.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }


    @ExceptionHandler
    public Result exceptionHandlerSql(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
       if (message.contains("Duplicate entry")){
           String[] msgs = message.split(" ");
           String name = msgs[2];
           String msg = name + MessageConstant.ALREADY_EXIT;
           return Result.error(msg);
       }else{
           return Result.error(MessageConstant.UNKNOWN_ERROR);
       }

    }

}
