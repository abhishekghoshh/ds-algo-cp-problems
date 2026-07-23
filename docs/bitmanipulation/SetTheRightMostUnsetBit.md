# SetTheRightMostUnsetBit

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/SetTheRightMostUnsetBit.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/set-the-rightmost-unset-bit_8160456)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		int n = 10;
		System.out.println(Integer.toBinaryString(n));
		int answer = setRightMostUnsetBit(n);
		System.out.println(answer);
		System.out.println(Integer.toBinaryString(answer));
	}
	public static int setRightMostUnsetBit(int n) {
		// Write your code here.
		int copy = n;
		int mask = 1;
		while (copy != 0 && (copy & 1) == 1) {
			mask = (mask << 1);
			copy = copy >> 1;
		}
		return copy == 0 ? n : (n | mask);
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		int n = 1279;
		int N = setBit(n);
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(N));
	}
```
