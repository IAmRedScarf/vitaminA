//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2083 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int climbStairs_20220513(int n) {
            if (n == 1) {
                return 1;
            }
            int f0 = 1, f1 = 1;
            int res = 0;
            for (int i = 2; i <= n; ++i) {
                res = f0 + f1;
                f0 = f1;
                f1 = res;
            }
            return res;

        }






        public int climbStairs(int n) {
            return climbStairs_20220513(n);
        }




        public int climbStairs_old(int n) {
            if (n == 1) {
                return 1;
            }
            int a0 = 1, a1 = 1;
            int res = 2;
            for (int i = 2; i <= n; ++i) {
                res = a0 + a1;
                a0 = a1;
                a1 = res;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
