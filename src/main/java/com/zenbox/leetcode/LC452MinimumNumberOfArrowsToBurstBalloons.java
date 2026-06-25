package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@code LC452MinimumNumberOfArrowsToBurstBalloons}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">452.
 * Minimum
 * Number of Arrows to Burst Balloons</a>.
 * </p>
 */
public class LC452MinimumNumberOfArrowsToBurstBalloons {

  class Solution {
    public int findMinArrowShots(int[][] points) {
      Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

      int n = points.length;
      int arrows = 1;
      int end = points[0][1];

      for (int i = 1; i < n; i++) {
        if (points[i][0] <= end) {
          end = Math.min(end, points[i][1]);
        } else {
          arrows++;
          end = points[i][1];
        }
      }

      return arrows;
    }
  }

  class Solution2 {
    public int findMinArrowShots(int[][] points) {

      Arrays.sort(points, (a, b) -> a[0] - b[0]);

      int[] curr = points[0];
      List<int[]> res = new ArrayList();

      for (int i = 1; i < points.length; i++) {
        if (isLeft(curr, points[i])) {
          res.add(curr);
          curr = points[i];
        } else if (isLeft(points[i], curr)) {
          res.add(points[i]);
        } else {
          curr[0] = Math.max(curr[0], points[i][0]);
          curr[1] = Math.min(curr[1], points[i][1]);
        }
      }

      res.add(curr);

      return res.size();
    }

    private boolean isLeft(int[] a, int[] b) {
      return a[1] < b[0];
    }
  };
}
