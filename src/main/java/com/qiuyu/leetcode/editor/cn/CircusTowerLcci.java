//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请
//编写代码计算叠罗汉最多能叠几个人。 
//
// 示例： 
//
// 
//输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190) 
//
//
// 提示： 
//
// 
// height.length == weight.length <= 10000 
// 
// Related Topics 数组 二分查找 动态规划 排序 👍 96 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircusTowerLcci {
    public static void main(String[] args) {
        Solution solution = new CircusTowerLcci().new Solution();
        int[] a = new int[] {65,70,56,75,60,68};
        int[] b = new int[] {100,150,90,190,95,110};
        solution.bestSeqAtIndex(a, b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestSeqAtIndex(int[] height, int[] weight) {
            List<int[]> heightWeightList = new ArrayList<>();
            int n = height.length;
            for (int i = 0; i < n; ++i) {
                heightWeightList.add(new int[]{height[i], weight[i]});
            }
            heightWeightList.sort((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });

            int[] longestSeqDp = new int[n];
            int res = 1;
            Arrays.fill(longestSeqDp, 1);
            for (int i = 1; i < n; ++i) {
                int cur = longestSeqDp[i];
                for (int j = i - 1; j >= 0; --j) {
                    if (heightWeightList.get(i)[1] > heightWeightList.get(j)[1]) {
                        cur = Math.max(cur, longestSeqDp[j] + 1);
                    }
                }
                longestSeqDp[i] = cur;
                res = Math.max(res, cur);
            }
            return res;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
