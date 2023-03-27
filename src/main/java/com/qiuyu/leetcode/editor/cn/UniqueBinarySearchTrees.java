//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1480 👎 0


package com.qiuyu.leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numTrees(int n) {
            return numTrees20230216(n);
        }

        // f(i) = f(k - 1) * f(i - k) 求和，其中i为根节点的值
        public int numTrees20230216(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int k = 1; k <= i; ++k) {
                    dp[i] += dp[k - 1] * dp[i - k];
                }
            }
            return dp[n];
        }











        public int numTrees_20220503(int n) {
            if (n < 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; ++i) {

                // 树有i个节点， 分别标记为 0,1,2,...,i-1
                // 选取j为根节点
                for (int j = 0; j <= i - 1; ++j) {
                    dp[i] += dp[j] * dp[i - 1 - j];
                }
            }
            return dp[n];



        }




        public int numTrees_old(int n) {
            if (n <= 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    dp[i] += (dp[j - 1] * dp[i - j]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
