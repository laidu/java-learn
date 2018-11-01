package org.laidu.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 排序工具类
 * <p>
 * Created by tiancai.zang
 * on 2018-10-31 23:07.
 */
@Slf4j
public class SortUtil {

    /**
     * 交换两个数位置
     * @param a
     * @param first
     * @param second
     */
    public static void swap(int[] a, int first, int second) {

        if (first == second) {
            return;
        }

        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void print(int[] a){

        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}