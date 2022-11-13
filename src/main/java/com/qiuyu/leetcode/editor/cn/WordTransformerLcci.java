//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 64 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class WordTransformerLcci {
    public static void main(String[] args) {
        Solution solution = new WordTransformerLcci().new Solution();
        String[] wordArray = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(solution.findLadders("hit", "cog", Arrays.asList(wordArray)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean flag = false;
        Set<String> wordSet;
        Set<String> visited;
        List<String> path;
        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            path = new ArrayList<>();
            wordSet = new HashSet<>(wordList);
            visited = new HashSet<>();
            dfs(beginWord, endWord);
            return path;
        }


        private boolean dfs(String curWord,String target) {
            if (flag) {
                return true;
            }
            path.add(curWord);
            Set<String> canReachWords = getChangedWord(curWord);
            if (canReachWords.contains(target)) {
                flag = true;
                path.add(target);
                return true;
            }
            if (canReachWords.isEmpty()) {
                path.remove(path.size() - 1);
                return false;
            }
            boolean res = false;
            for (String next : canReachWords) {
                if (dfs(next, target)) {
                    res = true;
                }
            }
            if (!res) {
                path.remove(path.size() - 1);
            }
            return res;
        }

        Set<String> getChangedWord(String curWord) {
            Set<String> res = new HashSet<>();
            for (int i = 0; i < curWord.length(); ++i) {
                StringBuilder sb = new StringBuilder(curWord);
                char c = curWord.charAt(i);
                for (int j = 0; j < 26; ++j) {
                    if (c - 'a' == j) {
                        continue;
                    }
                    sb.setCharAt(i, (char) ('a' + j));
                    String tmp = sb.toString();
                    if (wordSet.contains(tmp) && !visited.contains(tmp)) {
                        res.add(tmp);
                        visited.add(tmp);
                    }
                    sb.setCharAt(i, c);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
