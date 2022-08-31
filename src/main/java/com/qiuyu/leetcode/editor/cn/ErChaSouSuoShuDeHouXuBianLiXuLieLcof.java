//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 536 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return verifyPostorder_20220626(postorder);
        }
        public boolean verifyPostorder_20220625(int[] postorder) {
            if (postorder == null) {
                return false;
            }
            return verifyPostorder_0625(postorder, 0, postorder.length - 1);

        }

        private boolean verifyPostorder_0625(int[] postorder, int left, int right) {
            if (left >= right) {
                return true;
            }
            int rootVal = postorder[right];
            int i = left;
            while (postorder[i] < rootVal) {
                ++i;
            }
            int j = i;
            while (j < right) {
                if (postorder[j] < rootVal) {
                    return false;
                }
                ++j;
            }
            return verifyPostorder_0625(postorder, left, i - 1) && verifyPostorder_0625(postorder, i, right - 1);
        }


        public boolean verifyPostorder_20220626(int[] postorder) {
            if (postorder == null) {
                return false;
            }
            int parent = Integer.MAX_VALUE;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = postorder.length - 1; i >= 0; --i) {
                int cur = postorder[i];
                while (!stack.isEmpty() && stack.peekLast() > cur) {
                    parent = stack.pollLast();
                }
                if (cur > parent) {
                    return false;
                }
                stack.addLast(cur);

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
