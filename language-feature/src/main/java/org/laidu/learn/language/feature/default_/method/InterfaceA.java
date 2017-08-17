package org.laidu.learn.language.feature.default_.method;

/**
 * 带有默认方法的接口A
 * <p>
 * Created by 臧天才 on 2017-08-17 14:11.
 */
public interface InterfaceA {

    default void sayHello(){
        System.out.println("InterfaceA ： hello");
    }

    default void sayBye(){
        System.out.println("InterfaceA ： bye");
    }

    void sayGood();
}
