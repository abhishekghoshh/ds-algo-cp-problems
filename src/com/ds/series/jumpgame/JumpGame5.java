package com.ds.series.jumpgame;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-v/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=pQXbujZLTv0&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=5
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/1340.%20Jump%20Game%20V
 * */
public class JumpGame5 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // using dynamic programming
    private static void type2() {
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;
        int n = arr.length;
        int max = 0;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, jumpNext(i, arr, d, memo));
        }
        System.out.println(max);
    }

    private static int jumpNext(int i, int[] arr, int d, int[] memo) {
        if (memo[i] != 0) return memo[i];
        int max = 0;
        int currentHeight = arr[i];
        int rightBoundary = Math.min(arr.length - 1, i + d);
        int leftBoundary = Math.max(0, i - d);
        for (int id = i + 1; id <= rightBoundary; id++) {
            if (currentHeight > arr[id]) {
                max = Math.max(max, jumpNext(id, arr, d, memo));
            } else {
                break;
            }
        }
        currentHeight = arr[i];
        for (int id = i - 1; id >= leftBoundary; id--) {
            if (currentHeight > arr[id]) {
                max = Math.max(max, jumpNext(id, arr, d, memo));
            } else {
                break;
            }
        }
        return memo[i] = max + 1;
    }

    // brute force
    // using recursion
    private static void type1() {
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, jumpNext(i, arr, d));
        }
        System.out.println(max);
    }

    private static int jumpNext(int i, int[] arr, int d) {
        int max = 0;
        int currentHeight = arr[i];
        int rightBoundary = Math.min(arr.length - 1, i + d);
        int leftBoundary = Math.max(0, i - d);
        for (int id = i + 1; id <= rightBoundary; id++) {
            if (currentHeight > arr[id]) {
                max = Math.max(max, jumpNext(id, arr, d));
            } else {
                break;
            }
        }
        currentHeight = arr[i];
        for (int id = i - 1; id >= leftBoundary; id--) {
            if (currentHeight > arr[id]) {
                max = Math.max(max, jumpNext(id, arr, d));
            } else {
                break;
            }
        }
        return max + 1;
    }
}
