//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1218 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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

        public List<Integer> inorderTraversal_20220513(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (!stack.isEmpty() || p != null) {
                while (p != null) {
                    stack.addLast(p);
                    p = p.left;
                }
                p = stack.pollLast();
                res.add(p.val);
                p = p.right;
            }
            return res;
        }


        public List<Integer> inorderTraversal(TreeNode root) {
            return inorderTraversal_20220513(root);
        }


        public List<Integer> inorderTraversal_old(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            mTraverse(root, res);
            return mTraverse1(root);
        }

        public void mTraverse(TreeNode root, List<Integer> res) {
            if (root != null) {
                mTraverse(root.left, res);
                res.add(root.val);
                mTraverse(root.right, res);
            }
        }

        private List<Integer> mTraverse1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> tmpStack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || !tmpStack.isEmpty()) {
                while (p != null) {
                    tmpStack.push(p);
                    p = p.left;
                }
                p = tmpStack.pop();
                res.add(p.val);
                p = p.right;
            }
            return res;


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
