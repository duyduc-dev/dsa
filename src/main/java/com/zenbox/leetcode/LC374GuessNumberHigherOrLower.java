package com.zenbox.leetcode;

/**
 * {@code LC374GuessNumberHigherOrLower}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/guess-number-higher-or-lower/">LeetCode
 * Problem 374: Guess Number Higher or Lower</a>.
 * </p>
 */
public class LC374GuessNumberHigherOrLower {

  private int pickedNumber = 6;

  public int guessNumber(int n) {
    int l = 1;
    int r = n;

    if (guess(n) == 0)
      return n;

    while (l < r) {
      int m = l + (r - l) / 2;
      int i = guess(m);
      if (i == 0)
        return m;
      if (i > 0)
        l = m + 1;
      else
        r = m;
    }

    return -1;
  }

  private int guess(int n) {
    if(n > pickedNumber) return -1;
    if(n < pickedNumber) return 1;
    return 0;
  }
}
