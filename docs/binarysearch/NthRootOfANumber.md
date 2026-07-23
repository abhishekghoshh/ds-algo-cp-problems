# NthRootOfANumber

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/1062679)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=rjEJeYCasHs)
- [▶ YouTube](https://www.youtube.com/watch?v=WjpswYrS2nY)
- [📄 takeUforward](https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/n-th-root-number/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
	private static void type2() {
		int m = 20;
		int n = 3;

		double mid, low = 1, high = m;
		double delta = 1e-14;
		while ((high - low) > delta) {
			mid = (low + high) / 2.0;
			if (pow(mid, n) < m) {
				low = mid;
			} else {
				high = mid;
			}
		}
		System.out.println(low);
	}

	private static double pow(double number, int n) {
		double ans = 1.0;
		for (int i = 1; i <= n; i++) ans = ans * number;
		return ans;
	}
```

### Approach 1: 🔨 Brute Force

```java
	private static void type1() {
		int m = 20;
		int n = 3;

		double answer = 0;
		double mid, low = 1, high = m, diff;
		double delta = 1e-7;
		while (low <= high) {
			mid = low + (high - low) / 2;
			diff = m - pow(mid, n);
			if (Math.abs(diff) < delta) {
				answer = mid;
				break;
			} else if (diff > 0) {
				low = mid;
			} else {
				high = mid;
			}
		}
		System.out.println(answer);
	}

}
```
