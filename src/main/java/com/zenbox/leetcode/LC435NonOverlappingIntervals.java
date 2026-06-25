package com.zenbox.leetcode;

import java.util.Arrays;

/**
 * {@code LC435NonOverlappingIntervals}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/non-overlapping-intervals/">435.
 * Non-overlapping Intervals</a>.
 * </p>
 */
public class LC435NonOverlappingIntervals {
  class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

      int[] curr = intervals[0];

      int res = 0;
      for (int i = 1; i < intervals.length; i++) {
        if (curr[1] > intervals[i][0]) {
          res++;
        } else {
          curr = intervals[i];
        }
      }

      return res;
    }

  }
}
