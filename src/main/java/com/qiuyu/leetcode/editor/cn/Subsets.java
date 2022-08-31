//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1394 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {

            res.add(new ArrayList<>(tmp));
            for (int i = start; i < nums.length; ++i) {
                tmp.add(nums[i]);
                dfs(nums, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }

        }


        public List<List<Integer>> subsets_20220502(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            dfs(nums, 0, new ArrayList<>(), res);
            return res;


        }


        public List<List<Integer>> subsets(int[] nums) {
            return subsets_20220502(nums);
        }


        private void backTrack(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
            if (start > nums.length) {
                return;
            }
            res.add(new ArrayList<>(tmp));
            for (int i = start; i < nums.length; ++i) {
                tmp.add(nums[i]);
                backTrack(nums, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }

        public List<List<Integer>> subsets_old(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            backTrack(nums, 0, new ArrayList<>(), res);
            return res;


//            List<Integer> tmp = new ArrayList<>();
//            backtrack(res, tmp, nums, 0);
//            return res;
        }

//        private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
//            if (start == nums.length + 1) {
//                return;
//            }
//            res.add(new ArrayList<>(tmp));
//            for (int i = start; i < nums.length; ++i) {
//                tmp.add(nums[i]);
//                backtrack(res, tmp, nums, i + 1);
//                tmp.remove(tmp.size() - 1);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
