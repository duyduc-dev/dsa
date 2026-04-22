package com.zenbox.leetcode;

/**
 * {@code LC424LongestRepeatingCharacterReplacement}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/longest-repeating-character-replacement">LeetCode
 * Problem 424: Longest Repeating Character Replacement</a>.
 * </p>
 */
public class LC424LongestRepeatingCharacterReplacement {

  public static void main(String[] args) {
    var runner = new LC424LongestRepeatingCharacterReplacement();
    runner.characterReplacement("ANNA", 0);
  }

  public int characterReplacement(String s, int k) {
    System.out.println(s.replaceAll("A", "D"));;
    return -1;
  }
}
