//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1469 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            // 用数组索引，使皇后分布在不同的行
            // 数组的值，表示皇后分布的列
            int[] solution = new int[n];
            List<int[]> arrayRes = new ArrayList<>();
            backtrack(solution, 0, arrayRes);
            List<List<String>> res = new ArrayList<>();
            for (int[] arr : arrayRes) {
                List<String> tmp = new ArrayList<>();
                for (int i : arr) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < arr.length; ++k) {
                        if (k == i) {
                            sb.append('Q');
                        } else {
                            sb.append('.');
                        }
                    }
                    tmp.add(sb.toString());
                }
                res.add(tmp);
            }
            return res;


        }


        private void backtrack(int[] solution, int start, List<int[]> arrayRes) {
            int n = solution.length;
            if (start == n) {
                arrayRes.add(Arrays.copyOf(solution, n));
                return;
            }
            for (int i = 0; i < n; ++i) {
                solution[start] = i;
                if (validate(solution, start)) {
                    backtrack(solution, start + 1, arrayRes);
                }
            }
        }



        private boolean validate(int[] solution, int queenIndex) {
            int colForCurQueen = solution[queenIndex];
            // 判断当前皇后放置，是否会使 列 出现冲突
            for (int i = 0; i < queenIndex; ++i) {
                if (solution[i] == colForCurQueen) {
                    return false;
                }
            }
            // 判断左上方对角线
            for (int i = queenIndex - 1, j = colForCurQueen - 1; i >= 0 && j >= 0; --i, --j) {
                if (solution[i] == j) {
                    return false;
                }
            }
            // 判断右上方对角线
            for (int i = queenIndex - 1, j = colForCurQueen + 1; i >= 0 && j < solution.length; --i, ++j) {
                if (solution[i] == j) {
                    return false;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
