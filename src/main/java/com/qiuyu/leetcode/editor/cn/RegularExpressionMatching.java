//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只含小写英文字母。 
// p 只含小写英文字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 👍 2690 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aa", "a*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            return isMatch20230404(s, p);
        }


        public boolean isMatch20230404(String s, String p) {
            if (p.length() == 0) {
                return s.length() == 0;
            }
            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); ++i) {
                if (p.charAt(i) == '*' && dp[i - 1][0]) {
                    dp[i + 1][0] = true;
                }
            }
            for (int i = 0; i < p.length(); ++i) {
                for (int j = 0; j < s.length(); ++j) {
                    if (p.charAt(i) == '*') {
                        dp[i + 1][j + 1] = dp[i - 1][j + 1] || ((p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j)) && dp[i + 1][j]);
                    } else {
                        dp[i + 1][j + 1] = (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) && dp[i][j];
                    }
                }
            }
            return dp[p.length()][s.length()];

        }







        public boolean isMatch_20220426(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            if (s.length() == 0) {
                return p.length() == 0;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int j = 0; j < p.length(); ++j) {
                dp[0][j + 1] = p.charAt(j) == '*' && dp[0][j - 1];
            }
            for (int i = 0; i < s.length(); ++i) {
                for (int j = 0; j < p.length(); ++j) {
                    if (p.charAt(j) != '*') {
                        dp[i + 1][j + 1] = dp[i][j] && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || ((p.charAt(j - 1) == '.' || s.charAt(i) == p.charAt(j - 1)) && dp[i][j + 1]);
                    }
                }
            }
            return dp[s.length()][p.length()];






        }


        public boolean isMatch00000000000000000(String s, String p) {
            return isMatch_20220426(s, p);
//            if (s == null || p == null) {
//                return false;
//            }
//            if (s.length() == 0) {
//                return p.length() == 0;
//            }
//            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//            dp[0][0] = true;
//            for (int j = 0; j < p.length(); ++j) {
//                if (p.charAt(j) == '*') {
//                    dp[0][j + 1] = dp[0][j - 1];
//                }
//            }
//            for (int i = 0; i < s.length(); ++i) {
//                for (int j = 0; j < p.length(); ++j) {
//                    if (p.charAt(j) != '*') {
//                        dp[i + 1][j + 1] = (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && dp[i][j];
//                    } else {
//                        if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
//                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
//                        } else {
//                            dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i][j + 1];
//                        }
//                    }
//                }
//            }

//            for (int i = 1; i < s.length(); ++i) {
//                for (int j = 1; j < p.length(); ++j) {
//                    if (p.charAt(j) != '*') {
//                        dp[i][j] = (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && dp[i - 1][j - 1];
//                    } else {
//                        if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
//                            dp[i][j] = dp[i][j - 2];
//                        } else {
//                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
//                        }
//                    }
//                }
//            }
//            return dp[s.length()][p.length()];
        }


        public int f(List<List<Integer>> a) {
            Map<Integer, Integer> tmpMap = new TreeMap<>();
            for (List<Integer> aa : a) {
                tmpMap.put(aa.get(0), tmpMap.getOrDefault(aa.get(0), 0) + 1);
                tmpMap.put(aa.get(1), tmpMap.getOrDefault(aa.get(1), 0) - 1);
            }
            int rooms = 0, res = 0;
            for (Map.Entry<Integer, Integer> entry : tmpMap.entrySet()) {
                rooms += entry.getValue();
                res = Math.max(res, rooms);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
