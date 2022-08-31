//实现 strStr() 函数。 
//
// 给你两个字符串 s 和 pattern ，请你在 s 字符串中找出 pattern 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 pattern 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 pattern 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello", pattern = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = "aaaaa", pattern = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：s = "", pattern = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, pattern.length <= 10⁴ 
// s 和 pattern 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1364 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(Arrays.toString(solution.getNext("ababcaababcaabc")));
        System.out.println(Arrays.toString(solution.getNext01("ababcaababcaabc")));
//
//        int[] next2 = solution.getNext("abcdabca");
//        System.out.println(Arrays.toString(next2));
//
//        int[] next3 = solution.getNext("abc");
//        System.out.println(Arrays.toString(next3));

//        System.out.println(solution.strStr("abc", "bc"));

//         a b a b c a a b a b c a a b c
//         0 0 1 2 0 1
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String s, String pattern) {
            if (pattern.isEmpty()) return 0;
            int sLen = s.length(), pLen = pattern.length();
            int curStart = 0;
            int[] next = getNext(pattern);
//            int i = 0, j = 0;
//            while (i < sLen) {
//                if (s.charAt(i) == pattern.charAt(j)) {
//                    ++i;
//                    ++j;
//                } else {
//                    int nextPatternPos = j > 0 ? next[j - 1] : 0;
//                    curStart = i - nextPatternPos;
//                    j = next[j - 1];
//                }
//
//                if (j == pLen) {
//                    return curStart;
//                }
//            }
//            return -1;
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                while(j > 0 && s.charAt(i) != pattern.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == pattern.charAt(j)) {
                    j++;
                }
                if (j == pattern.length() ) {
                    return (i - pattern.length() + 1);
                }
            }
            return -1;

        }


        private int[] getNext(String pattern) {
            int pLen = pattern.length();
            int[] next = new int[pLen];
            // j为前缀末尾
            for (int i = 1, j = 0; i < pLen; ) {
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    next[i] = j + 1;
                    ++j;
                } else {
                    while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                        j = next[j - 1];
                    }
                    if (pattern.charAt(i) == pattern.charAt(j)) {
                        next[i] = j + 1;
                        ++j;
                    } else {
                        next[i] = 0;
                    }
                }
                ++i;
            }
            return next;
        }

        public int[] getNext01(String s){
            int[] next = new int[s.length()];
            int j = -1;
            next[0] = j;
            for (int i = 1; i<s.length(); i++){
                while(j>=0 && s.charAt(i) != s.charAt(j+1)){
                    j=next[j];
                }

                if(s.charAt(i)==s.charAt(j+1)){
                    j++;
                }
                next[i] = j;
            }
            return next;
        }



    }

//leetcode submit region end(Prohibit modification and deletion)

}
