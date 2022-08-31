//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 982 👎 0


package com.qiuyu.leetcode.editor.cn;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        solution.findTargetSumWays_20220503(new int[]{1,1,1,1,1}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int res_20220503_a = 0;
        public int findTargetSumWays_20220503_a(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            dfs_20220503_a(nums, 0, target, 0);
            return res_20220503_a;


        }

        private void dfs_20220503_a(int[] nums, int curSum, int target, int start) {
            if (start == nums.length) {
                if (curSum == target) {
                    res_20220503_a++;
                }
                return;
            }
            dfs_20220503_a(nums, curSum + nums[start], target, start + 1);
            dfs_20220503_a(nums, curSum - nums[start], target, start + 1);
        }



        public int findTargetSumWays_20220503(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum + target < 0 || ((sum + target) & 1) == 1) {
                return 0;
            }
            int newTarget = (sum + target) / 2;
            int[] dp = new int[newTarget + 1];
            dp[0] = 1;

            for (int num : nums) {
                for (int j = newTarget; j >= 0; --j) {
                    if (num > j) {
                        dp[j] = dp[j];
                    } else {
                        dp[j] = dp[j - num] + dp[j];

                    }
                }
            }
            return dp[newTarget];











        }


        public int findTargetSumWays(int[] nums, int target) {
//            return findTargetSumWays_20220503(nums, target);
           return findTargetSumWays_20220503_a(nums, target);
        }




        Integer res = 0;

        public int findTargetSumWays_old(int[] nums, int target) {
            return f2(nums, target);
        }

        public int f1(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            backtrack(nums, 0, target);
            return res;
        }

        public void backtrack(int[] nums, int index, int left) {
            if (index == nums.length) {
                if (left == 0) {
                    res++;
                }
            } else {
                backtrack(nums, index + 1, left - nums[index]);
                backtrack(nums, index + 1, left + nums[index]);
            }
        }


        public int f2(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
            }

            if (sum - target < 0 || (sum - target) % 2 == 1) {
                return 0;
            }
            int neg = (sum - target) / 2;
            int[][] dp = new int[nums.length + 1][neg + 1];
            for (int j = 0; j <= neg; ++j) {
                dp[0][j] = j == 0 ? 1 : 0;
            }
            for (int i = 1; i <= nums.length; ++i) {
                for (int j = 0; j <= neg; ++j) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][neg];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
