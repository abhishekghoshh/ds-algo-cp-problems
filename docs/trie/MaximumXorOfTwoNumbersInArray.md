# MaximumXorOfTwoNumbersInArray

**Topic:** `trie` | **File:** `com/problems/trie/MaximumXorOfTwoNumbersInArray.java`

**Tags:** Bit Manipulation, Tries

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/maximum-xor_3119012)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6)
- [📄 takeUforward](https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Optimal approach

```java
private static void type4() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = findMaximumXOR4(nums);
		System.out.println(xor);
	}
	public static int findMaximumXOR4(int[] nums) {
		int max = 0, maxBit = 0;
		for (int num : nums)
			if (num > max) max = num;
		while (max != 0) {
			maxBit++;
			max >>= 1;
		}
		int xor = 0;
		int mask = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = maxBit - 1; i >= 0; i--) {
			set.clear();
			mask = mask | (1 << i);
			int tmp = xor | (1 << i);
			for (int num : nums) {
				set.add(num & mask);
				if (set.contains((num & mask) ^ tmp)) {
					xor = tmp;
					break;
				}
			}
		}
		return xor;
	}
```

### Approach 3

Check this later one more time using trie but optimized with maximum bit size rather using 31 we will use the bit required for the maximum number

```java
private static void type3() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };

		int xor = 0;
		// getting the max number of bits from the array
		int max = 0;
		for (int num : nums) if (num > max) max = num;
		int maxBits = 0;
		while (max != 0) {
			max = max / 2;
			maxBits++;
		}

		Trie1 trie = new Trie1(maxBits);
		for (int item : nums) trie.insert(item);

		for (int num : nums)
			xor = Math.max(trie.getMaxXor(num), xor);
		System.out.println(xor);
	}
```

### Approach 2

Using trie approach

```java
private static void type2() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;
		Trie1 trie = new Trie1();
		for (int item : nums) trie.insert(item);
		for (int num : nums)
			xor = Math.max(trie.getMaxXor(num), xor);
		System.out.println(xor);
	}
```

### Approach 1 — Brute Force

At the first time mask is 1<<31 which is negative, so we have to use unsigned shift operator >>> signed shift operator is not useful here at the first time mask is 1<<31 which is negative, it will check set bit at ith position 1-bit is equal to ~1 or the inverse of bit we can maximize the xor if the reverse bit is present set the i'th bit in maxXor so we have to use unsigned shift operator >>> signed shift operator is not useful here brute force approach time complexity O(n^2)

**Complexity:** Time: o(n^2)

```java
private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;
		for (int num1 : nums)
			for (int num2 : nums)
				xor = Math.max((num1 ^ num2), xor);

		System.out.println(xor);
	}
```
