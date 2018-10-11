package org.laidu.learn.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.mvc.model.Result;
import org.laidu.learn.spring.mvc.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 资源服务
 *
 * @author tiancai.zang
 * on 2018-10-11 10:39.
 */
@Slf4j
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private StorageService storageService;


    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws IOException {

        String resourceId = storageService.store(file);

        return Result.ok(resourceId);
    }

}
