# XorOfARange

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/l-to-r-xor_8160412)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

we need to find xor(L..R) we know how to find the xor of xor(n) in O(1) and we know xor(L-1)^xor(L..R)=xor(R) xor(L-1)^xor(L..R)^xor(L-1) = xor(R)^xor(L-1) xor(L..R) = xor(R)^xor(L-1) check for multiple examples

**Time Complexity:** `O(1)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		int left = 5, right = 11;
		int xor = xor(right) ^ xor(left - 1);
		System.out.println(xor);
	}

	// check for multiple examples
	private static int xor(int n) {
		int rem = n % 4;
		if (rem == 0) return n;
		else if (rem == 1) return 1;
		else if (rem == 2) return n + 1;
		else return 0;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int left = 5, right = 11;
		int xor = 0;
		for (int i = left; i <= right; i++) xor = xor ^ i;
		System.out.println(xor);
	}
}
```
