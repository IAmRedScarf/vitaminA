//现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。 
//
// 给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。 例如 
//prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。 
//
// 请根据给出的总课程数 numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。 
//
// 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: numCourses = 2, prerequisites = [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 
//输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
// 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 示例 3: 
//
// 
//输入: numCourses = 1, prerequisites = [] 
//输出: [0]
//解释: 总共 1 门课，直接修第一门课就可。 
//
// 
//
// 提示: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// prerequisites 中不存在重复元素 
// 
//
// 
//
// 注意：本题与主站 210 题相同：https://leetcode-cn.com/problems/course-schedule-ii/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 23 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class QA2IGt {
    public static void main(String[] args) {
        Solution solution = new QA2IGt().new Solution();
        int[][] a = new int[1][];
        a[0] = new int[] {1, 0};

        solution.findOrder(2, a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int vertexNum;
        List<List<Integer>> edges;
        // 每个顶点的搜索状态
        // 0-未搜索，1-搜索中，2-搜索完成
        List<Integer> vertexStatus;

        List<Integer> path;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            buildGraph(numCourses, prerequisites);
            boolean flag = true;
            for (int i = 0; i < vertexNum; ++i) {
                if (!dfs(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                int[] res = new int[vertexNum];
                for (int i = 0; i < vertexNum; ++i) {
                    res[vertexNum - i - 1] = path.get(i);
                }
                return res;
            } else {
                return new int[0];
            }

        }


        private boolean dfs(int start) {
            if (vertexStatus.get(start) == 2) {
                return true;
            }
            if (vertexStatus.get(start) == 1) {
                return false;
            }
            vertexStatus.set(start, 1);
            List<Integer> neighbours = edges.get(start);
            for (Integer neighbour : neighbours) {
                if (!dfs(neighbour)) {
                    return false;
                }
            }
            vertexStatus.set(start, 2);
            path.add(start);
            return true;
        }



        private void buildGraph(int numCourses, int[][] prerequisites) {
            vertexNum = numCourses;
            edges = new ArrayList<>();
            for (int i = 0; i < vertexNum; ++i) {
                edges.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                int b = prerequisite[1];
                int a = prerequisite[0];
                edges.get(b).add(a);
            }
            vertexStatus = new ArrayList<>();
            for (int i = 0; i < vertexNum; ++i) {
                vertexStatus.add(0);
            }

            path = new ArrayList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
