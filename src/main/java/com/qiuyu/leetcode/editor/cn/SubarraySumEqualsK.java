//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1194 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        solution.subarraySum(new int[]{1, 1, 1,}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum_20220430_a(int[] nums, int k) {
            if (nums == null) {
                return 0;
            }
            int count = 0;
            // 前缀和出现的次数
            Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
            prefixSumCountMap.put(0, 1);

            int prefixSum = 0;
            for (int i = 0; i < nums.length; ++i) {
                prefixSum += nums[i];
                if (prefixSumCountMap.containsKey(prefixSum - k)) {
                    count += prefixSumCountMap.get(prefixSum - k);
                }
                prefixSumCountMap.put(prefixSum, prefixSumCountMap.getOrDefault(prefixSum, 0) + 1);
            }
            return count;

        }



        public int subarraySum_20220430(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                int lastSum = 0;
                for (int j = i; j < nums.length; ++j) {
                    int curSum = nums[j] + lastSum;
                    lastSum = curSum;
                    if (curSum == k) {
                        ++count;
                    }
                }
            }
            return count;

        }










        public int subarraySum(int[] nums, int k) {
            return subarraySum_20220430_a(nums, k);
//            return subarraySum_20220430(nums, k);
//            return f2(nums, k);

        }

        private int f1(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;

            int[] preSum = new int[len];
            preSum[0] = nums[0];

            int res = 0;
            for (int i = 1; i < len; ++i) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            for (int i = 0; i < len; ++i) {
                for (int j = i; j < len; ++j) {
                    int curSum = i == 0 ? preSum[j] : (preSum[j] - preSum[i - 1]);
                    if (curSum == k) {
                        res++;
                    }

                }
            }
            return res;
        }

        private int f2(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int res = 0;
            // 存放等于某个值的前缀和个数
            Map<Integer, Integer> tmpMap = new HashMap<>();
            // 索引为-1的前缀和为0
            tmpMap.put(0, 1);
            int curPreSum = 0;
            for (int i = 0; i < len; ++i) {
                curPreSum = curPreSum + nums[i];
                res += tmpMap.getOrDefault(curPreSum - k, 0);
                int numOfCurPreSum = tmpMap.getOrDefault(curPreSum, 0);
                tmpMap.put(curPreSum, numOfCurPreSum + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
