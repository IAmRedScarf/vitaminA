//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9
//
//
// 提示：
//
//
// 1 <= n <= 104
//
// Related Topics 广度优先搜索 数学 动态规划
// 👍 1048 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares_20220503(13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            return numSquares20230223(n);
        }


        public int numSquares20230223(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; ++i) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; ++j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }





        public int numSquares_20220503(int n) {
            if (n <= 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                dp[i] = i;
                for (int j = 1; j * j <= i; ++j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];

        }



        public int numSquares_old(int n) {
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            for (int i = 1; i <= n; i++) {
//                dp[i] = i;
//                for (int j = 1; i - j * j >= 0; j++) {
//                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//                }
//            }
//            return dp[n];
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(n);

            int level = 0;

            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int target = queue.poll();
                    visited.add(target);
                    int j = 1;
                    while (true) {
                        int left = target - j * j;
                        if (left == 0) {
                            return level;
                        } else if (left > 0) {
                            if (!visited.contains(left)) {
                                queue.add(left);
                                visited.add(left);
                            }
                        } else {
                            break;
                        }
                        ++j;
                    }
                }
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
