//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 590 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            return f2(s, words);
        }

        private List<Integer> f1(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0] == null || words[0].length() == 0) {
                return res;
            }
            int numOfWords = words.length;
            Map<String, Integer> wordNumMap = new HashMap<>();
            for (String word : words) {
                if (wordNumMap.containsKey(word)) {
                    Integer curNum = wordNumMap.get(word);
                    wordNumMap.put(word, curNum + 1);
                } else {
                    wordNumMap.put(word, 1);
                }
            }
            int wordLen = words[0].length();
            int lenOfCandidate = wordLen * numOfWords;
            Map<String, Integer> tmpMap = new HashMap<>();
            for (int i = 0; i <= s.length() - lenOfCandidate; ++i) {
                String candidate = s.substring(i, i + lenOfCandidate);
                int j = 0;
                while (j < candidate.length()) {
                    String curWord = candidate.substring(j, j + wordLen);
                    if (!wordNumMap.containsKey(curWord)) {
                        break;
                    } else {
                        if (tmpMap.containsKey(curWord)) {
                            int curNum = tmpMap.get(curWord);
                            if (curNum >= wordNumMap.get(curWord)) {
                                break;
                            } else {
                                tmpMap.put(curWord, curNum + 1);
                            }
                        } else {
                            tmpMap.put(curWord, 1);
                        }
                    }
                    j = j + wordLen;
                }
                if (j == candidate.length()) {
                    res.add(i);
                }
                tmpMap.clear();
            }
            return res;
        }

        public List<Integer> f2(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            int wordNum = words.length;
            if (wordNum == 0) {
                return res;
            }
            int wordLen = words[0].length();
            HashMap<String, Integer> allWords = new HashMap<String, Integer>();
            for (String w : words) {
                int value = allWords.getOrDefault(w, 0);
                allWords.put(w, value + 1);
            }
            for (int j = 0; j < wordLen; ++j) {
                Map<String, Integer> hasWords = new HashMap<>();
                // 标识当前找到的符合条件的word个数
                int num = 0;
                for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                    while (num < wordNum) {
                        String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                        if (allWords.containsKey(word)) {
                            int value = hasWords.getOrDefault(word, 0);
                            hasWords.put(word, value + 1);
                            ++num;
                            // 出现情况3
                            if (hasWords.get(word) > allWords.get(word)) {
                                int removeNum = 0;
                                //一直移除单词，直到次数符合了
                                while (hasWords.get(word) > allWords.get(word)) {
                                    String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                    int v = hasWords.get(firstWord);
                                    hasWords.put(firstWord, v - 1);
                                    removeNum++;
                                }
                                num -= removeNum;
                                i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                                break;
                            } else {
                                if (num == wordNum) {
                                    res.add(i);
                                    String firstWord = s.substring(i, i + wordLen);
                                    int tmp = hasWords.get(firstWord);
                                    hasWords.put(firstWord, tmp - 1);
                                    num--;
                                    break;
                                }
                            }
                            // 情况2
                        } else {
                            hasWords.clear();
                            i = i + num * wordLen;
                            num = 0;
                            break;
                        }
                    }

                }
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
