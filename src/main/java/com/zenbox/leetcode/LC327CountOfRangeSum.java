package com.zenbox.leetcode;

/**
 * {@link LC327CountOfRangeSum}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/count-of-range-sum/">327.
 * Count of Range Sum</a>.
 * </p>
 */
public class LC327CountOfRangeSum {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int n = nums.length;
            long[] prefixSums = new long[n + 1];

            for (int i = 0; i < n; i++) {
                prefixSums[i + 1] = prefixSums[i] + nums[i];
            }

            return count(prefixSums, 0, n, lower, upper);
        }

        int count(long[] sums, int l, int r, int lower, int upper) {
            if (l >= r)
                return 0;

            int m = (r + l) / 2;

            return count(sums, l, m, lower, upper)
                    + count(sums, m + 1, r, lower, upper)
                    + countMerge(sums, l, m, r, lower, upper);
        }

        int countMerge(long[] sums, int l, int m, int r, int lower, int upper) {
            // 1. count
            /**
             * S(i, j) = S(j) - S(i)
             * lower <= S(j) - S(i) <= upper
             * lower + S(i) <= S(j) <= upper + S(i)
             */
            int count = 0;
            int low = m + 1;
            int high = m + 1;
            for (int i = l; i <= m; i++) {
                while (low <= r && sums[low] < lower + sums[i])
                    low++;
                while (high <= r && sums[high] <= upper + sums[i])
                    high++;
                count += high - low;
            }

            // 2. sort
            int i = l;
            int j = m + 1;
            int k = 0;
            long[] temp = new long[r - l + 1];

            while (i <= m && j <= r) {
                if (sums[i] <= sums[j])
                    temp[k++] = sums[i++];
                else
                    temp[k++] = sums[j++];
            }

            while (i <= m)
                temp[k++] = sums[i++];
            while (j <= r)
                temp[k++] = sums[j++];

            for (int p = 0; p < temp.length; p++)
                sums[l + p] = temp[p];

            return count;
        }
    }
}
