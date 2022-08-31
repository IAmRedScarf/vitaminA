//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 27 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class VvJkup {
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
        System.out.println(solution.permute(new int[] {1,2,3,4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] nums, boolean[] isVisited, List<Integer> tmp, List<List<Integer>> res) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = 0; i < nums.length; ++i) {
                    if (isVisited[i]) {
                        continue;
                    }
                    isVisited[i] = true;
                    tmp.add(nums[i]);
                    dfs(nums, isVisited, tmp, res);
                    tmp.remove(tmp.size() - 1);
                    isVisited[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
