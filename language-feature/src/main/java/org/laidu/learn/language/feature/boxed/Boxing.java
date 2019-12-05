package org.laidu.learn.language.feature.boxed;

/**
 * 自动拆装箱例子
 * User: zangtiancai
 * Date: 2017/8/29
 * Time: 上午10:48
 */
public class Boxing {

    public static void main(String[] args) {

        // 装箱
        Integer i = Integer.valueOf(100);
        int j = 100;

        Integer k = 222;
        Integer l = 222;

        System.out.println("i == j :"+(i.equals(j)));

    }
}
