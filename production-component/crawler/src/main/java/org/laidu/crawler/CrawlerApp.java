package org.laidu.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * crawler stater
 *
 * @author tiancai.zang
 * 2018-01-09 15:28.
 */
@SpringBootApplication
public class CrawlerApp {

    @Autowired
    private  ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApp.class, args);
    }

}