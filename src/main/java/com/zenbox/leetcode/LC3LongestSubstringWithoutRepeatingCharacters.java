package com.zenbox.leetcode;

import java.util.HashSet;

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
    String s = "pwwkew";
    /*          00000000*/
    System.out.println("Brute force: " + runner.lengthOfLongestSubstringWithSlidingWindowHashSet(s));
    // System.out.println("Sliding window: " + runner.lengthOfLongestSubstringWithSlidingWindow(s));
  }

  /**
   * Time: O(n)
   * Space: O(n)
   * @param s
   * @return
   */
  public int lengthOfLongestSubstringWithSlidingWindowHashSet(String s) {
    int l = 0, r = 0, n = s.length(), maxLength = 0;
    HashSet<Character> seen = new HashSet<>();

    while (r < n) {
      while(seen.contains(s.charAt(r))){
        seen.remove(s.charAt(l));
        l++;
      }
      seen.add(s.charAt(r));
      maxLength=Math.max(maxLength,seen.size());
      r++;
    }

    return maxLength;
  }

  public int lengthOfLongestSubstringWithSlidingWindow(String s) {
    /**
     * l = 3
     * r = 6
     * max = 3;
     */
    int l = 0, r = 0, n = s.length(), maxLength = 0;
    int[] seen = new int[128];
    while (r < n) {
      while (seen[s.charAt(r)] > 0) {
        seen[s.charAt(l)] = 0;
        l++;
      }
      seen[s.charAt(r)] = 1;
      maxLength = Math.max(maxLength, r - l + 1);
      r++;
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
      int[] seen = new int[128];

      for (int j = i; j < n; j++) {
        if (seen[s.charAt(j)] > 0) {
          break;
        }

        seen[s.charAt(j)] = 1;
        maxLength = Math.max(maxLength, j - i + 1);
      }
    }

    return maxLength;
  }
}
