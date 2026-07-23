# PowerOfXtoN

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/PowerOfXtoN.java`

## Solution Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/fast-exponention-using-bit-manipulation/)

## Approaches

Implementation:

### Implementation

Ans = n^b TODO check later

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
```
