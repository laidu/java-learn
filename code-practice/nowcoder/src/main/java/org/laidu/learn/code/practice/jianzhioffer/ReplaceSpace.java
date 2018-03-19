package org.laidu.learn.code.practice.jianzhioffer;

import lombok.extern.slf4j.Slf4j;

/**
 * 替换空格
 * <p>
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by tiancai.zang
 * on 2018-03-04 19:12.
 */
@Slf4j
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

}