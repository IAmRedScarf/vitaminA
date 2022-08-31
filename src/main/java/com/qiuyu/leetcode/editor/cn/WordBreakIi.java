//给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可
//能的句子。 
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 回溯 👍 580 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        solution.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0 || wordDict.size() == 0) {
                return res;
            }

            Set<String> wordSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i < s.length(); ++i) {
                for (int j = 0; j <= i; ++j) {
                    String suffix = s.substring(j, i + 1);
                    if (dp[j] && wordSet.contains(suffix)) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }

            if (dp[s.length()]) {
                dfs(s, s.length() - 1, dp, wordSet, new LinkedList<>(), res);
            }
            return res;
        }


        private void dfs(String s, int suffixEndIndex, boolean[] dp, Set<String> wordSet, List<String> path, List<String> res) {
            if (suffixEndIndex < 0) {
                res.add(String.join(" ", path));
            } else {
                for (int i = suffixEndIndex; i >= 0; --i) {
                    if (dp[i]) {
                        String suffix = s.substring(i, suffixEndIndex + 1);
                        if (wordSet.contains(suffix)) {
                            path.add(0, suffix);
                            dfs(s, i - 1, dp, wordSet, path, res);
                            path.remove(0);

                        }
                    }
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
