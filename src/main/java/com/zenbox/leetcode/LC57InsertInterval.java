package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * {@code LC57InsertInterval}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/insert-interval">57. Insert
 * Interval</a>.
 * </p>
 */
public class LC57InsertInterval {

  public static void main(String[] args) {
    Solution1 a = new Solution1();
    Solution2 b = new Solution2();

    int[][] intervals = { { 1, 5 } };
    int[] newIntervals = { 0, 0 };

    int[][] res = a.insert(intervals, newIntervals);
    int[][] res2 = b.insert(intervals, newIntervals);

    System.out.print("1 -> ");
    for (int[] item : res) {
      System.out.print(String.format("[%s,%s]", item[0], item[1]));
    }

    System.out.println("==");
    System.out.print("2 -> ");
    for (int[] item : res2) {
      System.out.print(String.format("[%s,%s]", item[0], item[1]));
    }
  }

  static class Solution3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> res = new ArrayList<>();
      int n = intervals.length;

      for (int i = 0; i < n; i++) {
        if (isLeft(newInterval, intervals[i])) {
          res.add(newInterval);
          newInterval = intervals[i];
        } else if (isLeft(intervals[i], newInterval)) {
          res.add(intervals[i]);
        } else {
          newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
          newInterval[1] = Math.min(newInterval[1], intervals[i][1]);
        }
      }

      res.add(newInterval);

      return res.toArray(new int[res.size()][2]);

    }

    private boolean isLeft(int[] a, int[] b) {
      return a[1] < b[0];
    }
  }

  static class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> res = new ArrayList<>();
      int n = intervals.length;

      int idx = 0;
      while (idx < n && isLeft(intervals[idx], newInterval)) {
        res.add(intervals[idx]);
        idx++;
      }

      while (idx < n && overlap(intervals[idx], newInterval)) {
        newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
        newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
        idx++;
      }

      res.add(newInterval);

      while (idx < n) {
        res.add(intervals[idx++]);
      }

      return res.toArray(new int[res.size()][2]);
    }

    private boolean overlap(int[] a, int[] b) {
      return a[0] <= b[1] && a[1] >= b[0];
    }

    private boolean isLeft(int[] a, int[] b) {
      return a[1] < b[0];
    }
  }

  /**
   * Time: O(nlogn)
   * Space: O(n)
   * Solution1
   */
  static class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
      intervalList.add(newInterval);

      Collections.sort(intervalList, (a, b) -> a[0] - b[0]);
      List<int[]> res = new ArrayList<>();

      int[] curr = intervalList.get(0);

      for (int i = 1; i < intervalList.size(); i++) {
        int[] interval = intervalList.get(i);
        if (overlap(curr, interval)) {
          curr[1] = Math.max(curr[1], interval[1]);
        } else {
          res.add(curr);
          curr = interval;
        }
      }

      res.add(curr);

      return res.toArray(new int[res.size()][]);
    }

    private boolean overlap(int[] a, int[] b) {
      return a[0] <= b[1] && a[1] >= b[0];
    }
  }
}
