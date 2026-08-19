package com.zenbox.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MonotonicQueue {
    public static void main(String[] args) {
        var stack = new StackSolve();
        List<Integer> data = List.of(3, 4, 2, 7, 5, 8, 4, 6);

        var res = stack.solve(data);
        var expected = List.of(-1, 0, -1, 2, 2, 4, 2, 2);

        for (int i = 0; i < res.size(); i++) {
            assert res.get(i) == expected.get(i)
                    : "This is not correct at " + i + " with (" + res.get(i) + ", " + expected.get(i) + ")";
        }
    }

    static class StackSolve {
        List<Integer> solve(List<Integer> list) {
            int n = list.size();
            var res = new ArrayList<Integer>();

            var stack = new Stack<int[]>();

            for (int i = 0; i < n; i++) {
                int curr = list.get(i);

                while (!stack.isEmpty() && stack.peek()[0] > curr) {
                    stack.pop();
                }

                res.add(stack.isEmpty() ? -1 : stack.peek()[1]);
                stack.add(new int[] { curr, i });
            }

            return res;
        }
    }
}
