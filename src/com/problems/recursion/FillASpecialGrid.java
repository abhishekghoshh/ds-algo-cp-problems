package com.problems.recursion;

import com.util.PrintUtl;

/*
 * Problem links:
 * https://leetcode.com/problems/fill-a-special-grid/description/
 *
 * Solution link
 *
 * */
public class FillASpecialGrid {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // recursive way
    private static void type2() {
        int N = 2;
        int[][] ans = specialGrid1(N);
        PrintUtl.print2D(ans);
    }

    public static int[][] specialGrid1(int N) {
        if (N == 0) return new int[][]{new int[]{0}};
        int n = 1 << N;
        int[][] arr = new int[n][n];
        int low = 0, high = (1 << 2 * N) - 1;
        fill2(arr, low, high, 0, n - 1, 0, n - 1);
        return arr;
    }

    private static void fill2(int[][] arr, int low, int high, int x1, int x2, int y1, int y2) {
        int count = high - low + 1;
        int d = (x2 - x1 + 1) / 2;
        int q = count / 4;
        if (count == 4) {
            arr[x1][y2] = low;
            arr[x2][y2] = low + 1;
            arr[x2][y1] = low + 2;
            arr[x1][y1] = high;
        } else {
            fill2(arr, low, low + q - 1, x1, x1 + d - 1, y1 + d, y2);
            fill2(arr, low + q, low + 2 * q - 1, x1 + d, x2, y1 + d, y2);
            fill2(arr, low + 2 * q, low + 3 * q - 1, x1 + d, x2, y1, y1 + d - 1);
            fill2(arr, low + 3 * q, high, x1, x1 + d - 1, y1, y1 + d - 1);
        }
    }

    // iterative way
    private static void type1() {

    }
}