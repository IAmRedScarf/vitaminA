//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 555 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
        boolean res = false;
        public boolean isSubStructure(TreeNode rootA, TreeNode rootB) {

            if (rootA == null || rootB == null) {
                return false;
            }

            return helper(rootA, rootB) || isSubStructure(rootA.left, rootB) || isSubStructure(rootA.right, rootB);
        }

        private boolean helper(TreeNode r1, TreeNode r2) {
            if (r2 == null) {
                return true;
            }
            if (r1 == null) {
                return false;
            }
            return r1.val == r2.val && helper(r1.left, r2.left) && helper(r1.right, r2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
