//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 986 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestConsecutive_20220503(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int res = 1;
            for (int num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int tmp = num + 1;

                    while (numSet.contains(tmp)) {
                        tmp++;
                    }
                    res = Math.max(tmp - num, res);
                }
            }
            return res;

        }







        public int longestConsecutive(int[] nums) {
            return longestConsecutive_20220503(nums);
        }
























        private int f1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = 0;
            Set<Integer> originSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            Set<Integer> tmpSet = new HashSet<>();
            for (int num : nums) {
                if (tmpSet.contains(num)) {
                    continue;
                }
                int cur = num;
                while (originSet.contains(cur)) {
                    tmpSet.add(cur);
                    ++cur;
                }
                res = Math.max(res, cur - num);
            }
            return res;
        }
//
//        private int f2(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return 0;
//            }
//            int res = 0;
//            Set<Integer> originSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//            for (int num : nums) {
//                if (originSet.contains(num - 1)) {
//                    continue;
//                }
//                int cur = num;
//                while (originSet.contains(cur)) {
//                    ++cur;
//                }
//                res = Math.max(res, cur - num);
//            }
//            return res;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
