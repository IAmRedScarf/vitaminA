//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1039 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int j = 0; j < s.length(); ++j) {
                for (int i = 0; i <= j; ++i) {
                    if (j == i) {
                        dp[i][j] = true;
                    } else if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 2 || dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }


            List<String> tmp = new ArrayList<>();
            dfs_001(s, 0, tmp, res, dp);
            return res;
        }

        private void dfs_001(String s, int startIndex, List<String> tmp, List<List<String>> res, boolean[][] dp) {
            if (startIndex == s.length()) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = startIndex; i < s.length(); ++i) {
                if (dp[startIndex][i]) {
                    tmp.add(s.substring(startIndex, i + 1));
                    dfs_001(s, i + 1, tmp, res, dp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }


        private void dfs(String sRemain, List<String> tmp, List<List<String>> res) {
            if (sRemain.equals("")) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < sRemain.length(); ++i) {
                String cutS = sRemain.substring(0, i + 1);
                if (isValid(cutS)) {
                    tmp.add(cutS);
                    dfs(sRemain.substring(i + 1), tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }

        }

        private boolean isValid(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
