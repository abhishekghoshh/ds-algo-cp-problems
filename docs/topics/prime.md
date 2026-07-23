# Prime Numbers

## Overview

**10 files** covering primality testing, sieve methods, prime factorization, and segmentation.

## Problem Solutions

### Primality Testing

```java
// Check if n is prime: O(√n)
boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}
```

### Sieve of Eratosthenes

```java
// Generate all primes up to N: O(N log log N)
boolean[] isPrime = new boolean[N + 1];
Arrays.fill(isPrime, true);
isPrime[0] = isPrime[1] = false;

for (int i = 2; i * i <= N; i++)
    if (isPrime[i])
        for (int j = i * i; j <= N; j += i)
            isPrime[j] = false;
```

### Segmented Sieve

```java
// Find primes in range [L, R] where R can be up to 10^12 but R-L ≤ 10^6
// 1. Generate primes up to √R using regular sieve
// 2. Use these primes to mark composites in [L, R]
```

### Prime Factorization

```java
// O(√n) factorization:
for (int i = 2; i * i <= n; i++) {
    while (n % i == 0) {
        factors.add(i);
        n /= i;
    }
}
if (n > 1) factors.add(n);
```

### Problem List

| Problem | Approach |
|---------|----------|
| isPrime | O(√n) trial division |
| All Divisors | O(√n) paired divisors |
| Sum of Divisors 1 to N | Contribution formula: `n/i` appears `i` times |
| Find 3 Distinct Numbers (product = N) | Factorization + combination |
| Sieve of Eratosthenes | O(N log log N) |
| Prime Count [0..N] | Sieve + counting |
| Kth Prime Number | Sieve + indexing |
| Count Numbers with Prime Factor | Sieve for prime factor count |
| Prime Factorization | O(√n) division |
| Segmented Sieve | Range-based sieve |
| Assign Elements to Groups | Prime factor constraints |
