package com.qiuyu.leetcode.editor.cn.util;

import java.util.Arrays;

/**
 * @author qiuyu13
 * @date 2022/1/28
 */
public class MySortUtil {

    public static int[] quickSort_20220429(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        quickSort_20220429(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort_20220429(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int j = partition_20220429(nums, start, end);
        quickSort_20220429(nums, start, j - 1);
        quickSort_20220429(nums, j + 1, end);

    }


    private static int partition_20220429(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start + 1, j = end;
        while (true) {

            while (i <= end && nums[i] < pivot) {
                ++i;
            }
            while (j > start && nums[j] > pivot) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            ++i;
            --j;
        }
        swap(nums, start, j);
        return j;


    }





















    public static int[] quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int j = partition(nums, left, right);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = getMediaValue(nums, left, right);
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && nums[i] < pivot) {
                ++i;
            }
            while (j >= left && nums[j] > pivot) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);

            ++i;
            --j;
        }
        swap(nums, left, j);
        return j;
    }

    private static int getMediaValue(int[] nums, int left, int right) {
        if (left + 2 > right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int minValue = Math.min(nums[left], nums[right]);
        int maxValue = Math.max(nums[left], nums[right]);
        if (nums[mid] < minValue) {
            minValue = nums[mid];
        }
        if (nums[mid] > maxValue) {
            maxValue = nums[mid];
        }
        if (nums[mid] > minValue && nums[mid] < maxValue) {
            swap(nums, left, mid);
        } else if (nums[right] > minValue && nums[right] < maxValue) {
            swap(nums, left, right);
        }
        return nums[left];
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(partition_20220429(new int[]{3, 2}, 0, 1));
//        int[] nums1 = new int[]{6, 5, 4, 3, 2, 1};
//        int[] nums2 = new int[]{6, 6, 6, 6, 6};
//        int[] nums3 = new int[]{6, 6};
//        int[] nums4 = new int[]{6, 5, 4, 4, 4, 3, 3, 3, 1};
//        int[] nums5 = new int[]{1, 2, 3, 4, 5, 5, 5, 5, 5, -1};
//        int[] nums6 = new int[]{6,6,6};
//        int[] nums7 = new int[] {6,5};
//        int[] nums8 = new int[] {5,6,7};
//        int[] nums9 = new int[] {5,8,6,7};
//        System.out.println(Arrays.toString(quickSort_20220429(nums1)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums2)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums3)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums4)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums5)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums6)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums7)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums8)));
//        System.out.println(Arrays.toString(quickSort_20220429(nums9 )));

    }
}
