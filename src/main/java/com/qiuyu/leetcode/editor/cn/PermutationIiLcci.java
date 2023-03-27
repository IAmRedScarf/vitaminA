//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
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

public class PermutationIiLcci {
    public static void main(String[] args) {
        Solution solution = new PermutationIiLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String str) {
            if (str == null || str.length() == 0) {
                return new String[0];
            }
            List<String> res = new ArrayList<>();
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            boolean[] visited = new boolean[str.length()];
            dfs(arr, new StringBuilder(), visited, res);
            return res.toArray(new String[0]);
        }

        private void dfs(char[] arr, StringBuilder sb, boolean[] visited, List<String> res) {
            if (sb.length() == arr.length) {
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < arr.length; ++i) {
                if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && visited[i - 1])) {
                    continue;
                }
                sb.append(arr[i]);
                visited[i] = true;
                dfs(arr, sb, visited, res);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
