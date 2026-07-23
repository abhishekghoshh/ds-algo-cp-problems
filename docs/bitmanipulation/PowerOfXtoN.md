# PowerOfXtoN

**Topic:** `bitmanipulation`  

## 🎥 Solution Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/fast-exponention-using-bit-manipulation/)

## 📝 Problem Statement

Calculate x^n using bit manipulation.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

ans = n^b check later Stores final answer

```java
	private static void type1() {
		int n = 2, b = 8;
		// Stores final answer
		int answer = 1;
		while (b > 0) {
			answer *= ((b & 1) == 1) ? n : 1;
			n = n * n;
			b = b >> 1;
		}
		System.out.println("answer is " + answer);
	}

}
```
