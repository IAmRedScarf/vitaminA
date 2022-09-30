//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
// Related Topics 广度优先搜索 字符串 👍 235 👎 0


package com.qiuyu.leetcode.editor.cn;

public class KSimilarStrings {
    public static void main(String[] args) {
        Solution solution = new KSimilarStrings().new Solution();
        solution.kSimilarity("baaababaabaababbaabb", "abbbababaabaabbaabaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int k = 0;
        int res = Integer.MAX_VALUE;
        public int kSimilarity(String s1, String s2) {
            dfs(new StringBuilder(s1), new StringBuilder(s2), 0);
            return res;
        }

        private void dfs(StringBuilder sb1, StringBuilder sb2, int start) {
            if (k >= res) {
                return;
            }
            int i = start;
            for (; i < sb1.length(); ++i) {
                if (sb1.charAt(i) != sb2.charAt(i)) {
                    break;
                }
            }
            if (i == sb1.length()) {
                res = Math.min(res, k);
                return;
            }
            for (int j = i + 1; j < sb1.length(); ++j) {
                if (sb1.charAt(j) == sb2.charAt(i) && sb1.charAt(j) != sb2.charAt(j)) {
                    char tmp = sb1.charAt(i);
                    sb1.setCharAt(i, sb1.charAt(j));
                    sb1.setCharAt(j, tmp);
                    ++k;
                    dfs(sb1, sb2, i + 1);
                    --k;
                    tmp = sb1.charAt(i);
                    sb1.setCharAt(i, sb1.charAt(j));
                    sb1.setCharAt(j, tmp);

                    // 如果一次交换，可以使得i、j两个位置的字符都匹配，那么就是最佳交换
                    if (sb1.charAt(i) == sb2.charAt(j)) {
                        break;
                    }
                }
            }
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}
