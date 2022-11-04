//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 数组 二分查找 分治 矩阵 👍 49 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SortedMatrixSearchLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMatrixSearchLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }
            int m = matrix.length, n = matrix[0].length;
            int i = m - 1, j = 0;
            while (i >= 0 && j < n) {
                int pivot = matrix[i][j];
                if (pivot == target) {
                    return true;
                } else if (pivot < target) {
                    j++;
                } else {
                    i--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
