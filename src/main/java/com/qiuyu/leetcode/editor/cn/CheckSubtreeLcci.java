//检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。 
//
// 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。 
//
// 注意：此题相对书上原题略有改动。 
//
// 示例1: 
//
// 
// 输入：t1 = [1, 2, 3], t2 = [2]
// 输出：true
// 
//
// 示例2: 
//
// 
// 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
// 输出：false
// 
//
// 提示： 
//
// 
// 树的节点数目范围为[0, 20000]。 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 68 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class CheckSubtreeLcci {
    public static void main(String[] args) {
        Solution solution = new CheckSubtreeLcci().new Solution();
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
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t2 == null) {
                return true;
            }
            if (t1 == null) {
                return false;
            }
            return checkWith2Root(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }



        public boolean checkWith2Root(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null) {
                return true;
            }
            if (r1 == null || r2 == null) {
                return false;
            }
            return r1.val == r2.val && checkWith2Root(r1.left, r2.left) && checkWith2Root(r1.right, r2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
