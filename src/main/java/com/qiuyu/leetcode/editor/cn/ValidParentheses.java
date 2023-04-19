//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2777 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            return isValid20230409(s);
        }

        public boolean isValid20230409(String s) {
            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.addLast(c);
                } else {
                    if (c == ')') {
                        if (stack.isEmpty() || stack.peekLast() != '(') {
                            return false;
                        }
                        stack.pollLast();
                    } else if (c == ']') {
                        if (stack.isEmpty() || stack.peekLast() != '[') {
                            return false;
                        }
                        stack.pollLast();
                    } else {
                        if (stack.isEmpty() || stack.peekLast() != '{') {
                            return false;
                        }
                        stack.pollLast();
                    }
                }
            }
            return stack.isEmpty();
        }







        public boolean isValid_20220513(String s) {
            Map<Character, Character> tmpMap = new HashMap<>();
            tmpMap.put(')', '(');
            tmpMap.put(']', '[');
            tmpMap.put('}', '{');
            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.addLast(c);
                } else {
                    if (!stack.isEmpty() && stack.peekLast() == tmpMap.get(c)) {
                        stack.pollLast();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }


        public boolean isValid_old(String s) {
            if (s == null || s.length() == 0 || s.length() % 2 == 1) {
                return false;
            }
            Stack<Character> tmpStack = new Stack<>();
//            for (int i = 0; i < s.length(); ++i) {
//                if (s.charAt(i) == ')') {
//                    if (tmpStack.isEmpty() || tmpStack.pop() != '(') {
//                        return false;
//                    }
//                }
//                if (s.charAt(i) == ']') {
//                    if (tmpStack.isEmpty() || tmpStack.pop() != '[') {
//                        return false;
//                    }
//                }
//                if (s.charAt(i) == '}') {
//                    if (tmpStack.isEmpty() || tmpStack.pop() != '{') {
//                        return false;
//                    }
//                }
//                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
//                    tmpStack.push(s.charAt(i));
//                }
//            }
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    tmpStack.push(')');
                } else if (s.charAt(i) == '[') {
                    tmpStack.push(']');
                } else if (s.charAt(i) == '{') {
                    tmpStack.push('}');
                } else if (tmpStack.isEmpty() || tmpStack.pop() != s.charAt(i)) {
                    return false;
                }
            }
            return tmpStack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
