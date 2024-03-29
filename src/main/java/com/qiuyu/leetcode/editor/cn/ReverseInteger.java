//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3413 👎 0


package com.qiuyu.leetcode.editor.cn;

import javax.print.event.PrintEvent;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int a = -21;
        System.out.println(a % 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            return reverse20230418(x);
        }


        public int reverse20230418(int x) {
            int res = 0;
            while (x != 0) {
                int tmp = x % 10;
                if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                res = res * 10 + tmp;
                x = x / 10;
            }
            return res;
        }




        public int reverse222222222(int x) {
            int rev = 0;
            while (x != 0) {
                int digit = x % 10;

                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit > -(Integer.MIN_VALUE % 10))) {
                    return 0;
                }

                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
