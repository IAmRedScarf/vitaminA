//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-
//value/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 28 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LwUNpT {
    public static void main(String[] args) {
        Solution solution = new LwUNpT().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            return findBottomLeftValue_20220728(root);
        }


        int maxDepth = 0;
        int res = 0;
        public int findBottomLeftValue_20220728(TreeNode root) {
            dfs(root, 1);
            return res;
        }

        private void dfs(TreeNode root, int curDepth) {
            if (curDepth > maxDepth) {
                maxDepth = curDepth;
                res = root.val;
            }
            if (root.left != null) {
                dfs(root.left, curDepth + 1);
            }
            if (root.right != null) {
                dfs(root.right, curDepth + 1);
            }

        }


        public int findBottomLeftValue_20220730(TreeNode root) {
            int res = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                res = queue.peekFirst().val;
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode head = queue.pollFirst();
                    if (head.left != null) {
                        queue.addLast(head.left);
                    }
                    if (head.right != null) {
                        queue.addLast(head.right);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
