//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 622 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.List;

public class DesignLinkedList {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        private DoubleLinkedListNode dummyHead;
        private DoubleLinkedListNode dummyTail;
        private int size;

        public MyLinkedList() {
            dummyHead = new DoubleLinkedListNode(0);
            dummyTail = new DoubleLinkedListNode(0);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            DoubleLinkedListNode p = dummyHead.next;
            for (int i = 0; i < size; ++i) {
                if (i == index) {
                    return p.val;
                }
                p = p.next;
            }
            return -1;

        }

        public void addAtHead(int val) {
            DoubleLinkedListNode node = new DoubleLinkedListNode(val);
            addBefore(node, dummyHead.next);

        }

        public void addAtTail(int val) {
            DoubleLinkedListNode node = new DoubleLinkedListNode(val);
            node.pre = dummyTail.pre;
            dummyTail.pre = node;
            node.next = dummyTail;
            node.pre.next = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            DoubleLinkedListNode nodeAtIndex = dummyHead.next;
            if (index > 0) {
                for (int i = 1; i <= index; ++i) {
                    nodeAtIndex = nodeAtIndex.next;
                }
            }
            DoubleLinkedListNode nodeForInsert = new DoubleLinkedListNode(val);
            addBefore(nodeForInsert, nodeAtIndex);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            DoubleLinkedListNode p = dummyHead.next;
            for (int i = 1; i <= index; ++i) {
                p = p.next;
            }
            deleteNode(p);

        }

        private void addBefore(DoubleLinkedListNode nodeForInsert, DoubleLinkedListNode target) {
            nodeForInsert.pre = target.pre;
            target.pre = nodeForInsert;
            nodeForInsert.next = target;
            nodeForInsert.pre.next = nodeForInsert;
            size++;
        }

        private void deleteNode(DoubleLinkedListNode nodeForDelete) {
            nodeForDelete.pre.next = nodeForDelete.next;
            nodeForDelete.next.pre = nodeForDelete.pre;
            size--;
        }

    }


    class DoubleLinkedListNode {
        public int val;
        public DoubleLinkedListNode pre;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode(int val) {
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
