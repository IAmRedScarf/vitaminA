//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 👍 330 👎 0


package com.qiuyu.leetcode.editor.cn;

public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countDigitOne_20220518_a(int n) {
            if (n <= 0) {
                return 0;
            }
            int res = 0;

            int high = n / 10, cur = n % 10, low = 0;
            int digit = 1;
            while (high != 0 || cur != 0) {
                if (cur == 0) {
                    res += high * digit;
                } else if (cur == 1) {
                    res += (high * digit + low + 1);
                } else {
                    res += (high + 1) * digit;
                }

                low += cur * digit;
                cur = high % 10;
                high = high / 10;
                digit *= 10;


            }
            return res;
        }

        public int countDigitOne_20220518(int n) {
            if (n <= 0) {
                return 0;
            }
            int res = 0;

            long tmp = n;
            long high, cur = 0, low = 0;
            long digit = 1;
            while (tmp != 0) {
                low += cur * (digit / 10);
                cur = tmp % 10;
                tmp /= 10;
                high = n / (digit * 10);
                if (cur == 0) {
                    res += high * digit;
                } else if (cur == 1) {
                    res += (high * digit + low + 1);
                } else {
                    res += (high + 1) * digit;
                }
                digit *= 10;
            }
            return res;
        }


        public int countDigitOne(int n) {
            return countDigitOne_20220518_a(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
