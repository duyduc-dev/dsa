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

  /**
   * Time: O(nlogn)
   * Space: O(n)
   * Solution2
   */
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
        int l = i;
        int r = n - 1;
        int[] curr = intervals[i];
        int minStart = -1;
        boolean found = false;

        while (l <= r) {
          int mid = l + (r - l) / 2;
          if (intervals[mid][0] >= curr[1]) {
            minStart = intervals[mid][0];
            found = true;
            r = mid - 1;
          } else {
            l = mid + 1;
          }
        }

        res[map.get(curr[0])] = found ? map.get(minStart) : -1;
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
