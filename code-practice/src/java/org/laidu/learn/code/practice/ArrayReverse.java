package org.laidu.learn.code.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数组翻转
 *
 * @author tiancai.zang
 * on 2018-11-12 15:32.
 */
@Slf4j
public class ArrayReverse {

    public static void main(String[] args) {

        int[] input = {1,2,3,4,5,6,7};

        int[] result = reverse(input);
//        int[] result = reverse2(input);

        print(result);

    }

    private static void print(int[] array) {
        System.out.println(Arrays.stream(array).boxed().map(String::valueOf).collect(Collectors.joining(",")));
    }

    /**
     * for
     * @param input
     * @return
     */
    private static int[] reverse(int[] input) {

        int length = input.length;
//        int[] result = new int[length];
//
//        for (int i = length-1; i > -1; i--) {
//            result[input.length-i-1] = input[i];
//        }
//        return result;

        for (int i = 0, mid = length >> 1; i < mid ; i++) {
            swap(input,i,length-i-1);
        }
        return input;
    }

    private static void swap(int[] array, int i, int j){

        int length;
        if (array == null || i<0 || j<0 || i == j || i > (length = array.length-1) || j > length) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int[] reverse2(int[] input){
        List<Integer> raw = Arrays.stream(input).boxed().collect(Collectors.toList());
        Collections.reverse(raw);
        return raw.stream().mapToInt(i->i).toArray();
    }
}