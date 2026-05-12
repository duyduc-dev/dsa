package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code LC567PermutationInString}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/permutation-in-string">LeetCode
 * Problem 567: Permutation in String</a>.
 * </p>
 */
public class LC567PermutationInString {

  public static void main(String[] args) {
    String 
        s1 = "abc",
        s2 = "lecabee";
    var runner = new LC567PermutationInString();
    System.out.println(String.format("Result: %s", runner.checkInclusion(s1, s2)));
  }

  public boolean checkInclusion(String s1, String s2) {
    List<Character> l1 = new ArrayList<>();
    for (char c1 : s1.toCharArray()) {
      l1.add(c1);
    }

    int hasCount = 0;
    int res = 0;
    for (char c2 : s2.toCharArray()) {
      if (!l1.contains(c2)) {
        hasCount = 0;
        continue;
      }
      hasCount++;
      res = Math.max(hasCount, res);
    }

    return res == s1.length();
  }
}
