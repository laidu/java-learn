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

    @PostMapping("/test")
    public String test(@RequestBody byte[] bodyByte){

//        byte[] entryptionByte = "MTczNDY1MTkxNDM6cTExMTExMTExMQ==".getBytes();
//        int index = ArraysUtil.indexOf(body,entryptionByte);
//
//        byte[] byte1 = ArraysUtil.subarray(body,0,index);
////        byte[] byte2 = ArraysUtil.subarray(body,index+entryptionByte.length,body.length);
//        byte[] byte2 = ArraysUtil.remove(body,0,170);
//
//        System.out.println(Base64.encodeToString(byte1));
//        System.out.println(Base64.encodeToString(byte2));
//
//
//        return new String(body);

        return new String(bodyByte);
    }


}