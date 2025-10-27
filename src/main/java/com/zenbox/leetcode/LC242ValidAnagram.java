package com.zenbox.leetcode;

import java.util.HashMap;

/**
 * {@code LC242ValidAnagram}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/valid-anagram">LeetCode Problem 242: Valid Anagram</a>.
 * </p>
 */
public class LC242ValidAnagram {

    /**
     * Time: O(n)
     * Space: O(1)
     * Runtime 16ms
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramWithTwoHashMap(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return mapS.equals(mapT);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * Runtime 16ms
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramWithOneHashMap(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch: t.toCharArray()) {
            if(!map.containsKey(ch) || map.getOrDefault(ch, 0) == 0) return false;
            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * Runtime 5ms
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int num: arr) {
            if(num != 0) return false;
        }
        return true;
    }
}
