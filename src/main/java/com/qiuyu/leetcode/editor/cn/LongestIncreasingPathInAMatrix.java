//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
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
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 632 👎 0


package com.qiuyu.leetcode.editor.cn;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
            int res = 0;
            int[][] alreadyKnown = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    res = Math.max(res, dfs(matrix, i, j, alreadyKnown));
                }
            }
            return res;

        }

        private int dfs(int[][] matrix, int i, int j, int[][] alreadyKnown) {
            if (alreadyKnown[i][j] > 0) {
                return alreadyKnown[i][j];
            }
            int left = 0, right = 0, up = 0, down = 0;
            int cur = matrix[i][j];
            if (j - 1 >= 0 && matrix[i][j - 1] > cur) {
                left = dfs(matrix, i, j - 1, alreadyKnown);
            }
            if (j + 1 < matrix[0].length && matrix[i][j + 1] > cur) {
                right = dfs(matrix, i, j + 1, alreadyKnown);
            }
            if (i - 1 >= 0 && matrix[i - 1][j] > cur) {
                up = dfs(matrix, i - 1, j, alreadyKnown);
            }
            if (i + 1 < matrix.length && matrix[i + 1][j] > cur) {
                down = dfs(matrix, i + 1, j, alreadyKnown);
            }
            alreadyKnown[i][j] = 1 + Math.max(left, Math.max(right, Math.max(up, down)));
            return alreadyKnown[i][j];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
