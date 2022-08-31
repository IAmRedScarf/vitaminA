//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
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
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 41 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IDBivT {
    public static void main(String[] args) {
        Solution solution = new IDBivT().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n <= 0) {
                return res;
            }
            dfs(n, n, new StringBuilder(), res);
            return res;
        }


        private void dfs(int leftAvailable, int rightAvailable, StringBuilder sb, List<String> res) {
            if (leftAvailable > rightAvailable) {
                return;
            }
            if (rightAvailable == 0) {
                res.add(sb.toString());
                return;
            }
            if (leftAvailable > 0) {
                sb.append("(");
                dfs(leftAvailable - 1, rightAvailable, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            dfs(leftAvailable, rightAvailable - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
