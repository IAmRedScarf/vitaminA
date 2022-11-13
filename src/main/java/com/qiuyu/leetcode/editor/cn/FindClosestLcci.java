//有个内含单词的超大文本文件，给定任意两个不同的单词，
// 找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 👍 95 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindClosestLcci {
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
        String[] words = new String[]{"I","am","a","student","from","a","university","in","a","city"};
        int res = solution.findClosest(words, "a", "student");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findClosest(String[] words, String word1, String word2) {
            Map<String, List<Integer>> wordIndexListMap = new HashMap<>();
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                if (!wordIndexListMap.containsKey(word)) {
                    wordIndexListMap.put(word, new ArrayList<>());
                }
                wordIndexListMap.get(word).add(i);
            }
            List<Integer> aList = wordIndexListMap.getOrDefault(word1, new ArrayList<>());
            List<Integer> bList = wordIndexListMap.getOrDefault(word2, new ArrayList<>());
            int res = Integer.MAX_VALUE;
            int i = 0, j = 0;
            while (i < aList.size() && j < bList.size()) {
                res = Math.min(res, Math.abs(aList.get(i) - bList.get(j)));
                if (aList.get(i) < bList.get(j)) {
                    i++;
                } else if (aList.get(i) > bList.get(j)) {
                    j++;
                } else {
                    break;
                }
            }
            return res;
        }


        public int findClosest20221104(String[] words, String word1, String word2) {
            int res = Integer.MAX_VALUE;
            int aIndex = -1, bIndex = -1;
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                if (word.equals(word1)) {
                    aIndex = i;
                } else if (word.equals(word2)) {
                    bIndex = i;
                }
                if (aIndex >= 0 && bIndex >= 0) {
                    res = Math.min(res, Math.abs(aIndex - bIndex));
                }

            }
            return res;
        }


        public int findClosest20221107(String[] words, String word1, String word2) {
            ListNode dummyHead1 = new ListNode();
            ListNode dummyHead2 = new ListNode();
            ListNode p1 = dummyHead1, p2 = dummyHead2;

            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                if (word.equals(word1)) {
                    p1.next = new ListNode(i, 1, null);
                    p1 = p1.next;
                }
                if (word.equals(word2)) {
                    p2.next = new ListNode(i, 2, null);
                    p2 = p2.next;
                }
            }
            ListNode merged = merge2Sorted(dummyHead1.next, dummyHead2.next);
            return findClosest(merged);

//            Map<String, ListNode[]> wordIndexListMap = buildMap(words);
//            ListNode merged = merge2Sorted((wordIndexListMap.get(word1))[0], (wordIndexListMap.get(word2))[1]);
//            return findClosest(merged);


        }

        private Map<String, ListNode[]> buildMap(String[] words) {
            int color = 0;
            Map<String, Integer> wordColorMap = new HashMap<>();
            for (String word : words) {
                if (!wordColorMap.containsKey(word)) {
                    wordColorMap.put(word, color++);
                }
            }
            Map<String, ListNode[]> wordIndexListMap = new HashMap<>();
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                int curColor = wordColorMap.get(word);
                ListNode[] headTail;
                if (!wordIndexListMap.containsKey(word)) {
                    ListNode cur = new ListNode(i, curColor, null);
                    headTail = new ListNode[] {cur, cur};
                    wordIndexListMap.put(word, headTail);
                } else {
                    headTail = wordIndexListMap.get(word);
                    headTail[1].next = new ListNode(i, curColor, null);
                }
            }
            return wordIndexListMap;
        }


        private int findClosest(ListNode head) {
            if (head == null || head.next == null) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            ListNode p = head;
            while (p.next != null) {
                if (p.color != p.next.color) {
                    res = Math.min(res, p.next.val - p.val);
                }
                p = p.next;
            }
            return res;
        }

        private ListNode merge2Sorted(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return null;
            }
            ListNode dummyHead = new ListNode(-1, 0, null);
            ListNode p = dummyHead;
            ListNode p1 = l1, p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }
            while (p1 != null) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
            while (p2 != null) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
            return dummyHead.next;
        }



    }

    class ListNode {
        public int val;
        public int color;
        public ListNode next;

        public ListNode() {

        }

        public ListNode(int val, int color, ListNode next) {
            this.val = val;
            this.color = color;
            this.next = next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
