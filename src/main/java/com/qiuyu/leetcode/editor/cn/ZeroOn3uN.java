//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
// Related Topics 字符串 回溯 👍 32 👎 0


package com.qiuyu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZeroOn3uN {
    public static void main(String[] args) {
        Solution solution = new ZeroOn3uN().new Solution();
        System.out.println(solution.restoreIpAddresses("10203040"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s.length() < 4 || s.length() > 12) {
                return new ArrayList<>();
            }
            List<List<String>> res = new ArrayList<>();
            List<String> tmpIp = new ArrayList<>();
            dfs(s, s.length() - 1, tmpIp, res);
            return res.stream().map(sList -> {
                StringBuilder sb = new StringBuilder();
                sList.forEach(ss -> sb.append(ss).append('.'));
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }).collect(Collectors.toList());
        }

        private void dfs(String s, int right, List<String> tmpIp, List<List<String>> res) {
            if (right < 0) {
                if (tmpIp.size() == 4) {
                    res.add(new ArrayList<>(tmpIp));
                }
                return;
            }
            for (int i = 0; i < 3; ++i) {
                if (right - i < 0) {
                    break;
                }
                String numStr = s.substring(right - i, right + 1);
                if (numStr.length() > 1 && numStr.charAt(0) == '0') {
                    continue;
                }
                int num = Integer.parseInt(numStr);
                if (num > 255) {
                    continue;
                }
                tmpIp.add(0, numStr);
                dfs(s, right - i - 1, tmpIp, res);
                tmpIp.remove(0);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
