//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 997 👎 0


package com.qiuyu.leetcode.editor.cn;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        char[][] aa = new char[6][];

        char[] a = new char[]{'1','0','1','1','0','1'};
        char[] b = new char[]{'1','1','1','1','1','1'};
        char[] c = new char[]{'0','1','1','0','1','1'};
        char[] d = new char[]{'1','1','1','0','1','0'};
        char[] e = new char[]{'0','1','1','1','1','1'};
        char[] f = new char[]{'1','1','0','1','1','1'};
        aa[0] = a;
        aa[1] = b;
        aa[2] = c;
        aa[3] = d;
        aa[4] = e;
        aa[5] = f;
        solution.maximalSquare_20220430(aa);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare_20220426(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
            int rows = matrix.length, cols = matrix[0].length;
            int[][] dp = new int[rows][cols];
            int maxSide = 0;
            for (int i = 0; i < rows; ++i) {
                dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
                maxSide = Math.max(maxSide, dp[i][0]);
            }
            for (int j = 1; j < cols; ++j) {
                dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
                maxSide = Math.max(maxSide, dp[0][j]);
            }
            for (int i = 1; i < rows; ++i) {
                for (int j = 1; j < cols; ++j) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) , dp[i - 1][j - 1]) + 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;

        }





        // 暴力
        public int maximalSquare_20220430(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
            int maxSide = 0;
            int rows = matrix.length, cols = matrix[0].length;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (matrix[i][j] == '1') {
                        maxSide = Math.max(maxSide, 1);

                        int addMax = Math.min(rows - i, cols - j) - 1;
                        for (int add = 1; add <= addMax; ++add) {
                            boolean flag = true;
                            if (matrix[i + add][j + add] != '1') {
                                break;
                            }
                            for (int ii = i + add; ii >= i; --ii) {
                                if (matrix[ii][j + add] != '1') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (!flag) {
                                break;
                            }
                            for (int jj = j + add; jj >= j; --jj) {
                                if (matrix[i + add][jj] != '1') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                maxSide = Math.max(maxSide, add + 1);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return maxSide * maxSide;





        }













        public int maximalSquare(char[][] matrix) {
            return maximalSquare_20220426(matrix);
//            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
//                return 0;
//            }
//            int rows = matrix.length, cols = matrix[0].length;
//            int[][] dp = new int[rows][cols];
//            int maxLen = 0;
//            for (int i = 0; i < rows; ++i) {
//                dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
//                maxLen = Math.max(maxLen, dp[i][0]);
//            }
//            for (int j = 1; j < cols; ++j){
//                dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
//                maxLen = Math.max(maxLen, dp[0][j]);
//            }
//            for (int i = 1; i < rows; ++i) {
//                for (int j = 1; j < cols; ++j) {
//                    char c = matrix[i][j];
//                    if (c != '1') {
//                        dp[i][j] = 0;
//                    } else {
//                        int tmpLen = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
//                        dp[i][j] = tmpLen + 1;
//                    }
//                    maxLen = Math.max(maxLen, dp[i][j]);
//                }
//            }
//            return maxLen * maxLen;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
