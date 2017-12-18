package org.laidu.learn.design.pattern._abstract.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端
 * <p>
 * Created by 臧天才 on 2017-09-01 18:28.
 */
@Slf4j
public class Client {

    public static void main(String[] args) {

        AbstractProductA appleProductA = new ConcreteProcductFactoryApple().createProductA();
        AbstractProductB appleProductB = new ConcreteProcductFactoryApple().createProductB();

        AbstractProductA dellProductA = new ConcreteProcductFactoryDell().createProductA();
        AbstractProductB dellProductB = new ConcreteProcductFactoryDell().createProductB();

    }
}
