//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 601 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.addLast(root);
        int level = 0;
        while (!tmpQueue.isEmpty()) {
            int curSize = tmpQueue.size();
            List<Integer> thisFloor = new ArrayList<>();
            for (int i = 0; i < curSize; ++i) {
                TreeNode node = tmpQueue.pollFirst();
                if (level % 2 == 1) {
                    thisFloor.add(0, node.val);
                } else {
                    thisFloor.add(node.val);
                }
                if (node.left != null) {
                    tmpQueue.addLast(node.left);
                }
                if (node.right != null) {
                    tmpQueue.addLast(node.right);;
                }
            }
            res.add(thisFloor);
            level++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
