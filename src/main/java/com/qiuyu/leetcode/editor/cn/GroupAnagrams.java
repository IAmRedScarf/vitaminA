//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 911 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return groupAnagrams20230216(strs);
        }



        public List<List<String>> groupAnagrams20230216(String[] strs) {
            Map<String, List<String>> hashStringsMap = new HashMap<>();
            for (String str : strs) {
                String hash = strHash(str);
                if (hashStringsMap.containsKey(hash)) {
                    hashStringsMap.get(hash).add(str);
                } else {
                    List<String> curList = new ArrayList<>();
                    curList.add(str);
                    hashStringsMap.put(hash, curList);
                }
            }
            return new ArrayList<>(hashStringsMap.values());
        }

        private String strHash(String str) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) {
                cnt[c - 'a']++;
            }
            return Arrays.toString(cnt);
        }



















        public List<List<String>> groupAnagrams_20220501(String[] strs) {
            Map<String, List<String>> tmpMap = new HashMap<>();
            for (String str : strs) {
                String hashValue = hash(str);
                if (tmpMap.containsKey(hashValue)) {
                    tmpMap.get(hashValue).add(str);
                } else {
                    List<String> values = new ArrayList<>();
                    values.add(str);
                    tmpMap.put(hashValue, values);
                }
            }
            return new ArrayList<>(tmpMap.values());
        }



        private String hash(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                count[c - 'a']++;
            }
            return Arrays.toString(count);
        }

        public List<List<String>> groupAnagrams_old(String[] strs) {

            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List<String>> tmpMap = new HashMap<>();
            for (String str : strs) {
                String hashValue = hash(str);
                if (tmpMap.containsKey(hashValue)) {
                    tmpMap.get(hashValue).add(str);
                } else {
                    List<String> candidates = new ArrayList<>();
                    candidates.add(str);
                    tmpMap.put(hashValue, candidates);
                }

            }
            return new ArrayList<>(tmpMap.values());





















//            Map<String, List<String>> tmpMap = new HashMap<>();
//            for (String s : strs) {
//                String hashValue = hash(s);
//                if (tmpMap.containsKey(hashValue)) {
//                    tmpMap.get(hashValue).add(s);
//                } else {
//                    tmpMap.put(hashValue, new ArrayList<>(Collections.singleton(s)));
//                }
//            }
//            return new ArrayList<>(tmpMap.values());
        }
















//        private String hash(String s) {
//            int[] charNum = new int[26];
//            for (int i = 0; i < s.length(); ++i) {
//                charNum[s.charAt(i) - 'a']++;
//            }
//            return Arrays.toString(charNum);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
