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
            long[] prefixSum = new long[n + 1];

            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }

            return count(prefixSum, 0, prefixSum.length - 1, lower, upper);
        }

        int count(long[] sums, int l, int r, int lower, int upper) {
            if (l >= r)
                return 0;
            int m = (l + r) / 2;

            return count(sums, l, m, lower, upper)
                    + count(sums, m + 1, r, lower, upper)
                    + countMerge(sums, l, m, r, lower, upper);
        }

        int countMerge(long[] sums, int l, int m, int r, int lower, int upper) {
            // 1.count
            /**
             * S(i, j) = S(0, j) - S(0, i)
             */

            int count = 0;
            int low = m + 1, high = m + 1;
            for (int i = l; i <= m; i++) {
                while (low <= r && sums[low] < lower + sums[i])
                    low++;
                while (high <= r && sums[high] <= upper + sums[i])
                    high++;

                count += high - low;
            }

            // 2.merge
            int i = l;
            int j = m + 1;
            int n = r - l + 1;
            long[] temp = new long[n];
            int k = 0;

            while (i <= m && j <= r) {
                if (sums[i] < sums[j])
                    temp[k++] = sums[i++];
                else
                    temp[k++] = sums[j++];
            }

            while (i <= m)
                temp[k++] = sums[i++];
            while (j <= r)
                temp[k++] = sums[j++];

            for (int p = 0; p < n; p++) {
                sums[l + p] = temp[p];
            }

            return count;
        }
    }
}
