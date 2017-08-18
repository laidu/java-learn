package org.laidu.learn.language.feature.default_.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by 臧天才 on 2017/8/18.
 */
@Slf4j
@DisplayName("实现多个接口的默认方法实现")
public class ExtendClassTest {

    @Test
    @DisplayName("!!sayHello")
    void sayHello() {

        new ExtendClass().sayHello();

        System.out.println("123123");

        log.info("-*--*--*--*--*--*--*--*--*--  --*--*--*--*--*--*--*--*--*-: {}");
    }

    @Test
    void sayBye() {
    }

    @Test
    void sayGood() {
    }

}