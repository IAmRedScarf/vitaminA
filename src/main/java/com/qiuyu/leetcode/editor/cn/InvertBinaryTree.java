//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1145 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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

        public TreeNode invertTree(TreeNode root) {
            return invertTree20230409(root);
        }

        public TreeNode invertTree20230409(TreeNode root) {
            invertTreeHelper(root);
            return root;
        }

        private void invertTreeHelper(TreeNode root) {
            if (root == null) {
                return;
            }
            invertTree20230409(root.left);
            invertTreeHelper(root.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }










        public TreeNode invertTree_20220515(TreeNode root) {
            helper_20220515(root);
            return root;
        }

        private void helper_20220515(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            helper_20220515(root.left);
            helper_20220515(root.right);
        }


        public TreeNode invertTree_old(TreeNode root) {
            f(root);
            return root;
        }

        private void f(TreeNode root) {
            if (root != null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                f(root.left);
                f(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
