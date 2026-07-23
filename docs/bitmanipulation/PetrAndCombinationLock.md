# PetrAndCombinationLock

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/PetrAndCombinationLock.java`

## Problem Links

- [https://codeforces.com/problemset/problem/1097/B](https://codeforces.com/problemset/problem/1097/B)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		int[] arr = { 10, 20, 30 };
		int n = arr.length;
		// size of power is 2^n
		// so we will run a loop 0 to 2^n -1
		int bound = 1 << n;
		int index, num, sum;
		boolean isPossible = false;
		for (int i = 0; i < bound; i++) {
			index = 0;
			num = i;
			sum = 0;
			while (index < n) {
				if ((num & 1) == 1) {
					sum = sum + arr[index];
				} else {
					sum = sum - arr[index];
				}
				index++;
				num = num >> 1;
			}
			if (sum % 360 == 0) {
				isPossible = true;
				break;
			}
		}
		System.out.println(isPossible);
	}
```

### Approach 1 — Brute Force

This is a problem of recursion, memoization, bottom-up problem

```java
private static void type1() {
		int[] arr = { 10, 20, 30 };
		boolean isPossible = combination(arr, 0, 0);
		System.out.println(isPossible);
	}
	private static boolean combination(int[] arr, int i, int sum) {
		if (i == arr.length) {
			return sum % 360 == 0;
		}
		return combination(arr, i + 1, sum + arr[i]) || combination(arr, i + 1, sum - arr[i]);
	}
```
