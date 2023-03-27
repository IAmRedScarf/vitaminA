//堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行
//为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与
//普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行
//pop操作。 
//
// 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1. 
//
// 示例1: 
//
//  输入：
//["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
//[[1], [1], [2], [1], [], []]
// 输出：
//[null, null, null, 2, 1, -1]
// 
//
// 示例2: 
//
//  输入：
//["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
//[[2], [1], [2], [3], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, 3]
// 
// Related Topics 栈 设计 链表 👍 49 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackOfPlatesLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class StackOfPlates {
        private Integer singlePlateCapacity;
        private List<Deque<Integer>> plates;

        public StackOfPlates(int cap) {
            if (cap < 0) {
                throw new IllegalArgumentException();
            }
            this.singlePlateCapacity = cap;
            plates = new ArrayList<>();
        }

        public void push(int val) {
            if (singlePlateCapacity <= 0) {
                return;
            }
            if (plates.isEmpty() || plates.get(plates.size() - 1).size() == singlePlateCapacity) {
                plates.add(new LinkedList<>());
            }
            plates.get(plates.size() - 1).addLast(val);
        }

        public int pop() {
//            if (plates.isEmpty()) {
//                return -1;
//            }
//            int res = plates.get(plates.size() - 1).pollLast();
//            if (plates.get(plates.size() - 1).isEmpty()) {
//                plates.remove(plates.size() - 1);
//            }
//            return res;
            if (plates.isEmpty()) {
                return -1;
            }
            int res = plates.get(plates.size() - 1).pollLast();
            if (plates.get(plates.size() - 1).isEmpty()) {
                plates.remove(plates.size() - 1);
            }
            return res;
        }

        public int popAt(int index) {
            if (index < 0 || index >= plates.size() || plates.isEmpty()) {
                return -1;
            }
            int res = plates.get(index).pollLast();
            if (plates.get(index).isEmpty()) {
                plates.remove(index);
            }
            return res;
//            // 如果索引不合法，并且没有盘子了，就返回-1
//            if(index < 0 || index >= plates.size() || plates.isEmpty()){
//                return -1;
//            }
//            int result = plates.get(index).pollLast();
//            if(plates.get(index).isEmpty()){
//                plates.remove(index);
//            }
//            return result;
        }
    }

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
