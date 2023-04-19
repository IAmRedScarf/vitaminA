//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 743 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.TreeNode;
import com.sun.tools.javac.jvm.Code;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        Codec codec = new SerializeAndDeserializeBinaryTree().new Codec();

        String res = codec.serialize(node1);
        System.out.println(res);
        TreeNode newRoot = codec.deserialize(res);
        System.out.println(codec.serialize(newRoot));

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
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialize20230404(root);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialize20230404(data);
        }




        public String serialize20230404(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize20230404(root, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void serialize20230404(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(',');
                return;
            }
            sb.append(root.val).append(',');
            serialize20230404(root.left, sb);
            serialize20230404(root.right, sb);
        }


        int index = 0;
        String[] valArr;
        public TreeNode deserialize20230404(String data) {
             valArr = data.split(",");
             return deserialize20230404();
        }

        private TreeNode deserialize20230404() {
            if (valArr[index].equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(valArr[index]));
            index++;
            root.left = deserialize20230404();
            index++;
            root.right = deserialize20230404();
            return root;
        }










        public String serialize22222222222(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs_20220512(root, sb);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();

        }

        private void dfs_20220512(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
            } else {
                sb.append(root.val).append(",");
                dfs_20220512(root.left, sb);
                dfs_20220512(root.right, sb);

            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize2222222222(String data) {
            String[] tmpData = data.split(",");
            return deserialize(tmpData);

        }

        int start = 0;
        public TreeNode deserialize(String[] data) {
            if (data[start].equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(data[start]));
            start++;
            root.left = deserialize(data);
            start++;
            root.right = deserialize(data);
            return root;
        }
    }






    class Codec_old {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> res = new ArrayList<>();
            f1(root, res);
            return res.toString();
        }

        private void f1(TreeNode root, List<String> res) {
            if (root == null) {
                res.add("null");
                return;
            }
            res.add(String.valueOf(root.val));
            f1(root.left, res);
            f1(root.right, res);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() < 2) {
                throw new IllegalArgumentException();
            }
            if (data.equals("[]")) {
                return null;
            }
            String[] nodes = data.substring(1, data.length() - 1).split(", ");
            return f002(nodes);
        }

        private TreeNode f002(String[] nodes) {
            if (nodes[start].equals("null")) {
                start++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes[start]));
            start++;
            root.left = f002(nodes);
            root.right = f002(nodes);
            return root;
        }

        int start = 0;
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
