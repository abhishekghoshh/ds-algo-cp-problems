package com.problems.math;

public class HillProblem {

    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {4, 5, 11, 10, 21, 3, 1};
        boolean ans = check(arr);
        System.out.println(ans);
    }

    private static boolean check(int[] arr) {
        int n = arr.length;
        int prev = Integer.MIN_VALUE;
        int pivot = -1;
        int i = 0;
        for (; i < n; i++) {
            if (prev > arr[i]) {
                break;
            }
            pivot = i;
            prev = arr[i];
        }
        if (pivot == n - 1) return false;
        prev = arr[pivot];
        for (i = pivot + 1; i < n; i++) {
            if (prev < arr[i]) {
                break;
            }
            prev = arr[i];
        }
        return i == n;
    }
}
