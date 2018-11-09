package org.laidu.learn.advance.bytecode.jdk;

/**
 * hello world
 *
 * @author tiancai.zang
 * on 2018-10-26 13:23.
 */
public class Main {

    public static void main(String[] args) {

        int i = 127;
        int j = 128;
        double d = 123.123d;

        byte b = 127;

        System.out.println("int-i == byte-b : "+ (i==b));

        Integer k = 127;
        Integer l = 1290;
        l = new Integer(k);

        System.out.println(i + 1);
        System.out.println(j + 1);
        System.out.println(k + 1);
        System.out.println(l + 1);

        System.out.println("hello world!");
    }
}