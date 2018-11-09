package org.laidu.learn.code.practice.company.xunlei;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 整数翻转
 * <p>
 * [编程题] 整数反转
 * 时间限制：1秒
 * <p>
 * 空间限制：131072K
 * <p>
 * 输入一个有符号整数，输出该整数的反转值。
 * <p>
 * 输入描述:
 * 一个整数
 * <p>
 * <p>
 * 输出描述:
 * 一个整数
 * <p>
 * 输入例子1:
 * 123
 * <p>
 * 输出例子1:
 * 321
 *
 * @author tiancai.zang
 * on 2018-10-25 19:14.
 */
@Slf4j
public class IntegerReverse {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        int anInt = 0 ;
        try {
            anInt = Integer.parseInt(input);
        }catch (Exception e){
            return;
        }

        System.out.println(reverse(anInt));

    }

    private static int reverse(int input) {


        int flag = input >= 0 ? 1 : -1;

        ArrayDeque<String> num = new ArrayDeque<>();

        int var = Math.abs(input);
        while (var != 0){
            int ge = var % 10;
            num.add(ge+"");
            var = var / 10;
        }

        StringBuilder numStr = new StringBuilder();
        Iterator<String> iterator = num.iterator();
        while (iterator.hasNext()) {
            numStr.append(iterator.next());
        }

        return Integer.parseInt(numStr.toString()) * flag;

    }

}