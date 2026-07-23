# Radix Sort

## Problem Link
- (No specific problem link in source)

## Solution Link
- [GeeksforGeeks](https://www.geeksforgeeks.org/radix-sort/)

## Approach

Radix sort processes digits from least significant to most significant. At each digit position (1s, 10s, 100s, ...), it uses Counting Sort (which is stable) to sort by that digit. Because counting sort is stable, the relative order from previous passes is preserved.

## Complexity
- **Time**: O(d × (n + k)) where d = number of digits, k = base (10)
- **Space**: O(n + k)
- **Stable**: Yes

## Code

```java
package com.algo.sort;

public class RadixSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {121, 432, 564, 23, 1, 45, 788};
        int max = max(arr);
        // Apply counting sort for each digit place (1s, 10s, 100s, ...)
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(arr, arr.length, place, max);
        PrintUtl.print(arr);
    }

    private static void countingSort(int[] arr, int n, int place, int max) {
        int[] output = new int[n + 1];
        int[] count = new int[max + 1];
        // Count occurrences of each digit at current place
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }
        // Cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        // Place elements in sorted order (right to left for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            int item = count[digit];
            output[item - 1] = arr[i];
            count[item]--;
        }
        copy(arr, output);
    }
}
```

## How It Works

```
Input: [121, 432, 564, 23, 1, 45, 788]

place=1  (units digit):   sort by last digit  → [121, 1, 432, 23, 564, 45, 788]
place=10 (tens digit):    sort by tens digit  → [1, 121, 23, 432, 45, 564, 788]
place=100 (hundreds digit): sort by hundreds   → [1, 23, 45, 121, 432, 564, 788]
```

## Key Property

Radix sort can sort in O(n) when the number of digits is constant. It is commonly used for sorting large sets of integers or strings of fixed width.
