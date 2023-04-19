//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1518 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            return search20230418(nums, target);
        }

        public int search20230418(int[] nums, int target) {
            // 找到最大值所在的索引
            int pivot = nums[0];
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= pivot) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int leftHalfRes = search(nums, 0, right, target);
            return leftHalfRes != -1 ? leftHalfRes : search(nums, right + 1, nums.length - 1, target);

        }

        private int search(int[] nums, int start, int end, int target) {
            if (start >= nums.length || start > end) {
                return -1;
            }
            int left = start, right = end;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }















        public int search20230215(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int len = nums.length;
            // 1.确定旋转点
            int turnPointIndex = findTurnPointIndex(nums);
            if (target <= nums[len - 1]) {
                return binarySearch(nums, turnPointIndex, len - 1, target);
            } else {
                if (turnPointIndex == 0) {
                    return -1;
                } else {
                    return binarySearch(nums, 0, turnPointIndex, target);
                }
            }
        }

        private int binarySearch(int[] nums, int i, int j, int target) {
            int left = i, right = j;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }


        private int findTurnPointIndex(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == nums[right]) {
                    right = mid;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }

















        public int search_20220428(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > nums[right]) {
                    if (nums[left] <= target && nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] == nums[right]) {
                    right = mid - 1;
                } else {
                    if (nums[mid] < target && nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;




        }

















        public int search2222222222(int[] nums, int target) {
            return search_20220428(nums, target);
//            if (nums == null || nums.length == 0) {
//                return -1;
//            }
//            int left = 0, right = nums.length - 1;
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//                if (nums[mid] == target) {
//                    return mid;
//                } else if (nums[mid] > nums[right]) {
//                    if (target >= nums[left] && target < nums[mid]) {
//                        right = mid - 1;
//                    } else {
//                        left = mid + 1;
//                    }
//                } else {
//                    if (target <= nums[right] && target > nums[mid]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                }
//            }
//            return -1;



























//            int left = 0, right = nums.length - 1;
//            while (left <= right) {
//                int mid = (left + right) / 2;
//                if (nums[mid] == target) {
//                    return mid;
//                } else if (nums[mid] >= nums[left]) {
//                    if (target >= nums[left] && target < nums[mid]) {
//                        right = mid - 1;
//                    } else {
//                        left = mid + 1;
//                    }
//                } else {
//                    if (target > nums[mid] && target <= nums[right]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                }
//            }
//            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
