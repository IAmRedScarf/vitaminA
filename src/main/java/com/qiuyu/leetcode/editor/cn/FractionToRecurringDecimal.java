//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 👍 366 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        solution.fractionToDecimal(4, 333);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException();
            }
            long a = numerator, b = denominator;
            if (a % b == 0) {
                return String.valueOf(a / b);
            }
            StringBuilder sb = new StringBuilder();
            if (a * b < 0) {
                sb.append("-");
            }
            a = Math.abs(a);
            b = Math.abs(b);
            sb.append(a / b + ".");
            a %= b;
            Map<Long, Integer> remainderPlace = new HashMap<>();
            while (a != 0) {
                remainderPlace.put(a, sb.length() - 1);
                a *= 10;
                sb.append(a / b);
                a %= b;
                if (remainderPlace.containsKey(a)) {
                    int u = remainderPlace.get(a);
                    return String.format("%s(%s)", sb.substring(0, u + 1), sb.substring(u + 1));
                }

            }
            return sb.toString();










//            long a = numerator, b = denominator;
//            if (a % b == 0) {
//                return String.valueOf(a / b);
//            }
//            StringBuilder sb = new StringBuilder();
//            if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
//                sb.append("-");
//            }
//            a = Math.abs(a);
//            b = Math.abs(b);
//            sb.append(a / b);
//            sb.append(".");
//
//            a = a % b;
//            Map<Long, Integer> tmpMap = new HashMap<>();
//            while (a != 0) {
//                tmpMap.put(a, sb.length());
//                a *= 10;
//                sb.append(a / b);
//                a %= b;
//                if (tmpMap.containsKey(a)) {
//                    int u = tmpMap.get(a);
//                    return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
//                }
//
//            }
//            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
