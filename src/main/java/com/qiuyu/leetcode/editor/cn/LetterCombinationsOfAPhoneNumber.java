//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1613 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private void dfs_20220426(Map<Character, String> numLettersMap, String digits, int start, StringBuilder sb, List<String> res) {
            if (start == digits.length()) {
                res.add(sb.toString());
            } else {
                String letters = numLettersMap.get(digits.charAt(start));
                for (int i = 0; i < letters.length(); ++i) {
                    sb.append(letters.charAt(i));
                    dfs_20220426(numLettersMap, digits, start + 1, sb, res);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        public List<String> letterCombinations_20220426(String digits) {
            Map<Character, String> numLettersMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return res;
            }
            dfs_20220426(numLettersMap, digits, 0, new StringBuilder(), res);
            return res;

        }














        public List<String> letterCombinations(String digits) {
            return letterCombinations_20220426(digits);
//            Map<Character, String> numLettersMap = new HashMap<Character, String>() {{
//                put('2', "abc");
//                put('3', "def");
//                put('4', "ghi");
//                put('5', "jkl");
//                put('6', "mno");
//                put('7', "pqrs");
//                put('8', "tuv");
//                put('9', "wxyz");
//            }};
//            List<String> res = new ArrayList<>();
//            if (digits == null || digits.length() == 0) {
//                return res;
//            }
//            backTrack(digits, 0, new StringBuilder(), res, numLettersMap);
//
//            return res;
        }


        private void backTrack(String digits, int start, StringBuilder cur, List<String> res, Map<Character, String> numLettersMap) {
            if (start == digits.length()) {
                res.add(cur.toString());
            } else {
                String letters = numLettersMap.get(digits.charAt(start));
                for (int i = 0; i < letters.length(); ++i) {
                    cur.append(letters.charAt(i));
                    backTrack(digits, start + 1, cur, res, numLettersMap);
                    cur.deleteCharAt(cur.length() - 1);
                }
            }
        }




























//        private void backtrack(Map<Character, String> numLetters, List<String> res, String digits, int index, StringBuilder cur) {
//            if (index == digits.length()) {
//                res.add(cur.toString());
//            } else {
//                String letters = numLetters.get(digits.charAt(index));
//                for (int i = 0; i < letters.length(); ++i) {
//                    cur.append(letters.charAt(i));
//                    backtrack(numLetters, res, digits, index + 1, cur);
//                    cur.deleteCharAt(cur.length() - 1);
//                }
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
