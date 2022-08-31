//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 673 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        }

        public void addNum(int num) {
            int leftSize = maxHeap.size(), rightSize = minHeap.size();
            if (leftSize > rightSize) {
                int maxOfLeft = maxHeap.peek();
                if (num >= maxOfLeft) {
                    minHeap.add(num);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
            } else if (leftSize == rightSize) {
                if (rightSize == 0) {
                    maxHeap.add(num);
                    return;
                }
                int minOfRight = minHeap.peek();
                if (num <= minOfRight) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }
            }
        }

        public double findMedian() {
            int leftSize = maxHeap.size(), rightSize = minHeap.size();
            if (leftSize == 0) {
                throw new IllegalArgumentException();
            }
            if (leftSize == rightSize) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return (double) maxHeap.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
