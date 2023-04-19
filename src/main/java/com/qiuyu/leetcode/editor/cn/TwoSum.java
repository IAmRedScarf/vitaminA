//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11694 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            return  twoSum20230409(nums, target);
        }



        public int[] twoSum20230409(int[] nums, int target) {
            Map<Integer, Integer> valueIndexMap = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (valueIndexMap.containsKey(target - nums[i])) {
                    return new int[]{i, valueIndexMap.get(target - nums[i])};
                }
                valueIndexMap.put(nums[i], i);
            }
            return null;

        }






        public int[] twoSum_20220513(int[] nums, int target) {
            Map<Integer, Integer> tmpMap = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (tmpMap.containsKey(target - nums[i])) {
                    return new int[] {i, tmpMap.get(target - nums[i])};
                } else {
                    tmpMap.put(nums[i], i);
                }
            }
            return null;
        }








        public int[] twoSum_old(int[] nums, int target) {
            Map<Integer, Integer> tmpMap = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                tmpMap.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; ++i) {
                int sub = target - nums[i];
                if (tmpMap.containsKey(sub) && tmpMap.get(sub) != i) {
                    return new int[] {i, tmpMap.get(sub)};
                }
            }
            throw new IllegalArgumentException("no twoSum solution");

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
