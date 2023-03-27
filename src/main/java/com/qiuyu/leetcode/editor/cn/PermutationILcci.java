//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 字符串 回溯 👍 81 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationILcci {
    public static void main(String[] args) {
        Solution solution = new PermutationILcci().new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String str) {
            if (str == null || str.length() == 0) {
                return new String[0];
            }
            List<String> res = new ArrayList<>();
            boolean[] visited = new boolean[str.length()];
            dfs(str, new StringBuilder(), visited, res);
            return res.toArray(new String[0]);

        }

        private void dfs(String str, StringBuilder sb, boolean[] visited, List<String> res) {
            if (sb.length() == str.length()) {
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < str.length(); ++i) {
                if (visited[i]) {
                    continue;
                }
                sb.append(str.charAt(i));
                visited[i] = true;
                dfs(str, sb, visited, res);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
