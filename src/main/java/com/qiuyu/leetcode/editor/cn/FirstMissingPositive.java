//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1152 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] nums = new int[]{1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int N = nums.length;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= 0) {
                    nums[i] = N + 1;
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                int tmp = Math.abs(nums[i]);
                if (tmp >= 1 && tmp <= N) {
                    nums[tmp - 1] = -Math.abs(nums[tmp - 1]);
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return N + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
