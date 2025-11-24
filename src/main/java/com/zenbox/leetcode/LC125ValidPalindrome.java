package com.zenbox.leetcode;

/**
 * {@code LC125ValidPalindrome}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/valid-palindrome">LeetCode Problem 125: Valid Palindrome</a>.
 * </p>
 */
public class LC125ValidPalindrome {

    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int l = 0, r = n - 1;
        while(l < r) {
            while(r > l & (s.charAt(r) - 'a' >= 26 || s.charAt(r) - 'a' < 0 ) && (s.charAt(r) - '0' > 9 || s.charAt(r) - '0' < 0)) {
                r--;
            }
            while(l < r && (s.charAt(l) - 'a' > 26 || s.charAt(l) - 'a' < 0) && (s.charAt(l) - '0' > 9 || s.charAt(l) - '0' < 0)) {
                l++;
            }
            if(l > r) return false;
            if(s.charAt(r) != s.charAt(l)) {
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}
