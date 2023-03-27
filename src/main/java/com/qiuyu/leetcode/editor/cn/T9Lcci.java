//在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你
//会得到一张含有有效单词的列表。映射如下图所示： 
//
// 
//
// 示例 1: 
//
// 输入: num = "8733", words = ["tree", "used"]
//输出: ["tree", "used"]
// 
//
// 示例 2: 
//
// 输入: num = "2", words = ["a", "b", "c", "d"]
//输出: ["a", "b", "c"] 
//
// 提示： 
//
// 
// num.length <= 1000 
// words.length <= 500 
// words[i].length == num.length 
// num中不会出现 0, 1 这两个数字 
// 
// Related Topics 数组 哈希表 字符串 👍 33 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class T9Lcci {
    public static void main(String[] args) {
        Solution solution = new T9Lcci().new Solution();
        solution.getValidT9Words("8733", new String[]{"tree", "used"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> wordSet;
        Trie root;
        Map<Character, String> numStringMap;
        String originNum;


        public List<String> getValidT9Words(String num, String[] words) {
            List<String> res = new ArrayList<>();
            char[] charSingleNumMapArr = new char[]{'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
            int numLength = num.length();
            for (String word : words) {
                int i = 0;
                while (i < word.length()) {
                    if (charSingleNumMapArr[word.charAt(i) - 'a'] != num.charAt(i)) {
                        break;
                    }
                    i++;
                }
                if (i == numLength) {
                    res.add(word);
                }
            }
            return res;
        }


        public List<String> getValidT9Words20230201(String num, String[] words) {
            numStringMap = new HashMap<>();
            numStringMap.put('2', "abc");
            numStringMap.put('3', "def");
            numStringMap.put('4', "ghi");
            numStringMap.put('5', "jkl");
            numStringMap.put('6', "mno");
            numStringMap.put('7', "pqrs");
            numStringMap.put('8', "tuv");
            numStringMap.put('9', "wxyz");


            root = new Trie();
            for (String word : words) {
                root.insert(word);
                ;
            }
            originNum = num;
//            wordSet = new HashSet<>();
//            wordSet.addAll(Arrays.asList(words));

            List<String> res = new ArrayList<>();
            backtrack(0, new StringBuilder(), res);
            return res;

        }


        public void backtrack(int start, StringBuilder sb, List<String> res) {
            if (!root.startWith(sb.toString())) {
                return;
            }
            if (start == originNum.length()) {
                if (root.search(sb.toString())) {
                    res.add(sb.toString());
                }
                return;
            }
            String available = numStringMap.get(originNum.charAt(start));
            for (int i = 0; i < available.length(); ++i) {
                sb.append(available.charAt(i));
                backtrack(1 + start, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    class Trie {
        public Trie[] next;
        public boolean endFlag;

        public Trie() {
            next = new Trie[26];
            endFlag = false;
        }

        public void insert(String s) {
            Trie p = this;
            for (char c : s.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Trie();
                }
                p = p.next[c - 'a'];
            }
            p.endFlag = true;
        }

        public boolean search(String s) {
            Trie p = this;
            for (char c : s.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    return false;
                }
                p = p.next[c - 'a'];
            }
            return p.endFlag;
        }

        public boolean startWith(String prefix) {
            Trie p = this;
            for (char c : prefix.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    return false;
                }
                p = p.next[c - 'a'];
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
