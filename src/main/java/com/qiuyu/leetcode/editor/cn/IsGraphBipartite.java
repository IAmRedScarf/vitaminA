//存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u]
// 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有
//以下属性：
// 
// 不存在自环（graph[u] 不包含 u）。 
// 不存在平行边（graph[u] 不包含重复值）。 
// 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图） 
// 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。 
// 
//
// 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称
//为 二分图 。 
//
// 如果图是二分图，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//输出：false
//解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。 
//
// 示例 2： 
//
// 
//输入：graph = [[1,3],[0,2],[1,3],[0,2]]
//输出：true
//解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。 
//
// 
//
// 提示： 
//
// 
// graph.length == n 
// 1 <= n <= 100 
// 0 <= graph[u].length < n 
// 0 <= graph[u][i] <= n - 1 
// graph[u] 不会包含 u 
// graph[u] 的所有值 互不相同 
// 如果 graph[u] 包含 v，那么 graph[v] 也会包含 u 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 389 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class IsGraphBipartite {
    public static void main(String[] args) {
        Solution solution = new IsGraphBipartite().new Solution();
        int[] a = new int[]{1, 3};
        int[] b = new int[]{0, 2};
        int[] c = new int[]{1, 3};
        int[] d = new int[]{0, 2};
        int[] e = new int[0];
        System.out.println(solution.isBipartite(new int[][]{a, b, c, d, e}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            // 0-未上色
            int[] paintColor = new int[n];

            Deque<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; ++i) {
                if (paintColor[i] != 0) {
                    continue;
                }
                queue.addLast(i);
                paintColor[i] = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.pollFirst();
                    for (int neighbor : graph[cur]) {
                        if (paintColor[neighbor] == paintColor[cur]) {
                            return false;
                        }
                        if (paintColor[neighbor] == 0) {
                            paintColor[neighbor] = -paintColor[cur];
                            queue.addLast(neighbor);

                        }
                    }
                }
            }

            return true;

        }


        public boolean isBipartite_20220810_02(int[][] graph) {
            int n = graph.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; ++i) {
                int[] neighbors = graph[i];
                for (int neighbor : neighbors) {
                    if (uf.beConnected(neighbor, i)) {
                        return false;
                    }
                    uf.union(neighbors[0], neighbor);
                }
            }
            return true;

        }


        // 0标识未着色，1标识红色，-1标识蓝色
        int[] vertexColor;
        int[][] neighbors;

        public boolean isBipartite_20220810(int[][] graph) {
//            int n = graph.length;
//            vertexColor = new int[n];
//            neighbors = graph;
//            for (int i = 0; i < n; ++i) {
//                if (vertexColor[i] != 0) {
//                    continue;
//                }
//                if (!dfs_20220810(i, 1)) {
//                    return false;
//                }
//            }
//            return true;
            return isBipartite_20220809(graph);

        }

        public boolean dfs_20220810(int cur, int color) {
            if (vertexColor[cur] + color == 0) {
                return false;
            }
            if (vertexColor[cur] == color) {
                return true;
            }
            vertexColor[cur] = color;
            for (int neighbor : neighbors[cur]) {
                if (!dfs_20220810(neighbor, -color)) {
                    return false;
                }
            }
            return true;
        }


        public boolean isBipartite_20220809(int[][] graph) {
            int n = graph.length;
            vertexColor = new int[n];
            neighbors = graph;
            for (int i = 0; i < n; ++i) {
                if (vertexColor[i] != 0) {
                    continue;
                }
                vertexColor[i] = 1;
                if (!dfs_20220809(i)) {
                    return false;
                }
            }
            return true;

        }

        private boolean dfs_20220809(int cur) {

            for (int neighbor : neighbors[cur]) {
                if (vertexColor[neighbor] == 0) {
                    vertexColor[neighbor] = -vertexColor[cur];
                    if (!dfs_20220809(neighbor)) {
                        return false;
                    }
                } else if (vertexColor[neighbor] == vertexColor[cur]) {
                    return false;
                }
            }
            return true;
        }


    }

    class UnionFind {
        private int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; ++i) {
                parents[i] = i;
            }
        }

        public void union(int x, int y) {
            int xParent = findParent(x);
            int yParent = findParent(y);
            if (xParent != yParent) {
                parents[yParent] = xParent;
            }

        }

        public int findParent(int x) {
            if (x != parents[x]) {
                parents[x] = findParent(parents[x]);
            }
            return parents[x];
        }


        public boolean beConnected(int x, int y) {
            int xParent = findParent(x);
            int yParent = findParent(y);
            return xParent == yParent;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
