//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1408 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = new int[]{1, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void nextPermutation(int[] nums) {
            nextPermutation20230215(nums);
        }


        // 4 8 9 5
        // 5 8 9 4  -> 5 4 8 9
        public void nextPermutation20230215(int[] nums) {
            int len = nums.length;
            int i = len - 1;
            while (i > 0 && nums[i - 1] >= nums[i]) {
                i--;
            }
            if (i == 0) {
                reverse(nums);
                return;
            }
            int index = findLastBiggerThanTarget(nums, i, nums.length - 1, nums[i - 1]);
            swap(nums, i - 1, index);
            Arrays.sort(nums, i, nums.length);
        }





        // 原数组为降序排列
        private int findLastBiggerThanTarget(int[] nums, int i, int j, int target) {
            int left = i, right = j;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 到这一步，left为target可插入的位置
            // 开始判断
            if (left == i) {
                return -1;
            }
            return left - 1;
        }

        private void reverse(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                ++i;
                --j;
            }
        }















        private void reverse(int[] nums, int start, int end) {
            int mid = start + (end - start) / 2;
            for (int i = start; i <= mid; ++i) {
                int tmp = nums[i];
                nums[i] = nums[start + end - i];
                nums[start + end - i] = tmp;
            }
        }


        public void nextPermutation_20220426(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int j = nums.length - 1;
            while (j > 0 && nums[j - 1] >= nums[j]) {
                j--;
            }
            if (j == 0) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            int k = nums.length - 1;
            while (k >= j && nums[k] <= nums[j - 1]) {
                --k;
            }
            int tmp = nums[j - 1];
            nums[j - 1] = nums[k];
            nums[k] = tmp;

            reverse(nums, j, nums.length - 1);

        }


        public void nextPermutation22222222222(int[] nums) {
            nextPermutation_20220426(nums);
//            if (nums.length <= 1) {
//                System.out.print(Arrays.toString(nums));
//                return;
//            }
//            int len = nums.length;
//            int peak = len - 1;
//            for ( ; peak >= 0; peak--) {
//                if (peak == 0 || nums[peak] > nums[peak - 1]) {
//                    break;
//                }
//            }
//
//            if (peak == 0) {
//                Arrays.sort(nums);
//                System.out.print(Arrays.toString(nums));
//                return;
//            }
//
//            for (int j = len - 1; j >= peak; j--) {
//                if (nums[j] > nums[peak - 1]) {
//                    swap(nums, peak - 1, j);
//                    break;
//                }
//            }
//            Arrays.sort(nums, peak, len);
//            System.out.print(Arrays.toString(nums));


        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
