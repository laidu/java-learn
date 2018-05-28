package org.laidu.learn.spring.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro config
 * <p>
 * Created by tiancai.zang
 * on 2018-05-08 23:35.
 */
@Slf4j
@Configuration
public class ShiroConfig {

    @Value("${shiro.config.ini.file:classpath:shiro.ini}")
    private String shiroIniPath;

    @Bean
    public Realm realm(){

        return new IniRealm(shiroIniPath);
    }


}