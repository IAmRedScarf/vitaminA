//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// 
//
// 注意：本题与主站 120 题相同： https://leetcode-cn.com/problems/triangle/ 
// Related Topics 数组 动态规划 👍 17 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IlPe0q {
    public static void main(String[] args) {
        Solution solution = new IlPe0q().new Solution();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);

        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);

        System.out.println(solution.minimumTotal(triangle));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int height = triangle.size();
            List<Integer> ground = triangle.get(height - 1);

            int[] dpA = new int[ground.size()];

            for (int i = 0; i < ground.size(); ++i) {
                dpA[i] = ground.get(i);
            }

            for (int j = height - 2; j >= 0; --j) {
                for (int i = 0; i < triangle.get(j).size(); ++i) {
                    dpA[i] = triangle.get(j).get(i) + Math.min(dpA[i], dpA[i + 1]);
                }
            }
            return dpA[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
