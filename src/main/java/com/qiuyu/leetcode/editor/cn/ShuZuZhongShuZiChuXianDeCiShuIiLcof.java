//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 352 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        solution.singleNumber(new int[] {1,1,6,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for (int num : nums) {
                for (int j = 31; j >= 0; --j) {
                    counts[j] += (num & 1);
                    num >>>= 1;
                }
            }

            for (int j = 0; j < 32; ++j) {
                counts[j] = (counts[j] % 3);
            }
            int res = 0;
            for (int j = 0; j < 32; ++j) {
                res |= counts[j];
                if (j == 31) {
                    break;
                }
                res <<= 1;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
