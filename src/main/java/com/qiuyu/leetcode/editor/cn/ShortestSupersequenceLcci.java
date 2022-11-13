//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。 
//
// 示例 1: 
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10] 
//
// 示例 2: 
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: [] 
//
// 提示： 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 61 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestSupersequenceLcci {
    public static void main(String[] args) {
        Solution solution = new ShortestSupersequenceLcci().new Solution();
        int[] big = new int[] {878982, 143504, 268583, 394343, 849567, 257687, 352256, 35131, 663529, 543027};
        int[] small = new int[] {143504};
        System.out.println(Arrays.toString(solution.shortestSeq(big, small)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            int resLeft = 0, resRight = 0;
            int resLen = Integer.MAX_VALUE;
            Map<Integer, Integer> numNeedCntInWindow = new HashMap<>();
            for (int num : small) {
                numNeedCntInWindow.put(num, numNeedCntInWindow.getOrDefault(num, 0) + 1);
            }
            int left = 0, right = 0;
            int needCnt = small.length;
            while (right < big.length) {
                int curNum = big[right];
                if (numNeedCntInWindow.containsKey(curNum)) {
                    if (numNeedCntInWindow.get(curNum) > 0) {
                        needCnt--;
                    }
                    numNeedCntInWindow.put(curNum, numNeedCntInWindow.get(curNum) - 1);
                    if (needCnt == 0) {
                        while (left <= right) {
                            if (numNeedCntInWindow.containsKey(big[left])) {
                                if (numNeedCntInWindow.get(big[left]) == 0) {
                                    if (right - left + 1 < resLen) {
                                        resLeft = left;
                                        resRight = right;
                                        resLen = right - left + 1;
                                    }
                                    numNeedCntInWindow.put(big[left], numNeedCntInWindow.get(big[left]) + 1);
                                    left++;
                                    needCnt++;
                                    break;
                                }
                                numNeedCntInWindow.put(big[left], numNeedCntInWindow.get(big[left]) + 1);
                            }
                            left++;
                        }
                    }

                }
                right++;
            }
            if (resLen == Integer.MAX_VALUE) {
                return new int[0];
            }
            return new int[] {resLeft, resRight};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
