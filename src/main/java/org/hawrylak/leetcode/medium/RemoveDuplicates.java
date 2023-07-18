package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

public class RemoveDuplicates implements Solution {

    @Override
    public Object run() {
        var k = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        assert k == 5;
        return k;
    }

    public int removeDuplicates(int[] nums) {
        int i = 2;
        int j = 2;
        int n = nums.length;
        int prev = nums[0];
        while (i < n) {
            boolean isAhead = j - i > 2;
            int to_check = isAhead ? nums[i - 2] : prev;
            if (to_check == nums[i]) {

            } else {
                if (!isAhead) {
                    prev = nums[i - 1];
                }
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
