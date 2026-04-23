package com.zenbox.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    String s = "ABAA";
    int k = 0;

    System.out.println("characterReplacementSlidingWindow >> " + runner.characterReplacementSlidingWindow(s, k));
    System.out.println("characterReplacementWithBruteForce >> " + runner.characterReplacementWithBruteForce(s, k));
  }

  /**
   * Time: O(n^2)
   * Space: O(n)
   * 
   * @param s
   * @param k
   * @return
   */
  public int characterReplacementWithBruteForce(String s, int k) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      Map<Character, Integer> countChar = new HashMap<>();
      int maxf = 0;
      for (int j = i; j < s.length(); j++) {
        countChar.put(s.charAt(j), countChar.getOrDefault(s.charAt(j), 0) + 1);
        maxf = Math.max(maxf, countChar.get(s.charAt(j)));
        int sizeSubString = j - i + 1;
        if (sizeSubString - maxf <= k) {
          res = Math.max(res, sizeSubString);
        }
      }
    }

    return res;
  }

  /**
   * Time O(n)
   * Space O(n)
   * @param s
   * @param k
   * @return
   */
  public int characterReplacementSlidingWindow(String s, int k) {
    int l = 0, r = 0, n = s.length();
    Map<Character, Integer> countChar = new HashMap<>();
    int maxf = 0;
    int res = 0;

    while (r < n) {
      countChar.put(s.charAt(r), countChar.getOrDefault(s.charAt(r), 0) + 1);
      maxf = Math.max(maxf, countChar.get(s.charAt(r)));

      while ((r - l + 1) - maxf > k) {
        countChar.put(s.charAt(l), countChar.getOrDefault(s.charAt(l), 0) - 1);
        maxf = Math.max(maxf, countChar.get(s.charAt(l)));
        l++;
      }

      res = Math.max(res, r - l + 1);
      r++;

    }
    return res;
  }
}
