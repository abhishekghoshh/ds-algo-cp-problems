package com.problems.array;
/*
 * Problem link :
 * https://leetcode.com/contest/weekly-contest-454/problems/count-special-triplets/
 * https://leetcode.com/problems/count-special-triplets/description/
 *
 * Solution link :
 *
 *
 */

import java.util.HashMap;
import java.util.Map;

// Tags : Array
public class CountSpecialTriplets {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // very efficient solution
    // we could use a map to store the count of each number, but here we are using an array
    // to store the count of each number, which is more efficient in terms of time complexity
    // Time Complexity: O(2n)
    // Space Complexity: O(2*(max(nums) - min(nums) + 1))
    // for space optimization, we are checking the min and max of the array and then creating an array of size (max - min + 1)
    // we are using 2 freq array, one for current freq as we traverse the array and other for the overall freq of the numbers
    // so for the solution, we are considering each number x in the array and checking
    // how many 2x is present in left and how many 2x is present in right
    // every time we are incrementing the current freq of the number x
    // we will know the left freq of 2x from currFreq but how do we know the right freq?
    // right freq will freq[2x] - currFreq[2x]
    private static void type2() {
        int[] nums = {8, 4, 2, 8, 4};
        int ans = specialTriplets2(nums);
        System.out.println(ans);
    }

    private static int specialTriplets2(int[] nums) {
        long total = 0;
        int MOD = 1000000007;
        // counting the min and max of the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int offset = -min;
        int N = max + offset + 1;
        int[] freq = new int[N];
        int[] currFreq = new int[N];
        for (int num : nums) {
            freq[num + offset]++;
        }
        for (int num : nums) {
            // adjusting the number to the offset
            int seed = num + offset;
            int seedDouble = num * 2 + offset;
            // if seedDouble is not out of bounds and present in the both freq arrays
            if (seedDouble < N && freq[seedDouble] > 0 && currFreq[seedDouble] > 0) {
                int leftC = currFreq[seedDouble];
                int rightC = freq[seedDouble] - leftC;
                // for num 0, 2*num will also be 0, so the right count will also hold the current 0
                // we need to decrement the right count by 1
                if (num == 0) rightC--;
                // calculating the number of special triplets
                // for each seed, we can form leftC * rightC special triplets
                long ans = (long) leftC * rightC % MOD;
                total = (total + ans) % MOD;
            }
            currFreq[seed]++;
        }
        return (int) (total % MOD);
    }

    // so for the solution, we are considering each number x in the array and checking
    // how many 2x is present in left and how many 2x is present in right
    // every time we are incrementing the current freq of the number x.
    // we will know the left freq of 2x from currFreq but how do we know the right freq?
    // right freq will freq[2x] - currFreq[2x]
    private static void type1() {
        int[] nums = {8, 4, 2, 8, 4};
        int ans = specialTriplets1(nums);
        System.out.println(ans);
    }

    public static int specialTriplets1(int[] nums) {
        long total = 0;
        int MOD = 1000000007;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> currFreq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            // adjusting the number to the offset
            int numD = num * 2;
            // if seedDouble is not out of bounds and present in the both freq arrays
            if (freq.containsKey(numD) && currFreq.containsKey(numD)) {
                int leftC = currFreq.get(numD);
                int rightC = freq.get(numD) - leftC;
                // for num 0, 2*num will also be 0, so the right count will also hold the current 0
                // we need to decrement the right count by 1
                if (num == 0) rightC--;
                // calculating the number of special triplets
                // for each seed, we can form leftC * rightC special triplets
                long ans = (long) leftC * rightC % MOD;
                total = (total + ans) % MOD;
            }
            currFreq.put(num, currFreq.getOrDefault(num, 0) + 1);
        }
        return (int) (total % MOD);
    }
}