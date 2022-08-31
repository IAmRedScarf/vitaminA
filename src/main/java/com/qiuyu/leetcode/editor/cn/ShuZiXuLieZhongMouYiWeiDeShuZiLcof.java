//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 👍 261 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        System.out.println(solution.findNthDigit(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            if (n == 0) {
                return 0;
            }
            long start = 1;
            int digitOfNum = 1;
            long countOfNum = 9;
            long countOfDigit = 9;
            while (n > countOfDigit) {
                n -= countOfDigit;
                start *= 10;
                digitOfNum++;
                countOfNum = 9 * start;
                countOfDigit = countOfNum * digitOfNum;
            }
            long certainNum = start + (n - 1) / digitOfNum;
            int index = (n - 1) % digitOfNum;
            return String.valueOf(certainNum).charAt(index) - '0';

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
