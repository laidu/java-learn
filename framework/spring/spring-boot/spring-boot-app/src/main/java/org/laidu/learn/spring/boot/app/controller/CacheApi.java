package org.laidu.learn.spring.boot.app.controller;

import org.laidu.learn.spring.boot.app.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cache")
public class CacheApi {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/cacheAll")
    public String cacheAll() {
        cacheService.aaName(12L);
        cacheService.aaName2(12L);
        cacheService.bbName(12L);
        return cacheService.bbName2(12L);
    }

    @GetMapping("/clearAa")
    public String clearAa() {
        return cacheService.aaClear(12L);
    }
}
