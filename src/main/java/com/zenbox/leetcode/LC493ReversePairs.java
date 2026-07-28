package com.zenbox.leetcode;

/**
 * {@code LC493ReversePairs}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/reverse-pairs">493. Reverse Pairs
 * </a>.
 * </p>
 */
public class LC493ReversePairs {
    class Solution {

        public int reversePairs(int[] nums) {
            // 1. count
            // 2. merge and sort
            return count(nums, 0, nums.length - 1);
        }

        int count(int[] nums, int l, int r) {
            if (l >= r) {
                return 0;
            }

            int m = (r + l) / 2;
            int cL = count(nums, l, m);
            int cR = count(nums, m + 1, r);
            int cMerge = countMerge(nums, l, m, r);

            return cL + cR + cMerge;
        }

        int countMerge(int[] nums, int l, int m, int r) {
            // 1. count
            int j = m + 1;
            int count = 0;
            for (int i = l; i <= m; i++) {
                while (j <= r && (long) nums[i] > 2L * nums[j]) {
                    j++;
                }

                count += j - 1 - m;
            }

            // 2. sort
            int n = r - l + 1;
            int[] temp = new int[n];
            int k = 0;
            int i = l;
            j = m + 1;

            while (i <= m && j <= r) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    temp[k++] = nums[j++];
                }
            }

            while (i <= m) {
                temp[k++] = nums[i++];
            }

            while (j <= r) {
                temp[k++] = nums[j++];
            }

            for (int p = 0; p < n; p++) {
                nums[l + p] = temp[p];
            }

            return count;
        }
    }
}
