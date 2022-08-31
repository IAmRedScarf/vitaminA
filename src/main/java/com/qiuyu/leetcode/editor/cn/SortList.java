//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
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
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1443 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        solution.sortList_20220503(n1);
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

        public ListNode sortList_20220503(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode ps = head, pf = head;
            while (pf != null) {
                pf = pf.next;
                if (pf != null) {
                    pf = pf.next;
                }
                ps = ps.next;
            }
            // 将链表分割成两部分，ps为第二部分的头部
            ListNode p = head;
            while (p.next != ps) {
                p = p.next;
            }
            // 将第一部分尾部置为null
            p.next = null;

            ListNode p1New = sortList_20220503(head);
            ListNode p2New = sortList_20220503(ps);
            return merge2SortedList_20220503(p1New, p2New);

        }


        private ListNode merge2SortedList_20220503(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummyHead = new ListNode(0);
            ListNode p1 = l1, p2 = l2;
            ListNode p = dummyHead;
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


        public ListNode sortList(ListNode head) {
            return sortList_20220503(head);
        }


















        public ListNode merge2SortedList(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummyHead = new ListNode(0);
            ListNode pre = dummyHead, p1 = l1, p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    pre.next = p1;
                    p1 = p1.next;
                } else {
                    pre.next = p2;
                    p2 = p2.next;
                }
                pre = pre.next;
            }
            if (p1 != null) {
                pre.next = p1;
            }
            if (p2 != null) {
                pre.next = p2;
            }
            return dummyHead.next;
        }

        public ListNode sortList_old(ListNode head) {
//            if (head == null) {
//                return null;
//            }
//            if (head.next == null) {
//                return head;
//            }
//            ListNode p1 = head, p2 = head;
//            while (p2 != null) {
//                p1 = p1.next;
//                p2 = p2.next;
//                if (p2 != null) {
//                    p2 = p2.next;
//                }
//            }
//            ListNode tmpP = head;
//            while (tmpP.next != p1) {
//                tmpP = tmpP.next;
//            }
//            tmpP.next = null;
//            ListNode pNew1 = sortList(head);
//            ListNode pNew2 = sortList(p1);
//            return merge2SortedList(pNew1, pNew2);


//            return sortList(head, null);
            return anotherSortList(head);
        }


        private ListNode merge2List(ListNode aHead, ListNode bHead) {
            if (aHead == null) {
                return bHead;
            }
            if (bHead == null) {
                return aHead;
            }
            ListNode dummyHead = new ListNode(0);

            ListNode pA = aHead, pB = bHead, pNew = dummyHead;
            while (pA != null && pB != null) {
                if (pA.val < pB.val) {
                    pNew.next = pA;
                    pA = pA.next;
                } else {
                    pNew.next = pB;
                    pB = pB.next;
                }
                pNew = pNew.next;
            }
            if (pA == null) {
                pNew.next = pB;
            } else {
                pNew.next = pA;
            }
            return dummyHead.next;
        }


        public ListNode anotherSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = head;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            for (int subLen = 1; subLen <= len; subLen <<= 1) {
                ListNode pre = dummyHead, cur = pre.next;
                while (cur != null) {
                    ListNode head1 = cur;
                    for (int i = 1; i < subLen && cur.next != null; ++i) {
                        cur = cur.next;
                    }
                    ListNode head2 = cur.next;
                    cur.next = null;
                    cur = head2;
                    for (int i = 1; i < subLen && cur != null; ++i) {
                        cur = cur.next;
                    }
                    ListNode next = null;
                    if (cur != null) {
                        next = cur.next;
                        cur.next = null;
                    }
                    pre.next = merge2List(head1, head2);

                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    cur = next;
                }
            }
            return dummyHead.next;


//            int len = 0;
//            ListNode p = head;
//            while (p != null) {
//                ++len;
//                p = p.next;
//            }
//            ListNode dummyHead = new ListNode(0, head);
//            for (int subLen = 1; subLen < len; subLen <<= 1) {
//                ListNode pre = dummyHead, cur = pre.next;
//                while (cur != null) {
//                    ListNode head1 = cur;
//                    for (int i = 1; i < subLen && cur.next != null; ++i) {
//                        cur = cur.next;
//                    }
//                    ListNode head2 = cur.next;
//                    cur.next = null;
//                    cur = head2;
//                    for (int i = 1; i < subLen && cur != null; ++i) {
//                        cur = cur.next;
//                    }
//                    ListNode next = null;
//                    if (cur != null) {
//                        next = cur.next;
//                        cur.next = null;
//                    }
//                    pre.next = merge2List(head1, head2);
//                    while (pre.next != null) {
//                        pre = pre.next;
//                    }
//                    cur = next;
//                }
//            }
//            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
