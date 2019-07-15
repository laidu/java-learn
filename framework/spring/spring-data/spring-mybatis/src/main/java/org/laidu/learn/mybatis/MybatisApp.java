package org.laidu.learn.mybatis;

import org.laidu.learn.swagger.demo.config.SwaggerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * org.laidu.learn.amqp.Application
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-11-28 16:35
 */
@MapperScan("org.laidu.learn.mybatis.mapper")
@SpringBootApplication
@EnableSwagger2
@Import(SwaggerConfig.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MybatisApp {

    public static void main(String[] args){
        SpringApplication.run(MybatisApp.class);
    }

}