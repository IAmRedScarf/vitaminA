//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 10⁴ 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 768 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new TaskScheduler().new Solution();
        char[] tasks = new char[] {'A','A','A','B','B','B'};
        System.out.println(solution.leastInterval(tasks, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int leastInterval(char[] tasks, int n) {
            return leastInterval20230330(tasks, n);
        }


        public int leastInterval20230330(char[] tasks, int n) {
            int[] taskCntArr = new int[26];
            for (char c : tasks) {
                taskCntArr[c - 'A']++;
            }
            int singleTaskCntMax = 0;
            for (int cnt : taskCntArr) {
                singleTaskCntMax = Math.max(singleTaskCntMax, cnt);
            }
            int numOfMaxCntTask = 0;
            for (int j : taskCntArr) {
                if (j == singleTaskCntMax) {
                    numOfMaxCntTask++;
                }
            }
            if (numOfMaxCntTask >= (n + 1)) {
                return tasks.length;
            } else {
                int base = numOfMaxCntTask + (n + 1) * (singleTaskCntMax - 1);
                if (tasks.length > base) {
                    return tasks.length;
                } else {
                    return base;
                }
            }





        }




















        public int leastInterval_20220501_b(char[] tasks, int n) {
            int[] taskCount = new int[26];
            int singleTaskCountMax = 0;
            for (char task : tasks) {
                taskCount[task - 'A']++;
                singleTaskCountMax = Math.max(singleTaskCountMax, taskCount[task - 'A']);
            }

            int numOfMaxCountTask = 0;
            for (int count : taskCount) {
                if (count == singleTaskCountMax) {
                    numOfMaxCountTask++;
                }
            }
            return Math.max(tasks.length, (singleTaskCountMax - 1) * (n + 1) + numOfMaxCountTask);


        }

        // 模拟
        public int leastInterval_20220501_a(char[] tasks, int n) {
            // 任务出现的频次
            Map<Character, Integer> taskFreqMap = new HashMap<>();
            for (char task : tasks) {
                taskFreqMap.put(task, taskFreqMap.getOrDefault(task, 0) + 1);
            }

            // 下标对应一种类型的任务
            List<Integer> nextValidTime = new ArrayList<>();
            List<Integer> leftFreq = new ArrayList<>();

            for (Map.Entry<Character, Integer> entry : taskFreqMap.entrySet()) {
                nextValidTime.add(1);
                leftFreq.add(entry.getValue());
            }

            int time = 0;
            for (int i = 0; i < tasks.length; ++i) {
                ++time;
                int minNextValidTime = Integer.MAX_VALUE;
                for (int j = 0; j < nextValidTime.size(); ++j) {
                    if (leftFreq.get(j) != 0) {
                        minNextValidTime = Math.min(minNextValidTime, nextValidTime.get(j));
                    }
                }
                // 如果 minNextValidTime 比 time 大，表示存在待命状态
                time = Math.max(time, minNextValidTime);

                // 选择剩余需要执行次数最多的任务执行
                int needTodoMax = Integer.MIN_VALUE;
                int needTodoIndex = -1;
                for (int j = 0; j < leftFreq.size(); ++j) {
                    if (leftFreq.get(j) != 0 && nextValidTime.get(j) <= time && leftFreq.get(j) > needTodoMax) {
                        needTodoMax = leftFreq.get(j);
                        needTodoIndex = j;
                    }
                }
                nextValidTime.set(needTodoIndex, time + n + 1);
                leftFreq.set(needTodoIndex, leftFreq.get(needTodoIndex) - 1);
            }
            return time;

        }


        public int leastInterval_pre(char[] tasks, int n) {

            if (tasks.length == 0 || n < 0) {
                return 0;
            }
            int[] numOfTask = new int[26];
            for (int i = 0; i < tasks.length; ++i) {
                numOfTask[tasks[i] - 'A']++;
            }
            int most = 0, total = 0, types = 0;
            for (int i = 0; i < 26; ++i) {
                if (numOfTask[i] > 0) {
                    types++;
                }
                most = Math.max(numOfTask[i], most);
                total += numOfTask[i];
            }
            int numOfMost = 0;
            for (int i = 0; i < 26; ++i) {
                if (numOfTask[i] == most) {
                    numOfMost++;
                }
            }
            int baseTime = (most - 1) * (n + 1);
            return numOfMost + Math.max(total - numOfMost, baseTime);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
