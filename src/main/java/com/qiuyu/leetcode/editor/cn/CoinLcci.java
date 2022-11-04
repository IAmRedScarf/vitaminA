//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 数组 数学 动态规划 👍 261 👎 0


package com.qiuyu.leetcode.editor.cn;

public class CoinLcci {
    public static void main(String[] args) {
        Solution solution = new CoinLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToChange(int n) {
            int[] coins = new int[] {25, 10, 5, 1};
            return waysToChange(n, coins);
        }


        private int waysToChange(int n, int[] coins) {
            int[] ways = new int[n + 1];
            ways[0] = 1;

            for (int coin : coins) {
                for (int i = 1; i <= n; ++i) {
                    if (i >= coin) {
                        ways[i] += ways[i - coin];
                        ways[i] %= 1000000007;
                    }
                }
            }
            return ways[n];
//            for (int i = 1; i <= n; ++i) {
//                for (int coin : coins) {
//                    if (i >= coin) {
//                        ways[i] += ways[i - coin];
//                    }
//                }
//            }
//            return ways[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
