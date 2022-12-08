//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 228 👎 0


package com.qiuyu.leetcode.editor.cn;

public class GetKthMagicNumberLcci {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            int p3 = 1, p5 = 1, p7 = 1;
            int[] seq = new int[k + 1];
            seq[1] = 1;
            for (int i = 2; i <= k; ++i) {
                int next = Math.min(seq[p3] * 3, Math.min(seq[p5] * 5, seq[p7] * 7));
                seq[i] = next;

                if (seq[p3] * 3 == next) {
                    ++p3;
                }
                if (seq[p5] * 5 == next) {
                    ++p5;
                }
                if (seq[p7] * 7 == next) {
                    ++p7;
                }
            }
            return seq[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
