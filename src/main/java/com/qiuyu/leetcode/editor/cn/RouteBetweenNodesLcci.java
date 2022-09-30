//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 67 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RouteBetweenNodesLcci {
    public static void main(String[] args) {
        Solution solution = new RouteBetweenNodesLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> neighbours;
        int num;
        int goal;
        boolean flag = false;
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            goal = target;
            initGraph(n, graph);
            dfs(start);
            return flag;
        }


        private void dfs(int cur) {
            for (int ngh : neighbours.get(cur)) {
                if (ngh == goal) {
                    flag = true;
                    break;
                }
                dfs(ngh);
                if (flag) {
                    break;
                }
            }
        }

        private void initGraph(int n, int[][] graph) {
            neighbours = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                neighbours.add(new ArrayList<>());
            }
            for (int[] tmp : graph) {
                neighbours.get(tmp[0]).add(tmp[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
