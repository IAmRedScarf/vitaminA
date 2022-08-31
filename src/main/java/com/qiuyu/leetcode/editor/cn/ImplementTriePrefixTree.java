//Trie_20220429（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie_20220429 类：
//
// 
// Trie_20220429() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie_20220429", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie_20220429 trie = new Trie_20220429();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 842 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private boolean isEnd;
        private Trie[] next;

        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Trie();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;

        }

        public boolean search(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie cur = this;
            for (int i = 0; i < prefix.length(); ++i) {
                char c = prefix.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)










    class Trie_20220429 {
        private boolean isEnd;
        private Trie_20220429[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie_20220429() {
            this.next = new Trie_20220429[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie_20220429 curNode = this;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (curNode.next[index] == null) {
                    curNode.next[index] = new Trie_20220429();
                }
                curNode = curNode.next[index];
            }
            curNode.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie_20220429 curNode = this;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (curNode.next[index] == null) {
                    return false;
                }
                curNode = curNode.next[index];
            }
            return curNode.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie_20220429 curNode = this;
            for (int i = 0; i < prefix.length(); ++i) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (curNode.next[index] == null) {
                    return false;
                }
                curNode = curNode.next[index];
            }
            return true;
        }
    }

/**
 * Your Trie_20220429 object will be instantiated and called as such:
 * Trie_20220429 obj = new Trie_20220429();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


}
