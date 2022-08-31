//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3989 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum_20220426(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; ++i) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] > 0) {
                    break;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;


        }


        public List<List<Integer>> threeSum(int[] nums) {
            return threeSum_20220426(nums);
//            if (nums == null || nums.length < 3) {
//                return new ArrayList<>();
//            }
//            Arrays.sort(nums);
//            List<List<Integer>> res = new ArrayList<>();
//            for (int i = 0; i < nums.length - 2; ++i) {
//                if (i > 0 && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                if (nums[i] > 0) {
//                    break;
//                }
//                int left = i + 1, right = nums.length - 1;
//                while (left < right) {
//                    if (left > i + 1 && nums[left] == nums[left - 1]) {
//                        left++;
//                        continue;
//                    }
//                    int target = -nums[i];
//                    if (nums[left] + nums[right] == target) {
//                        List<Integer> tmpList = new ArrayList<>();
//                        tmpList.add(nums[i]);
//                        tmpList.add(nums[left]);
//                        tmpList.add(nums[right]);
//                        res.add(tmpList);
//                        left++;
//                        right--;
//                    } else if (nums[left] + nums[right] < target) {
//                        left++;
//                    } else {
//                        right--;
//                    }
//                }
//            }
//            return res;


//            Arrays.sort(nums);
//            List<List<Integer>> res = new ArrayList<>();
//            for (int i = 0; i < nums.length - 2; ++i) {
//                if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) {
//                    continue;
//                }
//                int left = i + 1, right = nums.length - 1;
//                while (left < right) {
//                    if (nums[i] + nums[left] + nums[right] > 0) {
//                        right--;
//                    } else if (nums[i] + nums[left] + nums[right] < 0) {
//                        left++;
//                    } else {
//                        List<Integer> tmp = new ArrayList<>();
//                        tmp.add(nums[i]);
//                        tmp.add(nums[left]);
//                        tmp.add(nums[right]);
//                        res.add(tmp);
//                        left++;
//                        right--;
//                    }
//                    while (left > i + 1 && nums[left] == nums[left - 1] && left < right) {
//                        left++;
//                    }
//                    while (right < nums.length - 1 && nums[right] == nums[right + 1] && left < right) {
//                        right--;
//                    }
//                }
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
