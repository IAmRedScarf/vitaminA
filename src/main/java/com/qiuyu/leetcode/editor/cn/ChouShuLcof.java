//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 356 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        solution.nthUglyNumber(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n == 1) {
                return 1;
            }
            int[] res = new int[n + 1];
            res[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; ++i) {
                int curMin = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
                res[i] = curMin;
                if (res[p2] * 2 == curMin) {
                    p2++;
                }
                if (res[p3] * 3 == curMin) {
                    p3++;
                }
                if (res[p5] * 5 == curMin) {
                    p5++;
                }
            }
            return res[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
