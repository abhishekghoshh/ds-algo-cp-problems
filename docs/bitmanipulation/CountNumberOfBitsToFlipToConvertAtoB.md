# CountNumberOfBitsToFlipToConvertAtoB

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-bit-flips-to-convert-number)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/flip-bits_8160405)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1)

## 📝 Problem Statement

You are given two numbers a and b. The task is&nbsp;to count the number of bits needed to be flipped to convert a to b.Note : flipping of bit means inverting its value -- changing 1 to 0 and 0 to 1
Examples:
Input: a = 10, b = 20
Output: 4
Explanatio

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

we know one thing that if we do the xor it will produce 1 only if both are different bits, 0 and 1 or 1 and 0 and our goal is the same, i.e. to check which bit is different, so if we do xor then the answer will have the set bits for different bits of start and goal, so now our work is just to count the bits of this xor output

```java
	private static void type2() {
		int start = 10;
		int goal = 20;
		// we know one thing that if we do the xor it will produce 1 only if both are
		// different bits, 0 and 1 or 1 and 0
		// and our goal is the same, i.e. to check which bit is different,
		// so if we do xor then the answer will have the set bits for different bits of
		// start and goal, so now our work is just to count the bits of this xor output
		int xor = start ^ goal;
		int count = 0;
		while (xor != 0) {
			count++;
			xor = xor & (xor - 1);
		}
		System.out.println(count);
	}
```

### Approach 1: 🔨 Brute Force

Brute force solution we will create a mask and we will left shift it and every time we will do and operation with both the number if the result is same that means bit is same checking ith bit is same for both start or goal or not after checking we are left shifting it to check the next bit

```java
	private static void type1() {
		int start = 10;
		int goal = 20;
		// we will create a mask
		// and we will left shift it
		// and every time we will do and operation with both the number
		// if the result is same that means bit is same
		int mask = 1;
		int bound = 1 << 31;
		int count = 0;
		boolean diffBit;
		while (mask != bound && (mask <= start || mask <= goal)) {
			// checking ith bit is same for both start or goal or not
			diffBit = (start & mask) != (goal & mask);
			count = count + (diffBit ? 1 : 0);
			// after checking we are left shifting it
			// to check the next bit
			mask = mask << 1;
		}
		System.out.println(count);
	}

}
```
