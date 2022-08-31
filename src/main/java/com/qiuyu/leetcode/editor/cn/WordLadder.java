//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> 
//s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
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
// Related Topics 广度优先搜索 哈希表 字符串 👍 1005 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        String[] words = new String[] {"hot","dot","dog","lot","log","cog"};
        System.out.println(solution.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList(words))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0) {
                return 0;
            }
            Set<String> wordMap = new HashSet<>(wordList);
            if (!wordMap.contains(endWord)) {
                return 0;
            }
            Queue<String> leftDeque = new LinkedList<>();
            Queue<String> rightDeque = new LinkedList<>();
            leftDeque.add(beginWord);
            rightDeque.add(endWord);

            Set<String> leftAlreadyVisit = new HashSet<>();
            Set<String> rightAlreadyVisit = new HashSet<>();
            leftAlreadyVisit.add(beginWord);
            rightAlreadyVisit.add(endWord);
            int leftStep = 1, rightStep = 1;
            while (!leftDeque.isEmpty() && !rightDeque.isEmpty()) {
                int leftCurQueueSize = leftDeque.size();
                for (int k = 0; k < leftCurQueueSize; ++k) {
                    String curS = leftDeque.poll();
                    StringBuilder sb;
                    for (int i = 0 ; i < curS.length(); ++i) {
                        sb = new StringBuilder(curS);
                        for (int j = 0; j < 26; ++j) {
                            if (j == curS.charAt(i) - 'a') {
                                continue;
                            }
                            sb.setCharAt(i, (char) ('a' + j));
                            String convertS = sb.toString();
                            if (rightAlreadyVisit.contains(convertS)) {
                                return leftStep + rightStep;
                            }
                            if (wordMap.contains(convertS) && !leftAlreadyVisit.contains(convertS)) {
                                leftAlreadyVisit.add(convertS);
                                leftDeque.add(convertS);
                            }
                        }
                    }
                }
                leftStep++;

                int rightCurQueueSize = rightDeque.size();
                for (int k = 0; k < rightCurQueueSize; ++k) {
                    String curS = rightDeque.poll();
                    StringBuilder sb;
                    for (int i = 0 ; i < curS.length(); ++i) {
                        sb = new StringBuilder(curS);
                        for (int j = 0; j < 26; ++j) {
                            if (j == curS.charAt(i) - 'a') {
                                continue;
                            }
                            sb.setCharAt(i, (char) ('a' + j));
                            String convertS = sb.toString();
                            if (leftAlreadyVisit.contains(convertS)) {
                                return leftStep + rightStep;
                            }
                            if (wordMap.contains(convertS) && !rightAlreadyVisit.contains(convertS)) {
                                rightAlreadyVisit.add(convertS);
                                rightDeque.add(convertS);
                            }
                        }
                    }
                }
                rightStep++;


            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
