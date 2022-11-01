//给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符
//合要求的单词则返回空字符串。 
//
// 示例： 
//
// 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
//输出： "dogwalker"
//解释： "dogwalker"可由"dog"和"walker"组成。
// 
//
// 提示： 
//
// 
// 0 <= len(words) <= 200 
// 1 <= len(words[i]) <= 100 
// 
// Related Topics 字典树 数组 哈希表 字符串 👍 43 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordLcci {
    public static void main(String[] args) {
        Solution solution = new LongestWordLcci().new Solution();
        String[] words = new String[] {"ttaaaa","pp","tpa","kpaqkt","tktpqq","aqppatp"};
        System.out.println(solution.longestWord(words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 前提是，用例中无相同的单词
        public String longestWord(String[] words) {
            Arrays.sort(words, (s1, s2) -> {
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                } else {
                    return s1.compareTo(s2);
                }
            });
            Set<String> wordSet = new HashSet<>(Arrays.asList(words));

            for (String word : words) {
                wordSet.remove(word);
                if (find(word, wordSet)) {
                    // 排除自身
                    return word;
                }
            }
            return "";
        }

        public boolean find(String word, Set<String> wordSet) {
            if (word.length() == 0) {
                return true;
            }
            for (int i = 0; i < word.length(); ++i) {
                if (wordSet.contains(word.substring(0, i + 1)) && find(word.substring(i + 1), wordSet)) {
                    return true;
                }
            }
            return false;
        }


    }

    class TrieNode {
        public TrieNode[] next;
        public int wordNum;
        public boolean endFlag;

        public TrieNode() {
            next = new TrieNode[26];
            wordNum = 0;

        }

        public void insert(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            (cur.wordNum)++;
            endFlag = true;
        }

        public boolean search(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return cur.endFlag;
        }

        public boolean hasPrefix(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
