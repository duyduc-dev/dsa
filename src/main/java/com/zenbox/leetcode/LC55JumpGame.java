package com.zenbox.leetcode;

/**
 * {@code LC55JumpGame}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/jump-game">55. Jump
 * Game</a>.
 * </p>
 */
public class LC55JumpGame {
  class Solution {
    public boolean canJump(int[] nums) {
      int n = nums.length;

      int maxReach = 0;
      for (int i = 0; i < n; i++) {
        if (i > maxReach)
          return false;
        maxReach = Math.max(maxReach, i + nums[i]);
      }

      return true;
    }
  }
}
