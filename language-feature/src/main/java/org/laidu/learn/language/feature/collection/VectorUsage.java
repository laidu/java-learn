package org.laidu.learn.language.feature.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.stream.IntStream;

/**
 * vector 使用
 *
 * @see java.util.Vector
 * @author tiancai.zang
 * on 2018-08-27 17:33.
 */
@Slf4j
public class VectorUsage {

    public static void main(String[] args) {

        Vector<String> strings = new Vector<>(100,200);

        IntStream.range(0,1000)
                .boxed()
                .map(String::valueOf)
                .forEach(strings::add);

        System.out.println(strings.size());

        strings.forEach(System.out::println);


    }
}