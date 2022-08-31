//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1532 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestValidParentheses_20220511(String s) {
            int maxLen = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    dp[i] = 0;
                } else {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                    } else {
                        if (dp[i - 1] == 0) {
                            dp[i] = 0;
                        } else {
                            if (i - dp[i - 1] - 1 < 0 || s.charAt(i - dp[i - 1] - 1) == ')') {
                                dp[i] = 0;
                            } else {
                                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                            }
                        }
                    }
                }
                maxLen = Math.max(dp[i], maxLen);
            }
            return maxLen;
        }




        public int longestValidParentheses_20220510(String s) {
            int res = 0;
            // 栈中存储下标
            Deque<Integer> tmpStack = new LinkedList<>();
            tmpStack.addLast(-1);
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    tmpStack.addLast(i);
                } else if (c == ')') {
                    tmpStack.pollLast();
                    if (!tmpStack.isEmpty()) {
                        res = Math.max(i - tmpStack.peekLast(), res);
                    } else {
                        tmpStack.addLast(i);
                    }
                }
            }
            return res;

        }



        public int longestValidParentheses(String s) {
            return longestValidParentheses_20220511(s);
        }






        public int longestValidParentheses_old(String s) {
//            return f1(s);
            return f2(s);

        }

        private int f1(String s) {
            if (s == null || s.length() <= 1) {
                return 0;
            }
            Deque<Integer> tmpStack = new LinkedList<>();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    tmpStack.push(i);
                } else {
                    if (!tmpStack.isEmpty()) {
                        res.add(i);
                        res.add(tmpStack.pop());
                    }
                }
            }
            res.sort(Comparator.comparingInt(a -> a));
            int maxLen = 0;
            int start = 0;
            while (start < res.size()) {
                int j = start;
                while (j < res.size()) {
                    if ((j < res.size() - 1) && res.get(j + 1) == res.get(j) + 1) {
                        ++j;
                    } else {
                        maxLen = Math.max(maxLen, j - start + 1);
                        break;
                    }
                }
                start = j + 1;
            }
            return maxLen;
        }

        private int f2(String s) {
            if (s == null || s.length() <= 1) {
                return 0;
            }
            Deque<Integer> tmpStack = new LinkedList<>();
            tmpStack.push(-1);
            int maxLen = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    tmpStack.push(i);
                } else {
                    tmpStack.pop();
                    if (tmpStack.isEmpty()) {
                        tmpStack.push(i);
                    } else {
                        maxLen = Math.max(maxLen, i - tmpStack.peek());
                    }
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
