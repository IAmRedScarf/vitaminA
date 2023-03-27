//给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)
// 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。 
//
// 示例 1: 
//
// 输入: s = "1^0|0|1", result = 0
//
//输出: 2
//解释: 两种可能的括号方法是
//1^(0|(0|1))
//1^((0|0)|1)
// 
//
// 示例 2: 
//
// 输入: s = "0&0&0&1^1|0", result = 1
//
//输出: 10 
//
// 提示： 
//
// 
// 运算符的数量不超过 19 个 
// 
// Related Topics 记忆化搜索 字符串 动态规划 👍 72 👎 0


package com.qiuyu.leetcode.editor.cn;

public class BooleanEvaluationLcci {
    public static void main(String[] args) {
        Solution solution = new BooleanEvaluationLcci().new Solution();
        String str = "0&0&0&1^1|0";
        System.out.println(solution.countEval(str, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countEval(String s, int result) {


            int[][] dp0 = new int[s.length()][s.length()];
            int[][] dp1 = new int[s.length()][s.length()];
            // 初始值
            for (int i = 0; i <= s.length() - 1; i = i + 2) {
                if (s.charAt(i) == '0') {
                    dp0[i][i]++;
                } else if (s.charAt(i) == '1') {
                    dp1[i][i]++;
                }
            }

            for (int len = 3; len <= s.length(); len = len + 2) {
                for (int i = 0; i <= s.length() - len; i = i + 2) {
                    // 按运算符分割
                    for (int j = i + 1; j <= (i + len - 1 - 1); j = j + 2) {
                        char operator = s.charAt(j);
                        if (operator == '&') {
                            dp0[i][i + len - 1] += dp0[i][j - 1] * dp0[j + 1][i + len - 1] + dp0[i][j - 1] * dp1[j + 1][i + len - 1] + dp1[i][j - 1] * dp0[j + 1][i + len - 1];
                            dp1[i][i + len - 1] += dp1[i][j - 1] * dp1[j + 1][i + len - 1];
                        } else if (operator == '|') {
                            dp0[i][i + len - 1] += dp0[i][j - 1] * dp0[j + 1][i + len - 1];
                            dp1[i][i + len - 1] += dp1[i][j - 1] * dp1[j + 1][i + len - 1] + dp0[i][j - 1] * dp1[j + 1][i + len - 1] + dp1[i][j - 1] * dp0[j + 1][i + len - 1];
                        } else if (operator == '^') {
                            dp0[i][i + len - 1] += dp0[i][j - 1] * dp0[j + 1][i + len - 1] + dp1[i][j - 1] * dp1[j + 1][i + len - 1];
                            dp1[i][i + len - 1] += dp0[i][j - 1] * dp1[j + 1][i + len - 1] + dp1[i][j - 1] * dp0[j + 1][i + len - 1];
                        }
                    }
                }
            }
            if (result == 0) {
                return dp0[0][s.length() - 1];
            } else if (result == 1) {
                return dp1[0][s.length() - 1];
            }
            return 0;
        }



        private int doOperate(int a, int b, char op) {
            if (op == '&') {
                return andOperator(a, b);
            }
            if (op == '|') {
                return orOperator(a, b);
            }
            if (op == '^') {
                return xorOperator(a, b);
            }
            return 0;
        }


        private int andOperator(int a, int b) {
            return (a == 0 || b == 0) ? 0 : 1;
        }

        private int orOperator(int a, int b) {
            return (a == 1 || b == 1) ? 1 : 0;
        }

        private int xorOperator(int a, int b) {
            return (a == b) ? 0 : 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
