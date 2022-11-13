//在字典（单词列表） wordList 中，从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给定两个长度相同但内容不同的单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 
//的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// 
//
// 注意：本题与主站 127 题相同： https://leetcode-cn.com/problems/word-ladder/ 
// Related Topics 广度优先搜索 哈希表 字符串 👍 18 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class Om3reC {
    public static void main(String[] args) {
        Solution solution = new Om3reC().new Solution();
        String[] strArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        solution.ladderLength("hit", "cog", Arrays.asList(strArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            if (beginWord.equals(endWord)) {
//                return 2;
//            }
            if (wordList == null || wordList.size() == 0) {
                return 0;
            }

            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }

            Set<String> visited = new HashSet<>();


            Set<String> reachSet1 = new HashSet<>();
            reachSet1.add(beginWord);
            Set<String> reachSet2 = new HashSet<>();
            reachSet2.add(endWord);

            int step = 1;
            while (!reachSet1.isEmpty() && !reachSet2.isEmpty()) {
                if (reachSet1.size() > reachSet2.size()) {
                    Set<String> tmp = reachSet1;
                    reachSet1 = reachSet2;
                    reachSet2 = tmp;
                }

                Set<String> curReachSet = new HashSet<>();
                for (String curWord : reachSet1) {
                    if (findNextWordIsValid(curWord, wordSet, curReachSet, reachSet2, visited)) {
                        return 1 + step;
                    }
                }
                reachSet1 = curReachSet;
                step++;
            }
            return 0;
        }


        private boolean findNextWordIsValid(String curWord, Set<String> wordSet, Set<String> curReachSet, Set<String> targetSet, Set<String> visited) {
            char[] curCharArray = curWord.toCharArray();
            for (int i = 0; i < curWord.length(); ++i) {
                char origin = curCharArray[i];
                for (int j = 0; j < 26; ++j) {
                    if ('a' + j == origin) {
                        continue;
                    }
                    curCharArray[i] = (char) ('a' + j);
                    String fixedWord = String.valueOf(curCharArray);

                    if (targetSet.contains(fixedWord)) {
                        return true;
                    }

                    if (wordSet.contains(fixedWord) && !visited.contains(fixedWord)) {
                        curReachSet.add(fixedWord);
                        visited.add(fixedWord);
                    }

                }
                curCharArray[i] = origin;
            }
            return false;
        }


        public int ladderLength_20220808(String beginWord, String endWord, List<String> wordList) {
            if (beginWord.equals(endWord)) {
                return 2;
            }
            if (wordList.size() == 0) {
                return 0;
            }
            Set<String> visited = new HashSet<>();
            Set<String> wordSet = new HashSet<>(wordList);


            Deque<String> queue = new LinkedList<>();
            queue.add(beginWord);

            visited.add(beginWord);

            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    String tail = queue.pollFirst();
                    Set<String> nextWordSet = getNextWords(tail, wordSet, visited);
                    if (nextWordSet.contains(endWord)) {
                        return step + 1;
                    }
                    visited.addAll(nextWordSet);
                    for (String word : nextWordSet) {
                        queue.addLast(word);
                    }
                }
                step++;
            }
            return 0;
        }

        private Set<String> getNextWords(String curWord, Set<String> wordSet, Set<String> visited) {
            Set<String> nextWordSet = new HashSet<>();
            char[] curCharArray = curWord.toCharArray();
            for (int i = 0; i < curWord.length(); ++i) {
                char origin = curCharArray[i];
                for (int j = 0; j < 26; ++j) {
                    if ('a' + j == origin) {
                        continue;
                    }
                    curCharArray[i] = (char) ('a' + j);
                    String fixWord = String.valueOf(curCharArray);
                    if (wordSet.contains(fixWord) && !visited.contains(fixWord)) {
                        nextWordSet.add(fixWord);
                    }
                }
                curCharArray[i] = origin;
            }
            return nextWordSet;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
