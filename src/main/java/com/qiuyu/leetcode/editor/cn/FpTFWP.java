//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 329 题相同： https://leetcode-cn.com/problems/longest-increasing-path-
//in-a-matrix/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 23 👎 0


package com.qiuyu.leetcode.editor.cn;

public class FpTFWP {
    public static void main(String[] args) {
        Solution solution = new FpTFWP().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] lenFromCur;


        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            lenFromCur = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    res = Math.max(res, dfs(matrix, i, j));
                }
            }
            return res;

        }

        private int dfs(int[][] matrix, int i, int j) {
            if (lenFromCur[i][j] != 0) {
                return lenFromCur[i][j];
            }

            int curValue = matrix[i][j];
            int plus = 0;
            if (i - 1 >= 0 && matrix[i - 1][j] > curValue) {
                plus = Math.max(plus, dfs(matrix, i - 1, j));
            }
            if (i + 1 < matrix.length && matrix[i + 1][j] > curValue) {
                plus = Math.max(plus, dfs(matrix, i + 1, j));
            }
            if (j - 1 >= 0 && matrix[i][j - 1] > curValue) {
                plus = Math.max(plus, dfs(matrix, i, j - 1));
            }
            if (j + 1 < matrix[0].length && matrix[i][j + 1] > curValue) {
                plus = Math.max(plus, dfs(matrix, i, j + 1));
            }
            lenFromCur[i][j] = 1 + plus;
            return lenFromCur[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
