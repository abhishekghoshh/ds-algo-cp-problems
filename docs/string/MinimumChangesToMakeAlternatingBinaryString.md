# MinimumChangesToMakeAlternatingBinaryString

**Topic:** `string` | **File:** `com/problems/string/MinimumChangesToMakeAlternatingBinaryString.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=9vAQdmVU2ds)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Exactly same as the previous just here we will use one iteration but the checks are same here also

```java
private static void type3() {
        String s = "0100";
        int ans = minOperations3(s);
        System.out.println(ans);
    }
    public static int minOperations3(String s) {
        char[] arr = s.toCharArray();
        // we are choosing the first bit to be 0
        int counter1 = 0, counter2 = 0;
        int bit1 = 0, bit2 = 1;
        for (char ch : arr) {
            int b = ch - '0';
            // if the bit is already b then we need to change, and we will increment the counter
            if (b != bit1) counter1++;
            if (b != bit2) counter2++;
            // toggle the bit
            bit1 = (1 - bit1);
            bit2 = (1 - bit2);
        }
        // we will take the minimum
        return Math.min(counter1, counter2);
    }
```

### Approach 2

Optimized approach here we will check how many changes required to make it some like 101010101... and then we will check how many changes required to make it like 010101010....

```java
private static void type2() {
        String s = "0100";
        int ans = minOperations2(s);
        System.out.println(ans);
    }
    public static int minOperations2(String s) {
        char[] arr = s.toCharArray();
        // we are choosing the first bit to be 0
        int counter1 = 0;
        int bit = 0;
        for (char ch : arr) {
            int b = ch - '0';
            // if the bit is already b then we need to change, and we will increment the counter
            if (b != bit) counter1++;
            // toggle the bit
            bit = (1 - bit);
        }
        int counter2 = 0;
        bit = 1;
        for (char ch : arr) {
            int b = ch - '0';
            // if the bit is already b then we need to change and we will increment the counter
            if (b != bit) counter2++;
            // toggle the bit
            bit = (1 - bit);
        }
        // we will take the minimum
        return Math.min(counter1, counter2);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
