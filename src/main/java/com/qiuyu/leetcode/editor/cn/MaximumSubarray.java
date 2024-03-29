//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4042 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            return maxSubArray20230216(nums);
        }




        public int maxSubArray20230216(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < len; ++i) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                res = Math.max(res, dp[i]);
            }
            return res;

        }










        public int maxSubArray_20220513(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < nums.length; ++i) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = Math.max(dp[i], res);
            }
            return res;


        }


        public int maxSubArray_old(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("");
            }
            int res = nums[0];
            int curMax = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                curMax = Math.max(curMax + nums[i], nums[i]);
                res = Math.max(res, curMax);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
