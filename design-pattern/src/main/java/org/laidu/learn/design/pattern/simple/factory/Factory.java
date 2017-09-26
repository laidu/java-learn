package org.laidu.learn.design.pattern.simple.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 简单工厂类
 * <p>
 * Created by 臧天才 on 2017-09-01 18:23.
 */
@Slf4j
//  2017-09-01 18:23  简单工厂类
public class Factory {

    public static AbstractProduct createProduct(AbstractProduct.ColorType colorType) {

        switch (colorType) {

            case RED:
                log.info("-*--*--*--*- 创建红色产品 -*--*--*--*--");
                return new ConcreteRedProduct();
            case BLUE:
                log.info("-*--*--*--*- 创建蓝色产品 -*--*--*--*--");
                return new ConcreteBlueProduct();
            case YELLOW:
                log.info("-*--*--*--*- 创建黄色产品 -*--*--*--*--");
                return new ConcreteYellowProduct();

            default:
                    throw new UnsupportedOperationException();

        }
    }
}
