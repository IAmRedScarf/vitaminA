//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 738 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        int[] nums = new int[] {2,6,4,8,10,9,15};
        solution.findUnsortedSubarray_20220430(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findUnsortedSubarray_20220501(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return 0;
            }
            int max = nums[0], min = nums[nums.length - 1];
            int end = 0, begin = nums.length - 1;
            for (int i = 0; i < nums.length; ++i) {
                // 从左向右更新最大值，如果当前值小于最大值，则更新end
                if (nums[i] >= max) {
                    max = nums[i];
                } else {
                    end = i;
                }

                // 从右向左更新最小值
                if (nums[nums.length - 1 - i] <= min) {
                    min = nums[nums.length - 1 - i];
                } else {
                    begin = nums.length - 1 - i;
                }
            }
            return end == 0 ? 0 : (end - begin + 1);


        }

        public int findUnsortedSubarray_20220430(int[] nums) {
            int tmpLeft = 0;
            while (tmpLeft < nums.length - 1) {
                if (nums[tmpLeft] <= nums[tmpLeft + 1]) {
                    tmpLeft++;
                } else {
                    break;
                }
            }
            if (tmpLeft == nums.length - 1) {
                return 0;
            }
            int tmpRight = nums.length - 1;
            while (tmpRight > 0) {
                if (nums[tmpRight] >= nums[tmpRight - 1]) {
                    tmpRight--;
                } else {
                    break;
                }
            }
            if (tmpRight == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = tmpLeft; i <= tmpRight; ++i) {
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
            int realLeft = 0, realRight = nums.length - 1;
            while (realLeft < tmpLeft) {
                if (nums[realLeft] <= min) {
                    realLeft++;
                } else {
                    break;
                }
            }
            while (realRight > tmpRight) {
                if (nums[realRight] >= max) {
                    realRight--;
                } else {
                    break;
                }
            }
            return realRight - realLeft + 1;



















        }



        public int findUnsortedSubarray(int[] nums) {
//            return findUnsortedSubarray_20220430(nums);
            return findUnsortedSubarray_20220501(nums);
        }

        private int f1(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return 0;
            }
            int[] copyNums = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                copyNums[i] = nums[i];
            }
            Arrays.sort(copyNums);
            int left = 0, right = nums.length - 1;
            while (left < nums.length) {
                if (nums[left] != copyNums[left]) {
                    break;
                }
                ++left;
            }
            while (right >= 0) {
                if (nums[right] != copyNums[right]) {
                    break;
                }
                --right;
            }
            return left == nums.length ? 0 : (right - left + 1);
        }

        private int f2(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return 0;
            }
            int len = nums.length;
            int curMax = nums[0], curMin = nums[len - 1];
            int leftIndex = len - 1, rightIndex = 0;
            for (int i = 0; i < len; ++i) {
                if (nums[i] >= curMax) {
                    curMax = nums[i];
                } else {
                    rightIndex = i;
                }
                if (nums[len - i - 1] <= curMin) {
                    curMin = nums[len - i - 1];
                } else {
                    leftIndex = len - i - 1;
                }
            }
            return rightIndex == 0 ? 0 : (rightIndex - leftIndex + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
