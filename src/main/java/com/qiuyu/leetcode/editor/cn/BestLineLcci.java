//给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。 
// 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小
//的直线返回，S[0]相同则选择S[1]值较小的直线返回。 
// 示例： 
// 输入： [[0,0],[1,1],[1,0],[2,0]]
//输出： [0,2]
//解释： 所求直线穿过的3个点的编号为[0,2,3]
// 
// 提示： 
// 
// 2 <= len(Points) <= 300 
// len(Points[i]) = 2 
// 
// Related Topics 几何 数组 哈希表 数学 👍 26 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class BestLineLcci {
    public static void main(String[] args) {
        Solution solution = new BestLineLcci().new Solution();
        int[][] points = new int[4][];
        int[][] a = new int[][] {new int[]{-24272,-29606},
                new int[]{-37644,-4251},
                new int[]{2691,-22513},
                new int[]{-14592,-33765},
                new int[]{-21858,28550},
                new int[]{-22264,41303},
                new int[]{-6960,12785},
                new int[]{-39133,-41833},
                new int[]{25151,-26643},
                new int[]{-19416,28550},
                new int[]{-17420,22270},
                new int[]{-8793,16457},
                new int[]{-4303,-25680},
                new int[]{-14405,26607},
                new int[]{-49083,-26336},
                new int[]{22629,20544},
                new int[]{-23939,-25038},
                new int[]{-40441,-26962},
                new int[]{-29484,-30503},
                new int[]{-32927,-18287},
                new int[]{-13312,-22513},
                new int[]{15026,12965},
                new int[]{-16361,-23282},
                new int[]{7296,-15750},
                new int[]{-11690,-21723},
                new int[]{-34850,-25928},
                new int[]{-14933,-16169},
                new int[]{23459,-9358},
                new int[]{-45719,-13202},
                new int[]{-26868,28550},
                new int[]{4627,16457},
                new int[]{-7296,-27760},
                new int[]{-32230,8174},
                new int[]{-28233,-8627},
                new int[]{-26520,28550},
                new int[]{5515,-26001},
                new int[]{-16766,28550},
                new int[]{21888,-3740},
                new int[]{1251,28550},
                new int[]{15333,-26322},
                new int[]{-27677,-19790},
                new int[]{20311,7075},
                new int[]{-10751,16457},
                new int[]{-47762,-44638},
                new int[]{20991,24942},
                new int[]{-19056,-11105},
                new int[]{-26639,28550},
                new int[]{-19862,16457},
                new int[]{-27506,-4251},
                new int[]{-20172,-5440},
                new int[]{-33757,-24717},
                new int[]{-9411,-17379},
                new int[]{12493,29906},
                new int[]{0,-21755},
                new int[]{-36885,-16192},
                new int[]{-38195,-40088},
                new int[]{-40079,7667},
                new int[]{-29294,-34032},
                new int[]{-55968,23947},
                new int[]{-22724,-22513},
                new int[]{20362,-11530},
                new int[]{-11817,-23957},
                new int[]{-33742,5259},
                new int[]{-10350,-4251},
                new int[]{-11690,-22513},
                new int[]{-20241,-22513}};
        System.out.println(Arrays.toString(solution.bestLine(a)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] bestLine(int[][] points) {
            int targetLineHasPoints = 0;
            int s0 = 0, s1 = 0;
            int num = points.length;
            for (int i = 0; i < num; ++i) {
                Map<String, List<Integer>> slopePointsMap = new LinkedHashMap<>();
                int[] startPoint = points[i];
                for (int j = i + 1; j < num; ++j) {
                    int[] endPont = points[j];
                    int dx = endPont[0] - startPoint[0], dy = endPont[1] - startPoint[1];
                    int k = gcd(dx, dy);
                    String slope = (dx / k) + "_" + (dy / k);

                    List<Integer> curList = slopePointsMap.getOrDefault(slope, new ArrayList<>());
                    curList.add(j);
                    slopePointsMap.put(slope, curList);
                }
                int curMaxPointNum = 0;
                int tmpS1 = 0;
                List<int[]> s01 = new ArrayList<>();
                for (Map.Entry<String, List<Integer>> entry : slopePointsMap.entrySet()) {
                    if (entry.getValue().size() + 1 > curMaxPointNum) {
                        curMaxPointNum = entry.getValue().size() + 1;
                        tmpS1 = entry.getValue().get(0);
                        s01.add(new int[]{i, entry.getValue().get(0)});
                    }
                }

//                s01.sort((o1, o2) -> {
//                    if (o1[0] == o2[0]) {
//                        return o1[1] - o2[1];
//                    } else {
//                        return o1[0] - o2[0];
//                    }
//                });
                if (curMaxPointNum > targetLineHasPoints) {
                    targetLineHasPoints = curMaxPointNum;
                    s0 = i;
                    s1 = tmpS1;
                }
            }
            return new int[]{s0, s1};
        }
        int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
