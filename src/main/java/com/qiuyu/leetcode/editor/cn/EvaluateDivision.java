//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 667 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        List<String> tmp = new ArrayList<>();
        tmp.add("a");
        tmp.add("b");
        List<List<String>> equations = new ArrayList<>();
        equations.add(tmp);
        double[] values = new double[]{0.5d};
        solution.calcEquation(equations, values, null);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {

        class Union_Find_20220508 {
            private int[] parents;
            private double[] weights;

            public Union_Find_20220508(int n) {
                parents = new int[n];
                weights = new double[n];
                for (int i = 0; i < n; ++i) {
                    parents[i] = i;
                    weights[i] = 1.0d;
                }
            }

            /**
             * x/y=value
             */
            public void union(int x, int y, double value) {
                int xParent = findParent(x);
                int yParent = findParent(y);
                if (xParent != yParent) {
                    parents[xParent] = yParent;
                    weights[xParent] = weights[y] * value / weights[x];
                }
            }


            public int findParent(int x) {
                if (x != parents[x]) {
                    int origin = parents[x];
                    parents[x] = findParent(parents[x]);
                    weights[x] *= weights[origin];

                }
                return parents[x];
            }

            public double isConnected(int x, int y) {
                int xParent = findParent(x);
                int yParent = findParent(y);
                if (xParent == yParent) {
                    return weights[x] / weights[y];
                }
                return -1.0d;
            }
        }

        public double[] calcEquation_20220508(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Union_Find_20220508 union_find = new Union_Find_20220508(equations.size() * 2);
            Map<String, Integer> elementMap = new HashMap<>();
            int id = 0;
            int j = 0;
            for (List<String> equation : equations) {
                if (!elementMap.containsKey(equation.get(0))) {
                    elementMap.put(equation.get(0), id++);
                }
                if (!elementMap.containsKey(equation.get(1))) {
                    elementMap.put(equation.get(1), id++);
                }
                union_find.union(elementMap.get(equation.get(0)), elementMap.get(equation.get(1)), values[j++]);
            }
            double[] res = new double[queries.size()];
            for (int i = 0; i < queries.size(); ++i) {
                String e1 = queries.get(i).get(0);
                String e2 = queries.get(i).get(1);

                if (elementMap.containsKey(e1) && elementMap.containsKey(e2)) {
                    res[i] = union_find.isConnected(elementMap.get(e1), elementMap.get(e2));
                } else {
                    res[i] = -1.0d;
                }
            }
            return res;




        }



















        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            return calcEquation_20220508(equations, values, queries);
        }


        public double[] calcEquation_old(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Union_Find union_find = new Union_Find(equations.size() * 2);
            // 将各个元素编号
            HashMap<String, Integer> elementMap = new HashMap<>();
            int id = 0;
            for (int i = 0; i < equations.size(); ++i) {
                String element1 = equations.get(i).get(0);
                String element2 = equations.get(i).get(1);

                if (!elementMap.containsKey(element1)) {
                    elementMap.put(element1, id);
                    id++;
                }
                if (!elementMap.containsKey(element2)) {
                    elementMap.put(element2, id);
                    id++;
                }

                union_find.union(elementMap.get(element1), elementMap.get(element2), values[i]);
            }

            double[] res = new double[queries.size()];
            for (int i = 0; i < queries.size(); ++i) {
                String e1 = queries.get(i).get(0);
                String e2 = queries.get(i).get(1);

                if (elementMap.containsKey(e1) && elementMap.containsKey(e2)) {
                    res[i] = union_find.isConnected(elementMap.get(e1), elementMap.get(e2));
                } else {
                    res[i] = -1.0d;
                }
            }
            return res;
        }

        /**
         * 构造函数
         * 并查集有n个节点
         */
        private class Union_Find {
            private int[] parent;
            private double[] weight;

            public Union_Find(int n) {
                parent = new int[n];
                weight = new double[n];

                for (int i = 0; i < n; ++i) {
                    parent[i] = i;
                    weight[i] = 1.0d;
                }
            }

            public void union(int x, int y, double value) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) {
                    return;
                }
                parent[xRoot] = yRoot;
                weight[xRoot] = weight[y] * value / weight[x];
            }

            /**
             * 路径压缩
             *
             * @return 某个节点的根
             */
            public int find(int x) {
                if (x != parent[x]) {
                    int origin = parent[x];
                    parent[x] = find(origin);
                    weight[x] *= weight[origin];
                }
                return parent[x];
            }

            public double isConnected(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) {
                    return weight[x] / weight[y];
                } else {
                    return -1.0d;
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
