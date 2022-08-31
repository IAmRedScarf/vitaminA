//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 
//true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？ 
// Related Topics 贪心 数组 👍 549 👎 0


package com.qiuyu.leetcode.editor.cn;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        System.out.println(solution.increasingTriplet(new int[] {9,10,5,11,10,9,8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length < 3) {
                return false;
            }
            int len = nums.length;
            int[] leftMin = new int[len];
            int[] rightMax = new int[len];
            leftMin[0] = nums[0];
            for (int i = 1; i < len; ++i) {
                leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
            }
            rightMax[len - 1] = nums[len - 1];
            for (int i = len - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
            }

            for (int i = 1; i < len - 1; ++i) {
                if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                    return true;
                }
            }
            return false;
//            int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
//            for (int num : nums) {
//                if (num <= small) {
//                    small = num;
//                } else if (num <= mid) {
//                    mid = num;
//                } else {
//                    return true;
//                }
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
