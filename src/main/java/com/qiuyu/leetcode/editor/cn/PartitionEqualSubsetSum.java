//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1085 👎 0


package com.qiuyu.leetcode.editor.cn;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        solution.canPartition_20220507(new int[] {1,5,11,5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean canPartition_20220507(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum & 1) == 1) {
                return false;
            }
            int target = sum / 2;
            boolean[] dp = new boolean[1 + target];
            dp[0] = true;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = target; j >= 0; --j) {
                    int curNum = nums[i];
                    if (j < curNum) {
                        dp[j] = dp[j];
                    } else {
                        dp[j] = dp[j] || dp[j - curNum];
                    }
                }
            }
            return dp[target];

        }








        public boolean canPartition(int[] nums) {
            return canPartition_20220507(nums);
        }

        public boolean canPartition_old(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int targetSum = sum / 2;

//            boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];
//            dp[0][0] = true;
//            for (int target = 1; target <= targetSum; target++) {
//                for (int i = 1; i <= nums.length; ++i) {
//                    int curNum = nums[i - 1];
//                    if (curNum > target)  {
//                        dp[i][target] = dp[i - 1][target];
//                    } else {
//                        dp[i][target] = dp[i - 1][target - curNum] || dp[i - 1][target];
//                    }
//                }
//            }
//
//            return dp[nums.length][targetSum];
            boolean[] dp = new boolean[targetSum + 1];
            dp[0] = true;
            for (int i = 1; i <= nums.length; ++i) {
                for (int target = targetSum; target >= 0; --target) {
                    int curNum = nums[i - 1];
                    if (curNum <= target) {
                        dp[target] = dp[target] || dp[target - curNum];
                    }
                }
            }
            return dp[targetSum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
