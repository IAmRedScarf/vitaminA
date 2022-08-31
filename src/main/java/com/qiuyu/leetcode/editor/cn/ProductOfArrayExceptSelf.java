//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 👍 1033 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] productExceptSelf_20220502(int[] nums) {
            int[] tmpProduct = new int[nums.length];
            tmpProduct[0] = 1;
            for (int i = 1; i < nums.length; ++i) {
                tmpProduct[i] = nums[i - 1] * tmpProduct[i - 1];
            }

            int rightProduct = 1;
            for (int i = nums.length - 1; i >= 0; --i) {
                tmpProduct[i] = tmpProduct[i] * rightProduct;
                rightProduct *= nums[i];
            }
            return tmpProduct;
        }


        public int[] productExceptSelf(int[] nums) {
            return productExceptSelf_20220502(nums);
        }








        public int[] productExceptSelf_old(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return null;
            }
            int len = nums.length;
            int[] ans = new int[len];
            ans[0] = 1;
            for (int i = 1; i < len; ++i) {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
            int R = 1;
            for (int j = len - 1; j >= 0; --j) {
                ans[j] = ans[j] * R;
                R *= nums[j];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
