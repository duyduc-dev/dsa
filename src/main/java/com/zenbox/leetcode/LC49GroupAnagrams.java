package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * {@code LC49GroupAnagrams}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/group-anagrams/">LeetCode Problem 49: Group Anagrams</a>.
 * </p>
 */
public class LC49GroupAnagrams {

    /**
     * Time: O(n m.log(m))
     * Space: O(n x m)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * Time: O(n x m)
     * Space: O(n x m)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsWithSort(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] countChar = new int[26];
            for(char ch: str.toCharArray()) {
                countChar[ch - 'a']++;
            }
            String key = Arrays.toString(countChar);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
