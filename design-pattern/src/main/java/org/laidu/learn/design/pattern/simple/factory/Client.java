package org.laidu.learn.design.pattern.simple.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端
 * <p>
 * Created by 臧天才 on 2017-09-01 18:28.
 */
@Slf4j
public class Client {

    public static void main(String[] args) {

        AbstractProduct blueProduct = Factory.createProduct(AbstractProduct.ColorType.BLUE);

        AbstractProduct redProduct = Factory.createProduct(AbstractProduct.ColorType.RED);

        AbstractProduct yellowProduct = Factory.createProduct(AbstractProduct.ColorType.YELLOW);

    }
}
