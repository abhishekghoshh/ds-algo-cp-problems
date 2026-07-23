# Bit Manipulation

## Overview

**39 files** covering bit operations, XOR tricks, binary representation, and bitwise problem solving.

## Bit Operations Reference

```java
// Basic operations:
x & 1        // Check LSB (odd/even)
x >> 1       // Divide by 2
x << 1       // Multiply by 2
x & (x-1)    // Remove rightmost set bit
x & -x       // Extract rightmost set bit
x ^ x = 0    // XOR self = 0
x ^ 0 = x    // XOR 0 = self

// Nth bit operations:
x | (1 << n)      // Set nth bit
x & ~(1 << n)     // Clear nth bit
x ^ (1 << n)      // Toggle nth bit
(x >> n) & 1      // Check nth bit

// Swap: a = a ^ b; b = a ^ b; a = a ^ b;
```

## Problem Categories

### Basic Bit Operations

| Problem | Technique |
|---------|-----------|
| Odd or Even | `n & 1` |
| Number is Power of 2 | `n > 0 && (n & (n-1)) == 0` |
| Swap Two Numbers | XOR swap |
| Negative Representation | Two's complement |
| Bits Required | `floor(log2(n)) + 1` |
| Set Kth Bit | `n \| (1 << k)` |
| Clear Kth Bit | `n & ~(1 << k)` |
| Toggle Kth Bit | `n ^ (1 << k)` |
| Check Kth Bit | `(n >> k) & 1` |
| Remove Rightmost Set Bit | `n & (n-1)` |
| Extract Rightmost Set Bit | `n & -n` |
| Set Rightmost Unset Bit | `n \| (n+1)` |

### Counting Bits

```java
// Count set bits (Brian Kernighan):
int count = 0;
while (n != 0) {
    n &= (n - 1);
    count++;
}

// Built-in: Integer.bitCount(n)
```

| Problem | Technique |
|---------|-----------|
| Count Set Bits | Brian Kernighan's algorithm |
| Count Total Set Bits (1 to n) | Pattern observation: each bit position |
| Count Bits to Flip A→B | Count set bits in `A ^ B` |
| Reverse Bits | Bit-by-bit reversal |

### XOR Problems

```java
// XOR of 0 to n:
// if n % 4 == 0: return n
// if n % 4 == 1: return 1
// if n % 4 == 2: return n + 1
// if n % 4 == 3: return 0

// XOR of [L, R]: xor(R) ^ xor(L-1)
```

| Problem | Technique |
|---------|-----------|
| Single Number (rest appear twice) | XOR all → `a ^ a = 0` |
| Missing Number [0..n] | XOR with indices |
| Find Two Single Numbers | XOR all → `xorval & -xorval` → split into two groups |
| XOR of Every Subset | Always 0 for n > 1 (each element appears 2^(n-1) times) |
| Find the Difference | XOR extra char |
| Count Equal XOR Triplets | Brute force or prefix XOR + hashing |
| Max XOR of Two Numbers | Trie-based bit-by-bit |
| Min XOR in Array | Sort + adjacent XOR |
| Min XOR Sum of Two Arrays | Bit DP or Hungarian algorithm |

### Advanced Bit Manipulation

| Problem | Technique |
|---------|-----------|
| Add Without Plus | XOR + AND for carry |
| Divide Two Integers | Bit-by-bit subtraction |
| Pow(x, n) | Binary exponentiation: `x^n = x^(n/2) * x^(n/2)` |
| Bitwise AND of Range [L,R] | Find common prefix: `while(L<R) L>>=1, R>>=1` |
| Add Binary | Simulate addition with carry |
| Reverse Bits | 32-bit reversal |
| Minimum Array End | Bit operations |
| Good Number | Bit pattern matching |
| Petr and Combination Lock | Bitmask subset generation |
| N Queries for Power K | Precomputation with binary lifting |
