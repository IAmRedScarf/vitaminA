//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
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
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 58 👎 0


package com.qiuyu.leetcode.editor.cn;

public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
//            for (int i = 0; i < n; ++i) {
//                dp[i][i] = true;
//            }
            int res = 0;
            for (int j = 0; j < n; ++j) {
                for (int i = j; i >= 0; --i) {
                    if (j - i < 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        res++;
                    }
                }
            }
            return res;


        }



        public int countSubstrings_20220718(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); ++i) {
                int left = i, right = i;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }
            for (int i = 0; i < s.length() - 1; ++i) {
                int left = i, right = i + 1;
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
