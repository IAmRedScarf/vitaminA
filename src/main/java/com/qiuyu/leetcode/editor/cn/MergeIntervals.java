//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1071 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = new int[5][];
        intervals[0] = new int[] {2, 3};
        intervals[1] = new int[] {5, 5};
        intervals[2] = new int[] {2, 2};
        intervals[3] = new int[] {3, 4};
        intervals[4] = new int[] {3, 4};
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] merge_20220502(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));


            List<int[]> res = new ArrayList<>();
            for (int[] cur : intervals) {
                if (res.isEmpty()) {
                    res.add(new int[] {cur[0], cur[1]});
                } else {
                    int[] pre = res.get(res.size() - 1);
                    if (cur[0] <= pre[1]) {
                        pre[1] = Math.max(cur[1], pre[1]);
                    } else {
                        res.add(cur);
                    }
                }
            }
            int[][] arrayRes = new int[res.size()][2];
            for (int i = 0; i < res.size(); ++i) {
                arrayRes[i] = res.get(i);
            }
            return arrayRes;
        }

        public int[][] merge(int[][] intervals) {
            return merge_20220502(intervals);
        }
        public int[][] merge_old(int[][] intervals) {
//            if (intervals.length == 0) {
//                return new int[0][2];
//            }
//            int[] reserveFlag = new int[intervals.length];
//            int reserveCnt = intervals.length;
//            for (int i = 0; i < intervals.length; ++i) {
//                reserveFlag[i] = 1;
//                for (int j = i + 1; j < intervals.length; ++j) {
//                    if (!(intervals[i][0] > intervals[j][1] || intervals[i][1] < intervals[j][0])) {
//                        intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
//                        intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
//                        if (reserveFlag[i] == 1) {
//                            reserveFlag[i] = 0;
//                            reserveCnt--;
//                            break;
//                        }
//                    }
//                }
//            }
//            int[][] result = new int[reserveCnt][2];
//            int j = 0;
//            for (int i = 0; i < intervals.length; ++i) {
//                if (reserveFlag[i] == 1) {
//                    result[j++] = intervals[i];
//                }
//            }
//            return result;


            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] > o2[0] ? 1 : (o1[0] == o2[0] ? (o1[1] - o2[1]) : -1));

            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < intervals.length; ++i) {
                int left = intervals[i][0], right = intervals[i][1];
                if (i == 0) {
                    res.add(new int[] {left, right});
                } else {
                    if (left == res.get(res.size() - 1)[0]) {
                        res.remove(res.size() - 1);
                        res.add(new int[] {left, right});
                    } else {
                        int preRight = (res.get(res.size() - 1))[1];

                        if (left <= preRight && right <= preRight) {
                        } else if (left <= preRight) {
                            int beforeLeft = (res.get(res.size() - 1))[0];
                            res.remove(res.size() - 1);
                            res.add(new int[] {beforeLeft, right});

                        } else {
                            res.add(new int[] {left, right});
                        }
                    }
                }
            }
            int[][] merged = new int[res.size()][];
            for (int i = 0; i < res.size(); ++i) {
                merged[i] = res.get(i);
            }
            return merged;



























//            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//            List<int[]> merged = new ArrayList<>();
//            for (int[] interval : intervals) {
//                int L = interval[0], R = interval[1];
//                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
//                    merged.add(new int[]{L, R});
//                } else {
//                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
//                }
//            }
//            return merged.toArray(new int[merged.size()][]);


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
