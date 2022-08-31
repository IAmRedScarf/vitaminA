//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 253 👎 0


package com.qiuyu.leetcode.editor.cn;

public class MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new MinimumAsciiDeleteSumForTwoStrings().new Solution();
        solution.minimumDeleteSum("delete", "leet");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            if (s1 == null || s2 == null) {
                throw new IllegalArgumentException();
            }
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int len = 1; len <= s1.length(); ++len) {
                dp[len][0] = dp[len - 1][0] + s1.charAt(len - 1);
            }
            for (int len = 1; len <= s2.length(); ++len) {
                dp[0][len] = dp[0][len - 1] + s2.charAt(len - 1);
            }
            for (int len1 = 1; len1 <= s1.length(); ++len1) {
                for (int len2 = 1; len2 <= s2.length(); ++len2) {
                    if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
                        dp[len1][len2] = dp[len1 - 1][len2 - 1];
                    } else {
                        dp[len1][len2] = Math.min(dp[len1 - 1][len2] + s1.charAt(len1 - 1), dp[len1][len2 - 1] + s2.charAt(len2 - 1));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
