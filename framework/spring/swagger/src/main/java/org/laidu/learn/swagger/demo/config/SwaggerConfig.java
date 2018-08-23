package org.laidu.learn.swagger.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-10 21:55
 */
@Configuration
public class SwaggerConfig {


    @Bean
    @Profile("prod")
    public Docket apiProd() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 生产环境禁用swagger
                .enable(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    @Profile({"default", "dev", "test"})
    public Docket apiDev() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


}