package org.laidu.learn.algorithm.leetcode;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class FirstMissingPositive {

    /**
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return nums[0] == 1 ? 2 : 1;
        }

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }

        }
        return nums[0] == n ? n + 1 : n;
    }

    /**
     * 查找不包含的最小整数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }

        // 1、查找最小整数
        int min = 1;

        // 2、查找比第一个元素大，却不在当前数组中的元素
        while (contain(nums, min) || min < 1) {
            ++min;
        }

        return min;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean contain(int[] nums, int min) {

        for (int i = 0; i < nums.length; i++) {
            if (min == nums[i]) {
                return true;
            }
        }

        return false;
    }
}
