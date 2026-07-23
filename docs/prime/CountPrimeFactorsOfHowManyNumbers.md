# CountPrimeFactorsOfHowManyNumbers

**Topic:** `prime`  

## 📝 Problem Statement

Count numbers that have a given number as a prime factor.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

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

### Approach 1: 🔨 Brute Force

brute force

```java
	private static void type1() {

	}

}
```
