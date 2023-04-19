//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 自定义评测： 
//
// 评测系统 的输入如下（你设计的程序 不适用 此输入）： 
//
// 
// intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0 
// listA - 第一个链表 
// listB - 第二个链表 
// skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数 
// skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数 
// 
//
// 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
//作正确答案 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 👍 1510 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        b1.next = b2;
        b2.next = b3;
        b3.next = a2;
        solution.getIntersectionNode(a1, b1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            return getIntersectionNode20230407(headA, headB);
        }

        public ListNode getIntersectionNode20230407(ListNode headA, ListNode headB) {
            int lenA = 0, lenB = 0;
            ListNode p = headA;
            while (p != null) {
                lenA++;
                p = p.next;
            }
            p = headB;
            while (p != null) {
                lenB++;
                p = p.next;
            }
            return lenA > lenB ? getIntersectionNode20230407(headA, lenA, headB, lenB) : getIntersectionNode20230407(headB, lenB, headA, lenA);


        }

        private ListNode getIntersectionNode20230407(ListNode l1, int len1, ListNode l2, int len2) {
            if (len1 < len2 || len1 <= 0 || len2 <= 0) {
                return null;
            }
            ListNode p1 = l1, p2 = l2;
            for (int i = 0; i < len1 - len2; ++i) {
                p1 = p1.next;
            }
            while (p1 != null) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return null;

        }
















        public ListNode getIntersectionNode_20220514(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            int len1 = 0, len2 = 0;
            ListNode p = headA;
            while (p != null) {
                len1++;
                p = p.next;
            }
            p = headB;
            while (p != null) {
                len2++;
                p = p.next;
            }
            ListNode longHead = headA, shortHead = headB;
            if (len1 < len2) {
                ListNode tmp = longHead;
                longHead = shortHead;
                shortHead = tmp;
            }
            ListNode p1 = longHead, p2 = shortHead;
            for (int i = 0; i < Math.abs(len1 - len2); ++i) {
                p1 = p1.next;
            }
            while (p1 != null && p2 != null) {
                if (p1 == p2) {
                    return p1;
                } else {
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
            return null;


        }



        public ListNode getIntersectionNode_old(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            int longLen = 0, shortLen = 0;
            ListNode longHead = headA, shortHead = headB;
            ListNode p = headA;
            while (p != null) {
                longLen++;
                p = p.next;
            }
            p = headB;
            while (p != null) {
                shortLen++;
                p = p.next;
            }
            if (longLen < shortLen) {
                int tmp = longLen;
                longLen = shortLen;
                shortLen = tmp;
                longHead = headB;
                shortHead = headA;
            }
            int diff = longLen - shortLen;
            p = longHead;
            for (int i = 0; i < diff; ++i) {
                p = p.next;
            }
            ListNode p1 = p, p2 = shortHead;
            while (p1 != null && p2 != null) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return null;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
