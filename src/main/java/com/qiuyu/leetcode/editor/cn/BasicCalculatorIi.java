//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 数学 字符串 👍 536 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        solution.calculate("3+2*2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
        }};

        public int calculate(String s) {
            Deque<Integer> nums = new LinkedList<>();
            nums.add(0);
            Deque<Character> ops = new LinkedList<>();
            s = s.replaceAll(" ", "");
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    ops.add(c);
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
                        nums.addLast(res);
                        i = j - 1;
                    } else {
                        if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                            nums.add(0);
                        }
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            char preOp = ops.peekLast();
                            if (map.get(preOp) >= map.get(c)) {
                                calc(nums, ops);
                            } else {
                                break;
                            }
                        }
                        ops.addLast(c);
                    }
                }
            }
            while (!ops.isEmpty()) {
                calc(nums, ops);
            }
            return nums.peekLast();
        }

        private boolean isNum(char c) {
            return c >= '0' && c <= '9';
        }


        private void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) {
                return;
            }
            int b = nums.pollLast(), a = nums.pollLast();
            char op = ops.pollLast();
            int res = 0;
            if (op == '+') {
                res = a + b;
            } else if (op == '-') {
                res = a - b;
            } else if (op == '*') {
                res = a * b;
            } else if (op == '/') {
                res = a / b;
            }
            nums.addLast(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
