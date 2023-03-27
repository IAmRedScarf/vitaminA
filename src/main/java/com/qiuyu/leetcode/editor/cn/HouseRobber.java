//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 1819 👎 0


package com.qiuyu.leetcode.editor.cn;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int rob(int[] nums) {
            return rob20230220(nums);
        }

        public int rob20230220(int[] nums) {
            int[] dpRob = new int[nums.length];
            int[] dpNotRob = new int[nums.length];
            dpRob[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dpRob[i] = nums[i] + dpNotRob[i - 1];
                dpNotRob[i] = Math.max(dpRob[i - 1], dpNotRob[i - 1]);
            }
            return Math.max(dpRob[nums.length - 1], dpNotRob[nums.length - 1]);
        }










        public int rob_20220429(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // dp[0][i] 表示不偷第i家时，最大金额
            // dp[1][i] 表示偷第i家时，最大金额
            int[][] dp = new int[2][nums.length];
            dp[1][0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = dp[0][i - 1] + nums[i];
            }
            return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);





        }




        public int rob2222222222222(int[] nums) {


            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp0 = new int[nums.length];
            int[] dp1 = new int[nums.length];
            dp0[0] = 0;
            dp1[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                dp0[i] = Math.max(dp0[i - 1], dp1[i - 1]);
                dp1[i] = nums[i] + dp0[i - 1];
            }
            return Math.max(dp0[nums.length - 1], dp1[nums.length - 1]);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
