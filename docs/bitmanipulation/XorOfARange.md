# XorOfARange

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/XorOfARange.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/l-to-r-xor_8160412)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

We need to find xor(L..R) we know how to find the xor of xor(n) in O(1) and we know xor(L-1)^xor(L..R)=xor(R) xor(L-1)^xor(L..R)^xor(L-1) = xor(R)^xor(L-1) xor(L..R) = xor(R)^xor(L-1) time complexity O(1) space complexity O(1)

**Complexity:** Time: o(1) | Space: o(1)

```java
private static void type2() {
		int left = 5, right = 11;
		int xor = xor(right) ^ xor(left - 1);
		System.out.println(xor);
	}
	private static int xor(int n) {
		int rem = n % 4;
		if (rem == 0) return n;
		else if (rem == 1) return 1;
		else if (rem == 2) return n + 1;
		else return 0;
	}
```

### Approach 1 — Brute Force

Check for multiple examples brute force approach time complexity O(n) space complexity O(1)

**Complexity:** Time: o(n) | Space: o(1)

```java
private static void type1() {
		int left = 5, right = 11;
		int xor = 0;
		for (int i = left; i <= right; i++) xor = xor ^ i;
		System.out.println(xor);
	}
```
