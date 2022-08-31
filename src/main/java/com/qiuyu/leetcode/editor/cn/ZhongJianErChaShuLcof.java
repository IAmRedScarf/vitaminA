//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 671 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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

        public TreeNode buildTree_20220518(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length) {
                return null;
            }
            return helper_202202518(preorder, 0, inorder, 0, inorder.length - 1);

        }

        public TreeNode helper_202202518(int[] preorder, int l1, int[] inorder, int l2, int r2) {
            if (l2 > r2) {
                return null;
            }
            int rootVal = preorder[l1];
            int i = l2;
            while (i <= r2) {
                if (inorder[i] == rootVal) {
                    break;
                } else {
                    i++;
                }
            }
            int len = i - l2;
            TreeNode root = new TreeNode(rootVal);
            root.left = helper_202202518(preorder, l1 + 1, inorder, l2, i - 1);
            root.right = helper_202202518(preorder, l1 + 1 + len, inorder, i + 1, r2);
            return root;
        }












        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree_20220518(preorder, inorder);
        }



        public TreeNode buildTree_old(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
            if (begin1 > end1) {
                return null;
            }
            int rootValue = preorder[begin1];
            int i = begin2;
            for (; i <= end2; ++i) {
                if (inorder[i] == rootValue) {
                    break;
                }
            }
            int leftLen = i - begin2;
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTree(preorder, begin1 + 1, begin1 + leftLen, inorder, begin2, i - 1);
            root.right = buildTree(preorder, begin1 + leftLen + 1, end1, inorder, i + 1, end2);
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
