//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
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
// Related Topics 数组 回溯 👍 1510 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = new int[]{1, 2};
        System.out.println(solution.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            return permute20230215(nums);
        }


        public List<List<Integer>> permute20230215(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            boolean[] visited = new boolean[nums.length];
            backtrack(nums, visited, new ArrayList<>(), res);
            return res;

        }

        public void backtrack(int[] nums, boolean[] visited, List<Integer> available, List<List<Integer>> res) {
            if (available.size() == nums.length) {
                res.add(new ArrayList<>(available));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                available.add(nums[i]);
                backtrack(nums, visited, available, res);
                available.remove(available.size() - 1);
                visited[i] = false;
            }
        }











        private void dfs_20220428(int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> res) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = 0; i < nums.length; ++i) {
                    if (visited[i]) {
                        continue;
                    }
                    visited[i] = true;
                    tmp.add(nums[i]);
                    dfs_20220428(nums, visited, tmp, res);
                    tmp.remove(tmp.size() - 1);
                    visited[i] = false;
                }
            }
        }



        public List<List<Integer>> permute_20220428(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            dfs_20220428(nums, new boolean[nums.length], new ArrayList<>(), res);
            return res;


        }








        public List<List<Integer>> permute22222222(int[] nums) {
            return permute_20220428(nums);
//            List<List<Integer>> res = new ArrayList<>();
//            if (nums == null || nums.length == 0) {
//                return res;
//            }
//            boolean[] isVisited = new boolean[nums.length];
//            List<Integer> tmp = new ArrayList<>();
//            backTrack(res, tmp, nums, isVisited);
//            return res;
        }

        private void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] isVisited) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
            } else {
                for (int i = 0; i < nums.length; ++i) {
                    if (isVisited[i]) {
                        continue;
                    }
                    isVisited[i] = true;
                    tmp.add(nums[i]);
                    backTrack(res, tmp, nums, isVisited);
                    tmp.remove(tmp.size() - 1);
                    isVisited[i] = false;
                }
            }
        }








//        private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tmp, boolean[] isVisited) {
//            if (tmp.size() == nums.length) {
//                res.add(new ArrayList<>(tmp));
//            } else {
//                for (int i = 0; i < nums.length; ++i) {
//                    if (isVisited[i]) {
//                        continue;
//                    }
//                    tmp.add(nums[i]);
//                    isVisited[i] = true;
//                    backtrack(res, nums, tmp, isVisited);
//                    isVisited[i] = false;
//                    tmp.remove(tmp.size() - 1);
//                }
//            }
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
