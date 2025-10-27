package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code LC271EncodeAndDecodeStrings}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/top-k-frequent-elements">LeetCode Problem 271: Encode and decode strings</a>.
 * </p>
 *
 * input ["neet","code","love","you"] encoded => 4|neet4|code4|love4|you
 */
public class LC271EncodeAndDecodeStrings {
    public static String[][] TEST_CASES = new String[][]
    {
        new String[] { "we","say",":","yes","!@#$%^&*()" },
        new String[] { "" },
        new String[] { "neet","code","love","you" },
        new String[] { "we","say",":","yes" },
        new String[] { "","   ","!@#$%^&*()_+","LongStringWithNoSpaces","Another, String With, Commas" },
    };

    private final String delimiter = "|";

    /**
     * Time: O(n)
     * Space: O(1)
     * @param strs
     * @return
     */
    public String encode(List<String> strs) {
        String result = "";
        for(int i = 0; i < strs.size(); i++) {
            String value = strs.get(i);
            result += value.length() + delimiter + strs.get(i);
        }
        return result;
    }

    /**
     * Time: O(n)
     * Space:
     * @param str
     * @return
     */
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            StringBuilder countWordStr = new StringBuilder();
            while (isDigit(str.charAt(index))) {
                countWordStr.append(str.charAt(index++));
            }
            if(!countWordStr.isEmpty() && str.charAt(index++) == delimiter.charAt(0)) { // delimiter
                int countWord = Integer.parseInt(countWordStr.toString());
                StringBuilder wordSB = new StringBuilder();
                for (int i = 0; i < countWord; i++) {
                    wordSB.append(str.charAt(index + i));
                }
                result.add(wordSB.toString());
                index += countWord;
            } else {
                index++;
            }
        }
        return result;
    }

    public boolean isDigit(char ch) {
        int val = ch - '0';
        return val >= 0 && val <= 9;
    }
}
