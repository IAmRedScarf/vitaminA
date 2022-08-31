//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。 
//
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
// 
// 
// Related Topics 位运算 动态规划 👍 878 👎 0


package com.qiuyu.leetcode.editor.cn;

public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int[] countBits_20220515_b(int n) {
            int[] res = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                if ((i & 1) == 1) {
                    res[i] = res[i - 1] + 1;
                } else {
                    res[i] = res[i >> 1];
                }
            }
            return res;
        }



        public int[] countBits_20220515_a(int n) {
            int[] res = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                res[i] = res[i & (i - 1)] + 1;
            }
            return res;

        }

        public int[] countBits_20220515(int n) {
            int[] res = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                res[i] = countOnes(i);
            }
            return res;

        }


        public int countOnes(int n) {
            int res = 0;
            int x = n;
            while (x != 0) {
                x &= (x - 1);
                res++;
            }
            return res;
        }


        public int[] countBits(int n) {
            return countBits_20220515_b(n);
        }





        public int[] countBits_old(int n) {
            int[] bits = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                bits[i] = bits[i & (i - 1)] + 1;
            }
            return bits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
