//在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8
//, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。 
//
// 示例: 
//
// 输入: [5, 3, 1, 2, 3]
//输出: [5, 1, 3, 2, 3]
// 
//
// 提示： 
//
// 
// nums.length <= 10000 
// 
// Related Topics 贪心 数组 排序 👍 52 👎 0


/**
 * 假设按照峰-谷-峰的顺序排列数组，那么遍历一遍数组：
 * （1）如果i为峰的位置，则判断当前位置是否小于前一个位置（前一个为谷），若小于，则交换，大于则不处理。即： if(nums[i]<nums[i-1]) swap(nums[i],nums[i-1]);
 * （2）如果i为谷的位置，则判断当前位置是否大于前一个位置（前一个为峰），若大于，则交换，大于则不处理。即： if(nums[i]>nums[i-1]) swap(nums[i],nums[i-1]);
 *
 * 作者：whut_hj
 * 链接：https://leetcode.cn/problems/peaks-and-valleys-lcci/solution/onsuan-fa-qiu-jie-by-whut_hj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */





package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class PeaksAndValleysLcci {
    public static void main(String[] args) {
        Solution solution = new PeaksAndValleysLcci().new Solution();
        int[] nums = new int[] {1, 2, 3};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void wiggleSort(int[] nums) {
            wiggleSort20221028(nums);
        }



        public void wiggleSort20221028(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return;
            }
            // 最后排序为 峰-谷-峰
            // 需要判断位置i为奇偶
            for (int i = 1; i < nums.length; ++i) {
                if ((i & 1) == 1) {
                    if (nums[i] > nums[i - 1]) {
                        swap(nums, i, i - 1);
                    }
                } else {
                    if (nums[i] < nums[i - 1]) {
                        swap(nums, i, i - 1);
                    }
                }
            }
        }


        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public void wiggleSort20221027(int[] nums) {
            int n = nums.length;
            int[] tmp = Arrays.copyOf(nums, n);
            Arrays.sort(tmp);
            int mid = (n + 1) / 2;
            int k = 0;
            for (int i = 0, j = mid; i < mid; ++i, ++j) {
                nums[k++] = tmp[i];
                if (k < n) {
                    nums[k] = tmp[j];
                    k++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
