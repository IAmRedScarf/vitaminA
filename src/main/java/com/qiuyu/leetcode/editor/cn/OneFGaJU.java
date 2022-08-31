//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
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
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 69 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new OneFGaJU().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n - 2; ++i) {
                if (i > 0 && nums[i] == nums[i- 1]) {
                    continue;
                }
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int cur2Sum = nums[left] + nums[right];
                    if (cur2Sum == -nums[i]) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        res.add(tmp);
                        while (++left < right && nums[left] == nums[left - 1]);
                        while (--right > left && nums[right] == nums[right + 1]);
                    } else if (cur2Sum < -nums[i]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
