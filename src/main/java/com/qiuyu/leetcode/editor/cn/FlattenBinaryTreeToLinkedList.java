//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 977 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            flatten20230217(root);
        }


        public void flatten20230217(TreeNode root) {
            TreeNode p = root;
            while (p != null) {
                if (p.left != null) {
                    TreeNode tmp = p.left;
                    while (tmp.right != null) {
                        tmp = tmp.right;
                    }
                    tmp.right = p.right;
                    p.right = p.left;
                    p.left = null;
                }
                p = p.right;
            }

        }







        public void flatten_20220503(TreeNode root) {
            TreeNode p = root;
            while (p != null) {
                if (p.left != null) {
                    TreeNode tmp = p.left;
                    while (tmp.right != null) {
                        tmp = tmp.right;
                    }
                    tmp.right = p.right;
                    p.right = p.left;
                    p.left = null;
                }
                p = p.right;
            }
        }

        public void flatten_old(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode originRight = cur.right;
                    TreeNode rightOfLeft = cur.left;
                    while (rightOfLeft.right != null) {
                        rightOfLeft = rightOfLeft.right;
                    }
                    cur.right = cur.left;
                    rightOfLeft.right = originRight;
                    cur.left = null;
                }
                cur = cur.right;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
