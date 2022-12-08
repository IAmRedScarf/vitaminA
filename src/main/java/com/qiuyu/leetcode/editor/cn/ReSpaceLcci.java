//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 动态规划 哈希函数 滚动哈希 👍 205 👎 0

  
package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReSpaceLcci {
    public static void main(String[] args) {
        Solution solution = new ReSpaceLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        // 左开右闭区间
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; --j) {
                String cut = sentence.substring(j, i + 1);
                if (wordSet.contains(cut)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j]);
                } else {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + cut.length());
                }
            }
        }
        return dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
