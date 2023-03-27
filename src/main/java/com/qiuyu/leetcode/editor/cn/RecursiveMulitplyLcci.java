//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 位运算 递归 数学 👍 83 👎 0


package com.qiuyu.leetcode.editor.cn;

public class RecursiveMulitplyLcci {
    public static void main(String[] args) {
        Solution solution = new RecursiveMulitplyLcci().new Solution();
        int a = -10;
        System.out.println(Integer.toBinaryString(a));
        int b = a >>> 1;
        System.out.println(b);
        System.out.println(Integer.toBinaryString(b));


        System.out.println(solution.multiply(3, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int multiply(int A, int B) {
            int a = Math.max(A, B);
            int b = Math.min(A, B);

            int res = 0;
            int i = 0;
            while (b != 0) {
                if ((b & 1) == 1) {
                    res += (a << i);
                }
                b >>>= 1;
                i++;
            }
            return res;


        }

        private int multiply(int a, int b, int i) {
            if ((b >>> i) == 0) {
                return 0;
            }
            int cur = 0;
            if (((b >>> i) & 1) == 1) {
                cur = (a << i);
            }
            return cur + multiply(a, b, i + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
