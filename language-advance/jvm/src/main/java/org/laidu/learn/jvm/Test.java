package org.laidu.learn.jvm;


import java.io.FileNotFoundException;

/**
 * 测试
 * <p>
 * Created by 臧天才 on 2017-09-06 19:55.
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("Hello world");
        new java.io.PrintStream("Hello world").println();
    }

}
