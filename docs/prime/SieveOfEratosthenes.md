# SieveOfEratosthenes

**Topic:** `prime`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/count-primes/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/prime-factorisation_1760849)

## 📝 Problem Statement

Given a number n, generate all prime numbers less than or equal to n using the Sieve of Eratosthenes.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

2nd level optimization j = i * i let's say we have already marked for till 4 now we have to marked for 5 so we will mark for 10 15 20 25 but if we look closely then we can see that 10,20 is marked by 2 15 marked by 3 again if we start for 7 then 14 is marked by 2 21 is marked by 3 28 is marked by 2 35 is marked by 5 we will have start from 49 => 7*7 2nd level optimization

```java
	private static void type3() {
		int n = 50;
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i <= n; i++)
			primes[i] = true;
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				// 2nd level optimization
				for (int j = i * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		for (int j = 0; j <= n; j++) {
			System.out.println(j + " : " + primes[j]);
		}
	}
```

### Approach 2

first level optimization i * i <= n as the factors of n should be present before sqrt(n) first level of optimization

```java
	private static void type2() {
		int n = 50;
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i <= n; i++)
			primes[i] = true;
		// first level of optimization
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		for (int j = 0; j <= n; j++) {
			System.out.println(j + " : " + primes[j]);
		}
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
	private static void type1() {
		int n = 50;
		boolean[] primes = new boolean[n + 1];
		for (int i = 2; i <= n; i++)
			primes[i] = true;
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j <= n; j += i) {
					primes[j] = false;
				}
			}
		}
		for (int j = 0; j <= n; j++) {
			System.out.println(j + " : " + primes[j]);
		}
	}

}
```
