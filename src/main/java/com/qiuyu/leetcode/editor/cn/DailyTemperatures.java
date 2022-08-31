//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 942 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] dailyTemperatures_20220510(int[] temperatures) {

            int[] res = new int[temperatures.length];
            Deque<Integer> tmpStack = new LinkedList<>();
            for (int i = 0; i < temperatures.length; ++i) {
                while (!tmpStack.isEmpty()) {
                    int top = tmpStack.peekLast();
                    if (temperatures[top] < temperatures[i]) {
                        tmpStack.pollLast();
                        res[top] = i - top;
                    } else {
                        break;
                    }
                }
                tmpStack.addLast(i);
            }
//            while (!tmpStack.isEmpty()) {
//                res[tmpStack.pollLast()] = 0;
//            }
            return res;

        }











        public int[] dailyTemperatures(int[] temperatures) {
            return dailyTemperatures_20220510(temperatures);
        }

        public int[] dailyTemperatures_20220501(int[] temperatures) {
            // 递减栈，从栈底到栈顶元素递减
            int[] res = new int[temperatures.length];

            // 额外存储下标
            Deque<int[]> tmpStack = new LinkedList<>();
            for (int i = 0; i < temperatures.length; ++i) {
                while (!tmpStack.isEmpty()) {
                    int[] top = tmpStack.peekLast();
                    if (temperatures[i] > top[1]) {
                        tmpStack.pollLast();
                        res[top[0]] = i - top[0];
                    } else {
                        break;
                    }
                }
                tmpStack.addLast(new int[] {i, temperatures[i]});
            }
            return res;
        }


        public int[] dailyTemperatures_old(int[] temperatures) {
            if (temperatures == null) {
                return null;
            }
            int len = temperatures.length;
            int[] higher = new int[len];
            Deque<Integer> tmpStack = new LinkedList<>();
            for (int i = len - 1; i >= 0; --i) {
                while (!tmpStack.isEmpty() && temperatures[tmpStack.peek()] <=  temperatures[i]) {
                    tmpStack.pop();
                }
                higher[i] = tmpStack.isEmpty() ? 0 : tmpStack.peek() - i;
                tmpStack.push(i);
            }
            return higher;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
