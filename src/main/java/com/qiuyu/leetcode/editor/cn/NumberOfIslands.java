//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1484 👎 0


package com.qiuyu.leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            return numIslands20230220(grid);
        }

        public int numIslands20230220(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int cnt = 0;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        if (!visited[i][j]) {
                            cnt++;
                            spread(grid, visited, i, j);
                        }
                    }
                }
            }
            return cnt;
        }

        private void spread(char[][] grid, boolean[][] visited, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            visited[i][j] = true;
            spread(grid, visited, i + 1, j);
            spread(grid, visited, i - 1, j);
            spread(grid, visited, i,j + 1);
            spread(grid, visited, i, j - 1);

        }









        public int numIslands_20220429(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int res = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        res++;
                        dfs_20220429(grid, i, j, visited);
                    }
                }
            }
            return res;

        }

        private void dfs_20220429(char[][] grid, int i, int j, boolean[][] visited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            visited[i][j] = true;
            dfs(grid, i + 1, j, visited);
            dfs(grid, i - 1, j, visited);
            dfs(grid, i, j + 1, visited);
            dfs(grid, i, j - 1, visited);
        }

        public int numIslands2022222222222(char[][] grid) {
            return numIslands_20220429(grid);
//            if (grid == null || grid.length == 0) {
//                return 0;
//            }
//            int res = 0;
//            boolean[][] isVisited = new boolean[grid.length][grid[0].length];
//            for (int i = 0; i < grid.length; ++i) {
//                for (int j = 0; j < grid[0].length; ++j) {
//                    if (grid[i][j] == '1' && !isVisited[i][j]) {
//                        ++res;
//                        dfs(grid, i, j, isVisited);
//                    }
//                }
//            }
//            return res;

//            int res = 0;
//            for (int i = 0; i < grid.length; ++i) {
//                for (int j = 0; j < grid[0].length; ++j) {
//                    if (grid[i][j] == '1') {
//                        ++res;
//                        spreadIsland(grid, i, j);
//                    }
//                }
//            }
//            return res;
        }



        private void spreadIsland(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
                return;
            }
            if (grid[i][j] != '1') {
                return;
            }
            grid[i][j] = '2';
            spreadIsland(grid, i + 1, j);
            spreadIsland(grid, i - 1, j);
            spreadIsland(grid, i, j + 1);
            spreadIsland(grid, i, j - 1);
        }


        private void dfs(char[][] grid, int i, int j, boolean[][] isVisited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] != '1' || isVisited[i][j]) {
                return;
            }

            isVisited[i][j] = true;
            dfs(grid, i - 1, j, isVisited);
            dfs(grid, i + 1, j, isVisited);
            dfs(grid, i, j - 1, isVisited);
            dfs(grid, i, j + 1, isVisited);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
