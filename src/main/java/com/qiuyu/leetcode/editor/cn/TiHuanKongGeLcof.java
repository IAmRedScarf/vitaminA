//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 217 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.Arrays;

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == ' ') {
                    res.append("%20");
                } else {
                    res.append(c);
                }
            }
            return res.toString();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
