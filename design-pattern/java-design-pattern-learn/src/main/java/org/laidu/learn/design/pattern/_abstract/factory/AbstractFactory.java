package org.laidu.learn.design.pattern._abstract.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象工厂类
 * <p>
 * Created by 臧天才 on 2017-09-01 18:23.
 */
@Slf4j
//  2017-09-01 18:23  抽象工厂类
public abstract class AbstractFactory {

    public abstract AbstractProductA createProductA();
    public abstract ConcreteProductB createProductB();
}
