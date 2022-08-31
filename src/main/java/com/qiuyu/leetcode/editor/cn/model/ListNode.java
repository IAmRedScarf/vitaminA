package com.qiuyu.leetcode.editor.cn.model;

/**
 * @author qiuyu13
 * @date 2021/8/1
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
