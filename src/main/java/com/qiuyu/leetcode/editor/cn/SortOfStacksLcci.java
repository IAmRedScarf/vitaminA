//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：
//push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。 
//
// 示例1: 
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
// 
//
// 示例2: 
//
//  输入： 
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
// 
//
// 说明: 
//
// 
// 栈中的元素数目在[0, 5000]范围内。 
// 
// Related Topics 栈 设计 单调栈 👍 79 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SortOfStacksLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class SortedStack {
        private Deque<Integer> mainStack;
        private Deque<Integer> subStack;

        public SortedStack() {
            mainStack = new LinkedList<>();
            subStack = new LinkedList<>();
        }

        public void push(int val) {
            while (!subStack.isEmpty() && subStack.peekLast() > val) {
                mainStack.addLast(subStack.pollLast());
            }
            while (!mainStack.isEmpty() && mainStack.peekLast() < val) {
                subStack.addLast(mainStack.pollLast());
            }
            mainStack.addLast(val);
        }

        public void pop() {
            while (!subStack.isEmpty()) {
                mainStack.addLast(subStack.pollLast());
            }
            mainStack.pollLast();
        }

        public int peek() {
            while (!subStack.isEmpty()) {
                mainStack.addLast(subStack.pollLast());
            }
            return mainStack.isEmpty() ? -1 : mainStack.peekLast();
        }

        public boolean isEmpty() {
            return mainStack.isEmpty();
        }
    }

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
