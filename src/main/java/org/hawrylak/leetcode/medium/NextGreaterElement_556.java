package org.hawrylak.leetcode.medium;

import org.hawrylak.leetcode.Solution;

public class NextGreaterElement_556 implements Solution {

    @Override
    public Object run() {
        /*
        Example 1:
            Input: n = 12
            Output: 21

        Example 2:
            Input: n = 21
            Output: -1
         */
        return null;
    }

    public int nextGreaterElement(int n) {
        int[] arr = convertToArr(n);

        int k = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return -1;
        }

        int j = arr.length - 1;
        for (int i = k + 1; i < arr.length; i++) {
            if (arr[k] >= arr[i]) {
                j = i - 1;
                break;
            }
        }

        int tmp = arr[k];
        arr[k] = arr[j];
        arr[j] = tmp;

        int start = k + 1;
        int end = arr.length - 1;
        int length = end - start + 1;
        for (int i = start; i < start + length / 2; i++) {
            j = arr.length - 1 - (i - start);
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return convertToNumber(arr);
    }

    private int[] convertToArr(int n) {
        int digitsN = (int) (Math.log10(n) + 1);
        int[] arr = new int[digitsN];
        int m = n;
        for (int i = digitsN - 1; i >= 0; i--) {
            arr[i] = m % 10;
            m /= 10;
        }
        return arr;
    }

    private int convertToNumber(int[] arr) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = 10 * res + arr[i];
            if (res > (long) (Integer.MAX_VALUE)) {
                return -1;
            }
        }

        return (int) res;
    }
}
