//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
// Related Topics 几何 数组 哈希表 数学 👍 402 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
        int a = 2, b = -4;
        System.out.println(a % b);
        System.out.println(solution.gcd(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            int num = points.length;
            if (num <= 2) {
                return num;
            }
            Map<String, Integer> ratioPointNumMap = new HashMap<>();

            int res = 0;

            for (int i = 0; i < num; ++i) {
                if (res >= num - i || res > num / 2) {
                    break;
                }
                int[] X = points[i];
                for (int j = i + 1; j < num; ++j) {
                    int[] Y = points[j];
                    // 计算斜率，保存约分后的分子分母
                    int numerator = X[1] - Y[1], denominator = X[0] - Y[0];

                    // 此时k与numerator同号（正负）
                    int k = gcd(numerator, denominator);
                    String key = (numerator / k) + "_" + (denominator / k);
                    ratioPointNumMap.put(key, ratioPointNumMap.getOrDefault(key, 0) + 1);
                    res = Math.max(res, ratioPointNumMap.get(key) + 1);
                }
                ratioPointNumMap.clear();
            }
            return res;

        }

        public int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
