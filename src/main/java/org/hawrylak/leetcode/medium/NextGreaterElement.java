package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement implements Solution {

    @Override
    public Object run() {
        int[] example_1 = {1, 2, 3, 4};
        int[] expected_1 = {2, 3, 4, -1};
        test(solveGreedy(example_1), expected_1);
        test(solveSmart(example_1), expected_1);

        int[] example_2 = {4, 3, 2, 1};
        int[] expected_2 = {-1, -1, -1, -1};
        test(solveGreedy(example_2), expected_2);
        test(solveSmart(example_2), expected_2);

        int[] example_3 = {4, 1, 2, 5};
        int[] expected_3 = {5, 2, 5, -1};
        test(solveGreedy(example_3), expected_3);
        test(solveSmart(example_3), expected_3);

        int[] example_4 = {1, 3, 1, 3, 1, 3};
        int[] expected_4 = {3, -1, 3, -1, 3, -1};
        test(solveGreedy(example_4), expected_4);
        test(solveSmart(example_4), expected_4);

        int[] example_5 = {4, 4, 4, 4};
        int[] expected_5 = {-1, -1, -1,-1};
        test(solveGreedy(example_5), expected_5);
        test(solveSmart(example_5), expected_5);
        return example_5;
    }

    private void test(int[] actual, int[] expected) {
        System.out.println("actual = " + Arrays.toString(actual) + ", expected = " + Arrays.toString(expected));
        assert Arrays.equals(actual, expected);
    }

    private int[] solveGreedy(int[] input) {
        int n = input.length;
        int[] result = new int[n];
        result[n - 1] = -1;

        for (int i = 0; i < n - 1; i++) {
            result[i] = findBigger(input, i);
        }

        return result;
    }

    private int findBigger(int[] input, int k) {
        var value = input[k];
        for (int i = k + 1; i < input.length; i++) {
            if (input[i] > value) {
                return input[i];
            }
        }
        return -1;
    }

    private int[] solveSmart(int[] input) {
        var n = input.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(input[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            var cur = input[i];
            while (!stack.empty() && stack.peek() <= cur) {
                stack.pop();
            }
            if (!stack.empty()) {
                result[i] = stack.peek();
            }
            stack.push(cur);
        }

        return result;
    }
}
