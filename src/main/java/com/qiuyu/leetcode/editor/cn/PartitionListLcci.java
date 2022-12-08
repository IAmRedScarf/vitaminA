

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你不需要 保留 每个分区中各节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 👍 120 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

public class PartitionListLcci {
    public static void main(String[] args) {
        Solution solution = new PartitionListLcci().new Solution();
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(3);
        ListNode a6 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        ListNode aa = solution.partition(a1, 2);
        System.out.println("aaa");

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode d1 = new ListNode(), p1 = d1;
            ListNode d2 = new ListNode(), p2 = d2;
            ListNode d3 = new ListNode(), p3 = d3;
            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    p1.next = p;
                    p1 = p1.next;
                } else if (p.val == x) {
                    p2.next = p;
                    p2 = p2.next;
                } else {
                    p3.next = p;
                    p3 = p3.next;
                }
                p = p.next;
            }
            p1.next = d2.next;
            p2.next = d3.next;
            return d1.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
