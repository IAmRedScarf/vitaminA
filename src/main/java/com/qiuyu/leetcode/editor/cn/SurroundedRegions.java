//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 739 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return;
            }
            if (board[i][j] == 'X' || board[i][j] == '#') {
                return;
            }
            board[i][j] = '#';
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }
            int rows = board.length, cols = board[0].length;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        if (board[i][j] == 'O') {
                            dfs(board, i, j);
                        }
                    }
                }
            }

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    char c = board[i][j];
                    if (c == '#') {
                        board[i][j] = 'O';
                    } else if (c == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }












//            int rows = board.length, cols = board[0].length;
//            Union_Find union_find = new Union_Find(rows * cols + 1);
//            int dummyNode = rows * cols;

//            for (int i = 0; i < rows; ++i) {
//                for (int j = 0; j < cols; ++j) {
//                    if (board[i][j] == 'O') {
//                        int curIndex = i * cols + j;
//                        if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
//                            union_find.union(curIndex, dummyNode);
//                        } else {
//                            if (board[i - 1][j] == 'O') {
//                                union_find.union(curIndex, (i - 1) * cols + j);
//                            }
//                            if (board[i + 1][j] == 'O') {
//                                union_find.union(curIndex, (i + 1) * cols + j);
//                            }
//                            if (board[i][j - 1] == 'O') {
//                                union_find.union(curIndex, i * cols + j - 1);
//                            }
//                            if (board[i][j + 1] == 'O') {
//                                union_find.union(curIndex, i * cols + j + 1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            for (int i = 0; i < rows; ++i) {
//                for (int j = 0; j < cols; ++j) {
//                    if (board[i][j] == 'O' && !union_find.isConnected(i * cols + j, dummyNode)) {
//                        board[i][j] = 'X';
//                    }
//                }
//            }
    }


    /**
     * 连通图
     */
    private class Union_Find {
        private int[] parent;

        public Union_Find(int num) {
            parent = new int[num];
            for (int i = 0; i < num; ++i) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int xParent = findParent(x);
            int yParent = findParent(y);
            if (xParent != yParent) {
                parent[yParent] = xParent;
            }
        }

        public int findParent(int x) {
            if (x != parent[x]) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }

        private boolean isConnected(int x, int y) {
            int xParent = findParent(x);
            int yParent = findParent(y);
            return xParent == yParent;
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
