# SwapTwoNumbers

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/SwapTwoNumbers.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/swap-two-numbers_1380853)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		int x = 5;
		int y = 8;
		x = x ^ y;
		y = x ^ y; // this line is now same ase x ^ y ^ y which is x => now y has the value of x
		x = x ^ y; // this line is now same as x ^ y ^ x which is y => now x has the value of y
		System.out.println(x);
		System.out.println(y);
	}
```

### Approach 1 — Brute Force

Let's day a =5 b=7 a = 5^7 b= 5^7^7 => 5 a = 5^7^5 => 7 swap two variables without using third variable

```java
private static void type1() {
		int a = 5, b = 7;
		System.out.println("a = " + a + " b = " + b);
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("a = " + a + " b = " + b);
	}
```
