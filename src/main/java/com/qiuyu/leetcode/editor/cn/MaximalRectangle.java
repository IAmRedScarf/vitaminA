//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1095 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        char[][] matrix = new char[4][5];
        matrix[0] = new char[] {'1','0','1','0','0'};
        matrix[1] = new char[] {'1','0','1','1','1'};
        matrix[2] = new char[] {'1','1','1','1','1'};
        matrix[3] = new char[] {'1','0','0','1','0'};
        solution.maximalRectangle_20220511(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle_20220511(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] tmpMatrix = new int[m][n];
            for (int j = 0; j < n; ++j) {
                tmpMatrix[0][j] = matrix[0][j] == '1' ? 1 : 0;
            }
            int res = maxRectangle_helper(tmpMatrix[0]);
            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == '0') {
                        tmpMatrix[i][j] = 0;
                    } else {
                        tmpMatrix[i][j] = tmpMatrix[i - 1][j] + 1;
                    }
                }
                res = Math.max(res, maxRectangle_helper(tmpMatrix[i]));
            }
            return res;

        }

        private int maxRectangle_helper(int[] nums) {
            int[] leftFirstSmall = new int[nums.length];
            Arrays.fill(leftFirstSmall, -1);

            // 栈中存储下标
            Deque<Integer> tmpStack = new LinkedList<>();
            for (int i = nums.length - 1; i >= 0; --i) {
                while (!tmpStack.isEmpty()) {
                    int top = tmpStack.peekLast();
                    if (nums[i] < nums[top]) {
                        leftFirstSmall[top] = i;
                        tmpStack.pollLast();
                    } else {
                        break;
                    }
                }
                tmpStack.addLast(i);
            }

            tmpStack.clear();
            int[] rightFirstSmall = new int[nums.length];
            Arrays.fill(rightFirstSmall, nums.length);
            for (int i = 0; i < nums.length; ++i) {
                while (!tmpStack.isEmpty()) {
                    int top = tmpStack.peekLast();
                    if (nums[i] < nums[top]) {
                        rightFirstSmall[top] = i;
                        tmpStack.pollLast();
                    } else {
                        break;
                    }
                }
                tmpStack.addLast(i);
            }
            int res = 0;
            for (int i = 0; i < nums.length; ++i) {
                int distance = rightFirstSmall[i] - leftFirstSmall[i] - 1;
                res = Math.max(distance * nums[i], res);
            }
            return res;
        }







        public int maximalRectangle(char[][] matrix) {
            return maximalRectangle_20220511(matrix);
        }














        public int maximalRectangle_old(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
            int rows = matrix.length, cols = matrix[0].length;
            int[][] heights = new int[rows][cols];
            for (int j = 0; j < cols; ++j) {
                heights[0][j] = matrix[0][j] == '1' ? 1 : 0;
            }
            for (int i = 1; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    heights[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    if (heights[i][j] == 1) {
                        heights[i][j] += heights[i - 1][j];
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < rows; ++i) {
                res = Math.max(maxRect(heights[i]), res);
            }
            return res;

        }

        private int maxRect(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int[] leftFirstLess = new int[heights.length];
            int[] rightFirstLess = new int[heights.length];
            Deque<Integer> tmpStack = new LinkedList<>();
            for (int i = 0; i < heights.length; ++i) {
                while (!tmpStack.isEmpty() && heights[tmpStack.peek()] >= heights[i]) {
                    tmpStack.pop();
                }
                leftFirstLess[i] = tmpStack.isEmpty() ? -1 : tmpStack.peek();
                tmpStack.push(i);
            }
            tmpStack.clear();
            for (int i = heights.length - 1; i >= 0; --i) {
                while (!tmpStack.isEmpty() && heights[tmpStack.peek()] >= heights[i]) {
                    tmpStack.pop();
                }
                rightFirstLess[i] = tmpStack.isEmpty() ? heights.length : tmpStack.peek();
                tmpStack.push(i);
            }
            int res = 0;
            for (int i = 0; i < heights.length; ++i) {
                res = Math.max(res, heights[i] * (rightFirstLess[i] - leftFirstLess[i] - 1));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
