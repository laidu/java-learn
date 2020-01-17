package org.laidu.learn.language.feature.boxed;

import java.util.Random;

import lombok.Data;

/**
 * 自动拆装箱例子
 * User: zangtiancai
 * Date: 2017/8/29
 * Time: 上午10:48
 */
public class Boxing {

    public static void main(String[] args) {

        ifNull();


    }

    /**
     * 三目运算符中触发自动拆箱
     */
    private static void ifNull() {
        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2();
        demo1.setDemo2(demo2);

        for (int i = 0; i < 100; i++) {
            Long aa = new Random().nextInt() % 2 == 0 ? Long.valueOf(1) : demo1.getDemo2().getId();
            // 会触发自动拆箱，报null
//            Long aa = new Random().nextInt() % 2 == 0 ? 1L : demo1.getDemo2().getId();
            System.out.println(aa);
        }
    }

    @Data
    public static class Demo1 {
        private Demo2 demo2;
    }

    @Data
    public static class Demo2 {
        private Long id;
    }

    private static void test1() {
        // 装箱
        Integer i = Integer.valueOf(100);
        int j = 100;

        Integer k = 222;
        Integer l = 222;

        System.out.println("i == j :"+(i.equals(j)));
    }
}
