# SecondLargestElementInArray

**Topic:** `array` | **File:** `com/problems/array/SecondLargestElementInArray.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=37E9ckMDdTk&t=811s)
- [📄 takeUforward](https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using two variables

```java
private static void type2() {
        int[] arr = {1, 2, 4, 6, 7, 5};
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int item : arr) {
            if (item > max1) {
                max2 = max1;
                max1 = item;
            } else if (item > max2) {
                max2 = item;
            }
            if (item < min1) {
                min2 = min1;
                min1 = item;
            } else if (item < min2) {
                min2 = item;
            }
        }
        System.out.println(min1 + " , " + max2);
    }
```

### Approach 1 — Brute Force

Using sort

```java
private static void type1() {
        int[] arr = {1, 2, 4, 6, 7, 5};
        int n = arr.length;
        Arrays.sort(arr);
        System.out.println(arr[1] + " , " + arr[n - 2]);
    }
```
