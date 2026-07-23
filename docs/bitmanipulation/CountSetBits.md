# CountSetBits

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-1-bits/description/)
- [📄 NeetCode](https://neetcode.io/problems/number-of-one-bits)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/count-total-set-bits_784)

## 🎥 Solution Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/library/count-number-of-set-bits-in-an-integer)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/count-set-bits-in-an-integer/)
- [▶ YouTube](https://www.youtube.com/watch?v=5Km3utixwZs)

## 📝 Problem Statement

Given an integer n, return the number of '1' bits in its binary representation (Hamming weight).

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

on each iteration we will remove its right most set bit let say we want to remove right most set bit from 100110 then n-1 will be 100101 if we do n & n-1 we will get 100100 removing the right most set bit

**Time Complexity:** `O(number of set bit)`

```java
	private static void type3() {
		int n = -2147483648;
		int ones = hammingWeight3(n);
		System.out.println(ones);
	}

	private static int hammingWeight3(int n) {
		int ones = 0;
		while (n != 0) {
			// removing the right most set bit
			n = n & (n - 1);
			ones++;
		}
		return ones;
	}
```

### Approach 2

optimized approach, same as previous but here we will use >>> instead of >> as >>> this is a unsigned right shift operator if the number is negative then >> will not work same as previous one type2

**Time Complexity:** `O(log(n)`

```java
	private static void type2() {
		int n = -2147483648;
		int ones = hammingWeight2(n);
		System.out.println(ones);
	}

	private static int hammingWeight2(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}
```

### Approach 1: 🔨 Brute Force

optimized approach in case of negative it will fail as >> is a signed shift operator in MSB of negative number there is one and by using >> it will not shift to lsb, it will stay as it is, so in place of >> we can use >>>

**Time Complexity:** `O(log(n)`

```java
	private static void type1() {
		int n = 2147483647;
		int ones = hammingWeight1(n);
		System.out.println(ones);
	}

	private static int hammingWeight1(int n) {
		int ones = 0;
		while (n != 0) {
			ones += (n & 1);
			n = n >> 1;
		}
		return ones;
	}

}
```
