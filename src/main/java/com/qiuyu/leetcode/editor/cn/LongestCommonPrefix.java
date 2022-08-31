//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1709 👎 0


package com.qiuyu.leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String baseStr = strs[0];
            for (int i = 0; i < baseStr.length(); ++i) {
                char c = baseStr.charAt(i);
                for (int j = 1; j < strs.length; ++j) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return baseStr.substring(0, i);
                    }
                }
            }
            return baseStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
