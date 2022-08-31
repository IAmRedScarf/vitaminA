//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1100 👎 0


package com.qiuyu.leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean exist_20220503(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dfs_20220503(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }

            return false;

        }

        private boolean dfs_20220503(char[][] board, int i, int j, String word, int curIndex, boolean[][] visited) {
            if (curIndex == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
                return false;
            }
            if (board[i][j] != word.charAt(curIndex)) {
                return false;
            }
            visited[i][j] = true;
            boolean res = dfs_20220503(board, i + 1, j, word, curIndex + 1, visited)
                    || dfs_20220503(board, i - 1, j, word, curIndex + 1, visited)
                    || dfs_20220503(board, i, j + 1, word, curIndex + 1, visited)
                    || dfs_20220503(board, i, j - 1, word, curIndex + 1, visited);
            visited[i][j] = false;

            return res;

        }










        public boolean exist(char[][] board, String word) {
            return exist_20220503(board, word);
        }




        public boolean exist_old(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            boolean[][] isVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (dfs1(board, i, j, word, 0, isVisited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs1(char[][] board, int i, int j, String word, int start, boolean[][] isVisited) {
            if (start == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) {
                return false;
            }

            if (word.charAt(start) != board[i][j]) {
                return false;
            }
            isVisited[i][j] = true;
            boolean res = dfs1(board, i + 1, j, word, start + 1, isVisited)
                    || dfs1(board, i - 1, j, word, start + 1, isVisited)
                    || dfs1(board, i, j + 1, word, start + 1, isVisited)
                    || dfs1(board, i, j - 1, word, start + 1, isVisited);
            if (!res) {
                isVisited[i][j] = false;
                return false;
            } else {
                return true;
            }
        }


        private boolean dfs(char[][] board, String word, int start, int i, int j, boolean[][] isVisited) {
            if (start == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }
            if (isVisited[i][j]) {
                return false;
            }

            if (word.charAt(start) != board[i][j]) {
                return false;
            }

            isVisited[i][j] = true;
            boolean res = dfs(board, word, 1 + start, i + 1, j, isVisited)
                    || dfs(board, word, 1 + start, i - 1, j, isVisited)
                    || dfs(board, word, 1 + start, i, j + 1, isVisited)
                    || dfs(board, word, 1 + start, i, j - 1, isVisited);
            isVisited[i][j] = false;
            return res;

        }


        public boolean exist00(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0) {
                return false;
            }
            boolean[][] isVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (dfs(board, word, 0, i, j, isVisited)) {
                        return true;
                    }
                }
            }
            return false;


//        int m = board.length, n = board[0].length;
//        boolean[][] isVisited = new boolean[m][n];
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (backTrack(board, i, j, 0, word, isVisited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
        }

//    private boolean backTrack(char[][] board, int i, int j, int cur, String word, boolean[][] isVisited) {
//        if (cur == word.length()) {
//            return true;
//        }
//        if (i < 0 || i == board.length || j < 0 || j == board[0].length || isVisited[i][j]) {
//            return false;
//        }
//
//        if (board[i][j] != word.charAt(cur)) {
//            return false;
//        }
//
//        isVisited[i][j] = true;
//        boolean res = backTrack(board, i + 1, j, cur + 1, word, isVisited)
//                || backTrack(board, i -1, j, cur + 1, word, isVisited)
//                || backTrack(board, i, j + 1, cur + 1, word, isVisited)
//                || backTrack(board, i, j - 1, cur + 1, word, isVisited);
//        isVisited[i][j] = false;
//        return res;
//
//
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
