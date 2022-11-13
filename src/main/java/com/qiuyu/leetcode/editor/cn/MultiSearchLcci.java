//给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字
//符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。 
//
// 示例： 
//
// 输入：
//big = "mississippi"
//smalls = ["is","ppi","hi","sis","i","ssippi"]
//输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
// 
//
// 提示： 
//
// 
// 0 <= len(big) <= 1000 
// 0 <= len(smalls[i]) <= 1000 
// smalls的总字符数不会超过 100000。 
// 你可以认为smalls中没有重复字符串。 
// 所有出现的字符均为英文小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 滑动窗口 👍 43 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiSearchLcci {
    public static void main(String[] args) {
        Solution solution = new MultiSearchLcci().new Solution();
        String big = "mississippi";
        String[] smalls = new String[] {"is","ppi","hi","sis","i","ssippi"};
        System.out.println(Arrays.deepToString(solution.multiSearch(big, smalls)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] multiSearch(String big, String[] smalls) {
            List<List<Integer>> resList = new ArrayList<>();
            TrieNode root = new TrieNode();
            for (int i = 0; i < smalls.length; ++i) {
                resList.add(new ArrayList<>());
                root.insert(smalls[i], i);
            }
            for (int i = 0; i < big.length(); ++i) {
                String subStr = big.substring(i);
                List<Integer> indexOfSmall = root.search(subStr);
                for (int index : indexOfSmall) {
                    (resList.get(index)).add(i);
                }
            }
            int[][] res = new int[smalls.length][];
            for (int i = 0; i < res.length; ++i) {
                int[] tmp = new int[resList.get(i).size()];
                for (int j = 0; j < resList.get(i).size(); ++j) {
                    tmp[j] = resList.get(i).get(j);
                }
                res[i] = tmp;
            }
            return res;



        }

    }

    class TrieNode {
        public TrieNode[] children;
        public boolean endFlag;
        public int indexOfArray;

        public TrieNode() {
            children = new TrieNode[26];
            endFlag = false;
            indexOfArray = -1;
        }

        public void insert(String s, int indexOfArray) {
            TrieNode cur = this;
            for (Character c : s.toCharArray()) {
                if ((cur.children)[c - 'a'] == null) {
                    (cur.children)[c - 'a'] = new TrieNode();
                }
                cur = (cur.children)[c - 'a'];
            }
            cur.endFlag = true;
            cur.indexOfArray = indexOfArray;
        }

        public List<Integer> search(String s) {
            List<Integer> indexList = new ArrayList<>();
            TrieNode cur = this;
            for (Character c : s.toCharArray()) {
                if ((cur.children)[c - 'a'] != null) {
                    cur = (cur.children)[c - 'a'];
                    if (cur.endFlag) {
                        indexList.add(cur.indexOfArray);
                    }
                } else {
                    break;
                }
            }
            return indexList;
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

}
