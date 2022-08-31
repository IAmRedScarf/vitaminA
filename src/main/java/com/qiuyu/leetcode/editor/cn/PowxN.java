//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 885 👎 0


package com.qiuyu.leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n) {
            return myPow_20220818(x, n);
        }


        public double myPow_20220818(double x, int n) {
            if (x == 0) {
                return 0.0d;
            }
            if (n == 0) {
                return 1.0d;
            }
            long a = n;
            if (n < 0) {
                a = -a;
            }
            double res = 1;
            double tmp = x;
            while (a > 0) {
                if ((a & 1) == 1) {
                    res = res * tmp;
                }
                tmp *= tmp;
                a /= 2;
            }
            return n > 0 ? res : 1 / res;



        }



        public double myPow_before(double x, int n) {
            if (x == 0) {
                return 0.0d;
            }
            if (n == 0) {
                return 1.0d;
            }
            long a = n;
            if (n < 0) {
                a = -a;
            }
            double res = 1;
            double tmp = x;
            while (a > 0) {
                if ((a & 1) == 1) {
                    res = res * tmp;
                }
                tmp = tmp * tmp;
                a /= 2;
            }
            return n > 0 ? res : 1 / res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
