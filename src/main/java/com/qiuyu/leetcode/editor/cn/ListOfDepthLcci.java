//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 👍 80 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;
import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepthLcci {
    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
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
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return null;
            }
            List<ListNode> res = new ArrayList<>();
            Deque<TreeNode> q = new LinkedList<>();
            q.addLast(tree);
            while (!q.isEmpty()) {
                int size = q.size();
                ListNode dummyHead = new ListNode(0);
                ListNode p = dummyHead;
                for (int i = 0; i < size; ++i) {
                    TreeNode cur = q.pollFirst();
                    p.next = new ListNode(cur.val);
                    if (cur.left != null) {
                        q.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        q.addLast(cur.right);
                    }
                    p = p.next;
                }
                res.add(dummyHead.next);
            }
            ListNode[] ret = new ListNode[res.size()];
            for (int i = 0; i < ret.length; ++i) {
                ret[i] = res.get(i);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
