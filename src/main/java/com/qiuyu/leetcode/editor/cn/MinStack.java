//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类:
//
// 
// MinStack() 初始化堆栈对象。
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
// Related Topics 栈 设计 👍 1305 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack20230220 {
        private Deque<Long> diffStack;
        private int curMin;

        public MinStack20230220() {
            diffStack = new LinkedList<>();

        }

        public void push(int val) {
            if (diffStack.isEmpty()) {
                diffStack.add(0L);
                curMin = val;
            } else {
                int preMin = curMin;
                long diff = (long) val - preMin;
                diffStack.addLast(diff);
                if (val < curMin) {
                    curMin = val;
                }
            }
        }

        public void pop() {
            long diff = diffStack.pollLast();
            if (diff >= 0) {
                // diff大于0，说明该值的入栈，没有导致栈内最小值的更新，即 preMin = curMin
                // 根据 diff = val - preMin 可以反算出 val
            } else {
                // diff小于0，即 val - preMin = diff < 0，说明该值的入栈，导致了栈内最小值的更新，也就是该值，为当前栈内最小值，即 val = curMin
                // 反算出 preMin
                int val = curMin;
                curMin = (int) (val - diff);
            }
        }

        public int top() {
            long diff = diffStack.peekLast();
            if (diff >= 0) {
                // diff大于0，说明该值的入栈，没有导致栈内最小值的更新，即 preMin = curMin
                // 根据 diff = val - preMin 可以反算出 val
                // 即
                return (int) (diff + curMin);
            } else {
                // diff小于0，即 val - preMin = diff < 0，说明该值的入栈，导致了栈内最小值的更新，也就是该值，为当前栈内最小值，即 val = curMin
                return curMin;
            }
        }

        public int getMin() {
            return curMin;
        }
    }


    class MinStack_20220514 {

        private Deque<Long> data;
        private Integer min;

        public MinStack_20220514() {
            data = new LinkedList<>();

        }

        public void push(int x) {
            if (data.isEmpty()) {
                min = x;
                data.addLast(0L);
            } else {
                long diff = (long) x - min;
                data.addLast(diff);
                min = Math.min(x, min);
            }

//            if (data.isEmpty()) {
//                data.addLast(0L);
//                min = x;
//            } else {
//                //如果x是最小的数，这里可能越界，所以用Long来保存
//                data.addLast(Long.valueOf(x) - min);
//                min = Math.min(x, min);
//            }


        }

        public void pop() {
//            long diff = data.pollLast();
//            if (diff < 0) {
//                min = (int) (min - diff);
//            }
            Long diff = data.pollLast();
            if (diff >= 0) {
                //return min + diff;
            } else {
                int res = min;
                min = (int) (min - diff);
                //return res;
            }

        }

        public int top() {
            long diff = data.peekLast();
            if (diff < 0) {
                return min;
            } else {
                return (int) (min + diff);
            }
//            Long diff = data.peekLast();
//            if (diff >= 0) {
//                return (int) (min + diff);
//            } else {
//                return min;
//            }


        }

        public int getMin() {
            return min;
        }
    }





    class MinStack_Inner_20220513 {

        private Deque<Integer> baseStack;
        private Deque<Integer> tmpStack;

        public MinStack_Inner_20220513() {
            baseStack = new LinkedList<>();
            tmpStack = new LinkedList<>();
        }

        public void push(int val) {
            baseStack.addLast(val);
            if (tmpStack.isEmpty()) {
                tmpStack.addLast(val);
            } else {
                int curMin = Math.min(val, tmpStack.peekLast());
                tmpStack.addLast(curMin);
            }
        }

        public void pop() {
            baseStack.pollLast();
            tmpStack.pollLast();

        }

        public int top() {
            return baseStack.peekLast();

        }

        public int getMin() {
            return tmpStack.peekLast();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
