//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 505 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[] {7,5,6,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int reversePairs_20220518(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            int[] tmp = new int[nums.length];
            System.arraycopy(nums, 0, tmp, 0, nums.length);
            return reversePairs_20220518(nums, tmp, 0, nums.length - 1);
        }

        public int reversePairs_20220518(int[] nums, int[] tmp, int left, int right) {
            if (left >= right) {
                return 0;
            }
            int mid = left + (right - left) / 2;
            int leftPairs = reversePairs_20220518(nums, tmp, left, mid);
            int rightPairs = reversePairs_20220518(nums, tmp, mid + 1, right);
            int crossPairs = merge_20220518(nums, tmp, left, mid, right);
            return leftPairs + rightPairs + crossPairs;

        }

        public int merge_20220518(int[] nums, int[] tmp, int left, int mid, int right) {
            int res = 0;
            for (int i = left; i <= right; ++i) {
                tmp[i] = nums[i];
            }
            int k = left;
            int i = left, j = mid + 1;
            while (i <= mid && j <= right) {
                if (tmp[i] <= tmp[j]) {
                    nums[k] = tmp[i];
                    i++;
                } else {
                    res += (mid - i + 1);
                    nums[k] = tmp[j];
                    j++;
                }
                k++;
            }
            while (i <= mid) {
                nums[k++] = tmp[i++];
            }
            while (j <= right) {
                nums[k++] = tmp[j++];
            }
            return res;

        }









        public int reversePairs(int[] nums) {
            return reversePairs_20220518(nums);
        }



        public int reversePairs_old(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return 0;
            }
            int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
            return reversePairs(nums, tmp, 0, nums.length - 1);
        }

        public int reversePairs(int[] nums, int[] tmp, int start, int end) {
            if (start >= end) {
                return 0;
            }
            int mid = start + (end - start) / 2;
            int leftPairs = reversePairs(nums, tmp, start, mid);
            int rightPairs = reversePairs(nums, tmp, mid + 1, end);
            return leftPairs + rightPairs + merge(nums, tmp, start, mid, mid + 1, end);
        }

        public int merge(int[] nums, int[] tmp, int s1, int e1, int s2, int e2) {
            int pairs = 0;
            int k = s1;
            int i = s1, j = s2;
            while (i <= e1 && j <= e2) {
                if (nums[i] <= nums[j]) {
                    tmp[k++] = nums[i++];
                } else {
                    pairs += (e1 - i + 1);
                    tmp[k++] = nums[j++];
                }
            }
            while (i <= e1) {
                tmp[k++] = nums[i++];
            }
            while (j <= e2) {
                tmp[k++] = nums[j++];
            }
            for (int m = s1; m <= e2; ++m) {
                nums[m] = tmp[m];
            }

            return pairs;
        }


//        public int reversePairs(int[] nums) {
//            if (nums == null || nums.length <= 1) {
//                return 0;
//            }
//            int[] tmp = new int[nums.length];
//            for (int i = 0; i < nums.length; ++i) {
//                tmp[i] = nums[i];
//            }
//            return reversePairs(nums, 0, nums.length - 1, tmp);
//        }

//        private int reversePairs(int[] nums, int left, int right, int[] tmp) {
//            if (left >= right) {
//                return 0;
//            }
//            int mid = left + ((right - left) >> 1);
//            int leftReversePairs = reversePairs(nums, left, mid, tmp);
//            int rightReversePairs = reversePairs(nums, mid + 1, right, tmp);
//
//            int crossReversePairs = mergeSort(nums, left, mid, right, tmp);
//            return leftReversePairs + rightReversePairs + crossReversePairs;
//
//        }
//
//        private int mergeSort(int[] nums, int left, int mid, int right, int[] tmp) {
//            int reservePairNum = 0;
//            for (int k = left; k <= right; ++k) {
//                tmp[k] = nums[k];
//            }
//            int i = left, j = mid + 1;
//            int k = left;
//            while (k <= right) {
//                if (i > mid) {
//                    nums[k++] = tmp[j++];
//                } else if (j > right) {
//                    nums[k++] = tmp[i++];
//                } else if (tmp[i] > tmp[j]) {
//                    reservePairNum += (mid - i + 1);
//                    nums[k++] = tmp[j++];
//                } else {
//                    nums[k++] = tmp[i++];
//                }
//            }
//            return reservePairNum;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
