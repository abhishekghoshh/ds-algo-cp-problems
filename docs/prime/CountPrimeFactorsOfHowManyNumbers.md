# CountPrimeFactorsOfHowManyNumbers

**Topic:** `prime` | **File:** `com/problems/prime/CountPrimeFactorsOfHowManyNumbers.java`

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Like in range 0-10 2 is the lowest prime factor for 2,4,6,8,10 3 is the lowest prime factor for 3,9 4 is the lowest prime factor for 0 as 4 can be decomposed in to 2*2 optimized modified sieve approach

```java
private static void type2() {
		if (null == primesCount) initializePrimeCount();

		int[] queries = { 1, 2, 3, 101, 17, 41, 85, 11, 53 };
		for (int query : queries) {
			System.out.println(query + " is lowest prime factor for " + primesCount[query]);
		}
	}
	private static void initializePrimeCount() {
		primesCount = new int[N + 1];
		for (int i = 2; i <= N; i++)
			primesCount[i] = 1;
		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				if (primesCount[j] != 0) {
					primesCount[i]++;
					primesCount[j] = 0;
				}
			}
		}
	}
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {

	}
```
