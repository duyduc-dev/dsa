package com.zenbox.leetcode;

/**
 * {@code LC367ValidPerfectSquare}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/valid-perfect-square">LeetCode
 * Problem 367: Valid Perfect Square</a>.
 * </p>
 */
public class LC367ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    long l = 1;
    long r = num;

    while (l <= r) {
      long mid = l + (r - l) / 2;
      boolean isSquare = mid * mid == num;
      if (isSquare)
        return true;

      if (mid * mid > num) {
        r = mid;
      } else {
        l = mid;
      }
    }

    return false;
  }

  public boolean isPerfectSquare2(int num) {
    long l = 1;
    long r = num;

    while (l <= r) {
      long mid = l + (r - l) / 2;
      long db = mid * mid;
      if (db == num)
        return true;
      if (db > num)
        r = mid - 1;
      else
        l = mid + 1;
    }

    return false;
  }
}
