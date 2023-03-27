//已知一个由像素点组成的单色屏幕，每行均有 w 个像素点，所有像素点初始为 0，左上角位置为 (0,0)。 
//
// 现将每行的像素点按照「每 32 个像素点」为一组存放在一个 int 中，再依次存入长度为 length 的一维数组中。 
//
// 我们将在屏幕上绘制一条从点 (x1,y) 到点 (x2,y) 的直线（即像素点修改为 1），请返回绘制过后的数组。 
//
// 
//
// 注意： 
//
// 
// 用例保证屏幕宽度 w 可被 32 整除（即一个 int 不会分布在两行上） 
// 
//
// 
//
// 示例1: 
//
// 
// 输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
// 输出：[3]
// 解释：在第 0 行的第 30 位到第 31 位画一条直线，屏幕二进制形式表示为 [00000000000000000000000000000011]，因此
//返回 [3]
// 
//
// 示例2: 
//
// 
// 输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
// 输出：[-1, -1, -1]
// 解释：由于二进制 11111111111111111111111111111111 的 int 类型代表 -1，因此返回 [-1,-1,-1] 
//
// 
//
// 提示： 
//
// 
// 1 <= length <= 10^5 
// 1 <= w <= 3 * 10^5 
// 0 <= x1 <= x2 < w 
// 0 <= y <= 10 
// 
// Related Topics 位运算 数组 数学 👍 24 👎 0


package com.qiuyu.leetcode.editor.cn;

public class DrawLineLcci {
    public static void main(String[] args) {
        Solution solution = new DrawLineLcci().new Solution();
        System.out.println(0 % 32);
        System.out.println(31 % 32);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] drawLine(int length, int w, int x1, int x2, int y) {
            int[] res = new int[length];
            int startIndex = (w * y + x1) / 32;
            int endIndex = (w * y + x2) / 32;
            for (int i = startIndex; i <= endIndex; ++i) {
                res[i] = -1;
            }
            res[startIndex] = (-1 >>> (x1 % 32));
            res[endIndex] = res[endIndex] & (Integer.MIN_VALUE >> (x2 % 32));
            return res;


        }

        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
