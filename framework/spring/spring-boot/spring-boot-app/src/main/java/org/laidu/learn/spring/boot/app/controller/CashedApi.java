package org.laidu.learn.spring.boot.app.controller;

import org.laidu.learn.spring.boot.app.service.ThreadLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟内存泄漏
 *
 * @author zangtiancai.
 * @date 2019/12/23 下午9:32.
 */
@Slf4j
@RestController
@RequestMapping("/cashed")
public class CashedApi {

    @Lazy
    @Autowired
    private ThreadLocalService threadLocalService;

    @GetMapping("/threadLocal")
    public String threadLocal(@RequestParam("body") String body) {

        return threadLocalService.sayHello(body);
    }
}
