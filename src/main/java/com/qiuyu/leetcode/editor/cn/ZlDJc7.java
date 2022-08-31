//一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', 
//'9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这
//个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// 
//
// 注意：本题与主站 752 题相同： https://leetcode-cn.com/problems/open-the-lock/ 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 20 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class ZlDJc7 {
    public static void main(String[] args) {
        Solution solution = new ZlDJc7().new Solution();
        String[] strS = new String[] {"0201","0101","0102","1212","2002"};
        solution.openLock(strS, "0202");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> deadEndsSet = new HashSet<>(Arrays.asList(deadends));
            if (deadEndsSet.contains("0000")) {
                return -1;
            }
            if (target.equals("0000")) {
                return 0;
            }
            Set<String> less = new HashSet<>();
            less.add("0000");
            Set<String> more = new HashSet<>();
            more.add(target);

            Set<String> visited = new HashSet<>();

            int step = 0;
            while (!less.isEmpty() && !more.isEmpty()) {
                if (more.size() < less.size()) {
                    Set<String> tmp = less;
                    less = more;
                    more = tmp;
                }
                Deque<String> queue = new LinkedList<>(less);
                less.clear();
                step++;
                while (!queue.isEmpty()) {
                    String head = queue.pollFirst();
                    visited.add(head);
                    List<String> candidates = getNext(head, visited);
                    for (String candidate : candidates) {
                        if (more.contains(candidate)) {
                            return step;
                        }
                        if (!deadEndsSet.contains(candidate) && !visited.contains(candidate)) {
                            less.add(candidate);
                        }
                    }
                }
            }
            return -1;




        }





        public int openLock_20220717(String[] deadends, String target) {
            Set<String> deadEndsSet = new HashSet<>(Arrays.asList(deadends));
            Set<String> strVisitedSet = new HashSet<>();
            Deque<String> queue = new LinkedList<>();
            queue.add("0000");
            strVisitedSet.add("0000");
            if (target.equals("0000")) {
                return 0;
            }
            if (deadEndsSet.contains("0000")) {
                return -1;
            }
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                for (int i = 0; i < size; ++i) {
                    String curStr = queue.pollFirst();

                    List<String> candidates = getNext(curStr);
                    for (String candidate : candidates) {
                        if (candidate.equals(target)) {
                            return step;
                        }
                        if (!deadEndsSet.contains(candidate) && !strVisitedSet.contains(candidate)) {
                            queue.addLast(candidate);
                            strVisitedSet.add(candidate);
                        }
                    }

                }
            }
            return -1;

        }


        private List<String> getNext(String s, Set<String> visited) {
            List<String> candidates = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                StringBuilder sb = new StringBuilder(s);
                if (s.charAt(i) == '0') {
                    sb.setCharAt(i, '1');

                    if (!visited.contains(sb.toString())) {
                        candidates.add(sb.toString());
                    }
                    sb.setCharAt(i, '9');
                    if (!visited.contains(sb.toString())) {
                        candidates.add(sb.toString());
                    }
                } else if (s.charAt(i) == '9') {
                    sb.setCharAt(i, '8');
                    if (!visited.contains(sb.toString())) {
                        candidates.add(sb.toString());
                    }
                    sb.setCharAt(i, '0');
                    if (!visited.contains(sb.toString())) {
                        candidates.add(sb.toString());
                    }
                } else {
                    sb.setCharAt(i, (char) (s.charAt(i) + 1));
                    if (!visited.contains(sb.toString())) {
                        candidates.add(sb.toString());
                    }
                    sb.setCharAt(i, (char) (s.charAt(i) - 1));
                    if (!visited.contains(sb.toString())) {
                        candidates.add(sb.toString());
                    }
                }
            }
            return candidates;
        }

        private List<String> getNext(String s) {
            List<String> candidates = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                StringBuilder sb = new StringBuilder(s);
                if (s.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    candidates.add(sb.toString());
                    sb.setCharAt(i, '9');
                    candidates.add(sb.toString());
                } else if (s.charAt(i) == '9') {
                    sb.setCharAt(i, '8');
                    candidates.add(sb.toString());
                    sb.setCharAt(i, '0');
                    candidates.add(sb.toString());
                } else {
                    sb.setCharAt(i, (char) (s.charAt(i) + 1));
                    candidates.add(sb.toString());
                    sb.setCharAt(i, (char) (s.charAt(i) - 1));
                    candidates.add(sb.toString());
                }
            }
            return candidates;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
