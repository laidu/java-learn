package org.laidu.learn.code.practice.sort;

/**
 * @author laidu
 */
public class MergeSortDemo{

  public static void main(String[] args){

    int[] input = {1,2,43,65,76,32,89};

    int[] result = mergeSort(input, 0, input.length - 1);

    for (int var : result ) {
      System.out.print(var + ",");
    }
  }

  private static int[] mergeSort(int[] a, int low, int high){

    if (low == high) {
      return new int[]{a[low]};
    }else if (high - low == 1) {
      if (a[low] > a[high]) {
        swap(a, low, high);
      }
      return new int[]{a[low],a[high]};
    }

    int mid = (low + high) /2;

    int[] left = mergeSort(a, low, mid);
    int[] right = mergeSort(a, mid+1, high);

    return merge(left, right);
  }

  private static int[] merge(int[] left, int[] right){
    int length = left.length + right.length;
    int[] result = new int[length];
    int i = 0, j=0, k=0;
    while(k < length){
      while(i < left.length && (j >= right.length || left[i] < right[j]) ){
        result[k++] = left[i++];
      }
      while(j < right.length && (i >= left.length || left[i] > right[j])){
        result[k++] = right[j++];
      }
    }

    return result;
  }

  public static void swap(int[] a, int i, int j){
    if (i==j || a.length < Math.max(i,j) || Math.min(i,j) < 0 ) {
      return;
    }
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
