//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1114 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int[] a = new int[]{1, 3, 1};
        int[] b = new int[]{1, 5, 1};
        int[] c = new int[]{4, 2, 1};
        int[][] grid = new int[][]{a, b, c};
        solution.minPathSum(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            return minPathSum20230216(grid);
        }


        public int minPathSum20230216(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            // 0标识从左边来，1标识从上边来
            int[][] directionDp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; ++i) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
                directionDp[i][0] = 1;
            }
            for (int j = 1; j < n; ++j) {
                dp[0][j] = grid[0][j] + dp[0][j - 1];
                directionDp[0][j] = 0;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (dp[i - 1][j] < dp[i][j - 1]) {
                        directionDp[i][j] = 1;
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        directionDp[i][j] = 0;
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                }
            }
            int pathLen = m + n - 1;
            int[] path = new int[pathLen];
            path[pathLen - 1] = grid[m - 1][n - 1];
            int curX = m - 1, curY = n - 1;
            for (int i = pathLen - 2; i >= 0; --i) {
                int preX, preY;
                if (directionDp[curX][curY] == 0) {
                    preX = curX;
                    preY = curY - 1;
                } else {
                    preX = curX - 1;
                    preY = curY;
                }
                path[i] = grid[preX][preY];
                curX = preX;
                curY = preY;
            }
            System.out.println(Arrays.toString(path));
            System.out.println(dp[m - 1][n - 1]);

            return dp[m - 1][n - 1];
        }


        public int minPathSum_20220502(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; ++i) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int j = 1; j < n; ++j) {
                dp[0][j] = grid[0][j] + dp[0][j - 1];
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];


        }


        public int minPathSum_old(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int rows = grid.length, cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < rows; ++i) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < cols; ++j) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < rows; ++i) {
                for (int j = 1; j < cols; ++j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
