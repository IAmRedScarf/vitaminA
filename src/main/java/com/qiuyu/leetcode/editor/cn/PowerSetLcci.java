//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯 👍 98 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PowerSetLcci {
    public static void main(String[] args) {
        Solution solution = new PowerSetLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, 0, new ArrayList<>(), res);
            return res;

        }

        private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
            res.add(new ArrayList<>(tmp));
            for (int i = start; i < nums.length; ++i) {
                tmp.add(nums[i]);
                dfs(nums, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
