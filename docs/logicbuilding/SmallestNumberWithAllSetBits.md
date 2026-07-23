# SmallestNumberWithAllSetBits

**Topic:** `logicbuilding` | **File:** `com/problems/logicbuilding/SmallestNumberWithAllSetBits.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/contest/weekly-contest-426/problems/smallest-number-with-all-set-bits/description/)

## Approaches

Implementation:

### Implementation

Brute force also the simplest solution

```java
private static void type1() {
        int ans = smallestNumber1(10);
    }
    public static int smallestNumber1(int n) {
        if (n <= 1) return 1;
        if (n <= 3) return 3;
        if (n <= 7) return 7;
        if (n <= 15) return 15;
        if (n <= 31) return 31;
        if (n <= 63) return 63;
        if (n <= 127) return 127;
        if (n <= 255) return 255;
        if (n <= 511) return 511;
        if (n <= 1023) return 1023;
        return -1;
    }
```
