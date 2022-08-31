//请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 568 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            int[][] rowsTest = new int[9][10];
            int[][] colsTests = new int[9][10];
            int[][] squaresTest = new int[9][10];

            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    char c = board[i][j];
                    if (c == '.') {
                        continue;
                    } else if (c < '1' || c > '9') {
                        return false;
                    } else {
                        int curNum = c - '0';
                        // 检查行
                        if (rowsTest[i][curNum] != 0) {
                            return false;
                        } else {
                            rowsTest[i][curNum] = 1;
                        }

                        // 检查列
                        if (colsTests[j][curNum] != 0) {
                            return false;
                        } else {
                            colsTests[j][curNum] = 1;
                        }

                        // 检查方格
                        int squareIndex = i / 3 * 3 + j / 3;
                        if (squaresTest[squareIndex][curNum] != 0) {
                            return false;
                        } else {
                            squaresTest[squareIndex][curNum] = 1;
                        }
                    }
                }
            }
            return true;































//            List<Set<Integer>> rowSetList = new ArrayList<>();
//            List<Set<Integer>> colSetList = new ArrayList<>();
//            List<Set<Integer>> squareSetList = new ArrayList<>();
//
//            for (int i = 0; i < board.length; ++i) {
//                rowSetList.add(new HashSet<>());
//                colSetList.add(new HashSet<>());
//                squareSetList.add(new HashSet<>());
//            }
//
//            for (int i = 0; i < board.length; ++i) {
//                for (int j = 0; j < board[0].length; ++j) {
//                    if (board[i][j] != '.') {
//                        Integer ch = board[i][j] - '0';
//                        if (rowSetList.get(i).contains(ch) || colSetList.get(j).contains(ch) || squareSetList.get((i / 3) * 3 + j / 3).contains(ch)) {
//                            return false;
//                        }
//                        rowSetList.get(i).add(ch);
//                        colSetList.get(j).add(ch);
//                        squareSetList.get((i / 3) * 3 + j / 3).add(ch);
//                    }
//                }
//            }
//
//            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
