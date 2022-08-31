//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
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
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
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
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1441 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode mergeKLists_20220426(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (!pq.isEmpty()) {
            ListNode curMin = pq.poll();
            p.next = curMin;
            if (curMin.next != null) {
                pq.add(curMin.next);
            }
            p = p.next;
        }
        return dummyHead.next;


    }




    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
//        return f(lists, 0, lists.length - 1);

        return mergeKLists_20220426(lists);
    }























    private ListNode f(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        ListNode l1 = f(lists, left, (left + right) / 2);
        ListNode l2 = f(lists, (left + right) / 2 + 1, right);
        return mergeTwoSortedLists(l1, l2);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode preNewHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, pNew = preNewHead;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pNew.next = p1;
                p1 = p1.next;
            } else {
                pNew.next = p2;
                p2 = p2.next;
            }
            pNew = pNew.next;
        }
        if (p1 != null) {
            pNew.next = p1;
        }
        if (p2 != null) {
            pNew.next = p2;
        }
        return preNewHead.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
