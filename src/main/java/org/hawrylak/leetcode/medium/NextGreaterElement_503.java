package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_503 implements Solution {

    @Override
    public Object run() {
        /*
        Example 1:

            Input: nums = [1,2,1]
            Output: [2,-1,2]
         */
        return null;
    }

    public int[] nextGreaterElements(int[] input) {
        var n = input.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();
        stack.push(input[n - 1]);

        for (int i = 2 * n - 1; i >= 0; i--) {
            var j = i % n;
            var cur = input[j];
            while (!stack.empty() && stack.peek() <= cur) {
                stack.pop();
            }
            if (!stack.empty()) {
                result[j] = stack.peek();
            }
            stack.push(cur);
        }

        return result;
    }
}
