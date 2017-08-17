package org.laidu.learn.language.feature.default_.method;

/**
 * 带有默认方法的接口A
 * <p>
 * Created by 臧天才 on 2017-08-17 14:11.
 */
public interface InterfaceB {

    default void sayHello(){
        System.out.println("InterfaceB");
    }
    void sayBye();

    void sayGood();
}
