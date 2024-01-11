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
        type4();
        type5();
    }

    // Best solution
    // TODO check it one more time
    // to solve the solution in a single pass
    private static void type5() {
        int[] nums = {3, 1, 2, 4};
        long sum = 0;
        Stack<Integer> st = new Stack<>();

        // we are maintaining a monotonic increasing array here
        // like the type2 or type3, we will not do it in two different loops
        // if the stack is current 1 3 6 and the current item is 4
        // so look for stack top element we have found the range
        // in left it has 3 and in right it has 4
        // we dont need an extra loop to calculate everything
        // but this loop will run till n
        // on the last pass we will pop one by one and calculate the range
        for (int i = 0; i <= nums.length; i++) {
            while (!st.isEmpty() && (i == nums.length || nums[i] <= nums[st.peek()])) {
                int top = st.pop();
                long left = top - (st.isEmpty() ? -1 : st.peek());
                long right = i - top;
                sum += left * right * nums[top];
            }
            st.push(i);
        }
        System.out.println(sum);
    }

    static int mod = (int) 1e9 + 7;

    //TODO study this solution later
    private static void type4() {
        int[] arr = {3, 1, 2, 4};

        int n = arr.length + 1;
        int[] left = new int[n];
        int[] ext = new int[n];
        int[] sums = new int[n];
        for (int i = 0; i < n - 1; ++i)
            ext[i + 1] = arr[i];

        int res = 0;
        for (int i = 1; i < n; i++) {
            int cur = ext[i];
            int l = i - 1;
            while (ext[l] >= cur)
                l = left[l];

            left[i] = l;
            sums[i] = sums[l] + cur * (i - l);
            res = (res + sums[i]) % mod;
        }
        System.out.println(res);
    }

    // same as type2
    // here we will use an array as stack
    private static void type3() {
        int[] nums = {3, 1, 2, 4};

        int n = nums.length;

        // Left Stack
        long[] leftRange = new long[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && nums[i] <= nums[stack[top]]) top--;
            // total distance if less element not found = i+1
            // distance = i-Left_st.peek()
            leftRange[i] = top == -1 ? i + 1 : i - stack[top];
            stack[++top] = i;
        }
        // Right Stack
        long[] rightRange = new long[n];
        stack = new int[n];
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && nums[i] <= nums[stack[top]]) top--;
            rightRange[i] = top == -1 ? n - i : stack[top] - i;
            stack[++top] = i;
        }

        // for each value we have left and right contribution will be (Left * Right) * Element
        long res = 0;
        long prod, net;
        for (int i = 0; i < n; i++) {
            prod = (leftRange[i] * rightRange[i]) % MOD;
            net = nums[i] * prod;
            res = (res + net) % MOD;
        }
        int answer = (int) (res % MOD);

        System.out.println(answer);
    }

    private static final int MOD = 1000000007;

    // using stack
    // intuition is
    // rather creating all the subarrays and then find the minimum
    // we will find the range of subarray for every element
    // suppose we are considering a subarray 1 3 5 2 4 6 1
    // we are finding range of subarray for element 2
    // for the element 2 the range is from 3 5 2 4 6
    // on the left it is 3 5 2 and on the right it is 2 4 6
    // so including 2 we can make 3 subarrays in left and 3 in right
    // so now we just have the find the lower index in left and right
    // which will be the boundary or we can say stack.peek()
    // if stack is empty then count will be i+1
    // like for 5 4 3 => for the element 3 there is element lesser in left
    // so the stack will be empty
    // on the left we can make i + 1 or 2+1=> 3 subarrays => 5 4 3 then 4 3 then only 3
    // similar on the right side
    private static void type2() {
        int[] nums = {3, 1, 2, 4};

        int n = nums.length;

        // Left Stack
        long[] leftRange = new long[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && nums[i] <= nums[stack.peek()]) stack.pop();
            // total distance if less element not found = i+1
            // distance = i-Left_st.peek()
            leftRange[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        // Right Stack
        long[] rightRange = new long[n];
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] <= nums[stack.peek()]) stack.pop();
            rightRange[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // for each value we have left and right contribution will be (Left * Right) * Element
        long res = 0;
        long prod, net;
        for (int i = 0; i < n; i++) {
            prod = (leftRange[i] * rightRange[i]) % MOD;
            net = nums[i] * prod;
            res = (res + net) % MOD;
        }
        int answer = (int) (res % MOD);

        System.out.println(answer);
    }


    // brute force
    // using 2 loops
    private static void type1() {
        int[] arr = {3, 1, 2, 4};
        int n = arr.length;
        int ans = 0;
        int min;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                ans = (ans + min) % mod;
            }
        }
        System.out.println(ans);
    }

}
