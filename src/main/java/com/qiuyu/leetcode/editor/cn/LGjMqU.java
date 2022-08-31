//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 👍 64 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode ps = head, pf = head;
        while (pf.next != null && pf.next.next != null) {
            ps = ps.next;
            pf = pf.next.next;
        }
        ListNode p1 = head, p2 = ps.next;
        ps.next = null;

        p2 = reverseList(p2);

        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = head.next;
            head.next = p2;
            head = p2.next;
            p2 = tmp;
        }


    }


    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = next;
            next = cur;
            cur = tmp;
        }
        return next;
    }




    public void reorderList_20220728(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode ps = head, pf = head;
        while (pf.next != null && pf.next.next != null) {
            ps = ps.next;
            pf = pf.next.next;
        }
        // 将链表等分
        ListNode p1 = head, p2 = ps.next;
        ps.next = null;
        Deque<ListNode> tmpStack = new LinkedList<>();
        ListNode p = p2;
        ListNode tmp;
        while (p != null) {
            tmp = p.next;
            p.next = null;
            tmpStack.addLast(p);
            p = tmp;
        }
        p = p1;

        while (p != null) {
            tmp = p.next;
            if (!tmpStack.isEmpty()) {
                p.next = tmpStack.pollLast();
                p.next.next = tmp;
            }
            p = tmp;
        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
