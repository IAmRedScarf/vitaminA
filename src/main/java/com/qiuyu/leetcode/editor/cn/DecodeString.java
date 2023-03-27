//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 1005 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String decodeString(String s) {
            return decodeString20230320(s);
        }

        public String decodeString20230320(String s) {
            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c != ']') {
                    stack.addLast(c);
                } else {
                    List<Character> repeatList = new ArrayList<>();
                    while (!stack.isEmpty() && stack.peekLast() != '[') {
                        repeatList.add(0, stack.pollLast());
                    }
                    stack.pollLast();
                    int repeatNum = 0;
                    int multiply = 1;
                    while (!stack.isEmpty()) {
                        char curC = stack.peekLast();
                        if (judgeNum(curC)) {
                            stack.pollLast();
                            repeatNum += (curC - '0') * multiply;
                            multiply *= 10;
                        } else {
                            break;
                        }
                    }
                    while (repeatNum > 0) {
                        repeatList.forEach(stack::addLast);
                        repeatNum--;
                    }

                }
            }
            StringBuilder resSb = new StringBuilder();
            while (!stack.isEmpty()) {
                resSb.append(stack.pollFirst());
            }
            return resSb.toString();
        }


        private boolean judgeNum(char c) {
            return c >= '0' && c <= '9';
        }









        public String decodeString_20220506(String s) {
            Deque<Character> tmpStack = new LinkedList<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c != ']') {
                    tmpStack.addLast(c);
                } else {
                    List<Character> repeatList = new ArrayList<>();
                    while (!tmpStack.isEmpty()) {
                        char topC = tmpStack.pollLast();
                        if (topC == '[') {
                            break;
                        } else {
                            repeatList.add(0, topC);
                        }
                    }
                    int repeatNum = 0;
                    int multiply = 1;

                    while (!tmpStack.isEmpty()) {
                        char topC = tmpStack.peekLast();
                        if (topC >= '0' && topC <= '9') {
                            tmpStack.pollLast();
                            repeatNum = (topC - '0') * multiply + repeatNum;
                            multiply *= 10;
                        } else {
                            break;
                        }
                    }
                    while (repeatNum > 0) {
                        repeatList.forEach(tmpStack::addLast);
                        repeatNum--;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!tmpStack.isEmpty()) {
                sb.insert(0, tmpStack.pollLast());
            }
            return sb.toString();
        }




        public String decodeString_old(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            Deque<Character> tmpStack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c != ']') {
                    tmpStack.push(c);
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (!tmpStack.isEmpty()) {
                        char topChar = tmpStack.pop();
                        if (topChar != '[') {
                            sb.insert(0, topChar);
                        } else {
                            break;
                        }
                    }
                    String tmpStr = sb.toString();
                    sb = new StringBuilder();
                    while (!tmpStack.isEmpty()) {
                        if (tmpStack.peek() >= '0' && tmpStack.peek() <= '9') {
                            sb.insert(0, tmpStack.pop());
                        } else {
                            break;
                        }
                    }
                    int repeatNum = Integer.parseInt(sb.toString());
                    while (repeatNum > 0) {
                        for (char tmpC : tmpStr.toCharArray()) {
                            tmpStack.push(tmpC);
                        }
                        repeatNum--;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!tmpStack.isEmpty()) {
                stringBuilder.insert(0, tmpStack.pop());
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
