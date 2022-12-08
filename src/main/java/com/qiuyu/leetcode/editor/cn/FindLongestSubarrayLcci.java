//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// Related Topics 数组 哈希表 前缀和 👍 56 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarrayLcci {
    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci().new Solution();
        String[] strArray = new String[] {"A","1"};
        System.out.println(Arrays.toString(solution.findLongestSubarray(strArray)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findLongestSubarray(String[] array) {
            int len = array.length;
            int[] intArray = new int[len];
            for (int i = 0; i < len; ++i) {
                if (array[i].compareTo("A") >= 0 && array[i].compareTo("z") <= 0) {
                    intArray[i] = 1;
                } else {
                    intArray[i] = -1;
                }
            }
            int[] prefixSum = new int[len];
            prefixSum[0] = intArray[0];

            int resStart = Integer.MIN_VALUE, resLen = 0;

            // 前缀和值出现最早的下标
            Map<Integer, Integer> preSumValueIndexMap = new HashMap<>();
            preSumValueIndexMap.put(0, -1);
            preSumValueIndexMap.put(prefixSum[0], 0);
            for (int i = 1; i < len; ++i) {
                prefixSum[i] += intArray[i] + prefixSum[i - 1];
                if (preSumValueIndexMap.containsKey(prefixSum[i])) {
                    int curLen = i - preSumValueIndexMap.get(prefixSum[i]);
                    if (curLen > resLen) {
                        resLen = curLen;
                        resStart = preSumValueIndexMap.get(prefixSum[i]) + 1;
                    }
                } else {
                    preSumValueIndexMap.put(prefixSum[i], i);
                }
            }
            if (resStart == Integer.MIN_VALUE) {
                return new String[0];
            } else {
                return Arrays.copyOfRange(array, resStart, resStart + resLen);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
