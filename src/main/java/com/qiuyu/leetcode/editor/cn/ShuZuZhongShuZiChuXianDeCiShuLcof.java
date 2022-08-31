//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 👍 660 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        solution.singleNumbers(new int[] {1,2,5,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int x = 0, y = 0;
            int tmp = 0;
            for (int num : nums) {
                tmp ^= num;
            }
            int m = 1;
            while ((m & tmp) == 0) {
                m <<= 1;
            }
            for (int num : nums) {
                if ((num & m) == 0) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }
            return new int[]{x, y};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
