package org.laidu.commom.util.enums;

/**
 * basic code enum
 *
 * @author tiancai.zang
 * 2018-01-09 16:33.
 */
// : 2018-01-09 16:33  basic code enum
public interface BasicCodeEnum {

    String getCode();

    String getMsg();

    BasicCodeEnum getEnumByCode(String code);
}