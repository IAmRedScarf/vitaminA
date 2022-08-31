//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 706 👎 0


package com.qiuyu.leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings_20220501_a(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int res = 0;
            for (int center = 0; center < s.length(); ++center) {
                int left = center, right = center;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }

            for (int center = 0; center < s.length() - 1; ++center) {
                int left = center, right = center + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }


            return res;


        }



        public int countSubstrings_20220501(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); ++i) {
                dp[i][i] = true;
            }
            int res = 0;
            for (int j = 0; j < s.length(); ++j) {
                for (int i = j; i >= 0; --i) {
                    if (j - i < 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        res++;
                    }
                }
            }

            return res;


        }




        public int countSubstrings(String s) {
            return countSubstrings_20220501_a(s);
        }






        public int countSubstrings_old(String s) {
            if (s == null) {
                throw new IllegalArgumentException();
            }
            if (s.length() <= 1) {
                return s.length();
            }
            int res = 0;
//            boolean[][] dp = new boolean[s.length()][s.length()];
//            for (int j = 0; j < s.length(); ++j) {
//                for (int i = 0; i <= j; ++i) {
//                    if ((s.charAt(i) == s.charAt(j)) && (j - i <= 1 || dp[i + 1][j - 1])) {
//                        dp[i][j] = true;
//                        ++res;
//                    }
//                }
//            }
            for (int center = 0; center < s.length(); ++center) {
                int left = center, right = center;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }

            for (int center = 0; center < s.length() - 1; ++center) {
                int left = center, right = center + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
