//给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。 
//
// 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 
//最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
//输出: [1,0,2]
//解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
// 
//
// 示例 2: 
//
// 输入:
//[
//   [0,1,1],
//   [1,0,1],
//   [1,1,0]
//]
//输出: [0,0,1]
// 
//
// 提示： 
//
// 
// matrix.length == matrix[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 44 👎 0


package com.qiuyu.leetcode.editor.cn;

public class MaxBlackSquareLcci {
    public static void main(String[] args) {
        Solution solution = new MaxBlackSquareLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findSquare(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] rightMatrix = new int[m][n];
            int[][] downMatrix = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int curJ = j;
                    while (curJ < n && matrix[i][curJ] == 0) {
                        rightMatrix[i][j]++;
                        curJ++;
                    }
                    int curI = i;
                    while (curI < m && matrix[curI][j] == 0) {
                        downMatrix[i][j]++;
                        curI++;
                    }
                }
            }
            int targetSquareLen = 0;
            int targetI = 0, targetJ = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int curSquareLen = Math.min(rightMatrix[i][j], downMatrix[i][j]);
                    while (curSquareLen > 0) {
                        int rightJ = j + curSquareLen - 1;
                        int downI = i + curSquareLen - 1;
                        if (downMatrix[i][rightJ] >= curSquareLen && rightMatrix[downI][j] >= curSquareLen) {
                            break;
                        }
                        curSquareLen--;
                    }
                    if (curSquareLen > targetSquareLen) {
                        targetSquareLen = curSquareLen;
                        targetI = i;
                        targetJ = j;
                    }
                }
            }
            if (targetSquareLen == 0) {
                return new int[0];
            }
            return new int[] {targetI, targetJ, targetSquareLen};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
