package org.laidu.learn.design.pattern.factory;


import lombok.extern.slf4j.Slf4j;

/**
 * 具体的 蓝色产品 工厂类
 * <p>
 * Created by 臧天才 on 2017-09-06 10:44.
 */
//  : 2017-09-06 10:44  具体的 黄色产品 工厂类
@Slf4j
public class ConcreteYellowProcductFactory implements AbstractFactory {

    @Override
    public AbstractProduct createProduct() {
        log.info("-*--*--*--*- 创建黄色产品-*--*--*--*--");
        return new ConcreteYellowProduct();
    }
}
