# NextGreaterElementInCircle

**Topic:** `stack` | **File:** `com/problems/stack/NextGreaterElementInCircle.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/next-greater-element-ii/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/next-greater-element-ii_6212757)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2)
- [▶ YouTube](https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=75)
- [📄 takeUforward](https://takeuforward.org/data-structure/next-greater-element-using-stack/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Same as previous type4 here we are using an array as stack instead of in build stack class of java

```java
private static void type3() {
        int[] nums = {5, 7, 1, 2, 6, 0};
        int n = nums.length;
        int[] answer = new int[n];
        int[] stack = new int[2 * n];
        int top = -1;
        // we will start from 2*n-1
        // its like we are copying the same array and append it after the original
        // so i%n will give the index which will be 0 to n-1
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (top != -1 && stack[top] <= nums[i % n]) top--;
            if (i < n) {
                if (top != -1) answer[i] = stack[top];
                else answer[i] = -1;
            }
            stack[++top] = nums[i % n];
        }
        print(answer);
    }
```

### Approach 2

This is also the next greater element problem but it will check circular

```java
private static void type2() {
        int[] nums = {5, 7, 1, 2, 6, 0};
        int n = nums.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        // we will start from 2*n-1
        // its like we are copying the same array and append it after the original
        // so i%n will give the index which will be 0 to n-1
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) stack.pop();
            if (i < n) {
                if (!stack.isEmpty()) answer[i] = stack.peek();
                else answer[i] = -1;
            }
            stack.push(nums[i % n]);
        }
        print(answer);
    }
```

### Approach 1 — Brute Force

Brute force to check

```java
private static void type1() {

    }
```
