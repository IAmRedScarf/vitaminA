//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 730 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal20221009(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> tmpStack = new LinkedList<>();
        TreeNode p = root;
        while (!tmpStack.isEmpty() || p != null) {
            while (p != null) {
                res.add(p.val);
                if (p.left != null) {
                    tmpStack.addLast(p.left);
                }
                p = p.right;
            }
            p = tmpStack.pollLast();
        }
        Collections.reverse(res);
        return res;

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        return postorderTraversal20221009(root);
    }


    public List<Integer> postorderTraversal0000001(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> tmpStack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !tmpStack.isEmpty()) {
            if (p == null) {
                p = tmpStack.pop();
            }
            res.add(p.val);
            if (p.left != null) {
                tmpStack.push(p.left);
            }
            p = p.right;
        }
        Collections.reverse(res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
