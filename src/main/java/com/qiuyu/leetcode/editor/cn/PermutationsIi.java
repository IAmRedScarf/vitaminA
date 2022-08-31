//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1042 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            return permuteUnique_20220429(nums);
        }

        public List<List<Integer>> permuteUnique_20220429(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            Arrays.sort(nums);
            dfs_20220429(nums, new boolean[nums.length], new ArrayList<>(), res);
            return res;

        }

        private void dfs_20220429(int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> res) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = 0; i < nums.length; ++i) {
                    if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                        continue;
                    }
                    visited[i] = true;
                    tmp.add(nums[i]);
                    dfs_20220429(nums, visited, tmp, res);
                    tmp.remove(tmp.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
