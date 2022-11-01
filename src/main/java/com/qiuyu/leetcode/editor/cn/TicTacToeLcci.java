//设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（" "）中。 
// 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。 
// "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 
//"Pending"。 
//
// 示例 1： 
//
// 输入： board = ["O X"," XO","X O"]
//输出： "X"
// 
//
// 示例 2： 
//
// 输入： board = ["OOX","XXO","OXO"]
//输出： "Draw"
//解释： 没有玩家获胜且不存在空位
// 
//
// 示例 3： 
//
// 输入： board = ["OOX","XXO","OX "]
//输出： "Pending"
//解释： 没有玩家获胜且仍存在空位
// 
//
// 提示： 
//
// 
// 1 <= board.length == board[i].length <= 100 
// 输入一定遵循井字棋规则 
// 
// Related Topics 数组 计数 矩阵 👍 38 👎 0


package com.qiuyu.leetcode.editor.cn;

public class TicTacToeLcci {
    public static void main(String[] args) {
        Solution solution = new TicTacToeLcci().new Solution();
        String[] a = new String[] {"OO"," X"};
        solution.tictactoe(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String tictactoe(String[] board) {
            int n = board.length;
            boolean isFull = true;
            int rightDiagonalSum = 0, leftDiagonalSum = 0;
            boolean rightDiagonalNoSpace = true, leftDiagonalNoSpace = true;
            for (int i = 0; i < n; ++i) {
                int rowSum = 0, colSum = 0;
                boolean rowNoSpace = true, colNoSpace = true;
                for (int j = 0; j < n; ++j) {
                    if (board[i].charAt(j) == ' ') {
                        rowNoSpace = false;
                        isFull = false;
                    }
                    if (board[j].charAt(i) == ' ') {
                        colNoSpace = false;
                    }
                    if (!rowNoSpace && !colNoSpace) {
                        break;
                    }
                    rowSum += ((int) board[i].charAt(j));
                    colSum += ((int) board[j].charAt(i));
                }
                if ((rowNoSpace && rowSum == ((int) 'X') * n) || (colNoSpace && colSum == ((int) 'X') * n)) {
                    return "X";
                }
                if (colNoSpace && colSum == ((int) 'O') * n || (rowNoSpace && rowSum == ((int) 'O') * n)) {
                    return "O";
                }
                if (board[i].charAt(i) == ' ') {
                    rightDiagonalNoSpace = false;
                }
                if (board[i].charAt(n - 1 - i) == ' ') {
                    leftDiagonalNoSpace = false;
                }

                rightDiagonalSum += (int) board[i].charAt(i);
                leftDiagonalSum += (int) board[i].charAt(n - 1 - i);
            }
            if ((rightDiagonalNoSpace && rightDiagonalSum == ((int) 'X') * n ) || (leftDiagonalNoSpace && leftDiagonalSum == ((int) 'X') * n)) {
                return "X";
            }
            if ((rightDiagonalNoSpace && rightDiagonalSum == ((int) 'O') * n ) || (leftDiagonalNoSpace && leftDiagonalSum == ((int) 'O') * n)) {
                return "O";
            }
            if (isFull) {
                return "Draw";
            }
            return "Pending";



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
