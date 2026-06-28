package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@code LC352DataStreamAsDisjointIntervals}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/data-stream-as-disjoint-intervals">352. Data
 * Stream as Disjoint Intervals
 * </a>.
 * </p>
 */
public class LC352DataStreamAsDisjointIntervals {

  class SummaryRanges {

    Set<Integer> seen = new HashSet();

    public void addNum(int value) {
      seen.add(value);
    }

    public int[][] getIntervals() {
      int i = 0;

      List<Integer> sorted = new ArrayList(seen);
      Collections.sort(sorted);

      List<int[]> res = new ArrayList();

      while (i < sorted.size()) {
        int l = sorted.get(i);
        int r = sorted.get(i);

        while (i + 1 < sorted.size() && sorted.get(i + 1) == r + 1) {
          i++;
          r = sorted.get(i);
        }

        res.add(new int[] { l, r });
        i++;
      }

      return res.toArray(new int[][] {});
    }
  }

  /**
   * Your SummaryRanges object will be instantiated and called as such:
   * SummaryRanges obj = new SummaryRanges();
   * obj.addNum(value);
   * int[][] param_2 = obj.getIntervals();
   */
}
