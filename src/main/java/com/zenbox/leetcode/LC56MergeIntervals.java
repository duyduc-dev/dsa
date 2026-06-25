package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@code LC56MergeIntervals}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/merge-intervals/">56.
 * Merge Intervals</a>.
 * </p>
 */
public class LC56MergeIntervals {
  class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      int n = intervals.length;
      List<int[]> res = new ArrayList<>();

      int[] curr = intervals[0];

      for (int i = 1; i < n; i++) {
        if (overlap(curr, intervals[i])) {
          curr[1] = Math.max(curr[1], intervals[i][1]);
        } else {
          res.add(curr);
          curr = intervals[i];
        }
      }

      res.add(curr);
      int[][] output = new int[res.size()][2];
      for (int i = 0; i < res.size(); i++) {
        output[i] = res.get(i);
      }

      return output;
    }

    private boolean overlap(int[] a, int[] b) {
      return a[0] <= b[1] && a[1] >= b[0];
    }
  }
}
