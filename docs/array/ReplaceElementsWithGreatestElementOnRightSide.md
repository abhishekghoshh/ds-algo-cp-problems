# ReplaceElementsWithGreatestElementOnRightSide

**Topic:** `array` | **File:** `com/problems/array/ReplaceElementsWithGreatestElementOnRightSide.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach we can do it in one pass, we just need to store the prev max result in a variable time complexity O(n) space complexity O(1)

**Complexity:** Time: o(n) | Space: o(1)

```java
private static void type2() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] ans = replaceElements2(arr);
        print(ans);
    }
    public static int[] replaceElements2(int[] arr) {
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            arr[i] = max;
            max = Math.max(max, num);
        }
        return arr;
    }
```

### Approach 1 — Brute Force

Simple brute force time complexity O(n^2) space complexity O(n)

**Complexity:** Time: o(n^2) | Space: o(n)

```java
private static void type1() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] ans = replaceElements1(arr);
        print(ans);
    }
    public static int[] replaceElements1(int[] arr) {
        int n = arr.length;
        int[] copy = arr.clone();
        for (int i = n - 1; i >= 0; i--) {
            int max = -1;
            // checking the max on the right side
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, copy[j]);
            }
            arr[i] = max;
        }
        return arr;
    }
```
