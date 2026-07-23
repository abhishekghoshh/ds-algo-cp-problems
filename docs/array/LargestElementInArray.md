# LargestElementInArray

**Topic:** `array` | **File:** `com/problems/array/LargestElementInArray.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/largest-element-in-the-array-largest-element-in-the-array_5026279)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=37E9ckMDdTk&t=531s)
- [📄 takeUforward](https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using in place time complexity O(n)

**Complexity:** Time: o(n)

```java
private static void type2() {
        int[] arr = {2, 5, 1, 3, 0};
        int max = Integer.MIN_VALUE;
        for (int item : arr) max = Math.max(max, item);
        System.out.println(max);
    }
```

### Approach 1 — Brute Force

Using sorting time complexity O(nlog(n))

**Complexity:** Time: o(nlog(n)

```java
private static void type1() {
        int[] arr = {2, 5, 1, 3, 0};
        int[] copy = ArrayUtil.copy(arr);
        Arrays.sort(copy);
        System.out.println(copy[copy.length - 1]);
    }
```
