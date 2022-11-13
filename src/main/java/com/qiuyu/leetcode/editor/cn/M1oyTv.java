//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
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
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 54 👎 0


package com.qiuyu.leetcode.editor.cn;

public class M1oyTv {
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int resLen = Integer.MAX_VALUE;
            String resStr = "";
            int[] tCharNum = new int[128];
            int[] needCharNum = new int[128];
            for (Character c : t.toCharArray()) {
                tCharNum[c]++;
                needCharNum[c]++;
            }
            int needCnt = t.length();
            int left = 0, right = 0;
            while (right < s.length()) {
                char cur = s.charAt(right);
                if (tCharNum[cur] > 0) {
                    if (needCharNum[cur] > 0) {
                        needCnt--;
                    }
                    needCharNum[cur]--;
                    while (needCnt == 0 && left <= right) {
                        char leftC = s.charAt(left);
                        if (tCharNum[leftC] > 0) {
                            needCharNum[leftC]++;
                            if (needCharNum[leftC] == 0) {
                                if (right - left + 1 < resLen) {
                                    resLen = right - left + 1;
                                    resStr = s.substring(left, right + 1);
                                }
                                needCnt++;
                            }

                        }
                        left++;
                    }
                }
                right++;
            }
            return resStr;


        }


        public String minWindow20220909(String s, String t) {
            String res = "";
            int minLen = Integer.MAX_VALUE;

            int[] need = new int[128];
            int needCount = 0;
            for (char c : t.toCharArray()) {
                need[c]++;
                needCount++;
            }
            int left = 0, right = 0;
            while (right < s.length()) {
                char cur = s.charAt(right);
                if (need[cur] > 0) {
                    needCount--;
                }
                need[cur]--;
                while (left <= right && needCount == 0) {
                    char windowLeft = s.charAt(left);
                    need[windowLeft]++;
                    if (need[windowLeft] > 0) {
                        needCount++;
                        if (right - left < minLen) {
                            minLen = right - left;
                            res = s.substring(left, right + 1);
                        }
                    }
                    left++;


                }
                right++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
