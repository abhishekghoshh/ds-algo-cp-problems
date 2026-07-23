# FindNthMagicNumber

**Topic:** `bitmanipulation`  

## 🎥 Solution Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-nth-magic-number/)

## 📝 Problem Statement

A magic number is defined as a number which can be expressed as a power of 5

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

Go through every bit of n If last bit of n is set proceed to next bit or n = n/2

```java
	private static void type1() {
		int n = 8;
		int pow = 1, answer = 0;
		// Go through every bit of n
		while (n != 0) {
			pow = pow * 5;
			// If last bit of n is set
			answer += ((n & 1) == 1) ? pow : 0;
			// proceed to next bit
			// or n = n/2
			n >>= 1;
		}
		System.out.println(answer);
	}

}
```
