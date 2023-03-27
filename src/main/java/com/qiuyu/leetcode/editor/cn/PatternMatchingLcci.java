//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串
//"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
//
// 示例 1： 
//
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
//
// 示例 2： 
//
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
//
// 示例 3： 
//
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
//
// 示例 4： 
//
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
//
// 提示： 
//
// 
// 1 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 数学 字符串 回溯 枚举 👍 135 👎 0


package com.qiuyu.leetcode.editor.cn;

public class PatternMatchingLcci {
    public static void main(String[] args) {
        Solution solution = new PatternMatchingLcci().new Solution();
        boolean res = solution.patternMatching("abbb", "xxxxxxy");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String pattern;
        private String value;

        public boolean patternMatching(String p, String v) {
            pattern = resolve(p);
            value = v;
            int vLen = value.length();

            for (int end = 0; end <= vLen; ++end) {
                String a = v.substring(0, end);
                if (matchWithFixedA(a.length(), a)) {
                    return true;
                }
            }
            return false;
        }


        private boolean matchWithFixedA(int vStart, String a) {
            int pStart = 1;
            while (pStart < pattern.length() && pattern.charAt(pStart) == 'a') {
                if (vStart + a.length() > value.length()) {
                    return false;
                }
                String cur = value.substring(vStart, vStart + a.length());
                if (!a.equals(cur)) {
                    return false;
                }
                pStart++;
                vStart += a.length();
            }
            if (pStart == pattern.length()) {
                return vStart == value.length();
            }

            String b;
            for (int end = vStart; end <= value.length(); ++end) {
                b = value.substring(vStart, end);
                if (b.equals(a)) {
                    continue;
                }
                if (matchWithFixedAB(pStart + 1, vStart + b.length(), a, b)) {
                    return true;
                }
            }
            return false;
        }

        private boolean matchWithFixedAB(int pStart, int vStart, String a, String b) {
            while (pStart < pattern.length()) {
                if (pattern.charAt(pStart) == 'a') {
                    if (vStart + a.length() > value.length()) {
                        return false;
                    }
                    String cur = value.substring(vStart, vStart + a.length());
                    if (!a.equals(cur)) {
                        return false;
                    }
                    pStart++;
                    vStart += a.length();
                } else if (pattern.charAt(pStart) == 'b') {
                    if (vStart + b.length() > value.length()) {
                        return false;
                    }
                    String cur = value.substring(vStart, vStart + b.length());
                    if (!b.equals(cur)) {
                        return false;
                    }
                    pStart++;
                    vStart += b.length();
                } else {
                    return false;
                }
            }
            return vStart == value.length();
        }


        private String resolve(String p) {
            if (p.startsWith("a")) {
                return p;
            }
            StringBuilder sb = new StringBuilder(p);
            for (int i = 0; i < sb.length(); ++i) {
                if (sb.charAt(i) == 'a') {
                    sb.setCharAt(i, 'b');
                } else {
                    sb.setCharAt(i, 'a');
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
