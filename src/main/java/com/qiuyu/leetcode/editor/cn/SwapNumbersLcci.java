//编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。 
//
// 示例： 
//
// 
//输入: numbers = [1,2]
//输出: [2,1]
// 
//
// 提示： 
//
// 
// numbers.length == 2 
// -2147483647 <= numbers[i] <= 2147483647 
// 
// Related Topics 位运算 数学 👍 80 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SwapNumbersLcci {
    public static void main(String[] args) {
        Solution solution = new SwapNumbersLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] swapNumbers(int[] numbers) {
            swap(numbers, 0, 1);
            return numbers;
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
