//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出：[4, 1] 或者（[0b100, 0b1]）
// 
//
// 示例2: 
//
// 
// 输入：num = 1
// 输出：[2, -1]
// 
//
// 提示: 
//
// 
// num的范围在[1, 2147483647]之间； 
// 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。 
// 
// Related Topics 位运算 👍 55 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ClosedNumberLcci {
    public static void main(String[] args) {
        Solution solution = new ClosedNumberLcci().new Solution();
        System.out.println(solution.findClosedNumbers(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findClosedNumbers(int num) {
            int countOf1 = 0;
            int big = -1, small = -1;
            int numTmp = num;
            for (int i = 0; i < 30; ++i) {
                // 遇到01，变为10
                if ((num & (1 << i)) != 0 && (num & (1 << (i + 1))) == 0) {
                    numTmp += (1 << (i + 1));
                    numTmp -= (1 << i);
                    // 并将右侧的1都放到最右边
                    for (int j = 0; j < countOf1; ++j) {
                        numTmp += (1 << j);
                    }
                    big = numTmp;
                    break;
                }
                if ((num & (1 << i)) != 0) {
                    countOf1++;
                }
                // 将低位全部置为0，高位不变
                numTmp &= (~(1 << i));
            }

            numTmp = num;
            countOf1 = 0;
            for (int i = 0; i < 30; i++) {
                // 遇到10，把他变为01，并且把右侧的1放到最左边
                if ((num & (1 << i)) == 0 && (num & (1 << (i + 1))) != 0) {
                    numTmp -= (1 << (i + 1));
                    numTmp += (1 << i);
                    for (int j = 0; j < countOf1; ++j) {
                        numTmp += (1 << (i - j - 1));
                    }
                    small = numTmp;
                    break;
                }
                if ((num & (1 << i)) != 0) {
                    countOf1++;
                }
                numTmp &= (~(1 << i));
            }
            return new int[]{big, small};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
