package org.laidu.learn.language.feature.string;

import lombok.extern.slf4j.Slf4j;

/**
 * spring demo
 *
 * @author tiancai.zang
 * on 2018-10-26 12:33.
 */
@Slf4j
public class StringDemo {

    public static void main(String[] args) {


        String s = "hello";

        String s1 = new String("hello");

        System.out.println("s == s1 : " + (s == s1));

        System.out.println("s.equals(s1) : " + s.equals(s1));

    }
}