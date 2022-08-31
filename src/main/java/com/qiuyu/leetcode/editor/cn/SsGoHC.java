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
//
// 
//
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
// Related Topics 数组 排序 👍 27 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SsGoHC {
    public static void main(String[] args) {
        Solution solution = new SsGoHC().new Solution();
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2, 6};
        int[] c = new int[]{8, 10};
        int[] d = new int[]{15, 18};
        solution.merge(new int[][] {a, b,c, d});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> res = new ArrayList<>();
            for (int[] interval : intervals) {
                int left = interval[0], right = interval[1];
                if (res.isEmpty()) {
                    res.add(new int[]{left, right});
                } else {
                    int[] tail = res.get(res.size() - 1);
                    if (left == tail[0]) {
                        tail[1] = Math.max(right, tail[1]);
                    } else if (left <= tail[1]) {
                        tail[1] = Math.max(right, tail[1]);
                    } else {
                        res.add(new int[]{left, right});
                    }
                }
            }
            int[][] resArray = new int[res.size()][];
            for (int i = 0; i < res.size(); ++i) {
                resArray[i] = res.get(i);
            }
            return resArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
