//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2： 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
//string/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 30 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s.length() < p.length()) {
            return ret;
        }
        int n = p.length();
        int[] count1 = new int[26];
        for (char c : p.toCharArray()) {
            count1[c - 'a']++;
        }
        int[] count2 = new int[26];
        for (int i = 0; i < n; ++i) {
            count2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            ret.add(0);
        }
        for (int i = n; i < s.length(); ++i) {
            count2[s.charAt(i) - 'a']++;
            count2[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(count1, count2)) {
                ret.add(i - n + 1);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
