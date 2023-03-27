//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1326 👎 0


package com.qiuyu.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump_20220502(new int[]{3, 2, 1, 0, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            return canJump20230216(nums);
        }


        public boolean canJump20230216(int[] nums) {
            // 当前可以到达的最远下标
            int farthest = 0;
            int i = 0;
            while (i < nums.length) {
                if (farthest >= nums.length - 1) {
                    return true;
                }
                if (i > farthest) {
                    return false;
                }
                farthest = Math.max(i + nums[i], farthest);
                ++i;
            }
            return false;

        }


        public boolean canJump_20220502(int[] nums) {
            if (nums == null) {
                return false;
            }
            int maxJump = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (i > maxJump) {
                    return false;
                }
                maxJump = Math.max(i + nums[i], maxJump);
                if (maxJump >= nums.length - 1) {
                    return true;
                }
            }
            return true;

        }


        public boolean canJump_old(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("数组非法");
            }
            int maxJumpIndex = nums[0];
            for (int i = 0; i < nums.length; ++i) {
                if (maxJumpIndex >= nums.length - 1) {
                    return true;
                }
                // 是否能到达下标为i的位置
                if (i > maxJumpIndex) {
                    return false;
                }
                // 更新可以到达的最大位置
                maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);

            }
            return false;


//            int maxJumpDistance = nums[0];
//            int len = nums.length;
//            for (int i = 0; i < len; ++i) {
//                if (maxJumpDistance >= len - 1) {
//                    return true;
//                }
//                if (i <= maxJumpDistance) {
//                    maxJumpDistance = Math.max(i + nums[i], maxJumpDistance);
//                } else {
//                    return false;
//                }
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
