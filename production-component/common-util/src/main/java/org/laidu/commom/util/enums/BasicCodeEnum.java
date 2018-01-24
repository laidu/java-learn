package org.laidu.commom.util.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * basic code enum
 *
 * @author tiancai.zang
 * 2018-01-09 16:33.
 */
// TODO: 2018-01-09 16:33  basic code enum
public interface BasicCodeEnum {

    String getCode();
    String getMsg();
    BasicCodeEnum getEnumByCode(String code);
}