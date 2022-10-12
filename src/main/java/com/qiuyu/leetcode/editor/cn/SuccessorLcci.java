//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 209 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode next = null;
            if (p.right != null) {
                next = p.right;
                while (next.left != null) {
                    next = next.left;
                }
                return next;
            }
            TreeNode pivot = root;
            while (pivot != null) {
                if (p.val == pivot.val) {
                    pivot = pivot.right;
                } else if (p.val > pivot.val) {
                    pivot = pivot.right;
                } else {
                    next = pivot;
                    pivot = pivot.left;
                }
            }
            return next;
        }




        public TreeNode inorderSuccessor20221010(TreeNode root, TreeNode p) {
            boolean flag = false;
            TreeNode cur = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }
                cur = stack.pollLast();
                if (flag) {
                    return cur;
                }
                if (cur == p) {
                    flag = true;
                }
                cur = cur.right;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
