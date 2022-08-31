//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 643 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        char[] a1 = new char[]{'o', 'a', 'a', 'n'};
        char[] a2 = new char[]{'e', 't', 'a', 'e'};
        char[] a3 = new char[]{'i', 'h', 'k', 'r'};
        char[] a4 = new char[]{'i', 'f', 'l', 'v'};
        char[][] board = new char[4][];
        board[0] = a1;
        board[1] = a2;
        board[2] = a3;
        board[3] = a4;
        solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        char[][] board;
//        Set<String> wordSet;
//        boolean[][] isVisited;
//        List<String> ans = new ArrayList<>();
//
//        public List<String> findWords(char[][] _board, String[] words) {
//            if (_board == null || _board.length == 0 || _board[0].length == 0) {
//                return new ArrayList<>();
//            }
//            board = _board;
//            wordSet = new HashSet<>(Arrays.asList(words));
//            isVisited = new boolean[board.length][board[0].length];
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < board.length; ++i) {
//                for (int j = 0; j < board[0].length; ++j) {
//                    dfs1(i, j, sb);
//                }
//            }
//            return ans;
//
//        }
//
//        private void dfs1(int i, int j, StringBuilder sb) {
//            if (sb.length() > 10) {
//                return;
//            }
//            if (wordSet.contains(sb.toString())) {
//                ans.add(sb.toString());
//                wordSet.remove(sb.toString());
//            }
//            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) {
//                return;
//            }
//
//            isVisited[i][j] = true;
//            sb.append(board[i][j]);
//            dfs1(i + 1, j, sb);
//            dfs1(i - 1, j, sb);
//            dfs1(i, j + 1, sb);
//            dfs1(i, j - 1, sb);
//            sb.deleteCharAt(sb.length() - 1);
//            isVisited[i][j] = false;
//        }


        char[][] board;
        boolean[][] isVisited;
        Trie trieRoot;
        Set<String> res = new HashSet<>();

        public List<String> findWords(char[][] _board, String[] words) {
            if (_board == null || _board.length == 0 || _board[0].length == 0) {
                return new ArrayList<>();
            }
            board = _board;
            trieRoot = new Trie();
            for (String word : words) {
                trieRoot.insert(word);
            }

            isVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    dfs(i, j, trieRoot);
                }
            }
            return new ArrayList<>(res);


        }

        private void dfs(int i, int j, Trie now) {
            if (now.isEnd) {
                res.add(now.word);
            }

            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) {
                return;
            }
            if (now.next[board[i][j] - 'a'] == null) {
                return;
            }

            isVisited[i][j] = true;
            dfs(i + 1, j, now.next[board[i][j] - 'a']);
            dfs(i - 1, j, now.next[board[i][j] - 'a']);
            dfs(i, j + 1, now.next[board[i][j] - 'a']);
            dfs(i, j - 1, now.next[board[i][j] - 'a']);

            isVisited[i][j] = false;
        }

        class Trie {
            private boolean isEnd;
            private Trie[] next;
            private String word;

            public Trie() {
                isEnd = false;
                next = new Trie[26];
            }

            public void insert(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); ++i) {
                    int index = word.charAt(i) - 'a';
                    if (cur.next[index] == null) {
                        cur.next[index] = new Trie();
                    }
                    cur = cur.next[index];
                }
                cur.isEnd = true;
                cur.word = word;
            }

            public boolean search(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); ++i) {
                    int index = word.charAt(i) - 'a';
                    cur = cur.next[index];
                    if (cur == null) {
                        return false;
                    }
                }
                return cur.isEnd;
            }

            public boolean startWith(String prefix) {
                Trie curNode = this;
                for (int i = 0; i < prefix.length(); ++i) {
                    char ch = prefix.charAt(i);
                    int index = ch - 'a';
                    curNode = curNode.next[index];
                    if (curNode == null) {
                        break;
                    }
                }
                return curNode != null;
            }


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
