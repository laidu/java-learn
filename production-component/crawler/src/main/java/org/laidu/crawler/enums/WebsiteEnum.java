package org.laidu.crawler.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * website enum
 * Differentiate website type
 * @author tiancai.zang
 * 2018-01-09 16:15.
 */
// : 2018-01-09 16:15  web site enum
public enum WebsiteEnum {

    /**
     * baidu
     */
    BAIDU("001","baidu");

    private final String code;
    private final String name;
    private static final Map<String,WebsiteEnum> valueMap = new HashMap<>();
    static {
        for (WebsiteEnum websiteEnum : WebsiteEnum.values()){
            valueMap.put(websiteEnum.code,websiteEnum);
        }
    }
    WebsiteEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return name;
    }

    public WebsiteEnum getEnumByCode(String code) {
        return valueMap.get(code);
    }
}
