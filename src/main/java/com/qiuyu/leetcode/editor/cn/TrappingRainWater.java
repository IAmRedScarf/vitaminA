//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2551 👎 0


package com.qiuyu.leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int trap_20220510(int[] height) {
            int len = height.length;
            // 左边（包括自己）最高，也就是截止当前下标最高的
            int[] leftMax = new int[len];
            leftMax[0] = height[0];
            for (int i = 1; i < len; ++i) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            // 右边（包括自己）最高，和上述逻辑相反
            int[] rightMax = new int[len];
            rightMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int res = 0;
            for (int i = 0; i < len; ++i) {
                int waterHigh = Math.min(leftMax[i], rightMax[i]) - height[i];
                res += waterHigh;
            }
            return res;








        }











        public int trap(int[] height) {
            return trap_20220510(height);
        }


        public int trap_old(int[] height) {
            if (height.length <= 1) {
                return 0;
            }
            int len = height.length;
            int[] leftMax = new int[len];
            int[] rightMax = new int[len];

            leftMax[0] = height[0];
            for (int i = 1; i < len; ++i) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }

            rightMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; --i) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }

            int res = 0;
            for (int i = 0; i < len; ++i) {
                res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
