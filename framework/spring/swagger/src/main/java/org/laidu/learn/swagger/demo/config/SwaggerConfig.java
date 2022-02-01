package org.laidu.learn.swagger.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-10 21:55
 */
@Configuration
//@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


//    @Bean
//    @Profile("prod")
//    public Docket apiProd() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                // 生产环境禁用swagger
//                .enable(false)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//
//    @Bean
//    @Profile({"default", "dev", "test"})
//    public Docket apiDev() {
//
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        ticketPar.name("_sid").description("_sid")
//                .parameterType("query")
//                .modelRef(new ModelRef("string"))
//                .required(false).build();
//        pars.add(ticketPar.build());
//
//
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .forCodeGeneration(true)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.laidu.learn"))
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build()
//                .globalOperationParameters(pars);
//    }


}