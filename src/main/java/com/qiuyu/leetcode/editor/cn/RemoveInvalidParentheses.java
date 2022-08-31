//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 656 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        List<String> res = solution.removeInvalidParentheses("()())()");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int scoreMax;
        Set<String> res;
        int curValid = 0;

        int toBeDeleteLeft = 0;
        int toBeDeleteRight = 0;
        int maxValidLen = 0;
        public List<String> removeInvalidParentheses_20220512_a(String s) {
            // 需要删除的左右括号数量
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    toBeDeleteLeft++;
                } else if (c == ')') {
                    if (toBeDeleteLeft > 0) {
                        toBeDeleteLeft--;
                    } else {
                        toBeDeleteRight++;
                    }
                }
            }
            maxValidLen = s.length() - toBeDeleteLeft - toBeDeleteRight;
            int cl = 0, cr = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    cl++;
                } else if (c == ')') {
                    cr++;
                }
            }
            scoreMax = Math.min(cl, cr);
            res = new HashSet<>();

            dfs_20220512_a(s, 0, new StringBuilder(), 0, 0, 0);
            return new ArrayList<>(res);

        }
        private void dfs_20220512_a(String s, int start, StringBuilder sb, int dl, int dr, int score) {

            if (sb.length() > maxValidLen || dl > toBeDeleteLeft || dr > toBeDeleteRight || score < 0 || score > scoreMax) {
                return;
            }
            if (start == s.length()) {
                if (sb.length() == maxValidLen && score == 0) {
                    res.add(sb.toString());
                }
                return;
            }
            if (s.charAt(start) == '(') {
                dfs_20220512_a(s, start + 1, sb, dl + 1, dr, score);

                sb.append('(');
                dfs_20220512_a(s, start + 1, sb, dl, dr, score + 1);
                sb.deleteCharAt(sb.length() - 1);
            } else if (s.charAt(start) == ')') {
                dfs_20220512_a(s, start + 1, sb, dl, dr + 1, score);

                sb.append(')');
                dfs_20220512_a(s, start + 1, sb, dl, dr, score - 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(start));
                dfs_20220512_a(s, start + 1, sb, dl, dr, score);
                sb.deleteCharAt(sb.length() - 1);
            }

        }


        public List<String> removeInvalidParentheses_20220512(String s) {
            int leftCount = 0, rightCount = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    leftCount++;
                } else if (s.charAt(i) == ')') {
                    rightCount++;
                }
            }
            scoreMax = Math.min(leftCount, rightCount);
            res = new HashSet<>();

            dfs_20220512(s, new StringBuilder(), 0, 0);
            return new ArrayList<>(res);

        }

        private void dfs_20220512(String s, StringBuilder sb, int start, int score) {
            if (score < 0 || score > scoreMax) {
                return;
            }
            if (start == s.length()) {
                if (score == 0 && sb.length() >= curValid) {
                    if (sb.length() > curValid) {
                        res.clear();
                        curValid = sb.length();
                    }
                    res.add(sb.toString());
                }
                return;
            }
            if (s.charAt(start) == '(') {
                dfs_20220512(s, sb, start + 1, score);

                sb.append('(');
                dfs_20220512(s, sb, start + 1, score + 1);
                sb.deleteCharAt(sb.length() - 1);

            } else if (s.charAt(start) == ')') {
                dfs_20220512(s, sb, start + 1, score);

                sb.append(')');
                dfs_20220512(s, sb, start + 1, score - 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                dfs_20220512(s, sb.append(s.charAt(start)), start + 1, score);
                sb.deleteCharAt(sb.length() - 1);
            }
        }


        public List<String> removeInvalidParentheses(String s) {
            return removeInvalidParentheses_20220512_a(s);
        }


//        int maxValidLen = 0;
//        int maxScore = 0;
//        // 存储最长的合法括号
//        Set<String> tmpSet = new HashSet<>();
//
//        public List<String> removeInvalidParentheses(String s) {
//
//            if (s == null || s.length() < 1) {
//                return new ArrayList<>();
//            }
//            int num1 = 0, num2 = 0;
//            for (char c : s.toCharArray()) {
//                if (c == '(') {
//                    num1++;
//                } else if (c == ')') {
//                    num2++;
//                }
//            }
//            maxScore = Math.min(num1, num2);
//            dfs(s, 0, "", 0);
//            return new ArrayList<>(tmpSet);
//
//        }
//
//        private void dfs(String rawStr, int start, String curStr, int curScore) {
//            if (curScore < 0 || curScore > maxScore) {
//                return;
//            }
//            if (start == rawStr.length()) {
//                if (curScore == 0 && curStr.length() >= maxValidLen) {
//                    if (curStr.length() > maxValidLen) {
//                        maxValidLen = curStr.length();
//                        tmpSet.clear();
//                    }
//                    tmpSet.add(curStr);
//                }
//                return;
//            }
//            char c = rawStr.charAt(start);
//            if (c == '(') {
//                dfs(rawStr, start + 1, curStr + c, curScore + 1);
//                dfs(rawStr, start + 1, curStr, curScore);
//            } else if (c == ')') {
//                dfs(rawStr, start + 1, curStr + c, curScore - 1);
//                dfs(rawStr, start + 1, curStr, curScore);
//            } else {
//                dfs(rawStr, start + 1, curStr + c, curScore);
//            }
//
//        }


        // 模拟删除，从左到右，删除多余的右括号，从右到左，删除多余的左括号
        private void dfs(String s, Set<String> set) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                }
                if (count < 0) {
                    for (int j = 0; j <= i; j++) {
                        if (j > 0 && s.charAt(j - 1) == ')') {
                            continue;
                        }
                        if (s.charAt(j) == ')') {
                            dfs(new StringBuilder(s).deleteCharAt(j).toString(), set);
                        }
                    }
                    return;
                }
                if (i == s.length() - 1 && count == 0) {
                    set.add(s);
                    return;
                }
            }
            count = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '(') {
                    count--;
                } else if (c == ')') {
                    count++;
                }
                if (count < 0) {
                    for (int j = s.length() - 1; j >= i; j--) {
                        if (j < s.length() - 1 && s.charAt(j + 1) == '(') {
                            continue;
                        }
                        if (s.charAt(j) == '(') {
                            dfs(new StringBuilder(s).deleteCharAt(j).toString(), set);

                        }
                    }
                    return;
                }
                if (i == 0 && count == 0) {
                    set.add(s);
                    return;
                }
            }
        }

        public List<String> removeInvalidParentheses_old(String s) {
            int n = s.length();
            Set<String> set = new HashSet<>();
            dfs(s, set);
            if (set.isEmpty()) set.add("");
            return new ArrayList<String>(set);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
