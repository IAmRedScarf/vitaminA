//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。
//
//
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//
// 示例 2：
//
//
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//
//
// 提示：
//
//
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 910 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        int[][] a = new int[2][2];
        a[0] = new int[] {1, 0};
        a[1] = new int[] {0, 1};
        solution.canFinish(2, a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean canFinish(int numCourses, int[][] prerequisites) {
            return canFinish20230220(numCourses, prerequisites);
        }


        public boolean canFinish20230220(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                graph.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            }
            // 0-未开始搜索，1-搜索中，2-搜索完成
            int[] status = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                if (status[i] == 0) {
                    if (!dfs20230220(graph, status, i)) {
                        return false;
                    }
                }
            }
            return true;

        }

        // dfs判断当前节点开始的搜索是否有环
        // true标识无环
        private boolean dfs20230220(List<List<Integer>> graph, int[] status, int cur) {
            List<Integer> neighbors = graph.get(cur);
            status[cur] = 1;
            for (Integer neighbor : neighbors) {
                if (status[neighbor] == 2) {
                    continue;
                }
                // 如果发现邻居节点在搜索中，说明存在环路
                if (status[neighbor] == 1) {
                    return false;
                }
                if (!dfs20230220(graph, status, neighbor)) {
                    return false;
                }
            }
            status[cur] = 2;
            return true;
        }
















        List<List<Integer>> edges_20220429;
        // 0-未搜索，1-搜索中，2-搜索完成
        int[] visited_20220429;
        public boolean canFinish_20220429(int numCourses, int[][] prerequisites) {
            if (numCourses <= 1 || prerequisites == null) {
                return true;
            }

            edges_20220429 = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges_20220429.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                edges_20220429.get(prerequisite[1]).add(prerequisite[0]);
            }
            visited_20220429 = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                if (visited_20220429[i] == 0 && dfs_20220429(i)) {
                    return false;
                }
            }
            return true;
        }


        // dfs判断图中是否存在环
        // 返回结果，true表示有环
        private boolean dfs_20220429(int v) {
            visited_20220429[v] = 1;
            for (Integer neighbour : edges_20220429.get(v)) {
                if (visited_20220429[neighbour] == 2) {
                    continue;
                }
                if (visited_20220429[neighbour] == 1 || dfs_20220429(neighbour)) {
                    return true;
                }
            }
            visited_20220429[v] = 2;
            return false;
        }


        public boolean fDfs(int numCourses, int[][] prerequisites) {
            init(numCourses, prerequisites);
            for (int i = 0; i < numCourses; ++i) {
                if (circleFlag) {
                    break;
                }
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return !circleFlag;
        }


        // 课程表用0、1、2等表示，所以可以用 数组的下表或链表的索引  标识节点

        // 存储有向图的边
        List<List<Integer>> edges;

        // 标识节点的状态，0-未搜索，1-搜索中，2-搜索完成
        int[] visited;

        // 判断有向图是否有环
        boolean circleFlag = false;

        // 标识每个节点的入度
        int[] inDegrees;



        public boolean fBfs(int numCourses, int[][] prerequisites) {
            init(numCourses, prerequisites);
            Deque<Integer> tmpQueue = new LinkedList<>();
            for (int i = 0; i < numCourses; ++i) {
                if (inDegrees[i] == 0) {
                    tmpQueue.offer(i);
                }
            }
            int visited = 0;
            while (!tmpQueue.isEmpty()) {
                visited++;
                int curV = tmpQueue.poll();
                for (Integer v : edges.get(curV)) {
                    inDegrees[v]--;
                    if (inDegrees[v] == 0) {
                        tmpQueue.offer(v);
                    }
                }
            }
            return visited == numCourses;
        }

        private void init(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            inDegrees = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                inDegrees[info[0]]++;
            }
            visited = new int[numCourses];
        }


        private void dfs(int vertex) {
            visited[vertex] = 1;
            for (Integer v : edges.get(vertex)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (circleFlag) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    circleFlag = true;
                    return;
                }
            }
            visited[vertex] = 2;
        }

        // 2022-02-17
        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] prerequisite : prerequisites) {
                int from = prerequisite[1];
                int to = prerequisite[0];
                graph[from].add(to);
            }
            return graph;
        }


        public boolean canFinish_001(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            isVisited = new boolean[numCourses];
            inPath = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                // 遍历图中的所有节点
                traverse(i, graph);
            }
            // 只要没有循环依赖可以完成所有课程
            return !hasCycle;

        }

        public void test() {
            int[][] a = new int[4][2];
            a[0] = new int[] {1, 0};
            a[1] = new int[] {2, 1};
            a[2] = new int[] {3, 2};
            a[3] = new int[] {1, 3};
            List<Integer>[] graph = buildGraph(4, a);
            isVisited = new boolean[4];
            inPath = new boolean[4];
            traverse(0, graph);

        }


        private void traverse(int start, List<Integer>[] graph) {
            if (inPath[start]) {
                hasCycle = true;
                if (!hasPrintCycle) {
                    while (!tmpStack.isEmpty()) {
                        int top = tmpStack.pop();
                        if (top != start) {
                            cycle.add(top);
                        } else {
                            break;
                        }
                    }
                    System.out.println(cycle);
                }
            }

            if (isVisited[start] || hasCycle) {
                return;
            }
            isVisited[start] = true;
            tmpStack.push(start);

            inPath[start] = true;
            for (int neighbour : graph[start]) {
                traverse(neighbour, graph);
            }
            inPath[start] = false;
        }

        private Deque<Integer> tmpStack = new LinkedList<>();
        private boolean hasPrintCycle = false;
        List<Integer> cycle = new ArrayList<>();

        private boolean[] isVisited;
        private boolean[] inPath;
        private boolean hasCycle = false;





    }
//leetcode submit region end(Prohibit modification and deletion)

}
