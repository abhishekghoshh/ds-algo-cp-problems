# Maths

## Overview

**8 files** covering fundamental math operations frequently used in competitive programming.

## Problem Solutions

| Problem | Approach |
|---------|----------|
| **Count Digits** | `floor(log10(n)) + 1` or while loop |
| **Reverse Integer** | `result = result * 10 + digit`, handle overflow |
| **Palindrome Number** | Reverse half and compare |
| **GCD & LCM** | Euclidean algorithm: `gcd(a,b) = gcd(b, a%b)`; `lcm = a*b/gcd` |
| **Armstrong Numbers** | Sum of cubes of digits = number |
| **Print All Divisors** | O(√n): iterate i=1 to √n, if n%i==0 add i and n/i |
| **Sum of Divisors 1 to N** | O(√n): `result += i * (count of multiples) = i * (n/i)` |

```java
// GCD using Euclidean Algorithm (iterative):
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// Recursive:
int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

// LCM:
int lcm(int a, int b) {
    return (a / gcd(a, b)) * b;  // divide first to avoid overflow
}
```
