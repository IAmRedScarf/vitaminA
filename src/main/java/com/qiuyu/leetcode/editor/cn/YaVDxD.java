//给定一个正整数数组 nums 和一个整数 target 。 
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
//
// 
//
// 注意：本题与主站 494 题相同： https://leetcode-cn.com/problems/target-sum/ 
// Related Topics 数组 动态规划 回溯 👍 25 👎 0


package com.qiuyu.leetcode.editor.cn;

public class YaVDxD {
    public static void main(String[] args) {
        Solution solution = new YaVDxD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTargetSumWays(int[] nums, int target) {
            return findTargetSumWays_20220712(nums, target);
        }


        public int findTargetSumWays_20220716(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum + target & 1) == 1) {
                return 0;
            }
            int newTarget = (sum + target) / 2;
            int[][] dp = new int[1 + nums.length][1 + newTarget];
            dp[0][0] = 1;



            for (int i = 1; i <= nums.length; ++i) {
                for (int j = 0; j <= newTarget; ++j) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][newTarget];

        }


        public int findTargetSumWays_20220712(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum + target & 1) == 1) {
                return 0;
            }
            int newTarget = (sum + target) / 2;
            int[] dp = new int[1 + newTarget];

            dp[0] = 1;
            // 在二维数组中，dp[i][0] = 1

            for (int num : nums) {
                for (int i = newTarget; i >= 0; --i) {
                    if (i >= num) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[newTarget];
        }












        int res = 0;
        int[] _nums;
        int _target;
        public int findTargetSumWays_20220722(int[] nums, int target) {
            _nums = nums;
            _target = target;
            dfs(0, 0);
            return res;
        }

        private void dfs(int curIndex, int curSum) {
            if (curIndex == _nums.length) {
                if (curSum == _target) {
                    res++;
                }
                return;
            }
            dfs(curIndex + 1, curSum + _nums[curIndex]);
            dfs(curIndex + 1, curSum - _nums[curIndex]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
