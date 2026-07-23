# KthBitSetOrNot

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/check-whether-k-th-bit-is-set-or-not_5026446)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1)

## 📝 Problem Statement

Given a number N and a bit number K, check if Kth bit of N is set or not. A

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

```java
	private static void type4() {
		int n = 5, k = 1;
		int sol = n >> (k - 1);
		int kthBit = (sol & 1) == 1 ? 1 : 0;
		System.out.println(kthBit);
	}
```

### Approach 3

```java
	private static void type3() {
		int n = 5, k = 1;
		int mask = 1 << (k - 1);
		int kthBit = (n & mask) > 0 ? 1 : 0;
		System.out.println(kthBit);
	}
```

### Approach 2

rather than changing the input we can change the 1 and create one mask mask = 1<<k => 000100 n = 011000 n & mask => either 000000 or the 000100 n & mask => 0 or mask if it is 0 that means the bit is not set

```java
	private static void type2() {
		int n = 23;
		int k = 3;
		int mask = 1 << k;
		int setBit = (n & mask) == 0 ? 0 : 1;
		System.out.println(setBit);
	}
```

### Approach 1: 🔨 Brute Force

here we will right shift by k so when n = 11011100 and k = 3 so n>>k = 00011011 00011011 & 1 => 1 1 means 00000001 00011011 & 00000001 => 1

**Time Complexity:** `O(1)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int n = 23;
		int k = 3;
		int setBit = (n >> k) & 1;
		System.out.println(setBit);
	}

}
```
