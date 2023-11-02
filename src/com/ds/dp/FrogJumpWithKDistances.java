package com.ds.dp;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/minimal-cost_8180930
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5
 *
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
 * */
public class FrogJumpWithKDistances {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // space optimization can be done but it will make the code very complex
    // in frog jump example we were taking prev and prev2 to track
    // here we can take an array of o(k) elements
    // but then every time we have to add value and on every iteration we have to update the value
    // so it is not advisable
    private static void type4() {
    }

    // using tabulation
    // Time complexity O(k*n)
    // space complexity O(n) for array
    private static void type3() {
        int[] height = {10, 40, 50, 20, 60};
        int n = height.length;
        int k = 3;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int i = 1; i < n; i++) {
            int minJumpEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jumpEnergy = Math.abs(height[i] - height[i - j]) + memo[i - j];
                    minJumpEnergy = Math.min(minJumpEnergy, jumpEnergy);
                }
            }
            memo[i] = minJumpEnergy;
        }
        System.out.println(memo[n - 1]);
    }

    // using memoization
    // Time complexity O(k*n)
    // space complexity O(2n) for stack space and array
    private static void type2() {
        int[] height = {10, 40, 50, 20, 60};
        int n = height.length;
        int k = 3;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int answer = frogJumpK(n - 1, k, height, memo);
        System.out.println(answer);
    }

    private static int frogJumpK(int i, int k, int[] height, int[] memo) {
        if (i == 0)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        int minJumpEnergy = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int jumpEnergy = Math.abs(height[i] - height[i - j]) + frogJumpK(i - j, k, height, memo);
                minJumpEnergy = Math.min(minJumpEnergy, jumpEnergy);
            }
        }
        return memo[i] = minJumpEnergy;
    }

    // using Recursion
    // Time complexity O(k^n)
    // space complexity O(n) for stack space
    private static void type1() {
        int[] height = {10, 40, 50, 20, 60};
        int n = height.length;
        int k = 3;
        int answer = frogJumpK(n - 1, k, height);
        System.out.println(answer);
    }

    //Same as the normal frog jump just here we are checking previous k positions
    private static int frogJumpK(int i, int k, int[] height) {
        if (i == 0)
            return 0;
        int minJumpEnergy = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int jumpEnergy = Math.abs(height[i] - height[i - j]) + frogJumpK(i - j, k, height);
                minJumpEnergy = Math.min(minJumpEnergy, jumpEnergy);
            }
        }
        return minJumpEnergy;
    }
}
