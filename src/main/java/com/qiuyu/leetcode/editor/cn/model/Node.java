package com.qiuyu.leetcode.editor.cn.model;

/**
 * @author qiuyu13
 * @date 2022/5/29
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
