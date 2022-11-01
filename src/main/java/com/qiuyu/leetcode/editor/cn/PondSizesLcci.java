//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 88 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PondSizesLcci {
    public static void main(String[] args) {
        Solution solution = new PondSizesLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pondSizes(int[][] land) {
            List<Integer> poolSizeList = new ArrayList<>();
            boolean[][] isVisited = new boolean[land.length][land[0].length];
            for (int i = 0; i < land.length; ++i) {
                for (int j = 0; j < land[0].length; ++j) {
                    if (land[i][j] == 0 && !isVisited[i][j]) {
                        poolSizeList.add(dfs(i, j, land, isVisited));
                    }
                }
            }
            poolSizeList.sort(Comparator.comparingInt(o -> o));
            return poolSizeList.stream().mapToInt(i -> i).toArray();
        }


        private int dfs(int i, int j, int[][] land, boolean[][] isVisited) {
            if (i < 0 || i >= land.length || j < 0 || j >= land[0].length) {
                return 0;
            }
            if (isVisited[i][j]) {
                return 0;
            }
            if (land[i][j] > 0) {
                return 0;
            }
            isVisited[i][j] = true;
            return 1 + dfs(i + 1, j, land, isVisited)
                    + dfs(i - 1, j, land, isVisited)
                    + dfs(i, j + 1, land, isVisited)
                    + dfs(i, j - 1, land, isVisited)
                    + dfs(i - 1, j - 1, land, isVisited)
                    + dfs(i + 1, j - 1, land, isVisited)
                    + dfs(i - 1, j + 1, land, isVisited)
                    + dfs(i + 1, j + 1, land, isVisited);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
