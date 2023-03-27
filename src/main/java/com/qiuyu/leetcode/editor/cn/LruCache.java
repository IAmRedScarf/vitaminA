//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类：
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1554 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private int capacity;
        private Map<Integer, DoubleLinkedListNode> keyValueMap;
        private DoubleLinkedListNode dummyHead;
        private DoubleLinkedListNode dummyTail;
        private int size;


        public LRUCache(int capacity) {
            if (capacity < 1) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            keyValueMap = new HashMap<>();
            dummyHead = new DoubleLinkedListNode();
            dummyTail = new DoubleLinkedListNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            this.size = 0;
        }

        public int get(int key) {
            if (!keyValueMap.containsKey(key)) {
                return -1;
            }
            DoubleLinkedListNode node = keyValueMap.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (keyValueMap.containsKey(key)) {
                DoubleLinkedListNode toBeUpdated = keyValueMap.get(key);
                toBeUpdated.value = value;
                moveToHead(toBeUpdated);
                return;
            }
            if (size == capacity) {
                DoubleLinkedListNode toBeDeleted = dummyTail.pre;
                removeNode(toBeDeleted);
                keyValueMap.remove(toBeDeleted.key);
                size--;
            }
            DoubleLinkedListNode toBeInserted = new DoubleLinkedListNode(key, value);
            insertAfter(toBeInserted, dummyHead);
            keyValueMap.put(key, toBeInserted);
            size++;
        }

        private void moveToHead(DoubleLinkedListNode node) {
            removeNode(node);
            insertAfter(node, dummyHead);
        }

        private void removeNode(DoubleLinkedListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }

        private void insertAfter(DoubleLinkedListNode node, DoubleLinkedListNode target) {
            node.next = target.next;
            node.pre = target;

            target.next = node;
            node.next.pre = node;

        }







    }










    class LRUCache20222222222 {
        private int capacity;
        private Map<Integer, DoubleLinkedListNode> cacheMap;
        private DoubleLinkedListNode dummyHead = new DoubleLinkedListNode(0, 0);
        private DoubleLinkedListNode dummyTail = new DoubleLinkedListNode(0, 0);

        public LRUCache20222222222(int capacity) {
            this.capacity = capacity;
            cacheMap = new HashMap<>();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;
            }
            DoubleLinkedListNode targetNode = cacheMap.get(key);
            removeNode(targetNode);
            addToHead(targetNode);
            return targetNode.value;
        }


        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                DoubleLinkedListNode targetNode = cacheMap.get(key);
                targetNode.value = value;
                removeNode(targetNode);
                addToHead(targetNode);
            } else {
                if (cacheMap.size() == capacity) {
                    DoubleLinkedListNode curTail = dummyTail.pre;
                    cacheMap.remove(curTail.key);
                    removeNode(curTail);
                }
                DoubleLinkedListNode targetNode = new DoubleLinkedListNode(key, value);
                cacheMap.put(key, targetNode);
                addToHead(targetNode);

            }
        }




        private void removeNode(DoubleLinkedListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(DoubleLinkedListNode node) {
            node.next = dummyHead.next;
            node.pre = dummyHead;

            dummyHead.next = node;
            node.next.pre = node;

        }


    }
    class DoubleLinkedListNode {
        public int key;
        public int value;
        public DoubleLinkedListNode pre;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode() {

        }

        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }















    class LRUCache_old {
        public Map<Integer, DoubleLinkedListNode_old> cacheMap;
        public DoubleLinkedListNode_old dummyHead;
        public DoubleLinkedListNode_old dummyTail;
        public int capacity;
        public int curSize;


        public LRUCache_old(int capacity) {
            cacheMap = new HashMap<>();
            this.capacity = capacity;
            this.curSize = 0;

            dummyHead = new DoubleLinkedListNode_old(0, 0);
            dummyTail = new DoubleLinkedListNode_old(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }


        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;
            }
            DoubleLinkedListNode_old curNode = cacheMap.get(key);
            moveToHead(curNode);
            return curNode.val;

        }

        public void put(int key, int val) {
            if (cacheMap.containsKey(key)) {
                DoubleLinkedListNode_old targetNode = cacheMap.get(key);
                targetNode.val = val;
                moveToHead(targetNode);
            } else {
                if (curSize == capacity) {
                    DoubleLinkedListNode_old curTail = dummyTail.pre;
                    removeNode(curTail);
                    cacheMap.remove(curTail.key);
                    curSize--;
                }
                DoubleLinkedListNode_old node = new DoubleLinkedListNode_old(key, val);
                cacheMap.put(key, node);
                addToHead(node);
                curSize++;
            }
        }


        private void addToHead(DoubleLinkedListNode_old node) {
            node.next = dummyHead.next;
            node.pre = dummyHead;

            dummyHead.next.pre = node;
            dummyHead.next = node;

        }

        private void moveToHead(DoubleLinkedListNode_old node) {
            if (node == dummyHead.next) {
                return;
            }
            removeNode(node);
            addToHead(node);
        }


        private void removeNode(DoubleLinkedListNode_old node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }


    }

    class DoubleLinkedListNode_old {
        public int key;
        public int val;
        public DoubleLinkedListNode_old pre;
        public DoubleLinkedListNode_old next;

        public DoubleLinkedListNode_old(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DoubleLinkedListNode_old(int key, int val, DoubleLinkedListNode_old pre, DoubleLinkedListNode_old next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }


    }


//    class LRUCache20222222222 {
//        private int capacity;
//
//        private int curSize;
//
//        private Map<Integer, DoubleLinkedListNode> cacheMap;
//        private DoubleLinkedListNode preHead;
//        private DoubleLinkedListNode nextTail;
//
//
//        public LRUCache20222222222(int capacity) {
//            this.capacity = capacity;
//            this.curSize = 0;
//
//            cacheMap = new HashMap<>();
//
//            preHead = new DoubleLinkedListNode();
//            nextTail = new DoubleLinkedListNode();
//
//            // 加上伪头部和伪尾部
//            preHead.next = nextTail;
//            nextTail.pre = preHead;
//        }
//
//        public int get(int key) {
//            if (cacheMap.containsKey(key)) {
//                DoubleLinkedListNode curNode = cacheMap.get(key);
//
//                moveToHead(curNode);
//
//                return curNode.val;
//            }
//            return -1;
//        }
//
//        public void put(int key, int value) {
//            if (cacheMap.containsKey(key)) {
//                DoubleLinkedListNode curNode = cacheMap.get(key);
//                curNode.val = value;
//                moveToHead(curNode);
//            } else {
//                if (this.curSize == this.capacity) {
//                    DoubleLinkedListNode tailNode = nextTail.pre;
//                    cacheMap.remove(tailNode.key);
//                    removeNode(tailNode);
//                    this.curSize--;
//                }
//                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
//                cacheMap.put(key, node);
//                addToHead(node);
//
//                this.curSize++;
//            }
//        }
//
//        private void removeNode(DoubleLinkedListNode curNode) {
//            curNode.pre.next = curNode.next;
//            curNode.next.pre = curNode.pre;
//        }
//
//        private void addToHead(DoubleLinkedListNode node) {
//            node.pre = preHead;
//            node.next = preHead.next;
//            preHead.next.pre = node;
//            preHead.next = node;
//        }
//
//
//        private void moveToHead(DoubleLinkedListNode node) {
//            removeNode(node);
//            addToHead(node);
//        }
//
//
//    }
//
//    class DoubleLinkedListNode {
//        public int key;
//        public int val;
//        public DoubleLinkedListNode pre;
//        public DoubleLinkedListNode next;
//
//        public DoubleLinkedListNode() {
//        }
//
//        public DoubleLinkedListNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//
//        public DoubleLinkedListNode(int key, int val, DoubleLinkedListNode pre, DoubleLinkedListNode next) {
//            this.key = key;
//            this.val = val;
//            this.pre = pre;
//            this.next = next;
//        }
//
//    }


/**
 * Your LRUCache20222222222 object will be instantiated and called as such:
 * LRUCache20222222222 obj = new LRUCache20222222222(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
