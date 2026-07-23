# SquareRoot

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sqrtx/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/square-root-integral_893351)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Bsv3FPUX_BA)
- [📄 takeUforward](https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/)

## 📝 Problem Statement

Find the integer square root of a non-negative integer.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

binary search method

```java
	private static void type2() {
		int n = 40;
		int sqrt = sqrt(n);
		System.out.println(sqrt);
	}

	public static int sqrt(int n) {
		if (n <= 1) return n;
		long left = 1, right = n, mid, sqr;
		while (left <= right) {
			mid = left + (right - left) / 2;
			sqr = mid * mid;
			if (sqr == n) return (int) mid;
			else if (sqr < n) left = mid + 1;
			else right = mid - 1;
		}
		return (int) (left - 1);
	}
```

### Approach 1: 🔨 Brute Force



**Time Complexity:** `O(sqrt(n)`

```java
	private static void type1() {
		int n = 40;
		double i = 0, answer = 0;
		while (i * i <= n) answer = i++;
		System.out.println(answer);
	}

}
```
