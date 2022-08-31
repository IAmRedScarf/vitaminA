//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 463 👎 0


package com.qiuyu.leetcode.editor.cn;

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        solution.translateNum(18580);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            if (num < 0) {
                return 0;
            }
            if (num == 0) {
                return 1;
            }
            StringBuilder numStr = new StringBuilder();
            int tmp = num;
            while (tmp != 0) {
                numStr.insert(0, tmp % 10);
                tmp /= 10;
            }
            int[] dp = new int[numStr.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < numStr.length(); ++i) {
                dp[i + 1] += dp[i];
                int pre = numStr.charAt(i - 1) - '0';
                int cur = numStr.charAt(i) - '0';
                int tmpNum = pre * 10 + cur;
                if (pre > 0 && (tmpNum > 0 && tmpNum <= 25)) {
                    dp[i + 1] += dp[i - 1];
                }
            }
            return dp[numStr.length()];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
