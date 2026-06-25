package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code LC986IntervalListIntersections}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/interval-list-intersections">986.
 * Interval List Intersections</a>.
 * </p>
 */
public class LC986IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            if (firstList == null || secondList == null || firstList.length == 0 || secondList.length == 0)
                return new int[0][0];

            List<int[]> res = new ArrayList<>();

            int firstIdx = 0;
            int secondIdx = 0;

            while (firstIdx < firstList.length && secondIdx < secondList.length) {
                int[] first = firstList[firstIdx];
                int[] second = secondList[secondIdx];

                int x = Math.max(first[0], second[0]);
                int y = Math.min(first[1], second[1]);

                if (x <= y) {
                    res.add(new int[] { x, y });
                }

                if (first[1] == y)
                    firstIdx++;
                if (second[1] == y)
                    secondIdx++;

            }

            return res.toArray(new int[res.size()][2]);
        }

    }
}
