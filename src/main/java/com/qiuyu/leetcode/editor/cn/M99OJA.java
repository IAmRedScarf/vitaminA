//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 32 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class M99OJA {
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
        solution.partition("google");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[][] partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> tmp = new ArrayList<>();
            boolean[][] dp = isHuiWen(s);
            dfs(s, 0, dp, tmp, res);
            String[][] resArray = new String[res.size()][];
            for (int i = 0; i < res.size(); ++i) {
                String[] sTmp = res.get(i).toArray(new String[0]);
                resArray[i] = sTmp;
            }
            return resArray;
        }

        private void dfs(String s, int start, boolean[][] dp, List<String> tmp, List<List<String>> res) {
            if (start == s.length()) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = start; i < s.length(); ++i) {
                if (!dp[start][i]) {
                    continue;
                }
                String curCut = s.substring(start, i + 1);
                tmp.add(curCut);
                dfs(s, i + 1, dp, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }

        private boolean[][] isHuiWen(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); ++i) {
                dp[i][i] = true;
            }
            for (int j = 1; j < s.length(); ++j) {
                for (int i = j - 1; i >= 0; --i) {
                    boolean tmp = s.charAt(i) == s.charAt(j);
                    dp[i][j] = (j - i == 1) ? tmp : (tmp && dp[i + 1][j - 1]);
                }
            }
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
