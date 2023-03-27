//给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。 
//
// 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2
//]。所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点
//）。2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
// 
//
// 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。 
//
// 示例： 
//
// 输入：
//square1 = {-1, -1, 2}
//square2 = {0, -1, 2}
//输出： {-1,0,2,0}
//解释： 直线 y = 0 能将两个正方形同时分为等面积的两部分，返回的两线段端点为[-1,0]和[2,0]
// 
//
// 提示： 
//
// 
// square.length == 3 
// square[2] > 0 
// 
// Related Topics 几何 数学 👍 13 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BisectSquaresLcci {
    public static void main(String[] args) {
        Solution solution = new BisectSquaresLcci().new Solution();
        int[] square1 = new int[]{249, -199, 5};
        int[] square2 = new int[]{-1, 136, 76};
        System.out.println(Arrays.toString(solution.cutSquares(square1, square2)));
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] cutSquares(int[] square1, int[] square2) {
            int len1 = square1[2], len2 = square2[2];
            double[] c1 = new double[]{square1[0] + ((double) len1 / 2), square1[1] + ((double) len1 / 2)};
            double[] c2 = new double[]{square2[0] + ((double) len2 / 2), square2[1] + ((double) len2 / 2)};
            double x1, y1, x2, y2, x3, y3, x4, y4;

            // 直线平行y轴
            if (c1[0] == c2[0]) {
                x1 = x2 = x3 = x4 = c1[0];
                y1 = c1[1] + ((double) len1 / 2);
                y2 = c1[1] - ((double) len1 / 2);
                y3 = c2[1] + ((double) len2 / 2);
                y4 = c2[1] - ((double) len2 / 2);
            } else {
                double k = (c2[1] - c1[1]) / (c2[0] - c1[0]);
                if (Math.abs(k) >= 1.0d) {
                    y1 = square1[1];
                    x1 = (y1 - c1[1]) / k + c1[0];
                    y2 = square1[1] + len1;
                    x2 = (y2 - c1[1]) / k + c1[0];

                    y3 = square2[1];
                    x3 = (y3 - c2[1]) / k + c2[0];
                    y4 = square2[1] + len2;
                    x4 = (y4 - c2[1]) / k + c2[0];
                } else {
                    x1 = square1[0];
                    y1 = k * (x1 - c1[0]) + c1[1];
                    x2 = square1[0] + len1;
                    y2 = k * (x2 - c1[0]) + c1[1];

                    x3 = square2[0];
                    y3 = k * (x3 - c2[0]) + c2[1];
                    x4 = square2[0] + len2;
                    y4 = k * (x4 - c2[0]) + c2[1];
                }
            }
            List<double[]> points = new ArrayList<>();
            points.add(new double[]{x1, y1});
            points.add(new double[]{x2, y2});
            points.add(new double[]{x3, y3});
            points.add(new double[]{x4, y4});

            points.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Double.compare(o1[1], o2[1]);
                } else {
                    return Double.compare(o1[0], o2[0]);
                }
            });
            return new double[]{points.get(0)[0], points.get(0)[1], points.get(3)[0], points.get(3)[1]};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
