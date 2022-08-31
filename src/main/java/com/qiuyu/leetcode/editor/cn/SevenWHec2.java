//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 70 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class SevenWHec2 {
    public static void main(String[] args) {
        Solution solution = new SevenWHec2().new Solution();
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p1 = head, p2 = head;

            while (p2.next != null && p2.next.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            ListNode half = p1.next;
            p1.next = null;

            ListNode l1 = sortList(head);
            ListNode l2 = sortList(half);
            return merge2SortedList(l1, l2);


        }

        private ListNode merge2SortedList(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = dummyHead;
            ListNode p1 = l1, p2 = l2;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}
