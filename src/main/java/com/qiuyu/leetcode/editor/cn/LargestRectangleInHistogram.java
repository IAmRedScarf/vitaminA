//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
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
// 1 <= len <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1631 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea_20220510(new int[] {2,1,5,6,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestRectangleArea_20220510(int[] nums) {
            int[] leftFirstSmall = new int[nums.length];
            Arrays.fill(leftFirstSmall, -1);

            // 栈中存储下标
            Deque<Integer> tmpStack = new LinkedList<>();
            for (int i = nums.length - 1; i >= 0; --i) {
                while (!tmpStack.isEmpty()) {
                    int top = tmpStack.peekLast();
                    if (nums[i] < nums[top]) {
                        leftFirstSmall[top] = i;
                        tmpStack.pollLast();
                    } else {
                        break;
                    }
                }
                tmpStack.addLast(i);
            }

            tmpStack.clear();
            int[] rightFirstSmall = new int[nums.length];
            Arrays.fill(rightFirstSmall, nums.length);
            for (int i = 0; i < nums.length; ++i) {
                while (!tmpStack.isEmpty()) {
                    int top = tmpStack.peekLast();
                    if (nums[i] < nums[top]) {
                        rightFirstSmall[top] = i;
                        tmpStack.pollLast();
                    } else {
                        break;
                    }
                }
                tmpStack.addLast(i);
            }
            int res = 0;
            for (int i = 0; i < nums.length; ++i) {
                int distance = rightFirstSmall[i] - leftFirstSmall[i] - 1;
                res = Math.max(distance * nums[i], res);
            }
            return res;
//            int[] leftFirstMinIndex = new int[heights.length];
//            Arrays.fill(leftFirstMinIndex, -1);
//            Deque<Integer> tmpStack = new LinkedList<>();
//            for (int i = heights.length - 1; i >= 0; --i) {
//                while (!tmpStack.isEmpty()) {
//                    int top = tmpStack.peekLast();
//                    if (heights[i] < heights[top]) {
//                        leftFirstMinIndex[top] = i;
//                        tmpStack.pollLast();
//                    } else {
//                        break;
//                    }
//                }
//                tmpStack.addLast(i);
//            }
//            int[] rightFirstMinIndex = new int[heights.length];
//            Arrays.fill(rightFirstMinIndex, heights.length);
//            tmpStack.clear();
//            for (int i = 0; i < heights.length; ++i) {
//                while (!tmpStack.isEmpty()) {
//                    int top = tmpStack.peekLast();
//                    if (heights[i] < heights[top]) {
//                        rightFirstMinIndex[top] = i;
//                        tmpStack.pollLast();
//                    } else {
//                        break;
//                    }
//                }
//                tmpStack.addLast(i);
//            }
//            int res = 0;
//            for (int i = 0; i < heights.length; ++i) {
//                int distance = rightFirstMinIndex[i] - leftFirstMinIndex[i] - 1;
//                res = Math.max(distance * heights[i], res);
//            }
//            return res;









        }





        public int largestRectangleArea(int[] heights) {
            return largestRectangleArea_20220510(heights);
        }



        public int largestRectangleArea_old(int[] heights) {
            return f3(heights);
        }

        private int f1(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int len = heights.length;

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < len; ++i) {
                int curHeight = heights[i];
                int pLeft = i, pRight = i;
                while (pLeft >= 0 && heights[pLeft] >= curHeight) {
                    pLeft--;
                }
                while (pRight <= len - 1 && heights[pRight] >= curHeight) {
                    pRight++;
                }
                res = Math.max(res, curHeight * (pRight - pLeft - 1));
            }
            return res;
        }

        private int f2(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int len = heights.length;
            Deque<Integer> tmpStack = new LinkedList<>();
            int[] leftMin = new int[len];
            int res = 0;
            for (int i = 0; i < len; ++i) {
                while (!tmpStack.isEmpty() && heights[tmpStack.peek()] >= heights[i]) {
                    tmpStack.pop();
                }

                leftMin[i] = tmpStack.isEmpty() ? -1 : tmpStack.peek();
                tmpStack.push(i);
            }
            tmpStack.clear();
            int curRightMin = 0;
            for (int i = len - 1; i >= 0; --i) {
                while (!tmpStack.isEmpty() && heights[tmpStack.peek()] >= heights[i]) {
                    tmpStack.pop();
                }
                curRightMin = tmpStack.isEmpty() ? len : tmpStack.peek();
                res = Math.max(heights[i] * (curRightMin - leftMin[i] - 1), res);
                tmpStack.push(i);
            }
            return res;

        }

        private int f3(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int len = heights.length;
            Deque<Integer> tmpStack = new LinkedList<>();
            int[] leftMin = new int[len];
            int res = 0;
            for (int i = 0; i < len; ++i) {
                while (!tmpStack.isEmpty() && heights[tmpStack.peek()] >= heights[i]) {
                    int curPopIndex = tmpStack.pop();
                    res = Math.max(res, heights[curPopIndex] * (i - leftMin[curPopIndex] - 1));
                }
                leftMin[i] = tmpStack.isEmpty() ? -1 : tmpStack.peek();
                tmpStack.push(i);
            }
            while (!tmpStack.isEmpty()) {
                int curPopIndex = tmpStack.pop();
                res = Math.max(res, heights[curPopIndex] * (len - leftMin[curPopIndex] - 1));
            }

            return res;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
