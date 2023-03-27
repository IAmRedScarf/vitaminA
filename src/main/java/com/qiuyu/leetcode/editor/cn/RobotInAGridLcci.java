//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
// Related Topics 数组 动态规划 回溯 矩阵 👍 112 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGridLcci {
    public static void main(String[] args) {
        Solution solution = new RobotInAGridLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] grid;
        private List<List<Integer>> curPath = new ArrayList<>();
        // 标记位，false-未访问，true-不能到达
        private boolean[][] hasCheckedFlag;
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            grid = obstacleGrid;
            hasCheckedFlag = new boolean[obstacleGrid.length][obstacleGrid[0].length];
            dfs(0, 0);
            return curPath;
        }

        private boolean dfs(int i, int j) {
            if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
                return false;
            }
            if (hasCheckedFlag[i][j]) {
                return false;
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                List<Integer> curPos = new ArrayList<>();
                curPos.add(i);
                curPos.add(j);
                curPath.add(curPos);
                return true;
            }
            List<Integer> curPos = new ArrayList<>();
            curPos.add(i);
            curPos.add(j);
            curPath.add(curPos);
            if (dfs(i + 1, j) || dfs(i, j + 1)) {
                return true;
            }
            curPath.remove(curPath.size() - 1);
            hasCheckedFlag[i][j] = true;
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
