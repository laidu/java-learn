package org.laidu.learn.language.feature.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
class ListStreamDemoTest {

    List<String> list;

    @BeforeEach
    void setUp() {

        list = Arrays.asList(
                "1234",
                "13",
                "133",
                "1234",
                "13",
                "133",
                "1234",
                "13",
                "133",
                "1234",
                "13",
                "133",
                "13");
    }

    @Test
    void list2String() {

        log.info("string result: {}", ListStreamDemo.list2String(list));
    }

    @Test
    void list2String2() {
        log.info("String2 result: {}", ListStreamDemo.list2String2(list));
    }
}