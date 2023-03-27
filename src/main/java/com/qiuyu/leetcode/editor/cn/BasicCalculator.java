//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
// Related Topics 栈 递归 数学 字符串 👍 714 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        System.out.println(solution.calculate("(-1)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String originStr) {
            Deque<Integer> operands = new LinkedList<>();
            Deque<Character> operators = new LinkedList<>();
            String str = originStr.replace(" ", "");
            operands.add(0);
            int i = 0;
            while (i < str.length()) {
                char c = str.charAt(i);
                if (c == '(') {
                    operators.add(c);
                    ++i;
                } else if (c == ')') {
                    if (!operators.isEmpty() && operators.peekLast() != '(') {
                        oneCalc(operands, operators);
                    }
                    operators.pollLast();
                    ++i;
                } else {
                    if (isNum(c)) {
                        int curNum = 0;
                        while (i < str.length() && isNum(str.charAt(i))) {
                            curNum = curNum * 10 + (str.charAt(i) - '0');
                            ++i;
                        }
                        operands.add(curNum);
                    } else {
                        if (i > 0 && str.charAt(i - 1) == '(') {
                            operands.add(0);
                        }
                        if (!operators.isEmpty() && operators.peekLast() != '(') {
                            oneCalc(operands, operators);
                        }
                        operators.add(c);
                        ++i;
                    }
                }
            }
            oneCalc(operands, operators);
            return operands.pollLast();

        }

        private void oneCalc(Deque<Integer> operands, Deque<Character> operators) {
            if (operands.size() < 2 || operators.isEmpty()) {
                return;
            }
            int b = operands.pollLast(), a = operands.pollLast();
            int res = (operators.pollLast() == '+') ? (a + b) : (a - b);
            operands.add(res);

        }


        // 3 - 2 - 2
        // 3 2 2
        // - -















        public int calculate2022(String s) {
            Deque<Integer> nums = new LinkedList<>();
            // 防止第一个数为负数
            nums.add(0);
            Deque<Character> ops = new LinkedList<>();
            s = s.replaceAll(" ", "");
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    ops.add('(');
                } else if (c == ')') {
                    while (!ops.isEmpty()) {
                        if (ops.peekLast() != '(') {
                            calc(nums, ops);
                        } else {
                            ops.pollLast();
                            break;
                        }

                    }
                } else {
                    if (isNum(c)) {
                        int res = 0;
                        int j = i;
                        while (j < s.length() && isNum(s.charAt(j))) {
                            res = res * 10 + (s.charAt(j) - '0');
                            ++j;
                        }
                        // 此处为兼容for循环中的i++
                        i = j - 1;
                        nums.add(res);
                    } else {
                        // 此处 将 1+(-1-3) 调整为 1+(0-1-3)
                        if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                            nums.add(0);
                        }
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            calc(nums, ops);
                        }
                        ops.add(s.charAt(i));
                    }
                }
            }
            while (!ops.isEmpty()) {
                calc(nums, ops);
            }
            return nums.pollLast();
        }

        private void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) {
                return;
            }
            int b = nums.pollLast(), a = nums.pollLast();
            Character op = ops.pollLast();
            int res = op == '+' ? (a + b) : (a - b);
            nums.add(res);

        }

        private boolean isNum(char c) {
            return c >= '0' && c <= '9';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
