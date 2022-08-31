//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 305 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;

public class XuLieHuaErChaShuLcof {
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] tmpData = data.split(",");
            return deserialize_helper(tmpData);
        }
        int start = 0;
        private TreeNode deserialize_helper(String[] data) {
            if (start >= data.length) {
                return null;
            }
            if ("#".equals(data[start])) {
                return null;
            }
            TreeNode cur = new TreeNode(Integer.parseInt(data[start]));
            start++;
            cur.left = deserialize_helper(data);
            start++;
            cur.right = deserialize_helper(data);
            return cur;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
