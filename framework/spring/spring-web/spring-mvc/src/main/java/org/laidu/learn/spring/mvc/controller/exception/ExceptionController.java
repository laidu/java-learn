package org.laidu.learn.spring.mvc.controller.exception;

import org.laidu.learn.spring.mvc.controller.BaseController;
import org.laidu.learn.spring.mvc.exception.StorageException;
import org.laidu.learn.spring.mvc.model.Response;
import org.laidu.learn.spring.mvc.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 抛出异常controller
 *
 * @author zangtiancai
 * @date 2019-03-21 20:09.
 */
@Slf4j
@RestController
@RequestMapping("/exception")
public class ExceptionController extends BaseController {

    @Autowired
    private ExceptionService exceptionService;


    @GetMapping("/default")
    public Response<String> exception(){

        String var = null;

        log.info("var's length: {}",var.length());

        return Response.ok("exception");
    }

    @GetMapping("/null")
    public Response<String> nullException(){

        String var = null;

        log.info("var's length: {}",var.length());

        return Response.ok("exception");
    }

    @GetMapping("/callThis")
    public Response<String> callThisException(){

       return nullException();
    }

    @GetMapping("/service")
    public Response<String> serviceException(){

        return Response.ok(exceptionService.exception());
    }

    @GetMapping("/storage")
    public Response<String> storageException(){

        throw new StorageException(500,"storage exception");
    }


}
