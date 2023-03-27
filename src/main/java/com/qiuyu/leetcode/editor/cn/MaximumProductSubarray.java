//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 👍 1426 👎 0


package com.qiuyu.leetcode.editor.cn;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            return maxProduct20230220(nums);
        }

        public int maxProduct20230220(int[] nums) {
            int[] dpMax = new int[nums.length];
            int[] dpMin = new int[nums.length];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int res = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
                dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
                res = Math.max(res, dpMax[i]);
            }
            return res;
        }













        public int maxProduct_20220502(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int[][] dp = new int[2][nums.length];
            // dp[0][i]表示以下标i结尾的子数组最小值
            // dp[1][i]表示以下标i结尾的子数组最大值
            dp[0][0] = nums[0];
            dp[1][0] = nums[0];

            int res = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dp[0][i] = Math.min(Math.min(nums[i] * dp[0][i - 1], nums[i] * dp[1][i - 1]), nums[i]);
                dp[1][i] = Math.max(Math.max(nums[i] * dp[0][i - 1], nums[i] * dp[1][i - 1]), nums[i]);
                res = Math.max(res, dp[1][i]);
            }
            return res;


        }


        public int maxProduct_old(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("");
            }
            int[] dpMax = new int[nums.length];
            int[] dpMin = new int[nums.length];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int res = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
                dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
                res = Math.max(res ,dpMax[i]);
            }
            return res;


















//            int curMax = nums[0], curMin = nums[0];
//            int res = nums[0];
//            for (int i = 1; i < nums.length; ++i) {
//                int preMax = curMax, preMin = curMin;
//                curMax = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
//                curMin = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
//                res = Math.max(curMax, res);
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
