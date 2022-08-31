//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 656 👎 0


package com.qiuyu.leetcode.editor.cn;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        System.out.println(solution.longestSubstring("abcdedghijklmnopqrstuvwxyz", 2));;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            if (s.length() == 0) {
                return 0;
            }
//            int[] cnt = new int[26];
//            for (int i = 0; i < s.length(); ++i) {
//                cnt[s.charAt(i) - 'a']++;
//            }
//            int partition = -1;
//            for (int i = 0; i < s.length(); ++i) {
//                if (cnt[s.charAt(i) - 'a'] < k) {
//                    partition = i;
//                    break;
//                }
//            }
//            if (partition == -1) {
//                return s.length();
//            }
//            return Math.max(longestSubstring(s.substring(0, partition), k), longestSubstring(s.substring(partition + 1), k));
            return f(s, 0, s.length() - 1, k);
        }


        private int f(String s, int start, int end, int k) {
            if (start > end) {
                return 0;
            }
            int[] cnt = new int[26];
            for (int i = start; i <= end; ++i) {
                cnt[s.charAt(i) - 'a']++;
            }
            int partition = -1;
            for (int i = start; i <= end; ++i) {
                if (cnt[s.charAt(i) - 'a'] < k) {
                    partition = i;
                    break;
                }
            }
            if (partition == -1) {
                return end - start + 1;
            }
            return Math.max(f(s, start, partition - 1, k), f(s, partition + 1, end, k));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
