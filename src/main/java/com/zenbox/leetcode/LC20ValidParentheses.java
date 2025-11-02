package com.zenbox.leetcode;

import java.util.Stack;

/**
 * {@code LC20ValidParentheses}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/valid-parentheses">LeetCode Problem 20: Valid Parentheses</a>.
 * </p>
 */
public class LC20ValidParentheses {

    /**
     * Time: O(n)
     * Space: O(log(n))
     * @param s
     * @return
     */
    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(') stack.push(')');
            else if(ch == '[') stack.push(']');
            else if(ch == '{') stack.push('}');
            else if(stack.isEmpty() || stack.pop() != ch) return false;
        }

        return stack.isEmpty();
    }

    /**
     * Time: O(n)
     * Space: O(log(n))
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                char charPop = stack.pop();
                boolean isValid = (ch == ')' && charPop == '(') || (ch == ']' && charPop == '[') || (ch == '}' && charPop == '{');
                if(!isValid) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
