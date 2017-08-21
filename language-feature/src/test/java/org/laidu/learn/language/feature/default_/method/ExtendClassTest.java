package org.laidu.learn.language.feature.default_.method;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by 臧天才 on 2017/8/18.
 */
@DisplayName("实现提供相同签名方法的默认方法实现的多接口")
class ExtendClassTest {
    @Test
    @DisplayName("")
    void sayHello() {

        new ExtendClass().sayHello();
    }

    @Test
    void sayBye() {
    }

    @Test
    void sayGood() {
    }

}