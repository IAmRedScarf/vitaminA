//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 994 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        solution.topKFrequent_20220505(new int[] {1,1,1,2,2,3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] topKFrequent_20220505(int[] nums, int k) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int num : nums) {
                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            int a = 0;
            for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
                if (a < k) {
                    pq.add(new int[] {entry.getKey(), entry.getValue()});
                    ++a;
                } else {
                    if (entry.getValue() > pq.peek()[1]) {
                        pq.poll();
                        pq.add(new int[] {entry.getKey(), entry.getValue()});
                    }
                }
            }
            int[] res = new int[k];
            for (int i = 0; i < k; ++i) {
                res[i] = pq.poll()[0];
            }
            return res;

        }


        public int[] topKFrequent(int[] nums, int k) {
            return topKFrequent_20220505(nums, k);

        }












        public int[] topKFrequent_old(int[] nums, int k) {
            if (nums == null || nums.length <= k) {
                return nums;
            }
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int num : nums) {
                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> entry2.getValue() - entry1.getValue());
            numCountMap.entrySet().forEach(pq::add);
            int[] res = new int[k];
            for (int i = 0; i < k; ++i) {
                res[i] = Objects.requireNonNull(pq.poll()).getKey();
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
