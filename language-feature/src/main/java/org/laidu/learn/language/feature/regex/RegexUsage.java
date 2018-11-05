package org.laidu.learn.language.feature.regex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * regex usage
 * <p>
 * Created by tiancai.zang on 2017-10-12 14:22.
 */
@Slf4j
public class RegexUsage {

    private static Pattern bugPattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");


    public static void main(String[] args) {

        String email  = "123qq@qq123@qq.com";

        Matcher matcher = bugPattern.matcher(email);

        if (matcher.matches()) {
            System.out.println();

        }

    }
}