package org.laidu.commom.util.enums;

/**
 * basic string enum
 *
 * @author tiancai.zang
 * 2018-01-09 16:30.
 */
public interface NameValueEnum<T,V>{

    /**
     * name
     * @return
     */
    T getName();

    /**
     * value
     * @return
     */
    V getValue();


    /**
     * 通过name 通过name获取枚举
     * @param name
     * @return
     */
    NameValueEnum getEnumByName(T name);


    /**
     * 通过value 获取枚举
     * @param value
     * @return
     */
    NameValueEnum getEnumByValue(V value);
}
