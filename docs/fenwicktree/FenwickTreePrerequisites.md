# FenwickTreePrerequisites

**Topic:** `fenwicktree` | **File:** `com/problems/fenwicktree/FenwickTreePrerequisites.java`

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=DPiY9wFxGIw)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Remove the last set bit

```java
private static void type3() {
        int num = 710;
        System.out.println("710 in binary is " + Integer.toBinaryString(num));
        int ans = num - (num & (-num));
        System.out.println("after extracting last bit the binary is " + Integer.toBinaryString(ans));
    }
```

### Approach 2

Extract the first set bit from left

```java
private static void type2() {
        int num = 710;
        System.out.println("710 in binary is " + Integer.toBinaryString(num));
        int lastBit = num & (-num);
        System.out.println("last bit in binary is " + Integer.toBinaryString(lastBit));
    }
```

### Approach 1 — Brute Force

Check bit is set or not

```java
private static void type1() {
        int num = 710;
        int i = 3; // 0 indexed 3rd place means actually it is 2nd
        System.out.println("710 in binary is " + Integer.toBinaryString(num));
        int mask = (1 << (i - 1));
        System.out.println("mask in binary is " + Integer.toBinaryString(mask));
        int bit = (num & mask) == 0 ? 0 : 1;
        System.out.println("bit is " + bit);
    }
```
