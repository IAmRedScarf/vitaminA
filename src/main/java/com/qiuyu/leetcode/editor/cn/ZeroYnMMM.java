//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
//histogram/ 
// Related Topics 栈 数组 单调栈 👍 52 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new ZeroYnMMM().new Solution();
        solution.largestRectangleArea(new int[] {2,1,5,6,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int res = Integer.MIN_VALUE;

            int n = heights.length;
            int[] rightFirstSmaller = new int[n];
            // 从栈顶到底部，依次递减
            Deque<int[]> decreaseStack = new LinkedList<>();
            for (int i = n - 1; i >= 0; --i) {
                while (!decreaseStack.isEmpty() && decreaseStack.peekLast()[1] >= heights[i]) {
                    decreaseStack.pollLast();
                }
                rightFirstSmaller[i] = decreaseStack.isEmpty() ? n : decreaseStack.peekLast()[0];
                decreaseStack.addLast(new int[] {i, heights[i]});
            }

            decreaseStack.clear();
            int[] leftFirstSmaller = new int[n];
            for (int i = 0; i < n; ++i) {
                while (!decreaseStack.isEmpty() && decreaseStack.peekLast()[1] >= heights[i]) {
                    decreaseStack.pollLast();
                }
                leftFirstSmaller[i] = decreaseStack.isEmpty() ? -1 : decreaseStack.peekLast()[0];
                decreaseStack.addLast(new int[] {i, heights[i]});

                res = Math.max(res, (rightFirstSmaller[i] - leftFirstSmaller[i] - 1) * heights[i]);
            }
            return res;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
