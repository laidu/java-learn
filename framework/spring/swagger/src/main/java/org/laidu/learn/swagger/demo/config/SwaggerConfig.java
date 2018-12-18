package org.laidu.learn.swagger.demo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

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

        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("_sid").description("_sid")
                .parameterType("query")
                .modelRef(new ModelRef("string"))
                .required(false).build();
        pars.add(ticketPar.build());



        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.laidu.learn"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .globalOperationParameters(pars);
    }


}