//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 692 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{1, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
            res.add(new ArrayList<>(tmp));
            for (int i = start; i < nums.length; ++i) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tmp.add(nums[i]);
                dfs(nums, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }

        }



        public List<List<Integer>> subsetsWithDup_20220502(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(nums, 0, new ArrayList<>(), res);
            return res;

        }


        public List<List<Integer>> subsetsWithDup(int[] nums) {
            return subsetsWithDup_20220502(nums);
        }



        public List<List<Integer>> subsetsWithDup_old(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            List<Integer> tmp = new ArrayList<>();
            Arrays.sort(nums);
            boolean[] isVisited = new boolean[nums.length];
            backtrack(res, tmp, nums, 0, isVisited);
            return res;
        }

        private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start, boolean[] isVisited) {
            res.add(new ArrayList<>(tmp));
            for (int i = start; i < nums.length; ++i) {
                if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                    continue;
                }
                isVisited[i] = true;
                tmp.add(nums[i]);
                backtrack(res, tmp, nums, i + 1, isVisited);
                tmp.remove(tmp.size() - 1);
                isVisited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
