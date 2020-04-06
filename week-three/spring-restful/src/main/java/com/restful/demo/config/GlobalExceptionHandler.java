package com.restful.demo.config;

import com.restful.demo.common.ErrorResponseEntity;
import com.restful.demo.common.ExceptionType;
import com.restful.demo.exception.CustomException;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutorCompletionService;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//    定义要捕获的异常可以多个@EXCEPTIONHANDLER({})
    @ExceptionHandler(CustomException.class)
    public ErrorResponseEntity customExceptionHandler(
            HttpServletRequest request, final Exception e,
            HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_GATEWAY.value());
        CustomException exception=(CustomException) e;
        return new ErrorResponseEntity(exception.getCode(),exception.getMessage());
    }
//    捕获RuntimeException异常
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request,final Exception e,
                                                       HttpServletResponse response){
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        RuntimeException exception=(RuntimeException) e;
        return new ErrorResponseEntity(ExceptionType.SERVER_ERROR.getCode(),
                ExceptionType.SERVER_ERROR.getMsg());
    }
//    通过的接口映射异常处理
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request){
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception=(MethodArgumentNotValidException)ex;
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
                    exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),status);
        }
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception=(MethodArgumentNotValidException) ex;
            logger.error("参数错误，方法:"+exception.getParameter().getMethod().getName()+",参数："+exception
            +",信息："+exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(),"参数错误"),status);
        }
        return new ResponseEntity<>(new ErrorResponseEntity(status.value(),"参数错误"),status);
    }

}
