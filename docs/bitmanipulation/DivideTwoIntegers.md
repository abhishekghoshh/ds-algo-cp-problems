# DivideTwoIntegers

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/divide-two-integers/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/-divide-two-integers_1112617)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/division-without-using-multiplication-division-and-mod-operator/0)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=zhJt9xIoXCI)

## 📝 Problem Statement

Given two integers dividend and divisor, divide two integers without using

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

check it later if both are negative or both are positive as we have already extracted the final sign, so we don't require the dividend and divisor with sign as it will change the bits this means mask * 2 to power i mask will be negative only there is an overflow add the sign in case the answer is more than max int value

```java
	private static void type3() {
		int dividend = -2147483648;
		int divisor = -1;
		int quotient = divide(dividend, divisor);
		System.out.println(quotient);
	}

	// TODO best approach
	public static int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		long dividendL = dividend;
		long divisorL = divisor;
		// if both are negative or both are positive
		boolean sign = (dividendL > 0 && divisorL > 0) || (dividendL < 0 && divisorL < 0);
		// as we have already extracted the final sign, so we don't require the dividend
		// and divisor with sign as it will change the bits
		dividendL = dividendL > 0 ? dividendL : -dividendL;
		divisorL = divisorL > 0 ? divisorL : -divisorL;

		long quotient = 0, mask;
		for (int i = 32; i >= 0 & (dividendL > 0 && dividendL >= divisorL); i--) {
			// this means mask * 2 to power i
			mask = divisorL << i;
			// mask will be negative only there is an overflow
			if (mask > 0 && mask <= dividendL) {
				quotient += (1L << i);
				dividendL = dividendL - mask;
			}
		}
		// add the sign
		quotient = sign ? quotient : -quotient;
		// in case the answer is more than max int value
		int quotientI = quotient > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) quotient;
		System.out.println("quotient is " + quotientI + " reminder is " + dividendL);
		return quotientI;
	}
```

### Approach 2

int quotient = 0; int subQuot = 0;

```java
	private static void type2() {
		long dividend = 100;
		long divisor = 7;
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			System.out.println(Integer.MAX_VALUE);
			return;
		}
		boolean negative = (dividend ^ divisor) < 0;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		// int quotient = 0;
		// int subQuot = 0;
		int quotient = 0;
		int subq = 0;

		while (dividend - divisor >= 0) {
			for (subq = 0; dividend - (divisor << subq << 1) >= 0; subq++)
				;
			quotient += 1 << subq;
			dividend -= divisor << subq;

		}
		quotient = negative ? -quotient : quotient;
		System.out.println(quotient);
	}
```

### Approach 1: 🔨 Brute Force

if both are negative or both are positive as we have already extracted the final sign so we don't require the dividend and divisor with sign as it will change the bits

```java
	private static void type1() {
		long dividend = 100;
		long divisor = 7;

		// if both are negative or both are positive
		int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;

		// as we have already extracted the final sign so we don't require the dividend
		// and divisor with sign as it will change the bits
		dividend = dividend > 0 ? dividend : -dividend;
		divisor = divisor > 0 ? divisor : -divisor;

		long quotient = 0, previousSum = 0;
		for (int i = 31; i >= 0; i--) {
			if (previousSum + (divisor << i) <= dividend) {
				quotient += (1 << i);
				previousSum += (divisor << i);
			}
		}
		quotient = sign == 1 ? quotient : -quotient;
		System.out.println("quotient is " + quotient);
	}

}
```
