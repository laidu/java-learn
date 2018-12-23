package org.laidu.learn.language.feature.container;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.IntStream;

/**
 * container test
 *
 * @author tiancai.zang
 * 2018-02-03 16:04.
 */
@Slf4j
public class ContainerTest {
    // TODO: 2018-02-03 16:04  container test

    @Test
    void test(){

        Map<String,Set<String>> map = new HashMap<>();

        String key = "a";
        map.put("a", new CopyOnWriteArraySet<>());
        log.info(" size  : {}", map.get(key).size());

        Set<String> strings = map.get(key);
        strings.add("123");

        log.info(" 's value : {}", map.get(key).size());

        IntStream.range(0,100).boxed().forEach(var -> map.get(key).add(""+var));

        log.info(" 's value : {}", map.get(key).size());


    }
}