//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1405 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("cabwefgewcwaefgcf", "cae");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minWindow_20220508(String s, String t) {
            Map<Character, Integer> letterCountMap = new HashMap<>();
            Map<Character, Integer> windowLetterCountMap = new HashMap<>();


            for (int i = 0; i < t.length(); ++i) {
                char cur = t.charAt(i);
                letterCountMap.put(cur, letterCountMap.getOrDefault(cur, 0) + 1);
            }
            String res = "";
            int minLen = Integer.MAX_VALUE;

            int left = 0, right = 0;
            // 窗口中，满足字符串t中字符个数要求的字符个数
            int valid = 0;
            while (right < s.length()) {
                // 移入窗口的字符
                char cur = s.charAt(right);
                right++;
                if (letterCountMap.containsKey(cur)) {
                    windowLetterCountMap.put(cur, windowLetterCountMap.getOrDefault(cur, 0) + 1);
                    if (Objects.equals(windowLetterCountMap.get(cur), letterCountMap.get(cur))) {
                        valid++;
                    }
                }
                if (valid == letterCountMap.size()) {
                    while (left < right) {
                        if (valid == letterCountMap.size()) {
                            if (right - left < minLen) {
                                minLen = right - left + 1;
                                res = s.substring(left, right);
                            }
                            if (letterCountMap.containsKey(s.charAt(left))) {
                                windowLetterCountMap.put(s.charAt(left), windowLetterCountMap.getOrDefault(s.charAt(left), 0) - 1);
                                if (windowLetterCountMap.get(s.charAt(left)) < letterCountMap.get(s.charAt(left))) {
                                    valid--;
                                }
                            }
                            left++;

                        } else {
                            break;
                        }
                    }
                }

            }
            return res;

        }



        public String minWindow(String s, String t) {
            return minWindow_20220508(s, t);
        }












        public String minWindow_old(String s, String t) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0) {
                return "";
            }
            int[] stillNeed = new int[128];
            for (int i = 0; i < t.length(); ++i) {
                stillNeed[t.charAt(i)]++;
            }
            int minLen = Integer.MAX_VALUE;
            String res = "";
            int left = 0, right = 0;
            while (right < s.length()) {
                stillNeed[s.charAt(right)]--;
                if (isValid(stillNeed)) {
                    while (left <= right) {
                        if (isValid(stillNeed)) {
                            if (right - left + 1 < minLen) {
                                minLen = right - left + 1;
                                res = s.substring(left, right + 1);
                            }
                            stillNeed[s.charAt(left)]++;
                            ++left;
                        } else {
                            break;
                        }
                    }
                }
                right++;
            }
            return res;
        }

        private boolean isValid(int[] stillNeed) {
            for (int i = 0; i < stillNeed.length; ++i) {
                if (stillNeed[i] > 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
