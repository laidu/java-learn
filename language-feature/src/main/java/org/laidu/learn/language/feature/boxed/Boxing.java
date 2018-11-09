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
        int i = 10;
        Integer j = 10;

        int k = 222;
        Integer l = 222;

        System.out.println("i == j :"+(i == j));

        System.out.println("k == l : "+(k == l));

    }
}
