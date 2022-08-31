//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 573 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println(Arrays.toString(solution.permutation("aab")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            List<String> res = new ArrayList<>();
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            boolean[] isVisited = new boolean[cs.length];
            dfs(cs, new StringBuilder(), isVisited, res);
            return res.toArray(new String[0]);

        }

        private void dfs(char[] cs, StringBuilder sb, boolean[] isVisited, List<String> res) {
            if (sb.length() == cs.length) {
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < cs.length; ++i) {
                if (isVisited[i] || (i > 0 && cs[i] == cs[i - 1] && !isVisited[i - 1])) {
                    continue;
                }
                isVisited[i] = true;
                sb.append(cs[i]);
                dfs(cs, sb, isVisited, res);
                sb.deleteCharAt(sb.length() - 1);
                isVisited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
