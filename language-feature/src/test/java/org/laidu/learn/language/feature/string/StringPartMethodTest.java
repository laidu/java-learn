package org.laidu.learn.language.feature.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
@Slf4j
@DisplayName("java.lang.String 部分方法测试")
class StringPartMethodTest {


    @Test
    @DisplayName("java 8 新增方法")
    void join() {
        String var = "123123";

        var = String.join(":", "a","b","c");

        log.info("-*--*--*--*- var: {} -*--*--*--*--",var);
    }

    @Test
    void join1() {

        String var = "123123";

        List<CharSequence> charSequences = Arrays.asList("a","b","c");

        var = String.join("-",charSequences);

        log.info("-*--*--*--*- var: {} -*--*--*--*--",var);
    }

}