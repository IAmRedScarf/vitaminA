//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1463 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest_20220429(new int[] {7,6,5,4,3,2,1}, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest_20220429(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                throw new IllegalArgumentException();
            }
            // 第k大的数，在升序排列中，下标为
            int targetIndex = nums.length - k;
            int start = 0, end = nums.length - 1;
            while (true) {
                int j = partition_20220429(nums, start, end);
                if (j == targetIndex) {
                    return nums[j];
                } else if (j > targetIndex) {
                    end = j - 1;
                } else {
                    start = j + 1;
                }
            }
        }


        private int partition_20220429(int[] nums, int start, int end) {
            int pivot = nums[start];
            int i = start + 1, j = end;
            while (true) {
                while (i <= end && nums[i] < pivot) {
                    ++i;
                }
                while (j > start && nums[j] > pivot) {
                    --j;
                }
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
                ++i;
                --j;

            }
            swap(nums, start, j);
            return j;
        }




        public int findKthLargest_20220430(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                throw new IllegalArgumentException();
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < k; ++i) {
                pq.add(nums[i]);
            }
            for (int i = k; i < nums.length; ++i) {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            return pq.peek();

        }




        public int findKthLargest(int[] nums, int k) {
            return findKthLargest_20220429(nums, k);
//            return findKthLargest_20220430(nums, k);

//            if (nums == null || nums.length < k) {
//                throw new IllegalArgumentException();
//            }
//            int targetIndex = nums.length - k;
//            int left = 0, right = nums.length - 1;
//            while (true) {
//                int j = partition(nums, left, right);
//                if (targetIndex == j) {
//                    return nums[j];
//                } else if (targetIndex < j) {
//                    right = j - 1;
//                } else {
//                    left = j + 1;
//                }
//            }

        }

        private int partition(int[] nums, int left, int right) {
            int pivot = getMediaValue(nums, left, right);
            int i = left + 1, j = right;
            while (true) {
                while (i <= right && nums[i] < pivot) {
                    ++i;
                }
                while (j >= left && nums[j] > pivot) {
                    --j;
                }
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
                ++i;
                --j;
            }
            swap(nums, left, j);
            return j;
        }

        private int getMediaValue(int[] nums, int left, int right) {
            if (left + 2 > right) {
                return nums[left];
            }
            int mid = (left + right) / 2;
            int minValue = Math.min(nums[left], nums[right]);
            int maxValue = Math.max(nums[left], nums[right]);
            if (nums[mid] < minValue) {
                minValue = nums[mid];
            }
            if (nums[mid] > maxValue) {
                maxValue = nums[mid];
            }
            if (nums[mid] > minValue && nums[mid] < maxValue) {
                swap(nums, left, mid);
            } else if (nums[right] > minValue && nums[right] < maxValue) {
                swap(nums, left, right);
            }
            return nums[left];
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
