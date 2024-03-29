//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1521 👎 0


package com.qiuyu.leetcode.editor.cn;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            return findDuplicate20230223(nums);
        }


        public int findDuplicate20230223(int[] nums) {
            int fast = 0;
            int slow = 0;
            do {
                fast = nums[nums[fast]];
                slow = nums[slow];
            } while (fast != slow);

            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;

        }




        // 转化为链表是否存在环
        // 数值的范围为 1-n ，下标的范围是 0-n
        // 有重复数表示，存在不同的下标，指向了同一个数值，而数值的范围是下标范围的子集，所以存在了环
        public int findDuplicate_20220503(int[] nums) {
            int fast = 0;
            int slow = 0;
            do {
                fast = nums[nums[fast]];
                slow = nums[slow];
            } while (fast != slow);

            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;

        }


        public int findDuplicate_old(int[] nums) {
            int[] tmp = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                if (tmp[nums[i]] >= 1) {
                    return nums[i];
                } else {
                    tmp[nums[i]]++;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
