//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 203 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        int[] arr = new int[] {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(solution.smallestK(arr, 4)));;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int originK = 0;
        public int[] smallestK(int[] arr, int k) {
            if (k <= 0) {
                return new int[0];
            }
            originK = k;
            qSortPartition(arr, 0, arr.length - 1, k);
            int[] res = new int[k];
            System.arraycopy(arr, 0, res, 0, k);
            return res;

        }


        private void qSortPartition(int[] arr, int left, int right, int k) {
            int pivot = arr[left];
            int i = left + 1, j = right;
            while (true) {
                while (i <= right && arr[i] < pivot) {
                    ++i;
                }
                while (arr[j] > pivot) {
                    --j;
                }
                if (i >= j) {
                    break;
                }
                swap(arr, i, j);
                ++i;
                --j;
            }
            swap(arr, left, j);
            if (j > originK - 1) {
                qSortPartition(arr, left, j - 1, k);
            } else if (j < originK - 1) {
                qSortPartition(arr, j + 1, right, k - j - 1);
            }
        }











        private void quickSort(int[] arr, int left, int right) {
            if (left >= right) {
                return;
            }
            int j = partition(arr, left, right);
            quickSort(arr, left, j - 1);
            quickSort(arr, j + 1, right);
        }

        // 1 1 2
        //   i
        //   j


        // 1 0 2
        //     i
        //   j
        private int partition(int[] arr, int left, int right) {
            int pivot = arr[left];
            int i = left + 1, j = right;
            while (true) {
                while (i <= right && arr[i] < pivot) {
                    ++i;
                }
                while (j >= left && arr[j] > pivot) {
                    --j;
                }
                if (i >= j) {
                    break;
                }
                swap(arr, i, j);
            }
            swap(arr, left, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
