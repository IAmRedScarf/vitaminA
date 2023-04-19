//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1784 👎 0


package com.qiuyu.leetcode.editor.cn;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        solution.maxProfit_20220513(new int[] {7,1,5,3,6,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            return maxProfit20230409(prices);
        }

        public int maxProfit20230409(int[] prices) {
            int len = prices.length;
            int preMin = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < len; ++i) {
                if (prices[i] >= preMin) {
                    maxProfit = Math.max(maxProfit, prices[i] - preMin);
                } else {
                    preMin = prices[i];
                }
            }
            return maxProfit;



        }




        public int maxProfit_20220513(int[] prices) {
            int res = 0;
            int preMin = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                res = Math.max(prices[i] - preMin, res);
                if (prices[i] < preMin) {
                    preMin = prices[i];
                }
            }
            return res;
        }


        public int maxProfit_old(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }

            int leftMin = Integer.MAX_VALUE;
            int res = 0;
            for (int i = 1; i < prices.length; ++i) {
                leftMin = Math.min(leftMin, prices[i - 1]);
                res = Math.max(prices[i] - leftMin, res);
            }
            return res;





















//            int maxProfit = 0;
//            int beforeMinPrice = Integer.MAX_VALUE, curMinPrice = 0;
//            for (int i = 1; i < prices.length; ++i) {
//                curMinPrice = Math.min(prices[i - 1], beforeMinPrice);
//                if (prices[i] > curMinPrice) {
//                    maxProfit = Math.max(maxProfit, prices[i] - curMinPrice);
//                }
//                beforeMinPrice = curMinPrice;
//            }
//
//            return maxProfit;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
