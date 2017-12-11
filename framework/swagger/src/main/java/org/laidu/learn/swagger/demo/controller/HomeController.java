package org.laidu.learn.swagger.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.swagger.demo.model.Product;
import org.springframework.web.bind.annotation.*;

/**
 * home
 * <p>
 * Created by tiancai.zang on 2017-12-10 21:43.
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
    public Product query(@PathVariable String id){
        return Product.builder()
                .id(id)
                .name("test1")
                .productDate(System.currentTimeMillis()+"")
                .build();
    }

    @PostMapping("/add")
    public Product add(Product product){
        return product;
    }


}