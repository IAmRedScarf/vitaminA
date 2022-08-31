//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 806 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] candidates = new int[]{1, 2, 2};
        System.out.println(solution.combinationSum2(candidates, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2_20220429(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);
            dfs_20220429(candidates, target, 0, new ArrayList<>(), res);
            return res;
        }


        private void dfs_20220429(int[] candidates, int target, int start, List<Integer> tmp, List<List<Integer>> res) {
            if (target < 0) {
                return;
            } else if (target == 0) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = start; i < candidates.length; ++i) {
                    if (i > start && candidates[i - 1] == candidates[i]) {
                        continue;
                    }
                    tmp.add(candidates[i]);
                    dfs_20220429(candidates, target - candidates[i], i + 1, tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }









        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//            return combinationSum2_20220429(candidates, target);
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);
            List<Integer> tmpList = new ArrayList<>();
            backTrack(res, candidates, target, 0, tmpList);
            return res;
        }

        private void backTrack(List<List<Integer>> res, int[] candidates, int left, int start, List<Integer> tmpList) {
            if (start == candidates.length || candidates[start] > left) {
                return;
            }
            for (int i = start; i < candidates.length; ++i) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tmpList.add(candidates[i]);
                if (candidates[i] == left) {
                    res.add(new ArrayList<>(tmpList));
                }
                backTrack(res, candidates, left - candidates[i], i + 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
