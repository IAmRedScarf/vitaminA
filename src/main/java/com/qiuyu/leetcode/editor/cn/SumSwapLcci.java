//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 数组 哈希表 二分查找 排序 👍 40 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumSwapLcci {
    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findSwapValues(int[] array1, int[] array2) {
            int sum1 = 0, sum2 = 0;
            for (int num : array1) {
                sum1 += num;
            }
            Set<Integer> array2Set = new HashSet<>();
            for (int num : array2) {
                array2Set.add(num);
                sum2 += num;
            }
            if ((sum2 - sum1 & 1) == 1) {
                return new int[0];
            }
            int diff = (sum2 - sum1) / 2;
            for (int num : array1) {
                if (array2Set.contains(num + diff)) {
                    return new int[]{num, num + diff};
                }
            }
            return new int[0];

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
