package org.laidu.crawler.helper.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * pageProcessor temple var
 */
@AllArgsConstructor
public enum VariateEnum {

    PACKAGE_NAME("__PACKAGE_NAME__"),
    CLASS_CN_NAME("__CLASS_CN_NAME__"),
    DATE("__DATE__"),
    CLASS_NAME("__CLASS_NAME__"),
    ENUM_NAME("__ENUM_NAME__"),
    METHOD("__METHOD__"),
    SIGN("__SIGN__"),
    URL("__URL__"),
    HEADERS("__HEADERS__"),
    BODY("__BODY__"),
    ENCRYPTION_SOURCE("__ENCRYPTION_SOURCE__"),
    ENCRYPTION_ALGORITHM("__ENCRYPTION_ALGORITHM__"),
    ENCRYPTION_KEY("__ENCRYPTION_KEY__"),
    ENCRYPTION_IVP("__ENCRYPTION_IVP__"),

    ;

    @Getter
    private String value;
}
