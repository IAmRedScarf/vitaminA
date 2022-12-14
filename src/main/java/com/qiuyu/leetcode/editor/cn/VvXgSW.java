//给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// 
//
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 50 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class VvXgSW {
    public static void main(String[] args) {
        Solution solution = new VvXgSW().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKList_202208080_02(lists);
        }


        public ListNode mergeKList_202208080_02(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            int n = lists.length;

            return mergeKList_202208080_02(lists, 0, lists.length - 1);
        }

        public ListNode mergeKList_202208080_02(ListNode[] lists, int left, int right) {
            if (left >= right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode l1 = mergeKList_202208080_02(lists, left, mid);
            ListNode l2 = mergeKList_202208080_02(lists, mid + 1, right);
            return merge2List(l1, l2);

        }

        private ListNode merge2List(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead, p1 = l1, p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }
            while (p1 != null) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
            while (p2 != null) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
            return dummyHead.next;

        }


        public ListNode mergeKLists_20220808_01(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head);
                }
            }
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (!pq.isEmpty()) {
                ListNode min = pq.poll();
                p.next = min;
                p = p.next;
                if (min.next != null) {
                    pq.add(min.next);
                }
            }
            return dummyHead.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
