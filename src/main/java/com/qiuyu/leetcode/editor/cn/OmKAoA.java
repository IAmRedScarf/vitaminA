//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
//
// 
//
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
// Related Topics 字符串 动态规划 👍 38 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class OmKAoA {
    public static void main(String[] args) {
        Solution solution = new OmKAoA().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int len = s.length();
            boolean[][] dp0 = new boolean[len][len];
            for (int j = 0; j < len; ++j) {
                for (int i = j; i >= 0; --i) {
                    if (j - i < 2) {
                        dp0[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp0[i][j] = dp0[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                    }
                }
            }

            int[] dp1 = new int[1 + len];
            Arrays.fill(dp1, Integer.MAX_VALUE);
            dp1[0] = 0;
            for (int j = 0; j < len; ++j) {
                for (int i = j; i >= 0; --i) {
                    if (dp0[i][j])
                        dp1[j + 1] = Math.min(dp1[j + 1], dp1[i] + 1);
                }
            }
            return dp1[len] - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}