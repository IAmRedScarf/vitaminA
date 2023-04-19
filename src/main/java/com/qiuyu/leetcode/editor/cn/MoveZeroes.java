//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1530 👎 0


package com.qiuyu.leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            moveZeroes20230409(nums);
        }
        public void moveZeroes20230409(int[] nums) {
            int i = 0, j = 0;
            while (j < nums.length) {
                if (nums[j] != 0) {
                    swap(nums, i, j);
                    i++;
                }
                j++;
            }
        }



        public void moveZeroes20230408(int[] nums) {
            int zeroIndex = 0;
            while (zeroIndex < nums.length && nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            int notZeroIndex = zeroIndex + 1;
            while (notZeroIndex < nums.length && nums[notZeroIndex] == 0) {
                notZeroIndex++;
            }
            while (zeroIndex < nums.length && notZeroIndex < nums.length) {
                swap(nums, zeroIndex, notZeroIndex);
                zeroIndex++;
                while (zeroIndex < nums.length && nums[zeroIndex] != 0) {
                    zeroIndex++;
                }
                notZeroIndex++;
                while (notZeroIndex < nums.length && nums[notZeroIndex] == 0) {
                    notZeroIndex++;
                }
            }

        }








        public void moveZeroes_20220515_a(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    if (i > j) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }


        public void moveZeroes_20220515(int[] nums) {

            int availableIndex = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[availableIndex++] = nums[i];
                }
            }
            for (int i = availableIndex; i < nums.length; ++i) {
                nums[availableIndex++] = 0;
            }



        }



        public void moveZeroes_old(int[] nums) {
//            int zeroIndex = 0;
//            int notZeroIndex;
//            while (zeroIndex < nums.length) {
//                if (nums[zeroIndex] != 0) {
//                    zeroIndex++;
//                } else {
//                    notZeroIndex = zeroIndex + 1;
//                    while (notZeroIndex < nums.length) {
//                        if (nums[notZeroIndex] == 0) {
//                            notZeroIndex++;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (notZeroIndex >= nums.length) {
//                        break;
//                    }
//                    swap(nums, zeroIndex, notZeroIndex);
//                }
//            }
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) {
                return;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
