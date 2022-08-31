//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 308 👎 0


package com.qiuyu.leetcode.editor.cn;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 擂台上的人，得分
            // 得分为0时，标识擂台上没有人
            int score = 0;
            // 擂台上的人
            int cur = 0;
            for (int num : nums) {
                if (score == 0) {
                    cur = num;
                }
                if (cur == num) {
                    score++;
                } else {
                    score--;
                }
            }
            return cur;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
