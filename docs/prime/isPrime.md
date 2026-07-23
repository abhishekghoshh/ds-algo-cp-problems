# isPrime

**Topic:** `prime`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/prime-number2314/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=1xNbjMdbjug)
- [📄 takeUforward](https://takeuforward.org/data-structure/check-if-a-number-is-prime-or-not/)

## 📝 Problem Statement

Given a number n, determine whether it is a prime number or not.Note: A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
Examples :
Input: n = 7
Output: true
Explanation: 7 has exactly two divisors: 1 and

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

intuition lets take a number 36 and see i'ts factors 1 x 36 2 x 18 3 X 12 4 x 9 6 x 6 9 x 4 12 x 3 18 x 2 36 x 1 if we see closely then we will find that after 6 x 6 all the multiplications is repeated so in order to check a number is prime or not then we can check for the first half for any number n if n = a x b and a<=b then a<= sqrt(n)

**Time Complexity:** `O(sqrt(n)`

```java
	private static void type3() {
		int n = 27;
		boolean isPrime = true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(n + " is prime : " + isPrime);
	}
```

### Approach 2

brute force approach

```java
	private static void type2() {
		int n = 27;
		boolean isPrime = true;
		for (int i = 2; i < n / 2 + 1; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(n + " is prime : " + isPrime);
	}

	// brute force approach
	private static void type1_() {
		int n = 27;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		System.out.println(n + " is prime : " + (count == 2));
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
	private static void type1() {
		int n = 27;
		boolean isPrime = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(n + " is prime : " + isPrime);
	}

}
```
