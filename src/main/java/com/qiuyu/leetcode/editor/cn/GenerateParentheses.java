//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2159 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private void dfs_20220427(int n, StringBuilder sb, int leftAvailable, int rightAvailable, List<String> res) {
            if (sb.length() == n * 2) {
                res.add(sb.toString());
                return;
            }
            if (leftAvailable > rightAvailable) {
                return;
            }
            if (leftAvailable > 0) {
                dfs_20220427(n, sb.append('('), leftAvailable - 1, rightAvailable, res);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (rightAvailable > 0) {
                dfs_20220427(n, sb.append(')'), leftAvailable, rightAvailable - 1, res);
                sb.deleteCharAt(sb.length() - 1);
            }


        }









        public List<String> generateParenthesis_20220426(int n) {
            List<String> res = new ArrayList<>();
            if (n <= 0 || (n & 1) == 1) {
                return res;
            }

            dfs_20220427(n, new StringBuilder(), n, n, res);
            return res;


        }
















        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            dfs001(res, "", n, n);

            return res;
        }

        private void dfs001(List<String> res, String cur, int leftRemain, int rightRemain) {
            if (leftRemain == rightRemain && leftRemain == 0) {
                res.add(cur);
                return;
            }
            if (leftRemain > rightRemain) {
                return;
            }
            if (leftRemain > 0) {
                dfs001(res, cur + "(", leftRemain - 1, rightRemain);
            }
            if (rightRemain > 0) {
                dfs001(res, cur + ")", leftRemain, rightRemain - 1);
            }
        }








//        private void dfs1(List<String> res, int leftAvailable, int rightAvailable, StringBuilder cur, int n) {
//            if (cur.length() == n * 2) {
//                res.add(cur.toString());
//            }
//            if (leftAvailable > rightAvailable) {
//                return;
//            }
//            if (leftAvailable > 0) {
//                dfs1(res, leftAvailable - 1, rightAvailable, cur.append('('), n);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//
//            if (rightAvailable > 0) {
//                dfs1(res,  leftAvailable, rightAvailable - 1, cur.append(')'), n);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//
//        }
//
//        private void dfs2(List<String> res, int leftUsed, int rightUsed, StringBuilder cur, int n) {
//            if (cur.length() == n * 2) {
//                res.add(cur.toString());
//                return;
//            }
//            if (rightUsed > leftUsed) {
//                return;
//            }
//            if (leftUsed < n) {
//                dfs2(res, leftUsed + 1, rightUsed, cur.append('('), n);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//            if (rightUsed < n) {
//                dfs2(res, leftUsed, rightUsed + 1, cur.append(')'), n);
//                cur.deleteCharAt(cur.length() - 1);
//            }
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
