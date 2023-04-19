//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 808 👎 0


package com.qiuyu.leetcode.editor.cn;

public class BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
        System.out.println(solution.maxCoins(new int[]{3,1,5,8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            return maxCoins20230417(nums);
        }

        public int maxCoins20230417(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] arr = new int[nums.length + 2];
            arr[0] = 1;
            arr[arr.length - 1] = 1;
            for (int i = 0; i < nums.length; ++i) {
                arr[i + 1] = nums[i];
            }
            int[][] dp = new int[arr.length][arr.length];
            for (int i = arr.length - 3; i >= 0 ; --i) {
                for (int j = i + 1; j <= arr.length - 1; ++j) {
                    for (int k = i + 1; k < j; ++k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                    }
                }
            }
            return dp[0][arr.length - 1];

        }











        public int maxCoins20230404(int[] nums) {
            int[] arr =  new int[nums.length + 2];
            arr[0] = 1;
            arr[arr.length - 1] = 1;
            for (int i = 0; i < nums.length; ++i) {
                arr[i + 1] = nums[i];
            }
            int[][] dp = new int[arr.length][arr.length];

            for (int i = arr.length - 3; i >= 0; --i) {
                for (int j = i + 2; j < arr.length; ++j) {
                    for (int k = i + 1; k < j; ++k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                    }
                }
            }
            return dp[0][arr.length - 1];

        }






        public int maxCoins_20220512(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int fixLen = nums.length + 2;
            int[] fixNum = new int[fixLen];
            fixNum[0] = 1;
            fixNum[fixLen - 1] = 1;
            System.arraycopy(nums, 0, fixNum, 1, nums.length);

            int[][] dp = new int[fixLen][fixLen];


            for (int j = 1; j < fixLen; ++j) {
                for (int i = j - 1; i >= 0; --i) {
                    dp[i][j] = 0;
                    for (int k = i + 1; k < j; ++k) {
                        dp[i][j] = Math.max(dp[i][k] + fixNum[i] * fixNum[k] * fixNum[j] + dp[k][j], dp[i][j]);
                    }
                }
            }
            return dp[0][fixLen - 1];
        }





        public int maxCoins_old(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("...");
            }
            int[] tmpNums = new int[nums.length + 2];
            tmpNums[0] = 1;
            for (int i = 0; i < nums.length; ++i) {
                tmpNums[i + 1] = nums[i];
            }
            tmpNums[nums.length + 1] = 1;
            int[][] dp = new int[tmpNums.length][tmpNums.length];
            for (int intervalLen = 2; intervalLen <= tmpNums.length - 1; ++intervalLen) {
                for (int intervalBegin = 0; intervalBegin < tmpNums.length - intervalLen; intervalBegin++) {
                    int curMax = 0;
                    for (int lastBalloonIndex = intervalBegin + 1; lastBalloonIndex < intervalBegin + intervalLen; ++lastBalloonIndex) {
                        int cur = dp[intervalBegin][lastBalloonIndex]
                                + tmpNums[intervalBegin] * tmpNums[lastBalloonIndex] * tmpNums[intervalBegin + intervalLen]
                                + dp[lastBalloonIndex][intervalBegin + intervalLen];
                        if (cur > curMax) {
                            curMax = cur;
                        }
                    }
                    dp[intervalBegin][intervalBegin + intervalLen] = curMax;
                }
            }

            return dp[0][tmpNums.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
