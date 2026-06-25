package com.zenbox.leetcode;

import java.util.Arrays;

/**
 * {@code LC1288RemoveCoveredIntervals}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/remove-covered-intervals/">986.
 * Interval List Intersections</a>.
 * </p>
 */
public class LC1288RemoveCoveredIntervals {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int n = intervals.length;

            int res = 0, l = -1, r = -1;
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] > l && intervals[i][1] > r) {
                    l = intervals[i][0];
                    res++;
                }
                r = Math.max(r, intervals[i][1]);
            }

            return res;
        }

    }
}
