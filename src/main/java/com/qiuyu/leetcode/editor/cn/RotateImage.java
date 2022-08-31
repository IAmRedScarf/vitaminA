//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 👍 1063 👎 0


package com.qiuyu.leetcode.editor.cn;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate_20220430(int[][] matrix) {
            if (matrix == null) {
                return;
            }
            int n = matrix.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;

                }

            }

        }











        public void rotate(int[][] matrix) {
            rotate_20220430(matrix);
//            int n = matrix.length;
//            for (int i = 0; i < n / 2; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    int tmp = matrix[i][j];
//                    matrix[i][j] = matrix[n - 1- i][j];
//                    matrix[n - 1- i][j] = tmp;
//                }
//            }
//
//            for (int i = 0; i < n; ++i) {
//                for (int j = i; j < n; ++j) {
//                    int tmp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = tmp;
//                }
//            }


        }




















//        private void f1(int[][] matrix) {
//            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
//                return;
//            }
//            int n = matrix.length;
//            int totalCircles = n / 2;
//            for (int circle = 0; circle <= totalCircles; ++circle) {
//                int len = n - circle * 2 - 1;
//                for (int i = 0; i < len; ++i) {
//                    int tmp = matrix[circle][circle + i];
//                    matrix[circle][circle + i] = matrix[n - 1 - circle - i][circle];
//                    matrix[n - 1 - circle - i][circle] = matrix[n - 1 - circle][n - 1 - circle - i];
//                    matrix[n - 1 - circle][n - 1 - circle - i] = matrix[circle + i][n - 1 - circle];
//                    matrix[circle + i][n - 1 - circle] = tmp;
//
//                }
//            }
//        }


















//        private void f2(int[][] matrix) {
//            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
//                return;
//            }
//            int n = matrix.length;
//            for (int i = 0; i < n / 2; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    int tmp = matrix[i][j];
//                    matrix[i][j] = matrix[n - 1 - i][j];
//                    matrix[n - 1 - i][j] = tmp;
//                }
//            }
//
//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < i; ++j) {
//                    int tmp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = tmp;
//                }
//            }
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}



