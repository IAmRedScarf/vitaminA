//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3883 👎 0


package com.qiuyu.leetcode.editor.cn;


public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String str = "ccccc";
        System.out.println(solution.longestPalindrome(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome_20220426(String s) {
            if (null == s || s.length() == 0) {
                return null;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
//            for (int i = 0; i < s.length(); ++i) {
//                dp[i][i] = true;
//            }
            int maxLen = 1;
            int start = 0, end = 0;
            for (int j = 0; j < s.length(); ++j) {
                for (int i = j; i >= 0; --i) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]);
                    if (dp[i][j] && (j - i + 1 > maxLen)) {
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);



        }




        private int palindromeLen(String s, int i, int j) {
            while (i >= 0 && j < s.length()) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                } else {
                    i--;
                    j++;
                }
            }
            return j - i - 1;
        }

        public String longestPalindrome(String s) {
            if (null == s || s.length() == 0) {
                return null;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); ++i) {
                dp[i][i] = true;
            }
            String res = s.substring(0, 1);
            for (int i = s.length() - 1; i >= 0; --i) {
                for (int j = i + 1; j < s.length(); ++j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i == 1) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && (j - i + 1) > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;























//            String res = "";
//            for (int i = 0; i < s.length(); ++i) {
//                int len1 = palindromeLen(s, i, i);
//                if (len1 > res.length()) {
//                    res = s.substring(i - len1 / 2, i + len1 / 2 + 1);
//                }
//                int len2 = palindromeLen(s, i, i + 1);
//                if (len2 > res.length()) {
//                    res = s.substring(i - len2 / 2 + 1, i + len2 / 2 + 1);
//                }
//            }
//            return res;


//            int longest = 1;
//            String longestPalindrome = s.substring(0, 1);
//            boolean[][] tmp = new boolean[s.length()][s.length()];
//            for (int i = 0; i < s.length(); ++i) {
//                tmp[i][i] = true;
//            }
//            for (int i = 0; i + 1 < s.length(); ++i) {
//                tmp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
//                if (tmp[i][i + 1] && longest == 1) {
//                    longest = 2;
//                    longestPalindrome = s.substring(i, i + 2);
//                }
//            }
//            for (int step = 2; step < s.length(); ++step) {
//                for (int i = 0; i + step < s.length(); ++i) {
//                    int j = i + step;
//                    tmp[i][j] = tmp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
//                    if (tmp[i][j] && (j - i + 1 > longest)) {
//                        longest = j - i + 1;
//                        longestPalindrome = s.substring(i, j + 1);
//                    }
//                }
//            }
//            return longestPalindrome;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
