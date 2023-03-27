//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 113 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SubSortLcci {
    public static void main(String[] args) {
        Solution solution = new SubSortLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 默认递增顺序
        public int[] subSort(int[] array) {
            int right = -1;
            int leftMax = Integer.MIN_VALUE;
            // 从左向右，确定右侧边界
            for (int i = 0; i < array.length; ++i) {
                if (array[i] > leftMax) {
                    leftMax = array[i];
                }
                if (array[i] < leftMax) {
                    right = i;
                }
            }

            int left = -1;
            int rightMin = Integer.MAX_VALUE;
            // 从右向左，确定左侧边界
            for (int j = array.length - 1;  j >= 0; --j) {
                if (array[j] < rightMin) {
                    rightMin = array[j];
                }
                if (array[j] > rightMin) {
                    left = j;
                }
            }
            return new int[]{left, right};


        }







        public int[] subSort20221011(int[] array) {
            int left = -1, right = -1;
            // 确定left，从左到右检查所有数字，如果当前值比自己右边最小值大，则更新
            int min = Integer.MAX_VALUE;
            for (int i = array.length - 1; i >= 0; --i) {
                min = Math.min(array[i], min);
                if (array[i] > min) {
                    left = i;
                }
            }
            // 确定right，right左边的最大值，也应该比right位置的数字小
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; ++i) {
                max = Math.max(array[i], max);
                if (array[i] < max) {
                    right = i;
                }
            }
            return new int[] {left, right};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
