package com.zenbox.leetcode;

import java.util.Arrays;

/**
 * {@code LC1005MaximizeSumOfArrayAfterKNegations}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/">1005.
 * Maximize Sum Of Array After K Negations</a>.
 * </p>
 */
public class LC1005MaximizeSumOfArrayAfterKNegations {
  class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
      Arrays.sort(nums);

      for (int i = 0; i < nums.length && k > 0; i++) {
        if (nums[i] > 0)
          continue;
        nums[i] = -nums[i];
        k--;
      }

      int sum = 0;
      int min = Integer.MAX_VALUE;

      for (int n : nums) {
        sum += n;
        min = Math.min(min, Math.abs(n));
      }

      if (k % 2 == 1) {
        sum -= 2 * min;
      }

      return sum;

    }
  }
}
