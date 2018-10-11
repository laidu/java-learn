package org.laidu.learn.swagger.demo.enums;

/**
 * Created by laidu
 * on 2018-10-11 17:21.
 *
 * @author laidu
 */
public interface BasicIntEnum {

    /**
     * 获取 value
     * @return
     */
    int getValue();

    /**
     * 获取name
     * @return
     */
    String getName();

    BasicIntEnum getEnumByName(String name);

    BasicIntEnum getEnumByValue(Integer value);

}
