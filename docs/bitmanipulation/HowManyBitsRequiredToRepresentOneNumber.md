# HowManyBitsRequiredToRepresentOneNumber

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/HowManyBitsRequiredToRepresentOneNumber.java`

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

When base is 2

```java
private static void type3() {
		int n = 100;
		int bitsRequired = 0;
		while (n != 0) {
			bitsRequired++;
			n = (n >> 1);
		}
		System.out.println("bits required is " + bitsRequired);
	}
```

### Approach 2

Optimized approach

```java
private static void type2() {
		int n = 100;
		int base = 2;
		int bitsRequired = 0, bound = 1;
		while (bound <= n) {
			bitsRequired++;
			bound *= base;
		}
		System.out.println("bits required is " + bitsRequired);
	}
```

### Approach 1 — Brute Force

For in general

```java
private static void type1() {
		int n = 100;
		int base = 2;
		int bitsRequired = 1 + (int) (Math.log(n) / Math.log(base));
		System.out.println("bits required is " + bitsRequired);
	}
```
