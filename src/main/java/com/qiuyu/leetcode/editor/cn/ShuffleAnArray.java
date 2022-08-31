//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 10⁴ 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 👍 268 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
    public static void main(String[] args) {
        Solution solution= new ShuffleAnArray().new Solution(new int[] { 1,2,3});
        System.out.println(solution.shuffle());


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] origin;


        public Solution(int[] nums) {
            origin = new int[nums.length];
            System.arraycopy(nums, 0, origin, 0, nums.length);
        }

        public int[] reset() {
            int[] nums = new int[origin.length];
            System.arraycopy(origin, 0, nums, 0, origin.length);
            return nums;

        }

        public int[] shuffle() {
//            List<Integer> list = new ArrayList<>();
//            for (int num : origin) {
//                list.add(num);
//            }
//            Random rand = new Random();
//
//
//            int[] shuffled = new int[origin.length];
//            for (int i = 0; i < origin.length; ++i) {
//                int idx = rand.nextInt(list.size());
//                shuffled[i] = list.get(idx);
//                list.remove(idx);
//            }
            int[] nums = new int[origin.length];
            System.arraycopy(origin, 0, nums, 0, origin.length);
            Random rand = new Random();
            for (int i = 0; i < nums.length; ++i) {
                int randIndex = i + rand.nextInt(nums.length - i);
                int tmp = nums[i];
                nums[i] = nums[randIndex];
                nums[randIndex] = tmp;
            }

            return nums;

        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
