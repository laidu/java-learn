package org.laidu.learn.spring.mvc.exception;

import javax.servlet.http.HttpServletRequest;

import org.laidu.learn.spring.mvc.model.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常拦截器
 *
 * @author zangtiancai
 * @date 2019-03-21 19:58.
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exceptionDefault(HttpServletRequest request, Exception e){

        return Response.builder()
                .code("E500000")
                .message("系统内部错误")
                .build();
    }

    /**
     * 最匹配原则
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Response exceptionNull(HttpServletRequest request, Exception e){

        log.error("{}",e);

        return Response.builder()
                .code("E500001")
                .message("空指针异常")
                .build();
    }
}
