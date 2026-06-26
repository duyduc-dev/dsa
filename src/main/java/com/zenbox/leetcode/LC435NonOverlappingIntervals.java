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

  class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

      int end = intervals[0][1];
      int res = 0;
      for (int i = 1; i < intervals.length; i++) {
        if (end > intervals[i][0]) {
          res++;
        } else {
          end = intervals[i][1];
        }
      }

      return res;
    }
  }

  class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

      int count = 0;
      int end = intervals[0][1];
      int n = intervals.length;

      for (int i = 1; i < n; i++) {
        if (intervals[i][0] < end) {
          count++;
        } else {
          end = intervals[i][1];
        }
      }

      return count;
    }
  }

  class Solution3 {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      for (int[] i : intervals) {
        System.out.print(Arrays.toString(i));
      }

      int[] prevEnd = intervals[0];
      int res = 0;
      for (int[] i : intervals) {
        if (prevEnd == i)
          continue;
        if (prevEnd[1] > i[0]) {
          res++;
          if (i[1] < prevEnd[1])
            prevEnd = i;
        } else {
          prevEnd = i;
        }
      }

      return res;
    }
  }

}
