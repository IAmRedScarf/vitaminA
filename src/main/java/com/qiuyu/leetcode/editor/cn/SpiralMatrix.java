//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 854 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = new int[3][4];
        System.out.println(solution.spiralOrder(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
//            List<Integer> res = new ArrayList<>();
//            int m = matrix.length, n = matrix[0].length;
//            int N = Math.min(m, n);
//            int circles = N / 2;
//
//            for (int cIndex = 0; cIndex < circles; ++cIndex) {
//                // 上方
//                for (int j = cIndex; j < n - cIndex - 1; ++j) {
//                    res.add(matrix[cIndex][j]);
//                }
//                // 右侧
//                for (int i = cIndex; i < m - cIndex - 1; ++i) {
//                    res.add(matrix[i][n - 1 - cIndex]);
//                }
//                // 下方
//                for (int j = n - 1 - cIndex; j > cIndex; --j) {
//                    res.add(matrix[m - 1- cIndex][j]);
//                }
//
//                // 左侧
//                for (int i = m - 1 - cIndex; i > cIndex; --i) {
//                    res.add(matrix[i][cIndex]);
//                }
//            }
//
//            if (N % 2 == 1) {
//                if (N == m) {
//                    for (int j = circles; j < n - circles; ++j) {
//                        res.add(matrix[N / 2][j]);
//                    }
//                } else {
//                    for (int i = circles; i < m - circles; ++i) {
//                        res.add(matrix[i][N / 2]);
//                    }
//                }
//
//            }
//
//            return res;

















//            List<Integer> order = new ArrayList<Integer>();
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//                return order;
//            }
//            int rows = matrix.length, columns = matrix[0].length;
//            boolean[][] visited = new boolean[rows][columns];
//            int total = rows * columns;
//            int row = 0, column = 0;
//            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//            int directionIndex = 0;
//            for (int i = 0; i < total; i++) {
//                order.add(matrix[row][column]);
//                visited[row][column] = true;
//                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
//                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
//                    directionIndex = (directionIndex + 1) % 4;
//                }
//                row += directions[directionIndex][0];
//                column += directions[directionIndex][1];
//            }
//            return order;







//            // 另一种解法
            List<Integer> order = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            int total = matrix.length * matrix[0].length;
            int i = 0;
            while (i < total) {
                for (int j = left; j <= right && i < total; ++j) {
                    order.add(matrix[top][j]);
                    i++;
                }
                top++;
                for (int j = top; j <= bottom && i < total; ++j) {
                    order.add(matrix[j][right]);
                    i++;
                }
                right--;
                for (int j = right; j >= left && i < total; --j) {
                    order.add(matrix[bottom][j]);
                    i++;
                }
                bottom--;
                for (int j = bottom; j >= top && i < total; --j) {
                    order.add(matrix[j][left]);
                    i++;
                }
                left++;
            }
            return order;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
