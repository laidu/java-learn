package org.laidu.learn.language.feature.switch_;

import lombok.extern.slf4j.Slf4j;

/**
 * switch demo
 *
 * @author zangtiancai.
 * @date 2019/12/5 下午9:56.
 */
@Slf4j
public class SwitchDemo {

     static String switchWithInt(Integer i) {

        switch (i) {
            case 1:
                return "1";
            case 2:
                return "2";
            default:
                return "3";
        }
    }

    static String switchWithChar(Character i) {

        switch (i) {
            case 1:
                return "1";
            case 2:
                return "2";
            default:
                return "3";
        }
    }

    static String switchWithChar(String i) {

        switch (i) {
            case "AA":
                return "1";
            case "Aa":
                return "2";
            default:
                return "3";
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 30000; i++) {

//            String s = switchWithInt(i);
//            String s = switchWithChar((char) i);
            String s = switchWithChar( i % 2 == 0 ? "AA" : "Aa");

            System.out.println(s);
        }
    }
}
