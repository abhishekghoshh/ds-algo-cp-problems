package com.problems.greedy;

import com.util.PrintUtl;
/*
 * Problem link:
 * https://leetcode.com/problems/minimum-cost-to-reach-every-position/description/
 *
 * Solution link:
 *
 */

// Tags: Array, Greedy
public class MinimumCostToReachEveryPosition {
    public static void main(String[] args) {
        type1();
    }

    // todo optimized approach
    //  lets say the array is [4, 3, 2, 1, 5, 2]
    //  to go to the 2nd last we have to option either go to 1 or 5
    //  minimum is 1 and from from 1 we dont need to add any more cost
    //  we will compute from the start to end and find the minimum cost
    //  the minimum cost will be the answer for every cell as if we find min then we can go easily to the backward cell
    //  without adding any more cost
    private static void type1() {
        int[] cost = {1, 2, 3, 4, 5};
        int[] result = minCosts(cost);
        PrintUtl.print(result);
    }

    public static int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, cost[i]);
            ans[i] = min;
        }
        return ans;
    }
}
