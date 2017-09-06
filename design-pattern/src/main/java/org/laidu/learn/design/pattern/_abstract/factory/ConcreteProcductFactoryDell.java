package org.laidu.learn.design.pattern._abstract.factory;


import lombok.extern.slf4j.Slf4j;

/**
 * 具体的 蓝色产品 工厂类
 * <p>
 * Created by 臧天才 on 2017-09-06 10:44.
 */
//  : 2017-09-06 10:44  具体的 蓝色产品 工厂类
@Slf4j
public class ConcreteProcductFactoryDell extends AbstractFactory{


    @Override
    public AbstractProductA createProductA() {
        log.info("-*--*--*--*- dell 生产 ProductA -*--*--*--*--");
        return new ConcreteProductA(AbstractProductA.ColorType.RED,AbstractProductA.BrandName.DELL);
    }

    @Override
    public ConcreteProductB createProductB() {
        log.info("-*--*--*--*- dell 生产 ProductB -*--*--*--*--");
        return new ConcreteProductB(AbstractProductB.ProductName.TV);
    }
}
