package org.laidu.learn.language.feature.default_.method;


import lombok.extern.slf4j.Slf4j;

/**
 * 接口实现类
 * <p>
 * Created by 臧天才 on 2017-08-17 14:14.
 */
@Slf4j
public class ExtendClass implements InterfaceA,InterfaceB{

    @Override
    public void sayHello() {
        log.info("-*--*--*--*--*--*--*--*--*--  --*--*--*--*--*--*--*--*--*-: {}","123");

        System.out.println("123213");
    }

    public static void main(String[] args) {
        new ExtendClass().sayHello();
    }
}
