package org.laidu.learn.algorithm.sort;

/**
 * 快排
 *
 * @author tiancai.zang
 * on 2018-10-31 13:05.
 */
public class SortQui {

    public static void main(String[] args) {

        int[] input = new int[]{1, 32, 3, 43, 12, 7, 34};

        int[] sort = sort(input, 0, input.length - 1);

        SortUtil.print(sort);

    }

    public static int divide(int[] a, int start, int end) {

        int base = a[end];

        while (start < end) {

            while (start < end && a[start] <= base) {
                start++;
            }

            if (start < end) {
                SortUtil.swap(a, start, end);

                end--;
            }

            while (start < end && a[end] >= base) {
                end--;
            }

            if (start < end) {

                SortUtil.swap(a, start, end);

                start++;
            }

        }

        return end;
    }

    /**
     * 排序
     *
     * @param a
     * @param start
     * @param end
     */
    public static int[] sort(int[] a, int start, int end) {

        if (start > end) {
            return a;
        } else {

            int partition = divide(a, start, end);
            sort(a, start, partition - 1);
            sort(a, partition + 1, end);
        }

        return a;

    }
}