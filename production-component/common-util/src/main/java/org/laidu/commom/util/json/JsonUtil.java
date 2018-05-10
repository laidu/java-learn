package org.laidu.commom.util.json;

import com.alibaba.fastjson.JSON;

/**
 * json util
 * <p>
 * Created by tiancai.zang
 * on 2018-05-10 13:24.
 */
public enum JsonUtil{
    // instance
    INSTANCE;

    /**
     * get json String from object
     *
     * @param o
     * @return
     */
    public String toJsonString(Object o) {
        return JSON.toJSONString(o);
    }

}