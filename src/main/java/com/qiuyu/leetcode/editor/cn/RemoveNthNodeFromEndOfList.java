//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1480 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            return removeNthFromEnd20230214(head, n);
        }

        public ListNode removeNthFromEnd20230214(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode fast = head;
            int i = 0;
            while (i < n && fast != null) {
                fast = fast.next;
                ++i;
            }
            if (i < n) {
                return null;
            }
            ListNode p = dummyHead;
            while (fast != null) {
                p = p.next;
                fast = fast.next;
            }
            p.next = p.next.next;
            return dummyHead.next;


        }












        public ListNode removeNthFromEnd_20220426(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode p = head;
            for (int i = 0; i < n - 1 && p != null; ++i) {
                p = p.next;
            }
            ListNode p1Pre = dummyHead, p1 = head;
            while (p.next != null) {
                p = p.next;
                p1 = p1.next;
                p1Pre = p1Pre.next;
            }
            p1Pre.next = p1.next;
            return dummyHead.next;

        }







        public ListNode removeNthFromEnd222222222(ListNode head, int n) {
            return removeNthFromEnd_20220426(head, n);
//            if (head == null) {
//                return null;
//            }
//            ListNode preHead = new ListNode(0, head);
//            ListNode p = head;
//
//            // p最后可能为null
//            for (int i = 0; i < n; ++i) {
//                if (p != null) {
//                    p = p.next;
//                }
//            }
//
//            ListNode pre = preHead, cur = head;
//            while (p != null) {
//                p = p.next;
//                pre = cur;
//                cur = cur.next;
//            }
//            pre.next = cur.next;
//            return preHead.next;
























//            ListNode preHead = new ListNode(0, head);
//            ListNode p1 = preHead, p2 = preHead;
//            for (int i = 0; i < n; ++i) {
//                if (p2 == null) {
//                    return null;
//                }
//                p2 = p2.next;
//            }
//            while (p2 != null && p2.next != null) {
//                p2 = p2.next;
//                p1 = p1.next;
//            }
//            p1.next = p1.next.next;
//            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
