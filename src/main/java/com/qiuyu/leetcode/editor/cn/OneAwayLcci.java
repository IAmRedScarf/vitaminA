//字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 230 👎 0


package com.qiuyu.leetcode.editor.cn;

public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        solution.oneEditAway("ab", "bc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int len1 = first.length(), len2 = second.length();
            if (Math.abs(len1 - len2) > 1) {
                return false;
            }
            if (len1 < len2) {
                return oneEditAway(second, first);
            }
            int i = 0, j = 0;
            int diff = 0;
            while (i < len1 && j < len2) {
                if (first.charAt(i) != second.charAt(j)) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                    i++;
                    if (len1 == len2) {
                        j++;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        }


        public boolean oneEditAway20221208(String first, String second) {
            int len1 = first.length(), len2 = second.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int j = 1; j <= len2; ++j) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= len1; ++i) {
                dp[i][0] = i;
            }
            for (int i = 0; i < len1; ++i) {
                for (int j = 0; j < len2; ++j) {
                    if (first.charAt(i) == second.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {
                        dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                    }
                }
            }
            return dp[len1][len2] <= 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
