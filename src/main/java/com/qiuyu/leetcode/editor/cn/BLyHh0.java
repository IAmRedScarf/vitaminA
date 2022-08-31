//
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
// 1 1 0
// 1 1 0
// 0 0 1
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
//
// 
//
// 注意：本题与主站 547 题相同： https://leetcode-cn.com/problems/number-of-provinces/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 33 👎 0



package com.qiuyu.leetcode.editor.cn;

public class BLyHh0 {
    public static void main(String[] args) {
        Solution solution = new BLyHh0().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] isVisited = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; ++i) {
                if (!isVisited[i]) {
                    res++;
                    dfs(isConnected, isVisited, i);
                }
            }
            return res;
        }

        private void dfs(int[][] isConnected, boolean[] isVisited, int cur) {
            isVisited[cur] = true;
            for (int j = 0; j < isConnected[cur].length; ++j) {
                if (isConnected[cur][j] == 1 && !isVisited[j]) {
                    dfs(isConnected, isVisited, j);
                }
            }
        }


        public int findCircleNum_2022702(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isConnected[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < n; ++i) {
                if (unionFind.parentIsSelf(i)) {
                    res++;
                }
            }
            return res;

        }


        class UnionFind {
            private int[] parent;

            public UnionFind(int num) {
                parent = new int[num];
                for (int i = 0; i < num; ++i) {
                    parent[i] = i;
                }
            }

            public boolean parentIsSelf(int x) {
                return x == parent[x];
            }

            public int findParent(int x) {
                if (x != parent[x]) {
                    parent[x] = findParent(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y) {
                int xParent = findParent(x);
                int yParent = findParent(y);
                if (xParent != yParent) {
                    parent[xParent] = yParent;
                }
            }

            public boolean isConnected(int x, int y) {
                int xParent = findParent(x);
                int yParent = findParent(y);
                return xParent == yParent;
            }




        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
