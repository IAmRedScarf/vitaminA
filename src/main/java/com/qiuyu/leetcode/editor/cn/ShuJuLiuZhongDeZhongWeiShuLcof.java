//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
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
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-
//stream/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 315 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShuJuLiuZhongDeZhongWeiShuLcof {


    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private PriorityQueue<Integer> pq1;
        private PriorityQueue<Integer> pq2;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
            pq2 = new PriorityQueue<>((o1, o2) -> o1 - o2);
        }

        public void addNum(int num) {
            if (pq1.size() == pq2.size()) {
                if (pq1.size() == 0 || num < pq2.peek()) {
                    pq1.add(num);
                } else {
                    pq1.add(pq2.poll());
                    pq2.add(num);
                }
            } else {
                if (num < pq1.peek()) {
                    pq2.add(pq1.poll());
                    pq1.add(num);
                } else {
                    pq2.add(num);
                }
            }
        }

        public double findMedian() {
            if (pq1.size() == pq2.size()) {
                return (pq1.peek() + pq2.peek()) / 2.0;
            } else {
                return pq1.peek();
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
