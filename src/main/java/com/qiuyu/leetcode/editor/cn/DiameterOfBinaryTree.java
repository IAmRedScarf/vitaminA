//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 813 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        System.out.println(solution.diameterOfBinaryTree(tn1));
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
        public int diameterOfBinaryTree(TreeNode root) {
            return diameterOfBinaryTree20230409(root);
        }


        int maxNodeNum = 0;
        public int diameterOfBinaryTree20230409(TreeNode root) {
            helper(root);
            return maxNodeNum - 1;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = helper(root.left);
            int rightDepth = helper(root.right);
            maxNodeNum = Math.max(maxNodeNum, leftDepth + rightDepth + 1);
            return Math.max(leftDepth, rightDepth) + 1;
        }








        int res_20220730 = 0;

        public int diameterOfBinaryTree_20220730(TreeNode root) {
            dfs(root);
            return res_20220730;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = dfs(root.left);
            int rightDepth = dfs(root.right);

            res_20220730 = Math.max(res_20220730, leftDepth + rightDepth);
            return 1 + Math.max(leftDepth, rightDepth);
        }


        int res_20220515 = Integer.MIN_VALUE;

        public int diameterOfBinaryTree_20220515(TreeNode root) {
            getDepth(root);
            return res_20220515 - 1;
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            res_20220515 = Math.max(res_20220515, 1 + leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }


        int longestPath = 0;

        public int diameterOfBinaryTree_old(TreeNode root) {
            treeDepth(root);
            return longestPath;
        }

        private int treeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
//            int leftDepth = root.left != null ? treeDepth(root.left) + 1 : 0;
//            int rightDepth = root.right != null ? treeDepth(root.right) + 1 : 0;

            int leftDepth = treeDepth(root.left);
            int rightDepth = treeDepth(root.right);


            int pathLength = leftDepth + rightDepth;
            if (pathLength > longestPath) {
                longestPath = pathLength;
            }
            int depth = Math.max(leftDepth, rightDepth) + 1;
            return depth;

        }
    }

//    class Solution {
//        int maxd=0;
//        public int diameterOfBinaryTree(TreeNode root) {
//            depth(root);
//            return maxd;
//        }
//        public int depth(TreeNode node){
//            if(node==null){
//                return 0;
//            }
//            int Left = depth(node.left);
//            int Right = depth(node.right);
//            maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
//            return Math.max(Left,Right)+1;//返回节点深度
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
