//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2110 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            return lengthOfLIS20230320(nums);
        }

        public int lengthOfLIS20230320(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int maxLen = 1;
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; ++i) {
                for (int j = i - 1; j >= 0; --j) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;

        }





        public int lengthOfLIS_20220503(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = 1;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 1; i < nums.length; ++i) {
                dp[i] = 1;
                for (int j = 0;  j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                res = Math.max(dp[i], res);
            }
            return res;
        }



        private int findFirstBigger(List<Integer> piles, int target) {
            int left = 0, right = piles.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (piles.get(mid) > target) {
                    right = mid - 1;
                } else if (piles.get(mid) < target) {
                    left = mid + 1;
                } else {
                    return -1;
                }
            }
            return left;
        }

        public int lengthOfLIS_old(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            List<Integer> piles = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                int index = findFirstBigger(piles, nums[i]);
                if (index != -1) {
                    if (index < piles.size()) {
                        piles.set(index, nums[i]);
                    } else {
                        piles.add(nums[i]);
                    }
                }
            }
            return piles.size();













//            int[] dp = new int[nums.length];
//            dp[0] = 1;
//            int res = dp[0];
//            for (int i = 1; i < nums.length; ++i) {
//                dp[i] = 1;
//                for (int j = 0; j < i; ++j) {
//                    if (nums[i] > nums[j]) {
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
//                res = Math.max(res, dp[i]);
//            }
//            return res;






//            int[] dp = new int[nums.length];
//            dp[0] = 1;
//            int res = 1;
//            for (int i = 1; i < nums.length; ++i) {
//                int before = 0;
//                for (int j = 0; j < i; ++j) {
//                    if (nums[j] < nums[i]) {
//                        before = Math.max(dp[j], before);
//                    }
//                }
//                dp[i] = before + 1;
//                res = Math.max(dp[i], res);
//            }
//
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
