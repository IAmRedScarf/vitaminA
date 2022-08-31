//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 👍 379 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        // 存储   与最小值的差值
        // valSava = cur - min
        private Deque<Long> mainStack;
        // 最小值
        int min = 0;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            mainStack = new LinkedList<>();
        }

        public void push(int x) {

            if (mainStack.isEmpty()) {
                min = x;
                mainStack.addLast(0L);
            } else {
                long diff = (long) x - min;
                mainStack.addLast(diff);
                min = Math.min(x, min);
            }
        }

        // preMin
        // valSave = cur - preMin
        // min = Math.min(cur, min)


        public void pop() {
            long valSava = mainStack.pollLast();
            if (valSava < 0) {
                min = (int) (min - valSava);
            }
        }

        public int top() {
            long valSave = mainStack.peekLast();
            if (valSave < 0) {
                return min;
            } else {
                return (int) (valSave + min);
            }
        }

        public int min() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
