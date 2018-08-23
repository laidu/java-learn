package org.laidu.commom.util.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * MsOfficeType 文件类型
 *
 * @author tiancai.zang
 * on 2018-08-09 11:33.
 */
@Slf4j
@AllArgsConstructor
public enum MsOfficeType {

    /**
     * 2003
     */
    MOW2003("d0cf11e"),

    /**
     * 2007+
     */
    MOW2007("504b0"),

    ;

    @Getter
    private String type;

    /**
     * 根据文件头获取文件类型
     *
     * @param value
     * @return
     */
    public static String getTypeByValue(String value) {
        for (MsOfficeType mow : values()) {
            if (value.toUpperCase().startsWith(mow.getType().toUpperCase())) {
                return mow.name();
            }
        }
        return null;
    }
}