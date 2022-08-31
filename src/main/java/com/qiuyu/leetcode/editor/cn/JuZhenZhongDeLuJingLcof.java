//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 521 👎 0


package com.qiuyu.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean exist_20220518(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
                return false;
            }
            int rows = board.length, cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (dfs_20220518(board, visited, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;

        }

        private boolean dfs_20220518(char[][] board, boolean[][] visited, int i, int j, String word, int start) {
            if (start == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }
            if (visited[i][j]) {
                return false;
            }
            if (board[i][j] != word.charAt(start)) {
                return false;
            }
            visited[i][j] = true;
            boolean res = dfs_20220518(board, visited, i + 1, j, word, start + 1)
                    || dfs_20220518(board, visited, i - 1, j, word, start + 1)
                    || dfs_20220518(board, visited, i, j + 1, word, start + 1)
                    || dfs_20220518(board, visited, i, j - 1, word, start + 1);
            visited[i][j] = false;
            return res;
        }


        public boolean exist(char[][] board, String word) {
            return exist_20220518(board, word);
        }













        public boolean exist_old(char[][] board, String word) {
            int rows = board.length, cols = board[0].length;
            boolean[][] isVisited = new boolean[rows][cols];

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    if (backtrack(word, 0, board, i, j, isVisited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(String word, int start, char[][] board, int i, int j, boolean[][] isVisited) {
            if (start == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) {
                return false;
            }
            if (board[i][j] != word.charAt(start)) {
                return false;
            }
            isVisited[i][j] = true;
            boolean res = backtrack(word, start + 1, board, i - 1, j, isVisited)
                    || backtrack(word, start + 1, board, i + 1, j, isVisited)
                    || backtrack(word, start + 1, board, i, j - 1, isVisited)
                    || backtrack(word, start + 1, board, i, j + 1, isVisited);
            isVisited[i][j] = false;
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
