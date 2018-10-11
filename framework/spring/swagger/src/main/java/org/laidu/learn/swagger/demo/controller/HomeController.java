package org.laidu.learn.swagger.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/")
public class HomeController {

    @GetMapping({"/","/index","/home"})
    public String home(){
        return "hello world";
    }

    @GetMapping("/query/{id}")
    @ApiOperation("query product by id")
    @ApiParam(value = "id")
    @ApiResponse(code = 100, message = "123321" , response = ProductResDTO.class)
    public ProductResDTO query(@PathVariable String id){
        return ProductResDTO.builder()
                .id(id)
                .name("test1")
                .productDate(new Date())
                .build();
    }

    @PostMapping("/add")
    public ProductResDTO add(ProductResDTO product){
        return product;
    }

    @PostMapping("/test")
    public String test(@RequestBody byte[] bodyByte){

        log.info("body: {}", bodyByte);
        return new String(bodyByte);
    }


}