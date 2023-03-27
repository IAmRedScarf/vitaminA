//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 👍 90 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CalculatorLcci {
    public static void main(String[] args) {
        Solution solution = new CalculatorLcci().new Solution();
        System.out.println(solution.calculate("32"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {



        public int calculate(String s) {
            List<Character> cs = new ArrayList<>();
            for (Character c : s.toCharArray()) {
                if (c != ' ') {
                    cs.add(c);
                }
            }
            Deque<Integer> stack = new LinkedList<>();
            int i = -1;
            while (i < cs.size()) {
                int cur = 0;
                int j = i + 1;
                while (j < cs.size() && (cs.get(j) >= '0' && cs.get(j) <= '9')) {
                    cur = cur * 10 + (cs.get(j) - '0');
                    j++;
                }
                if (i == -1 || cs.get(i) == '+') {
                    stack.addLast(cur);
                } else if (cs.get(i) == '-') {
                    stack.addLast(-1 * cur);

                } else {
                    int pre = stack.pollLast();
                    if (cs.get(i) == '*') {
                        stack.addLast(pre * cur);
                    } else if (cs.get(i) == '/') {
                        stack.addLast(pre / cur);
                    }
                }
                i = j;
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pollLast();
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
