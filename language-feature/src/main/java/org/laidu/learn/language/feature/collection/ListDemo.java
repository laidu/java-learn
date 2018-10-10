package org.laidu.learn.language.feature.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * list learn
 *
 * @author tiancai.zang
 * 2018-01-19 15:40.
 */
@Slf4j
public class ListDemo {


    public static void main(String[] args) {


        int initSize = 8;

        List<Integer> list = new ArrayList<>(initSize);

        IntStream.range(0,99999).boxed()
                .forEach(e -> {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                    }

                    list.add(e);
                });


    }
}