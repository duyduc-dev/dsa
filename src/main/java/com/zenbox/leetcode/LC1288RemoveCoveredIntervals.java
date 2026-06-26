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

    class Solution2 {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            int n = intervals.length;

            int[] curr = intervals[0];
            int res = 0;

            for (int i = 1; i < n; i++) {
                if (coveredBy(intervals[i], curr)) {
                    res++;
                } else if (coveredBy(curr, intervals[i])) {
                    res++;
                    curr = intervals[i];
                } else {
                    curr = intervals[i];
                }
            }

            return n - res;
        }

        private boolean coveredBy(int[] a, int[] b) {
            return b[0] <= a[0] && a[1] <= b[1];
        }
    }

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
