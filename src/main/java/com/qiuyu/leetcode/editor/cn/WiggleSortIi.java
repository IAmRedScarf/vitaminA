//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 数组 分治 快速选择 排序 👍 331 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
        int[] nums = new int[] {1,2,3,4,5,6,6,6,7,7,8};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        nthDivide(nums, 0, len - 1, len / 2);
        int mid = nums[len / 2];
        int left = 0, i = 0, right = len - 1;
        while (i <= right) {
            if (nums[i] < mid) {
                swap(nums, left++, i++);
            } else if (nums[i] > mid) {
                swap(nums, i++, right--);
            } else {
                i++;
            }
        }

        int[] tmp1 = Arrays.copyOfRange(nums, 0, (len + 1) / 2);
        int[] tmp2 = Arrays.copyOfRange(nums, (len + 1) / 2, len);

        for (int j = 0; j < tmp1.length; ++j) {
            nums[j * 2] = tmp1[tmp1.length - 1 - j];
        }
        for (int j = 0; j < tmp2.length; ++j) {
            nums[j * 2 + 1] = tmp2[tmp2.length - 1 - j];
        }

    }

        /**
         * start, end均为有效下标
         * 0 <= n <= nums.length
         * 将数组中第n大的元素，放入索引为n的位置，且前面的元素不比它大，后面的元素不比它小
         */
    private void nthDivide(int[] nums, int start, int end, int n) {
        int i = start, j = start;
        int pivot = nums[end];
        while (j <= end) {
            // 该循环至少执行一次
            if (nums[j] <= pivot) {
                swap(nums, i++, j++);
            } else {
                j++;
            }
        }
        // 下标为i-1处的元素，为pivot
        if (i - 1 == n) {
            return;
        }
        if (i - 1 > n) {
            nthDivide(nums, start, i - 2, n);
        } else if (i - 1 < n) {
            nthDivide(nums, i, end, n);
        }
    }



    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
