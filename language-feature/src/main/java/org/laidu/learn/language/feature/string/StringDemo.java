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

        String aa = "Aa";
        String bb = "BB";

        // aa==bb : false
        log.debug("aa==bb : {}", aa==bb);

        // aa.hashCode() == bb.hashCode() : true
        log.debug("aa.hashCode() == bb.hashCode() : {}", aa.hashCode() == bb.hashCode());

        System.out.println("AA".getBytes().length);
        System.out.println("中A".getBytes().length);
    }

    public static void createString() {
        // 会在栈中创建一个对象引用变量str，然后查看字符串池中是否存在”XXX”，如果没有，则将”XXX”存放字符串池，并令引用变量str指向它；如果已经有”XXX”，则直接令str指向它
        String s = "hello";

        // 是java中标准的对象创建方式，其创建的对象将直接放置到堆中，每调用一次就会在堆上面创建一个新的对象
        String s1 = new String("hello");

        // intern() 用于返回一个String池中的对象，如果池中没有该对象则先将该String放入String池中然后返回该对象
        String s2 = new String("hello").intern();

        System.out.println("s == s1 : " + (s == s1));
        System.out.println("s == s2 : " + (s == s2));


        // System.identityHashCode(s) 获取对象内存地址，不管该对象是否重写hashCode()
        System.out.println("s\t" + System.identityHashCode(s));
        System.out.println("s1\t" + System.identityHashCode(s1));
        System.out.println("s2\t" + System.identityHashCode(s2));

        System.out.println("s.equals(s1) : " + s.equals(s1));
    }
}