package org.laidu.learn.spring.mvc.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.enums.NameValueEnum;

/**
 * 商品类型
 *
 * @author tiancai.zang
 * on 2018-08-23 11:35.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum  GoodsTypeEnum implements NameValueEnum<String,Integer> {

    /**
     * 书籍
     */
    BOOK(0,"书籍"),

    /**
     * 手机
     */
    PHONE(1,"手机"),

    ;
    @JsonValue
    private Integer value;

    private String name;


    @Override
    public GoodsTypeEnum getEnumByName(String name) {

        for (GoodsTypeEnum typeEnum : GoodsTypeEnum.values()) {
            if (name.equalsIgnoreCase(typeEnum.name)){
                return typeEnum;
            }
        }

        return null;
    }

    @Override
    public GoodsTypeEnum getEnumByValue(Integer value) {

        for (GoodsTypeEnum typeEnum : GoodsTypeEnum.values()) {
            if (value.equals(typeEnum.value)){
                return typeEnum;
            }
        }

        return null;
    }
}