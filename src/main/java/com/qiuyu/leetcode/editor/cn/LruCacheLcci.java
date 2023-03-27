//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache20222222222 cache = new LRUCache20222222222( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 175 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCacheLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private int capacity;
        private Map<Integer, DoubleLinkedListNode> cacheMap;
        private DoubleLinkedListNode dummyHead;
        private DoubleLinkedListNode dummyTail;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new HashMap<>();
            this.dummyHead = new DoubleLinkedListNode();
            this.dummyTail = new DoubleLinkedListNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public int get(int key) {
            if (cacheMap.containsKey(key)) {
                DoubleLinkedListNode node = cacheMap.get(key);
                moveNode2Head(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                DoubleLinkedListNode node = cacheMap.get(key);
                if (node.value != value) {
                    node.value = value;
                }
                moveNode2Head(node);
                return;
            }
            if (cacheMap.size() == capacity) {
                DoubleLinkedListNode need2Remove = this.dummyTail.pre;
                removeNode(need2Remove);
                cacheMap.remove(need2Remove.key);
            }
            DoubleLinkedListNode need2Put = new DoubleLinkedListNode(key, value);
            cacheMap.put(key, need2Put);
            putNodeAfter(need2Put, dummyHead);
        }

        private void moveNode2Head(DoubleLinkedListNode node) {
            removeNode(node);
            putNodeAfter(node, dummyHead);
        }


        private void removeNode(DoubleLinkedListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = null;
            node.pre = null;
        }



        private void putNodeAfter(DoubleLinkedListNode node, DoubleLinkedListNode target) {
            node.next = target.next;
            node.pre = target;

            target.next.pre = node;
            target.next = node;

        }

    }

    class DoubleLinkedListNode {
        public int key;
        public int value;

        public DoubleLinkedListNode pre;
        public DoubleLinkedListNode next;

        public DoubleLinkedListNode() {}
        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

/**
 * Your LRUCache20222222222 object will be instantiated and called as such:
 * LRUCache20222222222 obj = new LRUCache20222222222(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
