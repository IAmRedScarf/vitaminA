//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1404 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Vector;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] coins = new int[]{2};
        System.out.println(solution.coinChange(coins, 3));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {
            return coinChange_20220721(coins, amount);
        }

        public int coinChange_20220721(int[] coins, int amount) {
            int[] dp = new int[amount + 1];

            for (int i = 1; i <= amount; ++i) {
                int tmp = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i >= coin && dp[i - coin] >= 0) {
                        tmp = Math.min(tmp, dp[i - coin] + 1);
                    }
                }
                dp[i] = tmp == Integer.MAX_VALUE ? - 1 : tmp;
            }
            return dp[amount];
        }






        public int coinChange_20220503(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount <= 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; ++i) {
                int tmp = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i == coin || (i - coin > 0 && dp[i - coin] > 0)) {
                        tmp = Math.min(dp[i - coin] + 1, tmp);
                    }
                }
                dp[i] = tmp == Integer.MAX_VALUE ? -1 : tmp;
            }
            return dp[amount];

        }








        public int coinChange_old(int[] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }
            if (amount <= 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; ++i) {
                dp[i] = -1;
            }
            for (int cur = 1; cur <= amount; ++cur) {
                int curRes = Integer.MAX_VALUE;
                for (int i = 0; i < coins.length; ++i) {
                    if (cur - coins[i] >= 0 && dp[cur - coins[i]] != -1) {
                        curRes = Math.min(dp[cur - coins[i]] + 1, curRes);
                    }
                }
                if (curRes < Integer.MAX_VALUE) {
                    dp[cur] = curRes;
                }
            }

            return dp[amount];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

