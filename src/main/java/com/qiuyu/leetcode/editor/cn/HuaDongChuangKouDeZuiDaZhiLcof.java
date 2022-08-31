//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 440 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        solution.maxSlidingWindow_20220518(nums, 3);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            return maxSlidingWindow_20220518(nums, k);
        }

        public int[] maxSlidingWindow_20220518(int[] nums, int k) {
            if (k <= 0 || k > nums.length) {
                return new int[0];
            }

            int len = nums.length;
            int[] res = new int[len - k + 1];
            // 存储下标，保证双端队列从左到右，降序（按下标对应的值）
            Deque<Integer> dq = new LinkedList<>();
            for (int i = 0; i < k; ++i) {
                while (!dq.isEmpty()) {
                    int tail = nums[dq.peekLast()];
                    if (nums[i] >= tail) {
                        dq.pollLast();
                    } else {
                        break;
                    }
                }
                dq.addLast(i);
            }
            res[0] = nums[dq.peekFirst()];
            int j = 1;
            for (int i = k; i < len; ++i) {
                while (!dq.isEmpty()) {
                    int tail = nums[dq.peekLast()];
                    if (nums[i] >= tail) {
                        dq.pollLast();
                    } else {
                        break;
                    }
                }
                dq.addLast(i);
                while (!dq.isEmpty()) {
                    int head = dq.peekFirst();
                    if (head < i - k + 1) {
                        dq.pollFirst();
                    } else {
                        break;
                    }
                }
                res[j++] = nums[dq.peekFirst()];
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
