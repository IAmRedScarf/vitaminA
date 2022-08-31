//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
//
// 
//
// 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/ 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 27 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class TwoBCMpM {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            Deque<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] == 0) {
                        queue.addLast(new int[] {i, j});
                    } else if (mat[i][j] == 1) {
                        mat[i][j] = -1;
                    }
                }
            }

            int[] dx = new int[] {0, 0, -1, 1};
            int[] dy = new int[] {1, -1, 0, 0};

            while (!queue.isEmpty()) {
                int[] head = queue.pollFirst();
                int i = head[0], j = head[1];
                for (int k = 0; k < 4; ++k) {
                    int newX = i + dx[k], newY = j + dy[k];
                    if (newX < m && newX >= 0 && newY < n && newY >= 0 && mat[newX][newY] == -1) {
                        mat[newX][newY] = mat[i][j] + 1;
                        queue.addLast(new int[] {newX, newY});
                    }
                }
            }
            return mat;
        }


        public int[][] updateMatrix_20220708(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] == 2) {
                        continue;
                    }
                    if (mat[i][j] == 0) {
                        // 用2标识已经访问过的0
                        mat[i][j] = 2;
                        Deque<int[]> queue = new LinkedList<>();
                        queue.addLast(new int[]{i, j});
                        int step = 1;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int k = 0; k < size; ++k) {
                                int[] head = queue.pollFirst();
                                int ii = head[0], jj = head[1];
                                if (ii + 1 < m) {
                                    if (mat[ii + 1][jj] != 0 && mat[ii + 1][jj] != 2) {
                                        if (mat[ii + 1][jj] == 1 || -mat[ii + 1][jj] > step) {
                                            queue.addLast(new int[]{ii + 1, jj});
                                            mat[ii + 1][jj] = -step;
                                        }
                                    }
                                }
                                if (ii - 1 >= 0) {
                                    if (mat[ii - 1][jj] != 0 && mat[ii - 1][jj] != 2) {
                                        if (mat[ii - 1][jj] == 1 || -mat[ii - 1][jj] > step) {
                                            queue.addLast(new int[]{ii - 1, jj});
                                            mat[ii - 1][jj] = -step;
                                        }
                                    }
                                }
                                if (jj + 1 < n) {
                                    if (mat[ii][jj + 1] != 0 && mat[ii][jj + 1] != 2) {
                                        if (mat[ii][jj + 1] == 1 || -mat[ii][jj + 1] > step) {
                                            queue.addLast(new int[]{ii, jj + 1});
                                            mat[ii][jj + 1] = -step;
                                        }
                                    }
                                }
                                if (jj - 1 >= 0) {
                                    if (mat[ii][jj - 1] != 0 && mat[ii][jj - 1] != 2) {
                                        if (mat[ii][jj - 1] == 1 || -mat[ii][jj - 1] > step) {
                                            queue.addLast(new int[]{ii, jj - 1});
                                            mat[ii][jj - 1] = -step;
                                        }
                                    }
                                }

                            }
                            step++;
                        }
                    }

                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] == 2) {
                        mat[i][j] = 0;
                    } else if (mat[i][j] < 0) {
                        mat[i][j] = -mat[i][j];
                    }
                }
            }


            return mat;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
