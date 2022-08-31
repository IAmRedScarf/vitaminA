//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1631 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void dfs_20220428(int[] candidates, int start, int target, List<Integer> tmp, List<List<Integer>> res) {
            if (target < 0) {
                return;
            } else if (target == 0) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = start; i < candidates.length; ++i) {
                    tmp.add(candidates[i]);
                    dfs_20220428(candidates, i, target - candidates[i], tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }

        public List<List<Integer>> combinationSum_20220428(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return res;
            }
            dfs_20220428(candidates, 0, target, new ArrayList<>(), res);
            return res;


        }




















        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return combinationSum_20220428(candidates, target);
//            List<List<Integer>> res = new ArrayList<>();
//            if (candidates == null || candidates.length == 0) {
//                return res;
//            }
//            Arrays.sort(candidates);
//            List<Integer> tmp = new ArrayList<>();
//            backtrack1(res, candidates, 0, tmp, target);
//            return res;
        }

        private void backtrack(List<List<Integer>> res, int[] candidates, int start, List<Integer> tmp, int left) {
            if (left < 0) {
                return;
            } else if (left == 0) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = start; i < candidates.length; ++i) {
                    tmp.add(candidates[i]);
                    backtrack(res, candidates, i, tmp, left - candidates[i]);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }

        private void backtrack1(List<List<Integer>> res, int[] candidates, int start, List<Integer> tmp, int left) {
            if (left == 0) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = start; i < candidates.length; ++i) {
                    if (left - candidates[i] < 0) {
                        break;
                    }
                    tmp.add(candidates[i]);
                    backtrack(res, candidates, i, tmp, left - candidates[i]);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
