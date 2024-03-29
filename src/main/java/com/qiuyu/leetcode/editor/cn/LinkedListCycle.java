//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 哈希表 链表 双指针 👍 1306 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            return hasCycle20230407(head);
        }


        public boolean hasCycle20230407(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode pf = head, ps = head;
//            do {
//                pf = pf.next;
//                if (pf == null) {
//                    return false;
//                }
//                pf = pf.next;
//                ps = ps.next;
//            } while (pf != ps && pf != null);
//
//            return pf != null;

            while (pf != null && pf.next != null) {
                pf = pf.next.next;
                ps = ps.next;
                if (pf == ps) {
                    return true;
                }
            }
            return false;

        }








        public boolean hasCycle_20220513(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode p1 = head, p2 = head;
            while (p1 != null && p1.next != null) {
                p1 = p1.next.next;
                p2 = p2.next;
                if (p1 == p2) {
                    return true;
                }
            }
            return false;
        }




        public boolean hasCycle_old(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode pFast = head, pSlow = head;
            while (pFast != null && pFast.next != null) {
                pFast = pFast.next.next;
                pSlow = pSlow.next;
                if (pFast == pSlow) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
