//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1243 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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

        public boolean isPalindrome_20220515(ListNode head) {
            ListNode fast = head, slow = head;
            ListNode slowPre = null;
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
                slowPre = slow;
                slow = slow.next;
            }
            ListNode halfReverseHead = reverse_20220515(slow);
            boolean res = true;
            ListNode p1 = head, p2 = halfReverseHead;
            while (p2 != null) {
                if (p1.val != p2.val) {
                    res = false;
                    break;
                } else {
                    p2 = p2.next;
                    p1 = p1.next;
                }
            }
            slowPre.next = reverse_20220515(halfReverseHead);
            return res;

        }


        public ListNode reverse_20220515(ListNode head) {
            ListNode pre = null, cur = head, next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }


        public boolean isPalindrome(ListNode head) {
            return isPalindrome_20220515(head);
        }



        public boolean isPalindrome_old(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            int len = 0;
            ListNode p = head;
            while (p != null) {
                ++len;
                p = p.next;
            }
            int halfLen = len / 2;
            ListNode aTail = head;
            for (int i = 0; i < halfLen - 1; ++i) {
                aTail = aTail.next;
            }
            ListNode bHead = len % 2 == 1 ? aTail.next.next : aTail.next;
            ListNode bNewHead = reverse(bHead);
            boolean res = true;
            ListNode pA = head, pB = bNewHead;
            while (pA != null && pB != null) {
                if (pA.val != pB.val) {
                    res = false;
                    break;
                }
                pA = pA.next;
                pB = pB.next;
            }
            ListNode bOldHead = reverse(bNewHead);
            if (len % 2 == 1) {
                aTail.next.next = bOldHead;
            } else {
                aTail.next = bOldHead;
            }
            return res;

        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head, next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
