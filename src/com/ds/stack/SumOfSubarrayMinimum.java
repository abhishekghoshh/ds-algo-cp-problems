package com.ds.stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 * https://www.codingninjas.com/studio/problems/sum-of-subarray-minimums_8365431
 *
 * Solution link :
 * https://www.youtube.com/watch?v=5vt98BZq_9A&list=PLVXdTUhgoFMqfRJzzdpJ5aeWnGKRgviKd&index=18
 * https://www.youtube.com/watch?v=9-TXIVEXX2w
 * https://www.youtube.com/watch?v=DA9fG6sRKsc
 * */
public class SumOfSubarrayMinimum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // same as type2
    // here we will use an array as stack
    private static void type3() {

    }

    // using stack
    private static void type2() {
        int[] nums = {3, 1, 2, 4};
        final int MOD = 1000000007;

        int n = nums.length;
        long[] previousSmaller = new long[n];
        long[] nextSmaller = new long[n];
        // Left Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        previousSmaller[0] = 1; // distance = 1
        for (int i = 1; i < n; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()]) stack.pop();
            // total distance if less element not found = i+1
            // distance = i-Left_st.peek()
            previousSmaller[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        // Right Stack
        stack = new Stack<>();
        stack.push(n - 1);
        nextSmaller[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.empty() && nums[i] <= nums[stack.peek()]) stack.pop();
            nextSmaller[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // for each value we have left and right contribution will be (Left * Right) * Element
        long res = 0;
        long prod, net;
        for (int i = 0; i < n; i++) {
            prod = (previousSmaller[i] * nextSmaller[i]) % MOD;
            net = nums[i] * prod;
            res = (res + net) % MOD;
        }
        int answer = (int) (res % MOD);

        System.out.println(answer);
    }


    // brute force
    // using 2 loops
    /// 3 4 8 5 1 5 9 10
    private static void type1() {

    }

}
