//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1210 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
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

        int res_20220507 = 0;
        public int pathSum_20220507(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            Map<Integer, Integer> preSumCountMap = new HashMap<>();
            preSumCountMap.put(0, 1);
            dfs_20220507(root, 0, targetSum, preSumCountMap);
            return res_20220507;

        }

        private void dfs_20220507(TreeNode root, int preSum, int targetSum, Map<Integer, Integer> preSumCountMap) {
            if (root == null) {
                return;
            }
            preSum += root.val;
            res_20220507 += preSumCountMap.getOrDefault(preSum - targetSum, 0);
            int originCount = preSumCountMap.getOrDefault(preSum, 0);
            preSumCountMap.put(preSum, originCount + 1);
            dfs_20220507(root.left, preSum, targetSum, preSumCountMap);
            dfs_20220507(root.right, preSum, targetSum, preSumCountMap);
            preSumCountMap.put(preSum, originCount);
        }


        public int pathSum(TreeNode root, int targetSum) {
            return pathSum_20220507(root, targetSum);
        }











        int a_path = 0;
        int b_path = 0;
        public int pathSum_old(TreeNode root, int targetSum) {
            Map<Long, Integer> sumCountMap = new HashMap<>();
            sumCountMap.put(0L, 1);
            dfs(root, sumCountMap, 0L, targetSum);
            return b_path;
        }

        /**
         *
         * @param root
         * @param sumCountMap 所有前缀和的Map，key为前缀和，value为出现的次数
         * @param preSum 根节点到当前节点的前缀和（不包含当前节点）
         * @param targetSum
         */
        private void dfs(TreeNode root, Map<Long, Integer> sumCountMap, Long preSum,  Integer targetSum) {
            if (root == null) {
                return;
            }
            Long curSum = preSum + root.val;
            b_path += sumCountMap.getOrDefault(curSum - targetSum, 0);
            sumCountMap.put(curSum, sumCountMap.getOrDefault(curSum, 0) + 1);
            dfs(root.left, sumCountMap, curSum, targetSum);
            dfs(root.right, sumCountMap, curSum, targetSum);
            sumCountMap.put(curSum, sumCountMap.get(curSum) - 1);
        }



        public int a_pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int curPath = rootSum(root, targetSum);
            a_path += curPath;
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return a_path;
        }




        private int rootSum(TreeNode root, int target) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            if (root.val == target) {
                res++;
            }
            int leftRes = rootSum(root.left, target - root.val);
            int rightRes = rootSum(root.right, target - root.val);
            return res + leftRes + rightRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
