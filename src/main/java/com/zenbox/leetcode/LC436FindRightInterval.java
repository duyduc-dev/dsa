package com.zenbox.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code LC436FindRightInterval}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/find-right-interval/">436.
 * Find Right Interval</a>.
 * </p>
 */
public class LC436FindRightInterval {
  class Solution2 {
    public int[] findRightInterval(int[][] intervals) {
      int n = intervals.length;
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < n; i++) {
        map.put(intervals[i][0], i);
      }

      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

      int[] res = new int[n];

      for (int i = 0; i < n; i++) {
        int[] curr = intervals[i];

        int u = i;
        int v = n - 1;
        int min = -1;
        boolean found = false;
        while (u <= v) {
          int mid = u + ((v - u) / 2);
          if (intervals[mid][0] >= curr[1]) {
            min = intervals[mid][0];
            found = true;
            v = mid - 1;
          } else {
            u = mid + 1;
          }
        }

        res[map.get(curr[0])] = found ? map.get(min) : -1;
      }

      return res;

    }
  }

  /**
   * Time: O(n^2)
   * Space: O(n)
   * Solution
   */
  class Solution {
    public int[] findRightInterval(int[][] intervals) {
      int n = intervals.length;

      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < n; i++) {
        map.put(intervals[i][0], i);
      }

      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

      int[] res = new int[n];
      Arrays.fill(res, -1);

      int i = 0, j = 1;

      if (intervals[i][0] == intervals[i][1]) {
        res[map.get(intervals[i][0])] = map.get(intervals[i][0]);
        i++;
        j = i + 1;
      }

      while (i < j && j < n) {
        if (intervals[i][0] == intervals[i][1]) {
          res[map.get(intervals[i][0])] = map.get(intervals[i][0]);
          i++;
          j = i + 1;
        } else if (isRight(intervals[j], intervals[i])) {
          res[map.get(intervals[i][0])] = map.get(intervals[j][0]);
          i++;
          j = i + 1;
        } else {
          j++;
          if (j >= n) {
            i++;
            j = i + 1;
          }
        }
      }

      return res;

    }

    private boolean isRight(int[] a, int[] b) {
      return a[0] >= b[1];
    }
  }
}
