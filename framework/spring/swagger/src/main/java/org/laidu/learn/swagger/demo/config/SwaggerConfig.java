package org.laidu.learn.swagger.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-10 21:55
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("'${spring.profiles.active}' == 'default' || '${spring.profiles.active}' == 'dev' || '${spring.profiles.active}' == 'test'")
public class SwaggerConfig {
    @Bean
    @ConditionalOnBean(SwaggerConfig.class)
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}