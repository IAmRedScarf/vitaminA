//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 234 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean reverseFlag = false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            if (reverseFlag) {
                for (int i = 0; i < size; ++i) {
                    TreeNode head = queue.pollFirst();
                    tmp.add(0, head.val);
                    if (head.left != null) {
                        queue.addLast(head.left);
                    }
                    if (head.right != null) {
                        queue.addLast(head.right);
                    }
                }
            } else {
                for (int i = 0; i < size; ++i) {
                    TreeNode head = queue.pollFirst();
                    tmp.add(head.val);
                    if (head.left != null) {
                        queue.addLast(head.left);
                    }
                    if (head.right != null) {
                        queue.addLast(head.right);
                    }
                }
            }
            res.add(tmp);
            reverseFlag = !reverseFlag;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
