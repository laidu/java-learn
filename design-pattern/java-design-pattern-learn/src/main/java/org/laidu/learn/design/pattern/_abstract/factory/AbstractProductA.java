package org.laidu.learn.design.pattern._abstract.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象工厂
 * <p>
 * Created by 臧天才 on 2017-09-01 18:10.
 */
@Slf4j
//  : 2017-09-01 18:10  抽象产品
public abstract class AbstractProductA {

    private BrandName brandName;
    protected ColorType color;

    AbstractProductA(ColorType color, BrandName brandName) {
        this.color = color;
        this.brandName = brandName;
    }

    public enum ColorType {

        RED,
        BLACK,
        BLUE,
        YELLOW;
    }

    public enum BrandName{
        APPLE,
        SAMSUNG,
        DELL
    }
}
