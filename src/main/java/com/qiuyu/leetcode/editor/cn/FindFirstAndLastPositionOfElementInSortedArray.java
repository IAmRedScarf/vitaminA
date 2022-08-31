//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1154 👎 0


package com.qiuyu.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange_20220428(int[] nums, int target) {
            return new int[] {leftBound_20220428(nums, target), rightBound_20220428(nums, target)};


        }

        private int leftBound_20220428(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left == nums.length) {
                return -1;
            }
            return nums[left] == target ? left : -1;
        }

        private int rightBound_20220428(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (right == -1) {
                return - 1;
            }
            return nums[right] == target ? right : -1;
        }





















        public int[] searchRange(int[] nums, int target) {
            return searchRange_20220428(nums, target);
//            int leftBound = searchLeftBound(nums, target);
//            int rightBound = searchRightBound(nums, target);
//            return new int[]{leftBound, rightBound};

        }

        private int searchLeftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left == nums.length) {
                return -1;
            }
            return nums[left] == target ? left : -1;
        }

        private int searchRightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                } else {
                    left = mid + 1;
                }
            }
            if (right == -1) {
                return -1;
            }
            return nums[right] == target ? right : -1;
        }


//        private int leftBoundary(int[] nums, int target) {
//            if (nums.length == 0) {
//                return -1;
//            }
//            int left = 0, right = nums.length - 1;
//            while (left < right) {
//                int mid = (left + right) / 2;
//                if (nums[mid] < target) {
//                    left = mid + 1;
//                } else if (nums[mid] == target) {
//                    right = mid;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            return nums[left] == target ? left : -1;
//        }
//
//        private int rightBoundary(int[] nums, int target) {
//            if (nums.length == 0) {
//                return -1;
//            }
//            int left = 0, right = nums.length - 1;
//            while (left < right) {
//                int mid = (left + right + 1) / 2;
//                if (nums[mid] < target) {
//                    left = mid + 1;
//                } else if (nums[mid] == target) {
//                    left = mid;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            return nums[right] == target ? right : -1;
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
