package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

public class CanJump implements Solution {
    @Override
    public Object run() {
        boolean canJump = canJump(new int[]{2,3,1,1,4});
        assert canJump;
        return canJump;
    }

    private boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int farthest_reachable = 0;
        for (int i = 0; i < n - 1; i++) {
            if (reachable[i]) {
                int jumps = nums[i];
                for (int j = Math.max(farthest_reachable, i + 1); j <= i + jumps; j++) {
                    if (j >= n) {
                        return true;
                    }
                    reachable[j] = true;
                    farthest_reachable = Math.max(farthest_reachable, j);
                }
            }
        }
        return reachable[n - 1];
    }
}
