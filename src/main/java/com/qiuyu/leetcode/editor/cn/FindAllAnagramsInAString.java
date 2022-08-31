//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
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
// Related Topics 哈希表 字符串 滑动窗口 👍 722 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(solution.findAnagrams(s, p));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<Integer> findAnagrams_20220503(String s, String p) {
            int[] letterCount = new int[26];
            for (int i = 0; i < p.length(); ++i) {
                letterCount[p.charAt(i) - 'a']++;
            }
            int valid = 0;
            for (int i = 0; i < letterCount.length; ++i) {
                if (letterCount[i] > 0) {
                    valid++;
                }
            }
            List<Integer> res = new ArrayList<>();

            int[] windowLetter = new int[26];
            int left = 0, right = 0;
            int windowValid = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                if (letterCount[c - 'a'] > 0) {
                    windowLetter[c - 'a']++;
                    if (windowLetter[c - 'a'] == letterCount[c - 'a']) {
                        windowValid++;
                    }
                }
                while (left <= right) {
                    if (windowValid == valid) {
                        if (right - left + 1 == p.length()) {
                            res.add(left);
                        }
                        int leftC = s.charAt(left);
                        if (letterCount[leftC - 'a'] > 0) {
                            windowLetter[leftC - 'a']--;
                            if (windowLetter[leftC - 'a'] < letterCount[leftC - 'a']) {
                                windowValid--;
                            }
                        }
                        left++;
                    } else {
                        break;
                    }
                }
                right++;
            }
            return res;
        }




        public List<Integer> findAnagrams(String s, String p) {
            return findAnagrams_20220503(s, p);
        }






        public List<Integer> findAnagrams_old(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
                return res;
            }
            int[] pCharCount = new int[26];
            for (char c : p.toCharArray()) {
                pCharCount[c - 'a']++;
            }
            int[] window = new int[26];
            int left = 0, right = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                window[c - 'a']++;
                while (window[c - 'a'] > pCharCount[c - 'a']) {
                    window[s.charAt(left) - 'a']--;
                    ++left;
                }
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                right++;
            }
            return res;

        }

        public List<Integer> f001(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
                return res;
            }
            int[] pCharCount = new int[26];
            for (char c : p.toCharArray()) {
                pCharCount[c - 'a']++;
            }
            int[] window = new int[26];
            for (int i = 0; i < p.length(); ++i) {
                window[s.charAt(i) - 'a']++;
            }
            if (Arrays.equals(window, pCharCount)) {
                res.add(0);
            }
            for (int i = 1; i < s.length() - p.length() + 1; ++i) {
                // 窗口右移
                window[s.charAt(i - 1) - 'a']--;
                window[s.charAt(i + p.length() - 1) - 'a']++;
                if (Arrays.equals(window, pCharCount)) {
                    res.add(i);
                }
            }
            return res;

        }

        public List<Integer> f(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) {
                return res;
            }
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char c : p.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
            int subLen = p.length();
            for (int i = 0; i < s.length() - subLen + 1; ++i) {
                Map<Character, Integer> tmpMap = new HashMap<>(charCountMap);
                boolean valid = true;
                for (int j = i; j < i + subLen; ++j) {
                    char c = s.charAt(j);
                    if (tmpMap.getOrDefault(c, 0) == 0) {
                        valid = false;
                        break;
                    } else {
                        tmpMap.put(c, tmpMap.get(c) - 1);
                    }
                }
                if (valid) {
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
