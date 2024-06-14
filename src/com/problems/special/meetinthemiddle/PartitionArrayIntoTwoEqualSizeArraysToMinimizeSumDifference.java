package com.problems.special.meetinthemiddle;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link:
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
 *
 *
 * Solution link:
 * https://www.youtube.com/watch?v=wKeGeBN3u18 -> Tech dose
 * https://www.youtube.com/watch?v=JUFHwaZjO_M -> Happy Engineering With Anmol
 * https://www.youtube.com/watch?v=45TkgKy0GS0 -> Aryan Mittal
 * https://www.youtube.com/watch?v=R9n_Hq2YDhs -> Programming Live with Larry
 */
public class PartitionArrayIntoTwoEqualSizeArraysToMinimizeSumDifference {

    public static void main(String[] args) {
        type1();
        type2();
    }

    // using meet in the middle approach
    private static void type2() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        int ans = minimumDifference2(nums);
        System.out.println(ans);
    }

    // optimized approach
    private static int minimumDifference2(int[] nums) {
        int n = nums.length / 2;
        int sum = 0;
        for (int num : nums) sum += num;
        List<Integer>[] part1 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) part1[i] = new ArrayList<>();
        List<Integer>[] part2 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) part2[i] = new ArrayList<>();

        // power set approach to find all the sum but here
        // we will also store the sums along with how many numbers required making that sum
        int N = (1 << n);
        for (int num = 0; num < N; num++) {
            int p1 = 0, p2 = 0, count = 0;
            for (int d = 0; d < n; d++) {
                int bit = (num >> d) & 1;
                if (bit == 1) {
                    count++;
                    p1 += nums[d];
                    p2 += nums[n + d];
                }
            }
            part1[count].add(p1);
            part2[count].add(p2);
        }

        return -1;
    }

    // TODO Brute force with Man in the middle technique
    private static void type1() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        int ans = minimumDifference1(nums);
        System.out.println(ans);
    }

    // so we will divide the array into 2 equal parts
    // and build a power set for both parts,
    // but for this time along with the sums, we will also store
    // how many numbers are taken to produce the sum.
    // we will do this for both parts.
    // so for part1 there will be a map of 0=>{0},...n={sum}
    // same for part2 we will have a map of 0=>{0},...n={sum}
    // now we will produce sum1 by adding part1[i] + part2[n-i]
    // and sum2 will be totalSum - sum
    public static int minimumDifference1(int[] nums) {
        int n = nums.length / 2;
        int sum = 0;
        for (int num : nums) sum += num;
        List<Integer>[] partSum1 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) partSum1[i] = new ArrayList<>();
        powerSet1(0, 0, n, 0, nums, partSum1);

        List<Integer>[] partSum2 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) partSum2[i] = new ArrayList<>();
        powerSet1(n, 0, 2 * n, 0, nums, partSum2);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n / 2; i++) {
            // we will calculate all the sum for part1[i] and part2[n-i] and take the minimum
            for (int part1Sum : partSum1[i]) {
                for (int part2Sum : partSum2[n - i]) {
                    int sum1 = part1Sum + part2Sum;
                    ans = Math.min(ans, Math.abs(sum - 2 * sum1));
                }
            }
        }
        return ans;
    }

    static void powerSet1(int i, int numOfElements, int end, int sum, int[] nums, List<Integer>[] partSum) {
        if (i == end) {
            partSum[numOfElements].add(sum);
            return;
        }
        powerSet1(i + 1, numOfElements + 1, end, sum + nums[i], nums, partSum);
        powerSet1(i + 1, numOfElements, end, sum, nums, partSum);
    }
}
