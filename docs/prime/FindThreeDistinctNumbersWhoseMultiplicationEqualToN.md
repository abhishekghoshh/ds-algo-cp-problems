# FindThreeDistinctNumbersWhoseMultiplicationEqualToN

**Topic:** `prime`  

## 🔗 Problem Links

- [https://codeforces.com/problemset/problem/1294/C?f0a28=1](https://codeforces.com/problemset/problem/1294/C?f0a28=1)

## 📝 Problem Statement

Find three distinct numbers whose product equals N.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

n is a number such that n = a*b*c a!=b!=c!=1 so these 3 numbers will be factors of n we can solve like that greedy approach take the smallest a or the first smallest factor if there is any perfect multiples then we will be getting in the start not till the end we don't need to run till i*i <= n this loop is for finding the first multiple rem will be b*c we don't need to check for j=2 because in the outer loop we are already starting from 2 and if a,b,c is unique then it is a natural that a<b<c as we are considering "a" in the outer loop the then b and c must be greater than a j is greater than i this loop is for finding the other two multiples

```java
	private static void type1() {
		int n = 5;
		int a = 1, b = 1, c = 1, rem;

		// take the smallest a or the first smallest factor
		// if there is any perfect multiples
		// then we will be getting in the start not till the end
		// we don't need to run till i*i <= n
		// this loop is for finding the first multiple
		for (int i = 2; (i * i < n) && (i < n / i); i++) {
			if (n % i == 0) {
				a = i;
				break;
			}
		}
		// rem will be b*c
		rem = n / a;
		// we don't need to check for j=2
		// because in the outer loop we are already starting from 2
		// and if a,b,c is unique then it is a natural that a<b<c
		// as we are considering "a" in the outer loop the
		// then b and c must be greater than a
		// j is greater than i
		// this loop is for finding the other two multiples
		for (int j = a + 1; j * j < rem; j++) {
			if (rem % j == 0 && j != rem / j && j != a) {
				b = j;
				c = rem / j;
				break;
			}
		}
		System.out.println("a : " + a + ", b : " + b + ", c : " + c);
	}

}
```
