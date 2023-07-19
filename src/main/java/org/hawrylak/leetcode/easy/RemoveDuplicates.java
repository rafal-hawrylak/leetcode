package org.hawrylak.leetcode.easy;

import org.hawrylak.leetcode.Solution;

public class RemoveDuplicates implements Solution {

    @Override
    public Object run() {
        int k = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        assert k == 5;
        return k;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        int j = 1;
        int prev = nums[0];
        while (i < n) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
