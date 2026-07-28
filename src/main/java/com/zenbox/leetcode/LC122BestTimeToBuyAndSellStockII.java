package com.zenbox.leetcode;

/**
 * {@code LC122BestTimeToBuyAndSellStockII}
 * <p>
 * Solution for
 * <a href=
 * "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">122. Best
 * Time to Buy and Sell Stock II</a>.
 * </p>
 */
public class LC122BestTimeToBuyAndSellStockII {

    class Solution2 {
        public int maxProfit(int[] prices) {
            int profit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int b = 0;
            int s = 1;
            int n = prices.length;

            while (b < s && s < n) {
                if (prices[b] < prices[s]) {
                    int max = prices[s] - prices[b];
                    while (s < n - 1 && prices[s + 1] > prices[s]) {
                        max = Math.max(prices[++s] - prices[b], max);
                    }
                    profit += max;
                }
                b = s;
                s++;

            }

            return profit;
        }
    }
}
