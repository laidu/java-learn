package org.laidu.learn.language.feature.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 臧天才 on 2017/8/21.
 */
@Slf4j
class StringTest {

    private static final String VAR = "Hello JAVA String!";

    @Test
    @DisplayName("获取字符串字符长度")
    void length() {
        log.info("-*--*--*--*--*--*--*--*--*-- length --*--*--*--*--*--*--*--*--*-: {}", VAR.length());
    }

    @Test
    @DisplayName("判断字符串[内容]是否为空")
    void isEmpty() {

        log.info("-*--*--*--*--*--*--*--*--*-- {} isEmpty --*--*--*--*--*--*--*--*--*-: {}",VAR, VAR.isEmpty()); //false
        log.info("-*--*--*--*--*--*--*--*--*-- {} isEmpty --*--*--*--*--*--*--*--*--*-: {}","", "".isEmpty()); //true

    }


    /**
     * 按照索引取char值或者Unicode码
     */
    @Test
    @DisplayName("返回指定索引处的 char 值")
    void charAt() {
        for (int i = 0; i < VAR.length(); i++) {
            log.info("-*--*--*--*--*--*--*--*--*-- 第 {} 个字符 --*--*--*--*--*--*--*--*--*-: {}", i, VAR.charAt(i));
        }
    }

    @Test
    @DisplayName("返回指定索引处的字符（Unicode 代码点）")
    void codePointAt() {

        for (int i = 0; i < VAR.length(); i++) {
            log.info("-*--*--*--*--*--*--*--*--*-- 第 {} 个字符 --*--*--*--*--*--*--*--*--*-: {}", i, VAR.codePointAt(i));
        }
    }

    @Test
    @DisplayName("返回指定索引之前的字符（Unicode 代码点）")
    void codePointBefore() {

        for (int i = 1; i < VAR.length(); i++) {
            log.info("-*--*--*--*--*--*--*--*--*-- 第 {} 个字符之前的字符Unicode码 --*--*--*--*--*--*--*--*--*-: {}", i, VAR.codePointBefore(i));
        }
    }


    @Test
    @DisplayName("返回此 String 的指定文本范围中的 Unicode 代码点数")
    void codePointCount() {

        log.info("-*--*--*--*--*--*--*--*--*-- codePointCount --*--*--*--*--*--*--*--*--*-: {}",VAR.codePointCount(2,9));
    }

    @Test
    @DisplayName("")
    void offsetByCodePoints() {
    }

    @Test
    @DisplayName("")
    void getChars() {
    }

    @Test
    @DisplayName("")
    void getChars1() {
    }

    @Test
    @DisplayName("")
    void getBytes() {
    }

    @Test
    @DisplayName("")
    void getBytes1() {
    }

    @Test
    @DisplayName("")
    void getBytes2() {
    }

    @Test
    @DisplayName("")
    void getBytes3() {
    }

    @Test
    @DisplayName("")
    void equals() {
    }

    @Test
    @DisplayName("")
    void contentEquals() {
    }

    @Test
    @DisplayName("")
    void contentEquals1() {
    }

    @Test
    @DisplayName("")
    void equalsIgnoreCase() {
    }

    @Test
    @DisplayName("")
    void compareTo() {
    }

    @Test
    @DisplayName("")
    void compareToIgnoreCase() {
    }

    @Test
    @DisplayName("")
    void regionMatches() {
    }

    @Test
    @DisplayName("")
    void regionMatches1() {
    }

    @Test
    @DisplayName("")
    void startsWith() {
    }

    @Test
    @DisplayName("")
    void startsWith1() {
    }

    @Test
    @DisplayName("")
    void endsWith() {
    }

    @Test
    @DisplayName("")
    void indexOf() {
    }

    @Test
    @DisplayName("")
    void indexOf1() {
    }

    @Test
    @DisplayName("")
    void lastIndexOf() {
    }

    @Test
    @DisplayName("")
    void lastIndexOf1() {
    }

    @Test
    @DisplayName("")
    void indexOf2() {
    }

    @Test
    @DisplayName("")
    void indexOf3() {
    }

    @Test
    @DisplayName("")
    void indexOf4() {
    }

    @Test
    @DisplayName("")
    void indexOf5() {
    }

    @Test
    @DisplayName("")
    void lastIndexOf2() {
    }

    @Test
    @DisplayName("")
    void lastIndexOf3() {
    }

    @Test
    @DisplayName("")
    void lastIndexOf4() {
    }

    @Test
    @DisplayName("")
    void lastIndexOf5() {
    }

    @Test
    @DisplayName("")
    void substring() {
    }

    @Test
    @DisplayName("")
    void substring1() {
    }

    @Test
    @DisplayName("")
    void subSequence() {
    }

    @Test
    @DisplayName("")
    void concat() {
    }

    @Test
    @DisplayName("")
    void replace() {
    }

    @Test
    @DisplayName("")
    void matches() {
    }

    @Test
    @DisplayName("")
    void contains() {
    }

    @Test
    @DisplayName("")
    void replaceFirst() {
    }

    @Test
    @DisplayName("")
    void replaceAll() {
    }

    @Test
    @DisplayName("")
    void replace1() {
    }

    @Test
    @DisplayName("")
    void split() {
    }

    @Test
    @DisplayName("")
    void split1() {
    }

    @Test
    @DisplayName("")
    void join() {

    }

    @Test
    @DisplayName("")
    void join1() {
    }

    @Test
    @DisplayName("")
    void toLowerCase() {
    }

    @Test
    @DisplayName("")
    void toLowerCase1() {
    }

    @Test
    @DisplayName("")
    void toUpperCase() {
    }

    @Test
    @DisplayName("")
    void toUpperCase1() {
    }

    @Test
    @DisplayName("")
    void trim() {
    }

    @Test
    @DisplayName("")
    void toCharArray() {
    }

    @Test
    @DisplayName("")
    void format() {
    }

    @Test
    @DisplayName("")
    void format1() {
    }

    @Test
    @DisplayName("")
    void valueOf() {
    }

    @Test
    @DisplayName("")
    void valueOf1() {
    }

    @Test
    @DisplayName("")
    void valueOf2() {
    }

    @Test
    @DisplayName("")
    void copyValueOf() {
    }

    @Test
    @DisplayName("")
    void copyValueOf1() {
    }

    @Test
    @DisplayName("")
    void valueOf3() {
    }

    @Test
    @DisplayName("")
    void valueOf4() {
    }

    @Test
    @DisplayName("")
    void valueOf5() {
    }

    @Test
    @DisplayName("")
    void valueOf6() {
    }

    @Test
    @DisplayName("")
    void valueOf7() {
    }

    @Test
    @DisplayName("")
    void valueOf8() {
    }

    @Test
    @DisplayName("")
    void intern() {
    }

}