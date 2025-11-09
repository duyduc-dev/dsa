package com.zenbox.leetcode;

import java.util.Stack;

/**
 * {@code LC150EvaluateReversePolishNotation}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation">LeetCode Problem 150: Evaluate Reverse Polish Notation</a>.
 * </p>
 */
public class LC150EvaluateReversePolishNotation {

    /**
     * Time: O(n)
     * Space: O(log(n))
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if("+-*/".contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "/" -> stack.push(num2 / num1);
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num2 - num1);
                    case "*" -> stack.push(num1 * num2);
                }
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}
