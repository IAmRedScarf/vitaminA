//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 881 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "";
            }
            List<String> numList = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> {
                String ab = a + b, ba = b + a;
                return ba.compareTo(ab);
            }).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            numList.forEach(sb::append);
            int start = 0;
            while (start < sb.length() - 1 && sb.charAt(start) == '0') {
                start++;
            }
            return sb.substring(start);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
