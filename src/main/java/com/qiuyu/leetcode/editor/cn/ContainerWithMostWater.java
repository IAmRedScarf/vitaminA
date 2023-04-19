//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 2676 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        solution.maxArea(height);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            return maxArea20230418(height);


        }


        public int maxArea20230418(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int left = 0, right = height.length - 1;
            int maxWater = 0;
            while (left < right) {
                int w = right - left;
                int h = 0;
                if (height[left] < height[right]) {
                    h = height[left];
                    left++;
                } else {
                    h = height[right];
                    right--;
                }
                maxWater = Math.max(maxWater, w * h);
            }
            return maxWater;
        }











        public int maxArea20230214(int[] height) {
            int left = 0, right = height.length - 1;
            int maxRectangle = Integer.MIN_VALUE;
            while (left < right) {
                int curMax = (right - left) * Math.min(height[left], height[right]);
                maxRectangle = Math.max(maxRectangle, curMax);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxRectangle;
        }






        public int maxArea_20220426(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int left = 0, right = height.length - 1;
            int res = 0;
            while (left < right) {
                int distance = right - left;
                if (height[left] <= height[right]) {
                    res = Math.max(res, distance * height[left]);
                    left++;
                } else {
                    res = Math.max(res, distance * height[right]);
                    right--;
                }
            }
            return res;
        }











        public int maxArea2222222222(int[] height) {

            return maxArea_20220426(height);
//            if (height.length <= 1) {
//                return 0;
//            }
//            int left = 0, right = height.length - 1;
//            int res = 0;
//            while (left < right) {
//                int curMaxArea = Math.min(height[left], height[right]) * (right - left);
//                if (curMaxArea > res) {
//                    res = curMaxArea;
//                }
//                if (height[left] < height[right]) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//            return res;


//            int left = 0, right = height.length - 1;
//            int res = 0;
//            int cur = 0;
//            while (left < right) {
//
//
//                if (height[left] < height[right]) {
//                    cur = (right - left) * height[left];
//                    left++;
//                } else {
//                    cur = (right - left) * height[right];
//                    right--;
//                }
//                res = Math.max(res, cur);
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
