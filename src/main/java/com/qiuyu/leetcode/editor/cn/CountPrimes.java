//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 843 👎 0


package com.qiuyu.leetcode.editor.cn;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        solution.countPrimes(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countPrimes(int n) {
            return countPrimes_20220813(n);
        }


        public int countPrimes_20220813(int n) {
            if (n < 2) {
                return 0;
            }
            // 将所有大于2的数标记为质数，也就是false
            boolean[] flag = new boolean[n + 1];

            int res = 0;
            for (int i = 2; i < n; ++i) {
                if (!flag[i]) {
                    res++;
                    if ((long) i * i < n) {

                        for (int j = i * i; j < n; j += i) {
                            flag[j] = true;
                        }
                    }
                }
            }
            return res;
        }


        public int countPrimes_20220505(int n) {
            if (n < 2) {
                return 0;
            }
            int[] primeFlag = new int[n];
            for (int i = 2; i < n; ++i) {
                primeFlag[i] = 1;
            }

            int res = 0;
            for (int i = 2; i < n; ++i) {
                if (primeFlag[i] == 1) {
                    res++;
                    if ((long) i * i < n) {
                        for (int j = i * i; (long) j < n; j += i) {
                            primeFlag[j] = 0;
                        }
                    }
                }
            }
            return res;


//            int res = 0;
//            for (int i = 2; i < n; ++i) {
//                if (isPrime(i)) {
//                    res++;
//                }
//            }
//            return res;
        }

        private boolean isPrime(int x) {
            if (x < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(x); ++i) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
