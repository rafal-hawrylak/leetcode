package org.hawrylak.leetcode.easy;

import org.hawrylak.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement implements Solution {
    @Override
    public Object run() {
        var m = majorityElement(new int[]{3,3,4});
        assert m == 2;
        return m;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        int most_frequent_key = 1;
        int most_frequent_value = nums[0];
        for (int num : nums) {
            if (freqs.containsKey(num)) {
                int freq = freqs.get(num) + 1;
                if (freq > most_frequent_key) {
                    most_frequent_value = num;
                    most_frequent_key = freq;
                }
                freqs.put(num, freq);
            } else {
                freqs.put(num, 1);
            }
        }
        return most_frequent_value;
    }
}
