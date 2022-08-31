//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1404 👎 0


package com.qiuyu.leetcode.editor.cn;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        solution.jump_20220502_a(new int[] {2,3,1,1,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump_20220502_a(int[] nums) {
            int step = 0;
            // 每一次起跳点的区间范围
            int startIntervalLeft = 0, startIntervalRight = 0;
            int maxPos = 0;
            for (int i = 0; i < nums.length - 1; ++i) {
                maxPos = Math.max(i + nums[i], maxPos);
                if (i == startIntervalRight) {
                    startIntervalLeft = startIntervalRight + 1;
                    startIntervalRight = maxPos;
                    step++;
                }

            }

            return step;

        }



        public int jump_20220502(int[] nums) {
            int step = 0;
            // 每一次起跳点的区间范围
            int startIntervalLeft = 0, startIntervalRight = 0;

            // 当 startIntervalRight == nums.length - 1时，已经到达了终点，无需再进入循环进行跳跃
            while (startIntervalRight < nums.length - 1) {
                int tmp = 0;
                for (int i = startIntervalLeft; i <= startIntervalRight; ++i) {
                    tmp = Math.max(i + nums[i], tmp);
                }
                startIntervalLeft = startIntervalRight + 1;
                startIntervalRight = tmp;
                ++step;
            }
            return step;

        }

        public int jump(int[] nums) {
//            return jump_20220502(nums);
            return jump_20220502_a(nums);
        }


        public int jump_old(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
//            int ans = 0;
//            // 初始化起跳点的范围
//            int start = 0, end = 0;
//            while (end < nums.length - 1) {
//                // 第一次起跳最远位置
//                int thisJumpMaxPos = 0;
//                for (int i = start; i <= end; ++i) {
//                    thisJumpMaxPos = Math.max(thisJumpMaxPos, nums[i] + i);
//                }
//                ans++;
//                // 更新下一次起跳点的范围
//                start = end + 1;
//                end = thisJumpMaxPos;
//            }
//            return ans;


            int ans = 0;
            int start = 0, end = 0;
            int maxPos = 0;
            for (int i = start; i < nums.length - 1; ++i) {
                maxPos = Math.max(maxPos, nums[i] + i);
                if (i == end) {
                    ans++;
                    end = maxPos;
                }
            }
            return ans;






















//            if (nums.length == 1) {
//                return 0;
//            }
//            int steps = 1;
//            int end = nums[0];
//            // 每次跳跃
//            int maxPos = 0;
//            for (int i = 0; i < nums.length - 1; ++i) {
//                maxPos = Math.max(i + nums[i], maxPos);
//                if (i == end) {
//                    steps++;
//                    end = maxPos;
//                }
//            }
//            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
