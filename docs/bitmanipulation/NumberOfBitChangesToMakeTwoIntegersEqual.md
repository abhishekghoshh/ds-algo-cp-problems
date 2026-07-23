# NumberOfBitChangesToMakeTwoIntegersEqual

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/NumberOfBitChangesToMakeTwoIntegersEqual.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int n = 13, k = 4;
        int ans = minChanges(n, k);
        System.out.println(ans);
    }
    public static int minChanges(int n, int k) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 0 && (k & 1) == 1) return -1;
            if ((n & 1) == 1 && (k & 1) == 0) count++;
            n = n >> 1;
            k = k >> 1;
        }
        if (k > 0) return -1;
        return count;
    }
```
