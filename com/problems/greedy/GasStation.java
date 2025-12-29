package com.problems.greedy;

/*
 * Problem link :
 * https://leetcode.com/problems/gas-station/description/
 *
 * Solution link :
 *
 * https://www.youtube.com/watch?v=lJwbPZGo05A
 * https://www.youtube.com/watch?v=SmTow5Ht4iU
 *
 * */
public class GasStation {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // using greedy solution
    // this is not super intuitive
    // see the YouTube video
    // first we will check if sum(gas) >= sum(cost) or not
    // the question have only one valid answer if it exists
    // we will try to solve it linearly

    // the main intuition is we will start from an index where we will acquire positive gas as much as possible
    // lets say we started from index i and at some j the total remaining gas becomes negative
    // so we don't need to check from i+1 as at i we got positive gas that's why we started from there
    // if we remove gas acquired at index i then even i+1 to j will also not make any sense
    // as i to j is already negative, and we are removing ith index gas, that will again make it more negative
    // we will start from j+1 and reset the current gas to 0

    // also anything in between index i and j can never be the answer
    // let's say the answer lies between index i and j, and which is index k
    // ideally index k should give enough surplus gas to reach j
    // and the gas at i to k must be positive other otherwise we could not reach to k from i
    // so if k be the answer then from k to we could go to j, but again that invalidates our current math
    // currently at j we are having negative gas, so k can never be the answer
    // so we will start from j+1 and reset the current gas to 0
    private static void type3() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int ans = canCompleteCircuit3(gas, cost);
        System.out.println(ans);
    }

    private static int canCompleteCircuit3(int[] gas, int[] cost) {
        int n = gas.length;
        // we will check sum(gas) >= sun(cost) or not
        if (sum(gas) < sum(cost)) return -1;
        int currGas = 0; // to keep track of current gas
        int start = 0; // to keep track of starting index
        for (int i = 0; i < n; i++) {
            currGas += gas[i] - cost[i];
            // if at any point currGas < 0 we will reset currGas and start from the next index
            if (currGas < 0) {
                currGas = 0;
                start = i + 1;
            }
        }
        return start;
    }

    // this is little optimized approach but it will also hit TLE
    // using greedy approach
    // the greedy approach is not super intuitive
    // first we will check if sum(gas) >= sum(cost) or not
    // the question have only one valid answer if it exists
    // so both i and j can never be the solution
    // also let's say we have started from i and we reached end and the total gas is positive
    // so we do not need to check for 0 to i-1
    // as sum(gas) >= sum(cost) so the total gas from 0 to i-1 must be negative, but it can never surpass
    // the remaining gas we have when we reached end
    // so 'i' must be the answer
    // so we will start from 0 and keep track of total gas and if at any point total gas becomes negative
    // we will start from the next index and reset total gas to 0
    // if we reach the end we will return the starting index that will be our answer
    private static void type2() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int ans = canCompleteCircuit2(gas, cost);
        System.out.println(ans);
    }

    private static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        // we will check sum(gas) >= sun(cost) or not
        if (sum(gas) < sum(cost)) return -1;
        // now we will start from each index and try to reach end
        for (int start = 0; start < n; start++) {
            int currGas = 0;
            int curr = start;
            while (curr < n) {
                currGas += gas[curr] - cost[curr];
                // at any point if currGas < 0 we will break and try from the next index
                if (currGas < 0) break;
                curr++;
            }
            if (curr == n) return start; // we have reached the end
        }
        return -1;
    }

    // brute force
    // so from every index we will try to come to the starting index complete the circuit
    // if somewhere in the circuit we see that the gas becomes negative we will break and try from the next index
    // but before that we will check sum(gas) >= sun(cost) or not
    // if not then we will never be able to complete the circuit
    private static void type1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int ans = canCompleteCircuit1(gas, cost);
        System.out.println(ans);
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        // we will check sum(gas) >= sun(cost) or not
        if (sum(gas) < sum(cost)) return -1;
        // now we will start from each index and try to complete the circuit
        for (int start = 0; start < n; start++) {
            int currGas = 0;
            int curr = start;
            while (true) {
                currGas += gas[curr] - cost[curr];
                // at any point if currGas < 0 we will break and try from the next index
                if (currGas < 0) break;
                // we are using modulo to come back to the starting index
                curr = (curr + 1) % n;
                // if we have come back to the starting index we will return the starting index
                if (curr == start) return start;
            }
        }
        return -1;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int g : arr) {
            sum += g;
        }
        return sum;
    }
}
