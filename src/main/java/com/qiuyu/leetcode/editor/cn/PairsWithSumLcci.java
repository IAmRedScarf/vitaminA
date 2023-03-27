//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 👍 41 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class PairsWithSumLcci {
    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();
        int[] nums = new int[]{5, 6, 5, 6};
        System.out.println(solution.pairSums(nums, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length < 2) {
                return res;
            }
            Map<Integer, Integer> numCntMap = new HashMap<>();
//            numCntMap.put(nums[0], 1);
            for (int i = 0; i < nums.length; ++i) {
                int need = target - nums[i];
                if (numCntMap.containsKey(need)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(need);
                    tmp.add(nums[i]);
                    res.add(tmp);
                    int cnt = numCntMap.get(need);
                    if (cnt > 1) {
                        numCntMap.put(need, cnt - 1);
                    } else {
                        numCntMap.remove(need);
                    }
                } else {
                    numCntMap.put(nums[i], numCntMap.getOrDefault(nums[i], 0) + 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
