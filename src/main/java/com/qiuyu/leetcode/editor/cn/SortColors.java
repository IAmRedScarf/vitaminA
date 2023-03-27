//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
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
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1079 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void sortColors(int[] nums) {
            sortColors20230216(nums);
        }


        public void sortColors20230216(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int putIndex = 0;
            for (int i = putIndex; i < nums.length; ++i) {
                if (nums[i] == 0) {
                    swap(nums, putIndex, i);
                    putIndex++;
                }
            }
            for (int i = putIndex; i < nums.length; ++i) {
                if (nums[i] == 1) {
                    swap(nums, putIndex, i);
                    putIndex++;
                }
            }
        }

        public void sortColors20230217(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int putIndex0 = 0, putIndex1 = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 0) {
                    swap(nums, putIndex0++, i);
                    if (nums[i] == 1) {
                        swap(nums, putIndex1++, i);
                    }
                } else if (nums[i] == 1) {
                    swap(nums, putIndex1++, i);
                }
            }
        }












        public void sortColors_20220502_b(int[] nums) {
            int left0 = 0, left1 = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    swap(nums, left0, right);
                    if (nums[right] == 1) {
                        swap(nums, left1, right);
                    }
                    left0++;
                    left1++;
                } else if (nums[right] == 1) {
                    swap(nums, left1, right);
                    left1++;
                }
                right++;
            }


        }

        public void sortColors_20220502_a(int[] nums) {
            int left = 0;
            int right = left;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
            right = left;
            while (right < nums.length) {
                if (nums[right] == 1) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }

        }






        public void sortColors_old(int[] nums) {
//            int start = 0;
//            for (int i = start; i < nums.length; ++i) {
//                if (nums[i] == 0) {
//                    swap(nums, start, i);
//                    start++;
//                }
//
//            }
//            for (int i = start; i < nums.length; ++i) {
//                if (nums[i] == 1) {
//                    swap(nums, start, i);
//                    start++;
//                }
//            }

            int s0 = 0, s1 = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 0) {
                    swap(nums, s0, i);
                    if (nums[i] == 1) {
                        swap(nums, s1, i);
                    }
                    s0++;
                    s1++;
                } else if (nums[i] == 1) {
                    swap(nums, s1, i);
                    s1++;
                }
            }




















        }

//        private void f1(int[] nums) {
//            int first = 0;
//            for (int i = 0; i < nums.length; ++i) {
//                if (nums[i] == 0) {
//                    swap(nums, i, first);
//                    first++;
//                }
//            }
//            for (int j = first; j < nums.length; ++j) {
//                if (nums[j] == 1) {
//                    swap(nums, j, first);
//                    first++;
//                }
//            }
//        }

//        private void f2(int[] nums) {
//            int p0 = 0, p1 = 0;
//            for (int i = 0; i < nums.length; ++i) {
//                if (nums[i] == 1) {
//                    swap(nums, i, p1);
//                    p1++;
//                } else if (nums[i] == 0) {
//                    swap(nums, i, p0);
//                    if (p0 < p1) {
//                        swap(nums, i, p1);
//                    }
//                    p0++;
//                    p1++;
//                }
//            }
//        }
//
//
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
