//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 448 👎 0


package com.qiuyu.leetcode.editor.cn;

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(1, 2, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] visited;
        int res;
        public int movingCount_20220518(int m, int n, int k) {
            visited = new boolean[m][n];
            res = 0;
            dfs_20220518(m, n, 0, 0, k);
            return res;

        }

        public void dfs_20220518(int m, int n, int i, int j, int k) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            if (digitSum(i) + digitSum(j) > k) {
                return;
            }
            res++;
            visited[i][j] = true;
            dfs_20220518(m, n, i + 1, j, k);
            dfs_20220518(m, n, i - 1, j, k);
            dfs_20220518(m, n, i, j + 1, k);
            dfs_20220518(m, n, i, j - 1, k);
        }

        private int digitSum(int x) {
            int res = 0;
            int tmp = x;
            while (tmp != 0) {
                res += tmp % 10;
                tmp /= 10;
            }
            return res;
        }

        public int movingCount(int m, int n, int k) {
            return movingCount_20220518(m, n, k);
        }







        public int movingCount_old(int m, int n, int k) {
            int[][] board = new int[m][n];
            dfs(board, 0, 0, k);
            int count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(int[][] board, int i, int j, int k) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 0) {
                return;
            }

            if (placeSum(i) + placeSum(j) > k) {
                board[i][j] = 2;
                return;
            }
            board[i][j] = 1;
            dfs(board, i - 1, j, k);
            dfs(board, i + 1, j, k);
            dfs(board, i, j - 1, k);
            dfs(board, i, j + 1, k);

        }

        private int placeSum(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
