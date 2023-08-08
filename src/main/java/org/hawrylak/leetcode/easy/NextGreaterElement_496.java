package org.hawrylak.leetcode.easy;

import org.hawrylak.leetcode.Solution;

import java.util.*;

public class NextGreaterElement_496 implements Solution {
    @Override
    public Object run() {
        /*
          Ex 1.
           Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
           Output: [-1,3,-1]

          Ex 2.
           Input: nums1 = [2,4], nums2 = [1,2,3,4]
           Output: [3,-1]
         */
        return null;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m];
        if (m == 0) {
            return ans;
        }
        int[] greaters = findAllGreater(nums2);
        Arrays.fill(ans, -1);
        Map<Integer, Integer> idx = new HashMap<>();
        Set<Integer> nums1Set = addAll(nums1);
        for (int i = 0; i < n; i++) {
            if (nums1Set.contains(nums2[i])) {
                idx.put(nums2[i], i);
            }
        }

        for (int i = 0; i < m; i++) {
            ans[i] = greaters[idx.get(nums1[i])];
        }

        return ans;
    }

    private Set<Integer> addAll(int[] input) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int[] findAllGreater(int[] input) {
        int m = input.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(input[m - 1]);
        for (int i = m - 2; i >= 0; i--) {
            var cur = input[i];
            while (!stack.empty() && stack.peek() < cur) {
                stack.pop();
            }
            if (!stack.empty()) {
                ans[i] = stack.peek();
            }
            stack.push(cur);
        }

        return ans;
    }
}
