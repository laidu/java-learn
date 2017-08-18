package org.laidu.learn.language.feature.default_.method;


import lombok.extern.slf4j.Slf4j;

/**
 * 接口实现类
 *
 * 当一个类实现具有相同签名的默认方法的多个接口时，此类必须实现该默认方法。
 * <p>
 * Created by 臧天才 on 2017-08-17 14:14.
 */
@Slf4j
public class ExtendClass implements InterfaceA,InterfaceB{

    /**
     * InterfaceA 中提供默认实现，Interface中提供默认实现 --> sayHello()方法
     */
    @Override
    public void sayHello() {
        log.debug("-*--*--*--*--*--*--*--*--*-- sayHello --*--*--*--*--*--*--*--*--*-: {}","123");
        System.out.println("123123");
    }

    /**
     * InterfaceA 中提供默认实现，Interface中未提供默认实现 --> 继承类需要实现sayBye()方法
     */
    @Override
    public void sayBye() {
        ((InterfaceA) () -> log.debug("-*--*--*--*--*--*--*--*--*-- sayGood --*--*--*--*--*--*--*--*--*-: {}","good")).sayBye();
    }

    /**
     * InterfaceA 中未提供默认实现，Interface中未提供默认实现 --> 继承类需要实现sayGood()方法
     *
     */
    @Override
    public void sayGood() {
        log.debug("-*--*--*--*--*--*--*--*--*-- sayGood --*--*--*--*--*--*--*--*--*-: {}","good");
    }

    public static void main(String[] args) {
        new ExtendClass().sayHello();
    }
}
