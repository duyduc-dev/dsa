package com.zenbox.leetcode;

/**
 * {@code LC121 BestTimeToBuyAndSellStock}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/best-time-to-buy-and-sell-stock">LeetCode
 * Problem
 * 121: Best Time to Buy and Sell Stock</a>.
 * </p>
 */
public class LC121BestTimeToBuyAndSellStock {

  public int maxProfitWithTwoPoint(int[] prices) {
    int max = 0;
    int n = prices.length;

    int l = 0;
    int r = 1;

    while (r < n) {
      int buy = prices[l];
      int sell = prices[r];

      if (sell > buy) {
        int profit = sell - buy;
        if (profit > max) {
          max = profit;
        }
      } else {
        l = r;
      }

      r++;
    }

    return max;

  }

  /**
   * Brute force
   * Time: O(n)
   * Space: O(1)
   * 
   * @param prices
   * @return
   */
  public int maxProfitWithBruteForce(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
      int buy = prices[i];

      for (int j = i + 1; j < prices.length; j++) {
        int sell = prices[j];
        int profit = sell - buy;
        if (profit > max) {
          max = profit;
        }
      }
    }
    return max;
  }
}
