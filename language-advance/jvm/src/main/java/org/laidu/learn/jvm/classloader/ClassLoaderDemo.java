package org.laidu.learn.jvm.classloader;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * class loader
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 16:20.
 */
@Slf4j
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    }

    @Data
    public static class Person {
        private String name;
        private int grander;
    }

}