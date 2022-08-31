//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 481 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[] {999999998,999999997,999999999}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            int[] tmp = new int[nums.length];
            System.arraycopy(nums, 0, tmp, 0, nums.length);
            quickSort(tmp, 0, tmp.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int num : tmp) {
                sb.append(num);
            }
            return sb.toString();

        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivot = nums[left];
            int i = left, j = right + 1;
            while (true) {
                while (compare(nums[++i], pivot) < 0) {
                    if (i >= right) {
                        break;
                    }
                }
                while (compare(nums[--j], pivot) > 0 ) {

                }
                if (i < j) {
                    swap(nums, i, j);
                } else {
                    break;
                }
            }
            swap(nums, left, j);
            quickSort(nums, left, j - 1);
            quickSort(nums, j + 1, right);
        }


        private int compare(int x, int y) {
            String xy = String.valueOf(x) + y;
            String yx = String.valueOf(y) + x;
            return xy.compareTo(yx);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
