# SumOfSubarrayMaximum

**Topic:** `stack`  

## 📝 Problem Statement

Given an array arr, find the sum of max(b) for every contiguous subarray.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

complete it in single pass

```java
    private static void type4() {

    }

    private static final int MOD = 1000000007;
```

### Approach 3

same as type2 here we will use an array as stack total distance if less element not found = i+1 distance = i-Left_st.peek() for each value we have left and right contribution will be (Left * Right) * Element

```java
    private static void type3() {
        int[] nums = {3, 1, 2, 4};

        int n = nums.length;

        // Left Stack
        long[] leftRange = new long[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && nums[i] >= nums[stack[top]]) top--;
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
            while (top != -1 && nums[i] >= nums[stack[top]]) top--;
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
```

### Approach 2

optimized approach using the stack same as the sum of subarray minimum total distance if less element not found = i+1 distance = i-Left_st.peek() for each value we have left and right contribution will be (Left * Right) * Element

```java
    private static void type2() {
        int[] nums = {3, 1, 2, 4};

        int n = nums.length;

        // Left Stack
        long[] leftRange = new long[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && nums[i] >= nums[stack.peek()]) stack.pop();
            // total distance if less element not found = i+1
            // distance = i-Left_st.peek()
            leftRange[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        // Right Stack
        long[] rightRange = new long[n];
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] >= nums[stack.peek()]) stack.pop();
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

    static int mod = (int) 1e9 + 7;
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`

```java
    private static void type1() {
        int[] arr = {3, 1, 2, 4};
        int n = arr.length;
        int ans = 0;
        int max;
        for (int i = 0; i < n; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                max = Math.max(max, arr[j]);
                ans = (ans + max) % mod;
            }
        }
        System.out.println(ans);
    }
}
```
