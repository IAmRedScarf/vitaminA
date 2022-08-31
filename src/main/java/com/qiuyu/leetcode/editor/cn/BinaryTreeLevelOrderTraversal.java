//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1162 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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

        public List<List<Integer>> levelOrder_20220503(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> tmpQueue = new LinkedList<>();
            tmpQueue.addLast(root);
            while (!tmpQueue.isEmpty()) {
                int curSize = tmpQueue.size();
                List<Integer> tmpList = new ArrayList<>();
                for (int i = 0; i < curSize; ++i) {
                    TreeNode node = tmpQueue.pollFirst();
                    tmpList.add(node.val);
                    if (node.left != null) {
                        tmpQueue.addLast(node.left);
                    }
                    if (node.right != null) {
                        tmpQueue.addLast(node.right);
                    }
                }
                res.add(tmpList);
            }
            return res;
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            return levelOrder_20220503(root);
        }


        public List<List<Integer>> levelOrder_old(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> tmpQueue = new LinkedList<>();
            tmpQueue.addLast(root);
            while (!tmpQueue.isEmpty()) {
                int curSize = tmpQueue.size();
                List<Integer> thisFloor = new ArrayList<>();
                for (int i = 0; i < curSize; ++i) {
                    TreeNode node = tmpQueue.pollFirst();
                    thisFloor.add(node.val);
                    if (node.left != null) {
                        tmpQueue.addLast(node.left);
                    }
                    if (node.right != null) {
                        tmpQueue.addLast(node.right);;
                    }
                }
                res.add(thisFloor);
            }
            return res;























//            Deque<TreeNode> tmpQueue = new LinkedList<>();
//            tmpQueue.add(root);
//            while (!tmpQueue.isEmpty()) {
//                int size = tmpQueue.size();
//                List<Integer> tmpList = new ArrayList<>();
//                for (int i = 0; i < size; ++i) {
//                    TreeNode cur = tmpQueue.poll();
//                    if (cur != null) {
//                        tmpList.add(cur.val);
//                        if (cur.left != null) {
//                            tmpQueue.add(cur.left);
//                        }
//                        if (cur.right != null) {
//                            tmpQueue.add(cur.right);
//                        }
//                    }
//                }
//                res.add(tmpList);
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
