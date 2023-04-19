//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 👍 1032 👎 0


package com.qiuyu.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        solution.maxProfit_20220504(new int[] {1, 4, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return maxProfit20230320(prices);
        }

        public int maxProfit20230409(int[] prices) {
            int len = prices.length;
            // 当天结束持有股票
            int[] dp1 = new int[len];
            dp1[0] = -prices[0];
            // 当天未持有股票，当天有卖出
            int[] dp2 = new int[len];
            // 当天未持有股票，当天无卖出
            int[] dp3 = new int[len];



            for (int i = 1; i < len; ++i) {
                dp1[i] = Math.max(dp1[i - 1], dp3[i - 1] - prices[i]);
                dp2[i] = dp1[i - 1] + prices[i];
                dp3[i] = Math.max(dp2[i - 1], dp3[i - 1]);
            }
            return Math.max(dp2[len - 1], dp3[len - 1]);

        }











        public int maxProfit20230320(int[] prices) {
            int n = prices.length;
            // 某天结束时未持有股票，非当日卖出
            int[] dp0 = new int[n];
            // 某天结束时未持有股票， 当日卖出
            int[] dp1 = new int[n];
            // 某天结束时持有股票
            int[] dp2 = new int[n];
            dp0[0] = 0;
            dp1[0] = 0;
            dp2[0] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp0[i] = Math.max(dp0[i - 1], dp1[i - 1]);
                dp1[i] = dp2[i - 1] + prices[i];
                dp2[i] = Math.max(dp2[i - 1], dp0[i - 1] - prices[i]);
            }
            return Math.max(dp0[n - 1], dp1[n - 1]);



        }






        public int maxProfit_20220504(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int[] dp_have_stock_buy = new int[prices.length];
            dp_have_stock_buy[0] = -prices[0];
            int[] dp_have_stock_no_buy = new int[prices.length];
            dp_have_stock_no_buy[0] = -prices[0];
            int[] dp_no_stock_sell = new int[prices.length];
            int[] dp_no_stock_no_sell = new int[prices.length];

            for (int i = 1; i < prices.length; ++i) {
                dp_have_stock_buy[i] = dp_no_stock_no_sell[i - 1] - prices[i];
                dp_have_stock_no_buy[i] = Math.max(dp_have_stock_no_buy[i - 1], dp_have_stock_buy[i - 1]);
                dp_no_stock_sell[i] = Math.max(dp_have_stock_buy[i - 1], dp_have_stock_no_buy[i - 1]) + prices[i];
                dp_no_stock_no_sell[i] = Math.max(dp_no_stock_sell[i - 1], dp_no_stock_no_sell[i - 1]);
            }
            return Math.max(dp_no_stock_sell[prices.length - 1], dp_no_stock_no_sell[prices.length - 1]);

        }



        public int maxProfit_old(int[] prices) {
//            if (prices == null || prices.length <= 1) {
//                return 0;
//            }
            int[][] dp = new int[prices.length][3];
            // 非卖出的不持股
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            for (int i = 1; i < prices.length; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
                dp[i][2] = dp[i - 1][1] + prices[i];
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
        }

















//        private int f1(int[] prices) {
//            if (prices == null || prices.length <= 1) {
//                return 0;
//            }
//            int[][] dp = new int[3][prices.length];
//            // dp[i][0]表示第i天持有股票
//            dp[0][0] = -prices[0];
//            // dp[i][1]表示第i天不持有股票，且当日无卖出操作
//            dp[1][0] = 0;
//            // dp[i][2]表示第i天不持有股票，当日有卖出操作
//            dp[2][0] = 0;
//            for (int i = 1; i < prices.length; ++i) {
//                dp[0][i] = Math.max(dp[1][i - 1] - prices[i], dp[0][i - 1]);
//                dp[1][i] = Math.max(dp[1][i -1], dp[2][i - 1]);
//                dp[2][i] = prices[i] + dp[0][i -1];
//            }
//            return Math.max(dp[1][prices.length - 1], dp[2][prices.length - 1]);
//        }

//        private int f2(int[] prices) {
//            if (prices == null || prices.length <= 1) {
//                return 0;
//            }
//            int[][] dp = new int[3][prices.length];
//            // dp[i][0]表示第i天持有股票
//            int a = -prices[0];
//            // dp[i][1]表示第i天不持有股票，且当日无卖出操作
//            int b = 0;
//            // dp[i][2]表示第i天不持有股票，当日有卖出操作
//            int c = 0;
//            for (int i = 1; i < prices.length; ++i) {
//                int tmpA = a, tmpB = b, tmpC = c;
//                a = Math.max(tmpA, tmpB - prices[i]);
//                b = Math.max(tmpB, tmpC);
//                c = tmpA + prices[i];
//            }
//            return Math.max(b, c);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
