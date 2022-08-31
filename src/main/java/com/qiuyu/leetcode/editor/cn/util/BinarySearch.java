package com.qiuyu.leetcode.editor.cn.util;

import java.util.Arrays;

/**
 * @author qiuyu13
 * @date 2022/2/25
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search_left(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static int search_right(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 5, 5, 7, 10};

        System.out.println(Arrays.toString(nums));

        System.out.println();


        System.out.println("<<---one--->>");
        System.out.println(search(nums,0));
        System.out.println(search(nums,2));
        System.out.println(search(nums,5));
        System.out.println(search(nums,11));

        System.out.println("<<---two--->>");
        System.out.println(search_left(nums,0));
        System.out.println(search_left(nums,2));
        System.out.println(search_left(nums,5));
        System.out.println(search_left(nums,6));
        System.out.println(search_left(nums,11));

        System.out.println("<<---three--->>");
        System.out.println(search_right(nums,0));
        System.out.println(search_right(nums,2));
        System.out.println(search_right(nums,5));
        System.out.println(search_right(nums,6));
        System.out.println(search_right(nums,11));



    }


}
