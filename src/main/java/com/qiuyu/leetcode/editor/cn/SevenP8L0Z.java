//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
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
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 23 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] isVisited, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (isVisited[i] || (i > 0 && !isVisited[i - 1] && nums[i] == nums[i - 1])) {
                    continue;
                }
                tmp.add(nums[i]);
                isVisited[i] = true;
                dfs(nums, isVisited, tmp, res);
                isVisited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
