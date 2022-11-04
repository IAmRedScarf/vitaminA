//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 动态规划 回溯 👍 119 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BracketLcci {
    public static void main(String[] args) {
        Solution solution = new BracketLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(n, n, n, new StringBuilder(), res);
            return res;
        }

        private void dfs(int n, int leftAvailable, int rightAvailable, StringBuilder sb, List<String> res) {
            if (sb.length() == n * 2) {
                res.add(sb.toString());
                return;
            }
            if (leftAvailable > rightAvailable) {
                return;
            }
            if (leftAvailable > 0) {
                sb.append("(");
                dfs(n, leftAvailable - 1, rightAvailable, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            dfs(n, leftAvailable, rightAvailable - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
