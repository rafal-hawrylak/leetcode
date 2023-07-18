package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

import java.util.Arrays;

public class RotateArray implements Solution {
    @Override
    public Object run() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        assert Arrays.equals(nums, new int[]{5, 6, 7, 1, 2, 3, 4});
        return nums;
    }

    private void rotate(int[] nums, int k) {
        int n = nums.length;
        int real_k = k % n;
        boolean is_divider = n % real_k == 0;
        int how_often_switch = n / real_k;
        if (real_k == 0) {
            return;
        }
        int new_position = 0;
        int old_value = nums[0];
        for (int i = 0; i < n; i++) {
            if (is_divider && i > 0 && i % how_often_switch == 0) {
                new_position++;
                old_value = nums[new_position];
            }
            new_position = (new_position + real_k) % n;
            int tmp = nums[new_position];
            nums[new_position] = old_value;
            old_value = tmp;
        }
    }
}
