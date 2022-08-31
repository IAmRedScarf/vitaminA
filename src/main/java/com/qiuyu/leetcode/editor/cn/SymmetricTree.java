//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1713 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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

        public boolean isSymmetric_20220513(TreeNode root) {
            if (root == null) {
                return false;
            }
            return helper_20220513(root.left, root.right);

        }

        public boolean helper_20220513(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }

            return root1.val == root2.val && helper_20220513(root1.left, root2.right) && helper_20220513(root1.right, root2.left);

        }


        public boolean isSymmetric(TreeNode root) {
            return isSymmetric_20220513(root);
        }






        public boolean isSymmetric_old(TreeNode root) {
            if (root == null) {
                return false;
            }
            return helper(root.left, root.right);
        }
        private boolean helper(TreeNode p1, TreeNode p2) {
            if (p1 == null && p2 == null) {
                return true;
            }
            if (p1 == null || p2 == null) {
                return false;
            }
            return p1.val == p2.val && helper(p1.left, p2.right) && helper(p1.right, p2.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
