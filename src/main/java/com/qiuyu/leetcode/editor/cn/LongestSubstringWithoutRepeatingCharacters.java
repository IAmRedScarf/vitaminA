//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6290 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            return lengthOfLongestSubstring20230214(s);
        }



        public int lengthOfLongestSubstring20230214(String s) {
            if (s == null) {
                return 0;
            }
            if (s.length() < 2) {
                return s.length();
            }
            Set<Character> tmpSet = new HashSet<>();
            int left = 0, right = 0;
            int res = Integer.MIN_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                while (tmpSet.contains(c)) {
                    tmpSet.remove(s.charAt(left));
                    left++;
                }
                tmpSet.add(c);
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;

        }












        public int lengthOfLongestSubstring_20220912(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int left = 0, right = 0;
            int res = 0;
            Set<Character> window = new HashSet<>();
            while (right < s.length()) {
                char cur = s.charAt(right);
                while (window.contains(cur)) {
                    window.remove(s.charAt(left));
                    ++left;
                }
                window.add(cur);
                res = Math.max(right - left + 1, res);
                ++right;
            }
            return res;
        }














        public int lengthOfLongestSubstring_20220908(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            Set<Character> window = new HashSet<>();
            int ret = 0;
            int left = 0, right = 0;
            while (right < s.length()) {
                char cur = s.charAt(right);
                while (window.contains(cur)) {
                    window.remove(s.charAt(left));
                    left++;
                }
                window.add(cur);
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }












        public int lengthOfLongestSubstring_20220426(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int start = 0, end = 0;
            int res = 0;
            Set<Character> tmpSet = new HashSet<>();
            while (end < s.length()) {
                char c = s.charAt(end);
                if (!tmpSet.contains(c)) {
                    tmpSet.add(c);
                    res = Math.max(res, end - start + 1);
                } else {
                    while (start < end && s.charAt(start) != c) {
                        tmpSet.remove(s.charAt(start));
                        ++start;
                    }
                    ++start;
                }
                ++end;
            }
            return res;
        }
















        public int lengthOfLongestSubstring202222222222(String s) {
            return lengthOfLongestSubstring_20220912(s);



//            if (s.length() <= 1) {
//                return s.length();
//            }
//            int start = 0, end = 0;
//            Set<Character> tmpSet = new HashSet<>();
//            int maxLen = 0;
//            while (end < s.length()) {
//                char c = s.charAt(end);
//                if (!tmpSet.contains(c)) {
//                    tmpSet.add(c);
//                    maxLen = Math.max(maxLen, end - start + 1);
//                } else {
//                    while (start < end && s.charAt(start) != c) {
//                        tmpSet.remove(s.charAt(start));
//                        start++;
//                    }
//                    start++;
//                }
//                end++;
//            }
//            return maxLen;


//            int maxLen = 0;
//            int end = 0;
//            Set<Character> cSet = new HashSet<>();
//            for (int i = 0; i < s.length(); ++i) {
//                if (i > 0) {
//                    cSet.remove(s.charAt(i - 1));
//                    ++end;
//                }
//                while (end < s.length() && !cSet.contains(s.charAt(end))) {
//                    cSet.add(s.charAt(end));
//                    ++end;
//                }
//                maxLen = Math.max(end - i, maxLen);
//            }
//            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
