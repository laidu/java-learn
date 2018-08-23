package org.laidu.commom.util.string;

import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.annotation.Singleton;
import org.laidu.commom.util.xml.JAXBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * String util
 * <p>
 * Created by laidu
 * on 2018-07-31 17:53.
 *
 * @author laidu
 */
@Slf4j
public enum  StringUtil {

    /**
     * 实例
     */
    INSTANCE;

    /**
     * 驼峰转下划线
     * @param input
     * @return
     */
    public String toSnakeCase(String input) {
        if (input == null) {
            return input;
        } else {
            int length = input.length();
            StringBuilder result = new StringBuilder(length * 2);
            int resultLength = 0;
            boolean wasPrevTranslated = false;

            for (int i = 0; i < length; ++i) {
                char c = input.charAt(i);
                if (i > 0 || c != '_') {
                    if (Character.isUpperCase(c)) {
                        if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '_') {
                            result.append('_');
                            ++resultLength;
                        }

                        c = Character.toLowerCase(c);
                        wasPrevTranslated = true;
                    } else {
                        wasPrevTranslated = false;
                    }

                    result.append(c);
                    ++resultLength;
                }
            }

            return resultLength > 0 ? result.toString() : input;
        }
    }


    /**
     * 下划线转头峰
     *
     * @param name
     * @return
     */
    public String toCamelCase(String name) {

        StringBuilder camelCase = new StringBuilder();
        String[] arr = name.split("_");
        List<String> list = new ArrayList<>();

        for (String a : arr) {
            if (a.length() > 0) {
                list.add(a);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                char c = list.get(i).charAt(0);
                String s = String.valueOf(c).toUpperCase() + list.get(i).substring(1).toLowerCase();
                camelCase.append(s);
            } else {
                camelCase.append(list.get(i).toLowerCase());
            }
        }
        return camelCase.toString();
    }
}