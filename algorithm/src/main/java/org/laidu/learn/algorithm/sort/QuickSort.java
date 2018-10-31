package org.laidu.learn.algorithm.sort;

/**
 * 快排
 *
 * @author tiancai.zang
 * on 2018-10-31 13:05.
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] input = new int[]{1,2,3,43,12,7,34};

        QuickSort quickSort = new QuickSort();

        int[] sort = quickSort.sort(input, 0, input.length-1);

        System.out.println(sort);

    }

    /**
     * @param array
     * @return
     */
    public int[] sort(int[] array, int start, int end) {

        if ((end - start) < 2 || Math.max(start,end) > array.length-1) {
            return array;
        }

        int pivotIndex = (start + end) / 2;
        int pivot = array[pivotIndex];

        int i = start;
        int j = end;

        boolean iWait = false;
        boolean jWait = false;

        while (i <= j) {
            if (array[i] > pivot) {
                if (jWait) {
                    swap(array,i,j);
                    jWait = false;
                }else {
                    iWait = true;
                }
            } else {
                i++;
            }
            if (array[j] < pivot) {
                if (iWait) {
                    swap(array,i,j);
                    iWait = false;
                }else {
                    jWait = true;
                }
            } else {
                j--;
            }
        }

        if (array[Math.min(i,end)] <= pivot) {
            swap(array,pivotIndex,Math.min(i,end));
        }

        sort(array, start, pivotIndex-1);
        sort(array, pivotIndex+1, end);

        return array ;
    }

    public void swap(int[] array, int firstIndex, int second){

        if (firstIndex == second) {
            return;
        }
        int temp = array[firstIndex];
        array[firstIndex] = array[second];
        array[second] = temp;
    }
}