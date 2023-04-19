//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7080 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addTwoNumbers20230417(l1, l2);

        }


        public ListNode addTwoNumbers20230417(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            int add = 0;
            ListNode p1 = l1, p2 = l2;
            ListNode dummyHead = new ListNode(0);
            ListNode p = dummyHead;
            while (p1 != null && p2 != null) {
                int sum = p1.val + p2.val + add;
                p.next = new ListNode(sum % 10);
                p = p.next;
                add = sum / 10;
                p1 = p1.next;
                p2 = p2.next;
            }
            while (p1 != null) {
                int sum = p1.val + add;
                p.next = new ListNode(sum % 10);
                p = p.next;
                add = sum / 10;
                p1 = p1.next;
            }
            while (p2 != null) {
                int sum = p2.val + add;
                p.next = new ListNode(sum % 10);
                p = p.next;
                add = sum / 10;
                p2 = p2.next;
            }
            if (add > 0) {
                p.next = new ListNode(add);
            }
            return dummyHead.next;
        }








        public ListNode addTwoNumbers20230214(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode p1 = l1, p2 = l2;
            ListNode dummyHead = new ListNode();
            ListNode p = dummyHead;
            int carry = 0;
            while (p1 != null && p2 != null) {
                int sum = p1.val + p2.val + carry;
                p.next = new ListNode(sum % 10);
                carry = sum / 10;
                p1 = p1.next;
                p2 = p2.next;
                p = p.next;
            }
            while (p1 != null) {
                int sum = p1.val + carry;
                p.next = new ListNode(sum % 10);
                carry = sum / 10;
                p1 = p1.next;
                p = p.next;
            }

            while (p2 != null) {
                int sum = p2.val + carry;
                p.next = new ListNode(sum % 10);
                carry = sum / 10;
                p2 = p2.next;
                p = p.next;
            }

            if (carry != 0) {
                p.next = new ListNode(carry);
            }
            return dummyHead.next;



        }












        private ListNode addTwoNumbers_20220426(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode p1 = l1, p2 = l2;
            ListNode dummyHead = new ListNode(0);
            ListNode pNew = dummyHead;
            int another = 0;
            while (p1 != null && p2 != null) {
                int sum = p1.val + p2.val + another;
                pNew.next = new ListNode(sum % 10);
                pNew = pNew.next;
                another = sum / 10;
                p1 = p1.next;
                p2 = p2.next;
            }
            while (p1 != null) {
                int sum = p1.val + another;
                pNew.next = new ListNode(sum % 10);
                another = sum / 10;
                pNew = pNew.next;
                p1 = p1.next;

            }
            while (p2 != null) {
                int sum = p2.val + another;
                pNew.next = new ListNode(sum % 10);
                another = sum / 10;
                pNew = pNew.next;
                p2 = p2.next;
            }
            if (another != 0) {
                pNew.next = new ListNode(another);
            }
            return dummyHead.next;
        }








        public ListNode addTwoNumbers2200000(ListNode l1, ListNode l2) {
            return addTwoNumbers_20220426(l1, l2);
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            ListNode preHead = new ListNode(0);
//
//            ListNode p1 = l1, p2 = l2, pNew = preHead;
//            int tmp = 0;
//            while (p1 != null && p2 != null) {
//                int sum = p1.val + p2.val + tmp;
//                pNew.next = new ListNode(sum % 10);
//                tmp = sum / 10;
//                p1 = p1.next;
//                p2 = p2.next;
//                pNew = pNew.next;
//            }
//
//            while (p1 != null) {
//                int sum = p1.val + tmp;
//                pNew.next = new ListNode(sum % 10);
//                tmp = sum / 10;
//                p1 = p1.next;
//                pNew = pNew.next;
//            }
//
//            while (p2 != null) {
//                int sum = p2.val + tmp;
//                pNew.next = new ListNode(sum % 10);
//                tmp = sum / 10;
//                p2 = p2.next;
//                pNew = pNew.next;
//            }
//
//            if (tmp != 0) {
//                pNew.next = new ListNode(tmp);
//            }
//            return preHead.next;














//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            int curNum, highNum = 0;
//            ListNode p1 = l1, p2 = l2;
//            ListNode preSum = new ListNode();
//            ListNode pSum = preSum;
//            while (p1 != null || p2 != null) {
//
//                int curRealSum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + highNum;
//
//                curNum = curRealSum % 10;
//                highNum = curRealSum / 10;
//
//                pSum.next = new ListNode(curNum);
//                pSum = pSum.next;
//                if (p1 != null) {
//                    p1 = p1.next;
//                }
//                if (p2 != null) {
//                    p2 = p2.next;
//                }
//            }
//            if (highNum != 0) {
//                pSum.next = new ListNode(highNum);
//            }
//
//            return preSum.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
