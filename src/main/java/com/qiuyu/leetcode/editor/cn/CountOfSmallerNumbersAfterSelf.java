//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例： 
//
// 输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 633 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        System.out.println(solution.countSmaller(new int[]{0,2,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] tmpRes;
        int[] tmpIndex;

        public List<Integer> countSmaller(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            tmpRes = new int[nums.length];
            tmpIndex = new int[nums.length];
            // 索引数组，后续是对索引进行归并，原数组并不变化
            int[] index = new int[nums.length];
            for (int i = 0; i < index.length; ++i) {
                index[i] = i;
            }
            reversePairs(nums, index, 0, nums.length - 1);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < tmpRes.length; ++i) {
                res.add(tmpRes[i]);
            }
            return res;

        }

        private void reversePairs(int[] nums, int[] index, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = start + (end - start) / 2;
            reversePairs(nums, index, start, mid);
            reversePairs(nums, index, mid + 1, end);
            merge(nums, index, start, mid, mid + 1, end);
        }

        // 做降序归并
        private void merge(int[] nums, int[] index, int s1, int e1, int s2, int e2) {
            int i = s1, j = s2;
            int k = s1;

            while (i <= e1 && j <= e2) {
                // 对索引数组进行排序，但依据仍然是对原数组大小进行比较
                if (nums[index[i]] > nums[index[j]]) {
                    tmpRes[index[i]] += (e2 - j + 1);
                    tmpIndex[k++] = index[i++];
                } else {
                    // 注意，此处相等时移动j，副作用是破坏了归并排序稳定性
                    tmpIndex[k++] = index[j++];
                }
            }
            while (i <= e1) {
                tmpIndex[k++] = index[i++];
            }
            while (j <= e2) {
                tmpIndex[k++] = index[j++];
            }
            for (int m = s1; m <= e2; ++m) {
                index[m] = tmpIndex[m];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
