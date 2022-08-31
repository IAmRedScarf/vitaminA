//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1395 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        public TreeNode buildTree_20220503(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
            if (preLeft > preRight) {
                return null;
            }
            int rootVal = preorder[preLeft];
            int i = inLeft;
            for (; i <= inRight; ++i) {
                if (inorder[i] == rootVal) {
                    break;
                }
            }
            int len1 = i - inLeft, len2 = inRight - i;
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree_20220503(preorder, preLeft + 1, preLeft + len1, inorder, inLeft, i - 1);
            root.right = buildTree_20220503(preorder, preLeft + len1 + 1, preRight, inorder, i + 1, inRight);
            return root;


        }



        public TreeNode buildTree_20220503(int[] preorder, int[] inorder) {
            return buildTree_20220503(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        }


        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree_20220503(preorder, inorder);
        }








        private TreeNode buildTree_old(int[] preorder, int left1, int[] inorder, int left2, int len) {
            if (len == 0) {
                return null;
            }
            int rootVal = preorder[left1];
            int rootIndex = left2;
            for (; rootIndex - left2 + 1 <= len; ++rootIndex) {
                if (inorder[rootIndex] == rootVal) {
                    break;
                }
            }
            int len1 = rootIndex - left2;
            int len2 = len - len1 - 1;
            TreeNode root = new TreeNode(rootVal);
            root.left = buildTree_old(preorder, left1 + 1, inorder, left2, len1);
            root.right = buildTree_old(preorder, left1 + len1 + 1, inorder, rootIndex + 1, len2);
            return root;
        }

        public TreeNode buildTree_old(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || preorder.length != inorder.length) {
                return null;
            }
            return buildTree_old(preorder, 0, inorder, 0, inorder.length);




















//            Map<Integer, Integer> valueIndexMap = new HashMap<>();
//            for (int i = 0; i < inorder.length; ++i) {
//                valueIndexMap.put(inorder[i], i);
//            }
//            return buildTree(preorder, 0, inorder, 0, preorder.length, valueIndexMap);

        }

//        private TreeNode buildTree(int[] preorder, int preOrderBegin, int[] inorder, int inOrderBegin, int treeLen, Map<Integer, Integer> valueIndexMap) {
//            if (treeLen == 0) {
//                return null;
//            }
//            int rootVal = preorder[preOrderBegin];
//            TreeNode root = new TreeNode(rootVal);
//            int i = valueIndexMap.get(root.val);
//            int leftTreeLen = i - inOrderBegin;
//            root.left = buildTree(preorder, preOrderBegin + 1, inorder, inOrderBegin, leftTreeLen, valueIndexMap);
//
//            int rightTreeLen = treeLen - leftTreeLen - 1;
//            root.right = buildTree(preorder, preOrderBegin + leftTreeLen + 1, inorder, i + 1, rightTreeLen, valueIndexMap);
//            return root;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
