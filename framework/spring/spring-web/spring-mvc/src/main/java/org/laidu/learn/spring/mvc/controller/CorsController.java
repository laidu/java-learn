package org.laidu.learn.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跨域支持配置
 *
 * @author zangtiancai
 * @date 2019-02-18 14:01.
 */
@Slf4j
@RestController
@RequestMapping("/cors")
public class CorsController {

    @GetMapping("/serviceA")
    public ResponseEntity<String> serviceA(){

        HttpCookie cookie = ResponseCookie.from("_sid", "123456")
                .httpOnly(true)
                .maxAge(10000)
                .secure(true)
                .path("/cors/serviceA")
                .build();

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("serviceA");
    }


}
