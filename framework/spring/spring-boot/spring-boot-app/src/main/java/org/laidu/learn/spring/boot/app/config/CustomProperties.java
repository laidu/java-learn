package org.laidu.learn.spring.boot.app.config;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 配置demo
 * 集合类型不能用@Value进行注入，必须要通过类对象进行构造
 * @author zangtiancai.
 * @date 2019/12/20 下午12:20.
 */
@Data
@Configuration
@ConfigurationProperties("sbapp.config")
public class CustomProperties {

    private Map<String, List<String>> mapConfig;

    @PostConstruct
    public void init() {

        System.out.println(mapConfig);
    }
}
