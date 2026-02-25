package com.zenbox.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code LC3LongestSubstringWithoutRepeatingCharacters}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/longest-substring-without-repeating-characters">
 * LeetCode Problem 3: Longest Substring Without Repeating Characters
 * </a>.
 * </p>
 */
public class LC3LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    LC3LongestSubstringWithoutRepeatingCharacters runner = new LC3LongestSubstringWithoutRepeatingCharacters();
    /*          01234567*/
    String s = "abcabcbb";

    System.out.println("Brute force: " + runner.lengthOfLongestSubstringWithBruteForce(s));
    System.out.println("Sliding window: " + runner.lengthOfLongestSubstringWithSlidingWindow(s));
  }

    public int lengthOfLongestSubstringWithSlidingWindow(String s) {
      /**
       * l = 3
       * r = 6
       * max = 3;
       */
      int l = 0, r = 0, n = s.length(), maxLength = 0;
      int[] seen = new int[26];
      while (r < n) {
        if (l == r)
          r++;
        if (s.charAt(l) == s.charAt(r)) {
          while (seen[s.charAt(r) - 'a'] != 0) {
            seen[s.charAt(r) - 'a'] = 0;
            l = r;
          }
        } else {
          seen[s.charAt(r) - 'a'] = 1;
          maxLength = Math.max(maxLength, r - l + 1);
          r++;
        }
      }

      return maxLength;
    }

  /**
   * Time: O(n^2)
   * Space: O(1)
   * 
   * @param s
   * @return
   */
  public int lengthOfLongestSubstringWithBruteForce(String s) {
    int n = s.length();
    int maxLength = 0;

    for (int i = 0; i < n; i++) {
      boolean[] seen = new boolean[256];

      for (int j = i; j < n; j++) {
        char c = s.charAt(j);

        if (seen[c]) {
          break;
        }

        seen[c] = true;
        maxLength = Math.max(maxLength, j - i + 1);
      }
    }

    return maxLength;
  }
}
