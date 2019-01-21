package org.laidu.learn.swagger.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.swagger.demo.enums.ProductTypeIntEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.util.Locale;

/**
 * mvc config
 * <p>
 * Created by tiancai.zang
 * on 2019-01-22 00:05.
 */
@Slf4j
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<ProductTypeIntEnum>() {
            @Override
            public ProductTypeIntEnum parse(String text, Locale locale) throws ParseException {
                return ProductTypeIntEnum.valueOf(text);
            }

            @Override
            public String print(ProductTypeIntEnum object, Locale locale) {
                return object.getValue()+"";
            }
        });
    }
}