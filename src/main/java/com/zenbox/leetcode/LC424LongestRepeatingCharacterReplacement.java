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

    String s = "AAABABB";
    int k = 1;

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
    int longestRes = 0;

    for (int i = 0; i < s.length(); i++) {
      HashMap<Character, Integer> countChar = new HashMap<Character, Integer>();
      int maxRepeat = 0;

      for (int j = i; j < s.length(); j++) {
        countChar.put(s.charAt(j), countChar.getOrDefault(s.charAt(j), 0) + 1);
        maxRepeat = Math.max(maxRepeat, countChar.get(s.charAt(j)));

        if (j - i + 1 - maxRepeat <= k) {
          longestRes = Math.max(longestRes, j - i + 1);
        }
      }
    }

    return longestRes;
  }

  /**
   * Time O(n)
   * Space O(n)
   * 
   * @param s
   * @param k
   * @return
   */
  public int characterReplacementSlidingWindow(String s, int k) {
    int l = 0, r = 0, n = s.length();
    int res = 0;
    Map<Character, Integer> map = new HashMap<>();
    int maxF = 0;
    while (r < n) {
      map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
      maxF = Math.max(maxF, map.get(s.charAt(r)));

      while (r - l + 1 - maxF > k) {
        map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
        l++;
      }

      res = Math.max(res, r - l + 1);

      r++;
    }

    return res;
  }
}
