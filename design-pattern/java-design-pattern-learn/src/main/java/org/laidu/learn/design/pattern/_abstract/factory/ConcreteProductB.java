package org.laidu.learn.design.pattern._abstract.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 红色产品
 * <p>
 * Created by 臧天才 on 2017-09-01 18:17.
 */
@Slf4j
public class ConcreteProductB extends AbstractProductB{

    ConcreteProductB(ProductName productName) {
        super(productName);
    }
}
