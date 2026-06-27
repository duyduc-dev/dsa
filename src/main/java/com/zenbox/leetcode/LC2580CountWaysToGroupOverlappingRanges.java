package com.zenbox.leetcode;

import java.util.Arrays;

/**
 * {@code LC2580CountWaysToGroupOverlappingRanges}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/">2580.
 * Count Ways to Group Overlapping Ranges</a>.
 * </p>
 */
public class LC2580CountWaysToGroupOverlappingRanges {

  class Solution {
    private static final long MOD = 1_000_000_007;

    public int countWays(int[][] ranges) {
      Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));
      int n = ranges.length;

      int end = ranges[0][1];
      int res = 1;
      for (int i = 1; i < n; i++) {
        if (end >= ranges[i][0]) {
          end = Math.max(end, ranges[i][1]);
        } else {
          res++;
          end = ranges[i][1];
        }
      }

      return (int) modPow(2, res);
    }

    private long modPow(long base, int exp) {
      long result = 1;
      base %= MOD;
      while (exp > 0) {
        if ((exp & 1) == 1)
          result = result * base % MOD;
        base = base * base % MOD;
        exp >>= 1;
      }
      return result;
    }
  }
}
