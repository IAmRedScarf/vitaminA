//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 242 👎 0


package com.qiuyu.leetcode.editor.cn;

import com.qiuyu.leetcode.editor.cn.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
        public int[] reversePrint(ListNode head) {
            List<Integer> tmpRes = new ArrayList<>();
            recurse(head, tmpRes);
            int[] res = new int[tmpRes.size()];
            for (int i = 0; i < res.length; ++i) {
                res[i] = tmpRes.get(i);
            }
            return res;
        }
        private void recurse(ListNode head, List<Integer> res) {
            if (head == null) {
                return;
            }
            recurse(head.next, res);
            res.add(head.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
