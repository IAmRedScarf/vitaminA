//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 👍 1370 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        char[] a1 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] a2 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] a3 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] a4 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] a5 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] a6 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] a7 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] a8 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] a9 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        char[][] b = {a1,
                a2,
                a3,
                a4,
                a5,
                a6,
                a7,
                a8,
                a9};
        solution.solveSudoku(b);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 0-表示未填写，2-表示无需填写
        int[][] visited = new int[9][9];

        int[][] rowFlag = new int[9][10];
        int[][] colFlag = new int[9][10];
        int[][] squareFlag = new int[9][10];
        boolean valid = false;

        public void solveSudoku(char[][] board) {

            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    char c = board[i][j];
                    if (c != '.') {
                        visited[i][j] = 2;
                        rowFlag[i][c - '0'] = 1;
                        colFlag[j][c - '0'] = 1;
                        squareFlag[i / 3 * 3 + j / 3][c - '0'] = 1;
                    }
                }
            }
            backtrace(board, 0, 0);
        }

        private void backtrace(char[][] board, int i, int j) {
            if (valid) {
                return;
            }
            if (visited[i][j] == 2) {
                if (i == 8 && j == 8) {
                    valid = true;
                    return;
                }
                if (j == 8) {
                    backtrace(board, i + 1, 0);
                } else {
                    backtrace(board, i, j + 1);
                }
            } else {

                for (char num = '1'; num <= '9'; ++num) {
                    if (rowFlag[i][num - '0'] == 1 || colFlag[j][num - '0'] == 1 || squareFlag[i / 3 * 3 + j / 3][num - '0'] == 1) {
                        continue;
                    }

                    board[i][j] = num;
                    rowFlag[i][num - '0'] = 1;
                    colFlag[j][num - '0'] = 1;
                    squareFlag[i / 3 * 3 + j / 3][num - '0'] = 1;
                    if (i == 8 && j == 8) {
                        valid = true;
                        break;
                    }
                    if (j == 8) {
                        backtrace(board, i + 1, 0);
                    } else {
                        backtrace(board, i, j + 1);
                    }
                    if (valid) {
                        return;
                    }
                    rowFlag[i][num - '0'] = 0;
                    colFlag[j][num - '0'] = 0;
                    squareFlag[i / 3 * 3 + j / 3][num - '0'] = 0;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
