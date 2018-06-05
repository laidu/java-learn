package org.laidu.learn.mybatis.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlusConfig
 * <p>
 * Created by tiancai.zang
 * on 2018-06-05 17:20.
 *
 * @author tiancai.zang
 */
@EnableTransactionManagement
@Configuration
@MapperScan("org.laidu.learn.*.mapper*")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}