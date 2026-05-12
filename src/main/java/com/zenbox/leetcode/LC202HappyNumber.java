package com.zenbox.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * {@code LC202HappyNumber}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/happy-number">LeetCode
 * Problem 202: Happy number</a>.
 * </p>
 */
public class LC202HappyNumber {

  public static void main(String[] args) {
    var lC202HappyNumberRecursion = new LC202HappyNumberRecursion();
    var lC202HappyNumberIterative = new LC202HappyNumberIterative();

    System.out.println("LC202HappyNumberRecursion >> " + lC202HappyNumberRecursion.isHappy(7));
    System.out.println("LC202HappyNumberIterative >> " + lC202HappyNumberIterative.isHappy(7));
  }

  /**
   * Using recursion
   * Time: O(logn)
   * Space: 
   */
  public static class LC202HappyNumberIterative {

    public boolean isHappy(int n) {
      Set<Integer> seen = new HashSet<Integer>();

      while (!seen.contains(n)) {
        seen.add(n);
        n = getNextNumber(n);
        if (n == 1)
          return true;
      }

      return false;
    }

    private int getNextNumber(int n) {
      int res = 0;

      while (n > 0) {
        int digit = n % 10;
        res += digit * digit;
        n /= 10;
      }

      return res;
    }

  }

  /**
   * Using recursion
   * O(logn)
   */
  public static class LC202HappyNumberRecursion {

    public boolean isHappy(int n) {
      Set<Integer> seen = new HashSet<Integer>();

      return isHappyWithRecursion(n, seen);
    }

    private boolean isHappyWithRecursion(int n, Set<Integer> seen) {
      if (n == 1)
        return true;

      if (seen.contains(n))
        return false;

      seen.add(n);

      return isHappyWithRecursion(getNextNumber(n), seen);
    }

    private int getNextNumber(int n) {
      int res = 0;

      while (n > 0) {
        int digit = n % 10;
        res += digit * digit;
        n /= 10;
      }

      return res;
    }

  }

}
