//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1122 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
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
        public int rob(TreeNode root) {
            int[] res = dfs_20220803(root);
            return Math.max(res[0], res[1]);
        }


        /**
         * 返回值，第一个元素为偷当前节点，第二个元素为不偷当前节点
         * @param root
         * @return
         */
        public int[] dfs_20220803(TreeNode root) {
            if (root == null) {
                return new int[] {0, 0};
            }
            int[] left = dfs_20220803(root.left);
            int[] right = dfs_20220803(root.right);
            return new int[] {root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
        }










        public int rob_20220517(TreeNode root) {
            int[] cur = helper_20220517(root);
            return Math.max(cur[0], cur[1]);


        }

        private int[] helper_20220517(TreeNode root) {
            if (root == null) {
                return new int[] {0, 0};
            }
            int[] left = helper_20220517(root.left);
            int[] right = helper_20220517(root.right);
            int robCur = root.val + left[1] + right[1];
            int notRobCur = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return new int[] {robCur, notRobCur};
        }














        Map<TreeNode, Integer> robMap = new HashMap<>();
        Map<TreeNode, Integer> noRobMap = new HashMap<>();

        public int rob_20220505(TreeNode root) {
            int robCurValue = robCur(root);
            int noRobCurValue = noRobCur(root);
            return Math.max(robCurValue, noRobCurValue);
        }

        private int robCur(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (robMap.containsKey(root)) {
                return robMap.get(root);
            }
            int robCurValue = root.val + noRobCur(root.left) + noRobCur(root.right);
            robMap.put(root, robCurValue);
            return robCurValue;

        }

        private int noRobCur(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (noRobMap.containsKey(root)) {
                return noRobMap.get(root);
            }
            int leftValue = Math.max(robCur(root.left), noRobCur(root.left));
            int rightValue = Math.max(robCur(root.right), noRobCur(root.right));
            noRobMap.put(root, leftValue + rightValue);
            return leftValue + rightValue;
        }














        Map<TreeNode, Integer> hitCurMap = new HashMap<>();
        Map<TreeNode, Integer> missCurMap = new HashMap<>();

        public int rob_old(TreeNode root) {
//            dfs(root);
//            return Math.max(hitCurMap.getOrDefault(root, 0), missCurMap.getOrDefault(root, 0));
            int[] res = anotherDFS(root);
            return Math.max(res[0], res[1]);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            hitCurMap.put(root, root.val + missCurMap.getOrDefault(root.left, 0) + missCurMap.getOrDefault(root.right, 0));
            missCurMap.put(root, Math.max(hitCurMap.getOrDefault(root.left, 0), missCurMap.getOrDefault(root.left, 0)) +
                    Math.max(hitCurMap.getOrDefault(root.right, 0), missCurMap.getOrDefault(root.right, 0)));
        }


        private int[] anotherDFS(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = anotherDFS(root.left);
            int[] right = anotherDFS(root.right);
            return new int[] {root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
