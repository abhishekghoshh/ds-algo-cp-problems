# MakeArrayNonDecreasing

**Topic:** `stack` | **File:** `com/problems/stack/MakeArrayNonDecreasing.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/make-array-non-decreasing/description/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Most efficient approach

```java
private static void type4() {
        int[] nums = {4, 2, 5, 3, 5};
        int ans = maximumPossibleSize4(nums);
        System.out.println(ans);
    }
    private static int maximumPossibleSize4(int[] nums) {
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            if (prev <= num) {
                count++;
                prev = num;
            }
        }
        return count;
    }
```

### Approach 3

Exactly the same as previous type

```java
private static void type3() {
        int[] nums = {4, 2, 5, 3, 5};
        int ans = maximumPossibleSize3(nums);
        System.out.println(ans);
    }
    private static int maximumPossibleSize3(int[] nums) {
        int n = nums.length;
        int top = -1;
        int[] stack = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (top != -1 && num > stack[top])
                top--;
            stack[++top] = num;
        }
        return top + 1;
    }
```

### Approach 2

Optimized approach using stack, we need to choose a number such that it is the max of the current subarray. and ultimately, we need to make the array non-decreasing. we know whatever we choose, bigger elements will pop out in the answer sooner or later. if we can choose the array elements so that the chosen elements are non-decreasing, we can make the array non-decreasing. if we examine the next greater element problem, we can see that after the entire loop the stack becomes non-decreasing so that is the ask of this problem also.

```java
private static void type2() {
        int[] nums = {4, 2, 5, 3, 5};
        int ans = maximumPossibleSize2(nums);
        System.out.println(ans);
    }
    public static int maximumPossibleSize2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.isEmpty() && num > stack.peek())
                stack.pop();
            stack.push(num);
        }
        return stack.size();
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
