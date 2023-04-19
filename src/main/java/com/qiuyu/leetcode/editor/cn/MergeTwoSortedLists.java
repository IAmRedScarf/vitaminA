//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1823 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            return mergeTwoLists20230409(l1, l2);
        }


        public ListNode mergeTwoLists20230409(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
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



        public ListNode mergeTwoLists_20220513(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead, p1 = l1, p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
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



        public ListNode mergeTwoLists_old(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode pNewHead = new ListNode(0);
            ListNode p1 = l1, p2 = l2, pNew = pNewHead;

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
            } else {
                pNew.next = p2;
            }
            return pNewHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
