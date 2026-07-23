# FractionalSquareRoot

**Topic:** `binarysearch`  

## 📝 Problem Statement

Find the fractional square root of a number to a given precision.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

newton raphson method root = (X+N/X)/2 where X is an imaginary root

```java
	private static void type3() {
		int n = 40;
		double precision = 1e-14;
		double x = n, root;
		while (true) {
			root = (x + n / x) / 2;
			if (Math.abs(root - x) <= precision) break;
			x = root;
		}
		System.out.println(root);
	}
```

### Approach 2

binary search method

```java
	private static void type2() {
		int n = 40;
		double precision = 1e-14;
		double low = 0, high = n, answer = 0, mid, square;
		while (low < high) {
			mid = low + (high - low) / 2;
			square = mid * mid;
			if (Math.abs(square - n) <= precision) {
				answer = mid;
				break;
			} else if (square > n) high = mid;
			else low = mid;
		}
		System.out.println(answer);
	}
```

### Approach 1: 🔨 Brute Force

```java
	private static void type1() {
		int n = 40;
		double sqrt = Math.sqrt(n);
		System.out.println(sqrt);
	}

}
```
