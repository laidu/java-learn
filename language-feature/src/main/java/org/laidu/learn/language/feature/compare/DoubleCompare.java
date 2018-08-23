package org.laidu.learn.language.feature.compare;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * double 类型比较大小
 *
 * @author tiancai.zang
 * on 2018-08-13 10:47.
 */
@Slf4j
public class DoubleCompare {
    public static void main(String[] args) {


        double a = +0.00;
        double b = -0.00;

        for (double balance = 10; balance > 0; balance -= .2) { System.out.println(balance); }


        IntStream.range(0,100).parallel().forEach(i -> {
            if (a == b) {
                System.out.println(true);
            }else {
                System.out.println(false);
            }

        });

    }
}