//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 732 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if (numRows == 1) {
                res.add(Collections.singletonList(1));
                return res;
            }
            res.add(Collections.singletonList(1));
            res.add(Arrays.asList(1, 1));
            if (numRows == 2) {
                return res;
            }
            for (int row = 3; row <= numRows; ++row) {
                List<Integer> pre = res.get(row - 2);
                List<Integer> cur = new ArrayList<>();
                cur.add(1);
                for (int i = 1; i < pre.size(); ++i) {
                    cur.add(pre.get(i - 1) + pre.get(i));
                }
                cur.add(1);
                res.add(cur);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
