//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2213 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int singleNumber_20220513(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;


        }

        public int singleNumber(int[] nums) {
            return singleNumber_20220513(nums);

        }






        public int singleNumber_old(int[] nums) {
            if (nums == null || nums.length < 1) {
                throw new IllegalArgumentException();
            }
            int res = 0;
            for (int a : nums) {
                res = res ^ a;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
