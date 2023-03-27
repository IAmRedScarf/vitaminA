//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1358 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreak20230220(s, wordDict);
        }



        public boolean wordBreak20230220(String s, List<String> wordDict) {
            if (wordDict == null || wordDict.size() == 0) {
                return false;
            }
            Set<String> wordSet = new HashSet<>(wordDict);
            // 开区间
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i < s.length(); ++i) {
                for (int j = i; j >= 0; --j) {
                    if (dp[j] && wordSet.contains(s.substring(j, i + 1))) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }








        public boolean wordBreak_20220502(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict.size() == 0) {
                return false;
            }
            Set<String> wordSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i < s.length(); ++i) {
                for (int j = i; j >= 0; --j) {
                    if (dp[j] && wordSet.contains(s.substring(j, i + 1))) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }


        public boolean wordBreak_old(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict.size() == 0) {
                return false;
            }
            Set<String> tmpSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i < s.length(); ++i) {
                for (int j = 0; j <= i; ++j) {
                    String cut = s.substring(j, i + 1);
                    if (dp[j] && tmpSet.contains(cut)) {
                        dp[i + 1] = true;
                        break;
                    }

                }
            }
            return dp[s.length()];



















//            Set<String> wordSet = new HashSet<>(wordDict);
//            boolean[] dp = new boolean[s.length() + 1];
//            dp[0] = true;
//            for (int i = 0; i < s.length(); ++i) {
//                for (int j = 0; j <= i; ++j) {
//                    String cut = s.substring(j, i + 1);
//                    if (wordSet.contains(cut) && dp[j]) {
//                        dp[i + 1] = true;
//                        break;
//                    }
//                }
//            }
//            return dp[s.length()];










//            Set<String> tmpSet = new HashSet<>(wordDict);
//            boolean[] dp = new boolean[s.length() + 1];
//            dp[0] = true;
//            for (int i = 1; i <= s.length(); ++i) {
//                for (int j = i - 1; j >= 0; --j) {
//                    if (dp[i]) {
//                        break;
//                    }
//                    if (dp[j] && tmpSet.contains(s.substring(j, i))) {
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//            return dp[s.length()];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
