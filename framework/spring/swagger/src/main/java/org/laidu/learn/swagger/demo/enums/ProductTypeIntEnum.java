package org.laidu.learn.swagger.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 产品种类
 *
 * @author tiancai.zang
 * on 2018-10-11 17:20.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum ProductTypeIntEnum implements BasicIntEnum {

    /**
     * 手机
     */
    PHONE(1,"手机"),

    /**
     * 电脑
     */
    COMPUTER(2,"电脑"),
    ;


    private int value;
    private String name;



    @Override
    public BasicIntEnum getEnumByName(String name) {

        for (ProductTypeIntEnum anEnum : ProductTypeIntEnum.values()) {
            if (name.equalsIgnoreCase(anEnum.name)){
                return anEnum;
            }
        }

        return null;
    }

    @Override
    public BasicIntEnum getEnumByValue(Integer value) {

        for (ProductTypeIntEnum anEnum : ProductTypeIntEnum.values()) {
            if (value.equals(anEnum.value)){
                return anEnum;
            }
        }
        return null;
    }
}