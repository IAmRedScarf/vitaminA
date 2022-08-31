//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 645 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        int[] a = new int[] {1,5,9};
        int[] b = new int[] {10,11,13};
        int[] c = new int[] {12,13,15};
        int[][] matrix = new int[3][3];
        matrix[0] = a;
        matrix[1] = b;
        matrix[2] = c;
        solution.kthSmallest(matrix, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int lessOrEqualCount(int[][] matrix, int x) {
            int m = matrix.length, n = matrix[0].length;

            int res = 0;
            int i = matrix.length - 1, j = 0;
            while (i >= 0 && j <= n - 1) {
                if (matrix[i][j] <= x) {
                    res += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return res;
        }



        public int kthSmallest(int[][] matrix, int k) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                throw new IllegalArgumentException();
            }
            int m = matrix.length, n = matrix[0].length;
            if (k > m * n) {
                throw new IllegalArgumentException();
            }
            int leftVal = matrix[0][0], rightVal = matrix[m - 1][n - 1];
            while (leftVal < rightVal) {
                int mid = leftVal + (rightVal - leftVal) / 2;
                int lessOrEqualCnt = lessOrEqualCount(matrix, mid);

                if (lessOrEqualCnt == k) {
                    // 1. 如果此时mid=b不是矩阵中的元素，那么必定存在矩阵中的元素a，且小于并等于a的个数为k，也需要返回这个a。此时rightVal为b，并保持该值，一直到退出循环
                    rightVal = mid;
                } else if (lessOrEqualCnt < k) {
                    // 2. 当注释1情况出现时，之后的循环，都会走这一分支，直到leftVal = a，下一次循环中，mid将被置为a，并导致right=left=a，然后退出循环
                    leftVal = mid + 1;
                } else {
                    rightVal = mid;
                }
            }
            return leftVal;















//            if (k > n * m) {
//                throw new IllegalArgumentException();
//            }
//            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[0] - o2[0];
//                }
//            });
//
//            // 第几行，第几列的值
//            for (int i = 0; i < m; ++i) {
//                pq.add(new int[]{matrix[i][0], i, 0});
//            }
//            int rank = 1;
//            for (; rank < k; ++rank) {
//                int[] cur = pq.poll();
//                int rowIndex = cur[1], colIndex = cur[2];
//                if (colIndex < n - 1) {
//                    pq.add(new int[] {matrix[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
//                }
//            }
//            return (pq.poll())[0];









//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
//            throw new IllegalArgumentException();
//        }
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int left = matrix[0][0], right = matrix[rows - 1][cols - 1];
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            int count = findNumOfNotBigger(matrix, mid, rows, cols);
//            if (count < k) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;


//        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                return a[0] - b[0];
//            }
//        });
//        int n = matrix.length;
//        for (int i = 0; i < n; i++) {
//            pq.offer(new int[]{matrix[i][0], i, 0});
//        }
//        for (int i = 0; i < k - 1; i++) {
//            int[] now = pq.poll();
//            if (now[2] != n - 1) {
//                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
//            }
//        }
//        return pq.poll()[0];
        }

        private int findNumOfNotBigger(int[][] matrix, int target, int rows, int cols) {
            int i = rows - 1, j = 0;
            int count = 0;
            while (i >= 0 && j < cols) {
                if (matrix[i][j] <= target) {
                    count += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
