package org.laidu.learn.language.feature.string;


import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * java.lang.String 部分源码分析
 * <p>
 * Created by 臧天才 on 2017-08-21 20:45.
 * @see java.lang.String
 */
@Slf4j
public class StringPartMethod {

    /**
     * java 8 新增方法 String join(CharSequence delimiter, CharSequence... elements)
     * @param delimiter
     * @param elements
     * @return
     */
    public static String join(CharSequence delimiter, CharSequence... elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        // Number of elements not likely worth Arrays.stream overhead.
        StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence cs: elements) {
            joiner.add(cs);
        }
        return joiner.toString();
    }

    /**
     * java 8 新增方法 String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
     * @param delimiter
     * @param elements
     * @return
     */
    public static String join(CharSequence delimiter,
                              Iterable<? extends CharSequence> elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (CharSequence cs: elements) {
            joiner.add(cs);
        }
        return joiner.toString();
    }


}
