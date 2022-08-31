//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics 位运算 数学 👍 592 👎 0


package com.qiuyu.leetcode.editor.cn;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
//            int min = Math.min(a, b);
//            int max = Math.max(a, b);
//            int res = min * 2;
//            while (min != max) {
//                min++;
//                res++;
//            }
//            return res;
            int aa = a, bb = b;
            while ((aa & bb) != 0) {
                int tmp = aa;
                aa = aa ^ bb;
                bb = (tmp & bb) << 1;
            }
            return aa ^ bb;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
