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
        int[] nums = new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return threeSum20230417(nums);
        }

        public List<List<Integer>> threeSum20230417(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i <= nums.length - 3; ++i) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        res.add(tmp);
                        while (left < right && nums[++left] == nums[left - 1]);
                        while (right > left && nums[--right] == nums[right + 1]);
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;

        }










        public List<List<Integer>> threeSum20220214(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; ++i) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<int[]> tmp = find2Num(nums, i + 1, nums.length - 1, -nums[i]);
                if (!tmp.isEmpty()) {
                    for (int[] a : tmp) {
                        List<Integer> elements = new ArrayList<>();
                        elements.add(nums[i]);
                        elements.add(a[0]);
                        elements.add(a[1]);
                        res.add(elements);
                    }
                }
            }
            return res;
        }

        private List<int[]> find2Num(int[] nums, int left, int right, int targetSum) {
            List<int[]> res = new ArrayList<>();
            int i = left, j = right;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == targetSum) {
                    res.add(new int[] {nums[i], nums[j]});
                    while (++i <= right && nums[i] == nums[i - 1]);
                    while (--j >= left && nums[j] == nums[j + 1]);
                } else if (sum < targetSum) {
                    ++i;
                } else {
                    --j;
                }
            }
            return res;
        }
















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


        public List<List<Integer>> threeSum222222222(int[] nums) {
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
