//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26" 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 👍 1103 👎 0


package com.qiuyu.leetcode.editor.cn;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        solution.numDecodings("10");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            if (s.charAt(0) == '0') {
                return 0;
            }
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            for (int i = 0; i < s.length(); ++i) {
                char cur = s.charAt(i);
                if(cur != '0') {
                    dp[i + 1] += dp[i];
                }
                if (i > 0 && s.charAt(i - 1) != '0') {
                    char pre = s.charAt(i - 1);
                    int num = 10 * (pre - '0') + (cur - '0');
                    if (num <= 26) {
                        dp[i + 1] += dp[i - 1];
                    }
                }
            }
            return dp[s.length()];










//            int[] dp = new int[s.length() + 1];
//            dp[0] = 1;
//            dp[1] = 1;
//            for (int i = 1; i < s.length(); ++i) {
//                char pre = s.charAt(i - 1);
//                char cur = s.charAt(i);
//                // 前一个数字为0
//                if (pre == '0') {
//                    if (cur == '0') {
//                        return 0;
//                    }
//                    dp[i + 1] = dp[i];
//                } else {
//                    if (cur == '0') {
//                        if (pre > '2') {
//                            return 0;
//                        }
//                        dp[i + 1] = dp[i - 1];
//                    } else {
//                        int num = 10 * (pre - '0') + (cur - '0');
//                        if (num > 26) {
//                            dp[i + 1] = dp[i];
//                        } else {
//                            dp[i + 1] = dp[i] + dp[i - 1];
//                        }
//                    }
//                }
//            }
//            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
