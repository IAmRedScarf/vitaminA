package com.qiuyu.leetcode.editor.cn.model;

import java.util.Arrays;

/**
 * @author qiuyu13
 * @date 2021/8/27
 */
public class Sort {
    public static void mergeSort(int[] nums) {
        if (nums != null && nums.length > 1) {
            int[] tmp = new int[nums.length];
            for (int k = 0; k < nums.length; ++k) {
                tmp[k] = nums[k];
            }
            mergeSort(nums, 0, nums.length - 1, tmp);
        }
    }

    private static void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (right > left) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, tmp);
            mergeSort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int k = left; k <= right; ++k) {
            tmp[k] = nums[k];
        }
        int k = left, i = left, j = mid + 1;
        while (k <= right) {
            if (i > mid) {
                nums[k++] = tmp[j++];
            } else if (j > right) {
                nums[k++] = tmp[i++];
            } else if (tmp[i] < tmp[j]) {
                nums[k++] = tmp[i++];
            } else {
                nums[k++] = tmp[j++];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 1};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
