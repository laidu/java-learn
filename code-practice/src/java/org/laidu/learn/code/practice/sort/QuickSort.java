package org.laidu.learn.code.practice.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 快排练习
 *
 * @author tiancai.zang
 * on 2018-11-13 18:10.
 */
@Slf4j
public class QuickSort {

    public static void main(String[] args) {

        int[] input = {6, 5, 4, 3, 2, 1};

        quickSort(input);

        System.out.println(Arrays.stream(input).boxed().map(i -> i + "").collect(Collectors.joining(",")));

    }

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            qsort(arr, low, pivot - 1);

            qsort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}