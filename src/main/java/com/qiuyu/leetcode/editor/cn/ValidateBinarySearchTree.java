//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1387 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        int a = -2147483648;
        System.out.println(a <= Integer.MIN_VALUE);
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

        public boolean isValidBST(TreeNode root) {
            return isValidBST20230216(root);
        }




        public boolean isValidBST20230216(TreeNode root) {
            Integer preVal = null;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.addLast(p);
                    p = p.left;
                }
                p = stack.pollLast();
                if (preVal != null) {
                    if (p.val <= preVal) {
                        return false;
                    }
                }
                preVal = p.val;
                p = p.right;
            }
            return true;
        }





        long preNodeVal20230217 = Long.MIN_VALUE;
        public boolean isValidBST20230217(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST20230217(root.left)) {
                return false;
            }
            if (root.val <= preNodeVal20230217) {
                return false;
            }
            preNodeVal20230217 = root.val;
            return isValidBST20230217(root.right);
        }



















        Integer preNodeVal = null;
        public boolean isValidBST_20220503(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST_20220503(root.left)) {
                return false;
            }
            if (preNodeVal != null && preNodeVal >= root.val) {
                return false;
            } else {
                preNodeVal = root.val;
            }
            return isValidBST_20220503(root.right);

        }



        public boolean isValidBST_20220503_a(TreeNode root) {
            Deque<TreeNode> tmpStack = new LinkedList<>();
            TreeNode p = root;
            while (!tmpStack.isEmpty() || p != null) {
                while (p != null) {
                    tmpStack.addLast(p);
                    p = p.left;
                }
                p = tmpStack.pollLast();
                if (preNodeVal != null && preNodeVal >= p.val) {
                    return false;
                } else {
                    preNodeVal = p.val;
                }
                p = p.right;
            }
            return true;


        }











        long preVal = Long.MIN_VALUE;

        public boolean isValidBST_old(TreeNode root) {
            if (root == null) {
                return true;
            }
            Integer pivot = null;
            Deque<TreeNode> tmpStack = new LinkedList<>();
            TreeNode p = root;
            while (!tmpStack.isEmpty() || p != null) {
                while (p != null) {
                    tmpStack.addLast(p);
                    p = p.left;
                }
                p = tmpStack.pollLast();
                if (pivot != null && p.val <= pivot) {
                    return false;
                }
                pivot = p.val;
                p = p.right;
            }
            return true;

        }










//        public boolean f1(TreeNode root) {
//            if (root == null) {
//                return false;
//            }
//            long pre = Long.MIN_VALUE;
//            Deque<TreeNode> tmpStack = new LinkedList<>();
//            TreeNode p = root;
//            while (!tmpStack.isEmpty() || p != null) {
//                while (p != null) {
//                    tmpStack.push(p);
//                    p = p.left;
//                }
//                p = tmpStack.pop();
//                if (p.val <= pre) {
//                    return false;
//                } else {
//                    pre = p.val;
//                }
//                p = p.right;
//            }
//            return true;
//        }

//        public boolean f2(TreeNode root) {
//            if (root == null) {
//                return true;
//            }
//            if (!f2(root.left)) {
//                return false;
//            }
//            if (root.val <= preVal) {
//                return false;
//            }
//            preVal = root.val;
//            return f2(root.right);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
