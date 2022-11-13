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
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }

            Set<String> reachedSet1 = new HashSet<>();
            reachedSet1.add(beginWord);
            Set<String> reachedSet2 = new HashSet<>();
            reachedSet2.add(endWord);

            Set<String> visited = new HashSet<>();

            int step = 1;
            while (!reachedSet1.isEmpty() && !reachedSet2.isEmpty()) {
                if (reachedSet1.size() > reachedSet2.size()) {
                    Set<String> tmp = reachedSet1;
                    reachedSet1 = reachedSet2;
                    reachedSet2 = tmp;
                }
                Set<String> tmpReached = new HashSet<>();
                for (String curWord : reachedSet1) {
                    if (judgeChangedWord(curWord, wordSet, reachedSet2, visited, tmpReached)) {
                        return step + 1;
                    }
                }
                step++;
                reachedSet1 = tmpReached;
            }
            return 0;

        }

        private boolean judgeChangedWord(String curWord, Set<String> wordSet, Set<String> targetSet, Set<String> visited, Set<String> curRoundReached) {
            visited.add(curWord);
            for (int i = 0; i < curWord.length(); ++i) {
                StringBuilder sb = new StringBuilder(curWord);
                char c = curWord.charAt(i);
                for (int j = 0; j < 26; ++j) {
                    if (c - 'a' == j) {
                        continue;
                    }
                    sb.setCharAt(i, (char) ('a' + j));
                    String tmp = sb.toString();
                    if (targetSet.contains(tmp)) {
                        return true;
                    }
                    if (wordSet.contains(tmp) && !visited.contains(tmp)) {
                        curRoundReached.add(tmp);
                        visited.add(tmp);
                    }
                    sb.setCharAt(i, c);
                }
            }
            return false;
        }



        public int ladderLength20221104(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();

            Deque<String> q = new LinkedList<>();
            q.addLast(beginWord);
            int step = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; ++i) {
                    String curWord = q.pollFirst();
                    Set<String> canReachWords = getChangedWord(curWord, wordSet, visited);
                    if (canReachWords.contains(endWord)) {
                        return step + 1;
                    } else {
                        for (String word : canReachWords) {
                            q.addLast(word);
                        }
                    }
                }
                step++;
            }
            return 0;
        }


        public int ladderLength20220809(String beginWord, String endWord, List<String> wordList) {
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


        private Set<String> getChangedWord(String curWord, Set<String> wordSet, Set<String> visited) {
            visited.add(curWord);
            Set<String> res = new HashSet<>();
            for (int i = 0; i < curWord.length(); ++i) {
                StringBuilder sb = new StringBuilder(curWord);
                char c = curWord.charAt(i);
                for (int j = 0; j < 26; ++j) {
                    if (c - 'a' == j) {
                        continue;
                    }
                    sb.setCharAt(i, (char) ('a' + j));
                    String tmp = sb.toString();
                    if (wordSet.contains(tmp) && !visited.contains(tmp)) {
                        res.add(tmp);
                        visited.add(tmp);
                    }
                    sb.setCharAt(i, c);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
