package org.laidu.learn.swagger.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.swagger.demo.dto.ProductReqDTO;
import org.laidu.learn.swagger.demo.dto.ProductResDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * home
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-10 21:43
 */
@Slf4j
@RestController
@Tag(name = "")
@RequestMapping("/")
public class HomeController {

    @GetMapping({"/","/index","/home"})
    public String home(){
        return "hello world";
    }

    @GetMapping("/query/{id}")
    public ProductResDTO query(@PathVariable String id){
        return ProductResDTO.builder()
                .id(id)
                .name("test1")
                .productDate(new Date())
                .build();
    }

    @PostMapping("/add")
    public ProductReqDTO add(@RequestBody ProductReqDTO product){
        return product;
    }

    @PostMapping("/test")
    public String test(@RequestBody byte[] bodyByte){

        log.info("body: {}", bodyByte);
        return new String(bodyByte);
    }


}