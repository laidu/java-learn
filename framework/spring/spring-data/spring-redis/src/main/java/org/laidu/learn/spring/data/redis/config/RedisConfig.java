package org.laidu.learn.spring.data.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.data.redis.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis config
 * <p>
 * Created by tiancai.zang
 * on 2018-05-22 09:59.
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, UserInfo> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, UserInfo> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

}