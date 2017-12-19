package org.laidu.learn.design.pattern._abstract.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象工厂
 * <p>
 * Created by 臧天才 on 2017-09-01 18:10.
 */
@Slf4j
//  : 2017-09-01 18:10  抽象产品
public abstract class AbstractProductB {

    private ProductName productName;
    private final long productionTime = System.currentTimeMillis();

    public AbstractProductB(ProductName name) {
        this.productName = name;
    }

    public enum ProductName{
        TV
    }


}
