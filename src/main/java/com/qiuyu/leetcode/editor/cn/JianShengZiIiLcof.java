//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（p），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 167 👎 0


package com.qiuyu.leetcode.editor.cn;

public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int cuttingRope_20220519(int n) {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            int p = 1000000007;
            int a = n / 3, b = n % 3;
            if (b == 0) {
                return (int) remain(3, a, p);
            } else if (b == 1) {
                return (int) (remain(3, a- 1, p) * 4 % p);
            } else {
                return (int) (remain(3, a, p) * 2 % p);
            }
        }

        public int cuttingRope(int n) {
            return cuttingRope_20220519(n);
        }






        public int cuttingRope_old(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int p = 1000000007;
            int a = n / 3, b = n % 3;
            if (b == 0) {
                return (int) quick_remain(3, a, p);
            } else if (b == 1) {
                return (int) (quick_remain(3, a - 1, p) * 4 % p);
            } else {
                return (int) (quick_remain(3, a, p) * 2 % p);
            }

        }

        public long remain(int x, int a, int p) {
            long rem = 1;
            for (int i = 1; i <= a; ++i) {
                rem = (rem * x) % p;
            }
            return rem;
        }

        public long quick_remain(int x, int a, int p) {
            long tmpX = x;
            long rem = 1;
            while (a > 0) {
                if (a % 2 == 1) {
                    rem = (rem * tmpX) % p;
                }
                tmpX = (tmpX * tmpX) % p;
                a = a / 2;
            }
            return rem;
        }


        public long quick_power(int x, int a) {
            long res = 1;
            long tmpX = x;
            while (a > 0) {
                // 1.当幂次为奇数时，提前乘一次tmpX
                // 2. 当幂次为1时，把tmpX赋值给res
                if ((a & 1) == 1) {
                    res *= tmpX;
                }
                tmpX = tmpX * tmpX;
                a /= 2;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
