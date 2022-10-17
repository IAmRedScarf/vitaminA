//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的
//根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7] 
//
// 提示： 
//

//               5
//             / \
//            4   8

// 5 4 8
// 4 5 8
// 4 8 5
// 
// 节点总数 <= 10000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 125 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathsWithSumLcci {
    public static void main(String[] args) {
        Solution solution = new PathsWithSumLcci().new Solution();
        TreeNode root = new TreeNode(0);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        root.left = a;
        root.right = b;
        System.out.println(solution.pathSum(root, 0));
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
        Map<Integer, Integer> preSumCountMap;
        int res = 0;

        public int pathSum(TreeNode root, int sum) {
            preSumCountMap = new HashMap<>();
            preSumCountMap.put(0, 1);
            traversal(root, 0, sum);
            return res;

        }

        public void traversal(TreeNode root, int preSum, int sum) {
            if (root == null) {
                return;
            }
            // p(1) - p(0) = sum
            int curSum = preSum + root.val;
            res += preSumCountMap.getOrDefault(curSum - sum, 0);

            int originCnt = preSumCountMap.getOrDefault(curSum, 0);
            preSumCountMap.put(curSum, originCnt + 1);
            traversal(root.left, curSum, sum);
            traversal(root.right, curSum, sum);
            preSumCountMap.put(curSum, originCnt);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
