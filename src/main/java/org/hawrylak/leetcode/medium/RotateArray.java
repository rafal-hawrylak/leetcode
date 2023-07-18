package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

import java.util.Arrays;
import java.util.HashSet;

public class RotateArray implements Solution {
    @Override
    public Object run() {
        int[] nums = new int[]{1,2,3,4,5,6};
        rotate(nums, 4);
        assert Arrays.equals(nums, new int[]{3,4,5,6,1,2});
        return nums;
    }

    private void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int n = nums.length;
        int real_k = k % n;
        if (real_k == 0) {
            return;
        }
        int[] tmp_nums = new int[n];
        for (int i = 0; i < n; i++) {
            tmp_nums[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            int new_position = (i + real_k) % n;
            nums[new_position] = tmp_nums[i];
        }
    }
}
