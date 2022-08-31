//给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。 
//
// 注意：此题 matrix 输入格式为一维 01 字符串数组。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = ["10100","10111","11111","10010"]
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
//输入：matrix = ["0"]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = ["1"]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = ["00"]
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
//
// 
//
// 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-
//rectangle/ 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 52 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new PLYXKQ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length();

            char[][] matrixChar = new char[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrixChar[i][j] = matrix[i].charAt(j);
                }
            }


            int[][] dp = new int[m][n];
            for (int j = 0; j < n; ++j) {
                dp[0][j] = matrixChar[0][j] - '0';
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    dp[i][j] = matrixChar[i][j] == '0' ? 0 : dp[i - 1][j] + 1;
                }
            }
            int maxArea = 0;
            for (int i = 0; i < m; ++i) {
                maxArea = Math.max(maxArea, maxRect(dp[i]));
            }
            return maxArea;


        }


        private int maxRect(int[] nums) {
            int len = nums.length;
            int[] rightFirstSmaller = new int[len];
            // 从栈顶到栈底递减
            Deque<int[]> decreaseStack = new LinkedList<>();
            for (int i = len - 1; i >= 0; --i) {
                while (!decreaseStack.isEmpty() && decreaseStack.peekLast()[1] >= nums[i]) {
                    decreaseStack.pollLast();
                }
                rightFirstSmaller[i] = decreaseStack.isEmpty() ? len : decreaseStack.peekLast()[0];
                decreaseStack.addLast(new int[] {i , nums[i]});
            }
            decreaseStack.clear();
            int[] leftFirstSmaller = new int[len];
            int res = 0;
            for (int i = 0; i < len; ++i) {
                while (!decreaseStack.isEmpty() && decreaseStack.peekLast()[1] >= nums[i]) {
                    decreaseStack.pollLast();
                }
                leftFirstSmaller[i] = decreaseStack.isEmpty() ? -1 : decreaseStack.peekLast()[0];
                int width = rightFirstSmaller[i] - leftFirstSmaller[i] - 1;
                res = Math.max(res, nums[i] * width);
                decreaseStack.addLast(new int[] {i, nums[i]});
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
