package com.zenbox.leetcode;

/**
 * {@code LC326PowerOfThree}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/power-of-three/">LeetCode
 * Problem 326: Power of three</a>.
 * </p>
 */
public class LC326PowerOfThree {

  public static void main(String[] args) {
    System.out.println("isPowerOfThreeWithRecursion: " + isPowerOfThreeWithRecursion(45));
  }

  /**
   * Recursion
   * T: O(log(n))
   * S: O(log(n))
   * @param n
   * @return
   */
  public static boolean isPowerOfThreeWithRecursion(int n) {
    if (n < 1)
      return false;
    if (n == 1)
      return true;

    if(n % 3 != 0) return false;

    return isPowerOfThreeWithRecursion(n / 3);
  }
}
