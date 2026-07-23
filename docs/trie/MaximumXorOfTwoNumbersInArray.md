# MaximumXorOfTwoNumbersInArray

**Topic:** `trie`  
**Tags:** Bit Manipulation, Tries

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/maximum-xor_3119012)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6)
- [📄 takeUforward](https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/)

## 📝 Problem Statement

Given an integer array nums, return the maximum result of nums[i] XOR nums[j].

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

check this later one more time

```java
	private static void type4() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = findMaximumXOR4(nums);
		System.out.println(xor);
	}

	// TODO check this later one more time
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

using trie but optimized with maximum bit size rather using 31 we will use the bit required for the maximum number getting the max number of bits from the array

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

using trie approach at the first time mask is 1<<31 which is negative, so we have to use unsigned shift operator >>> signed shift operator is not useful here it will check set bit at ith position 1-bit is equal to ~1 or the inverse of bit we can maximize the xor if the reverse bit is present set the i'th bit in maxXor

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

	public static class Trie1 {
		public static class Node {
			public Node[] nodes = new Node[2];
		}

		private int BIT_SIZE = 31;
		private final Node head = new Node();

		public Trie1() {
		}

		public Trie1(int bitSize) {
			this.BIT_SIZE = bitSize;
		}

		public void insert(int n) {
			Node node = head;
			// at the first time mask is 1<<31 which is negative,
			int mask = 1 << BIT_SIZE;
			for (int i = BIT_SIZE; i >= 0; i--) {
				int bit = (n & mask) == 0 ? 0 : 1;
				if (node.nodes[bit] == null)
					node.nodes[bit] = new Node();
				node = node.nodes[bit];
				// so we have to use unsigned shift operator >>>
				// signed shift operator is not useful here
				mask = mask >>> 1;
			}
		}

		public int getMaxXor(int num) {
			Node node = head;
			int maxXor = 0;
			// at the first time mask is 1<<31 which is negative,
			int mask = 1 << BIT_SIZE;
			for (int i = BIT_SIZE; i >= 0; i--) {
				// it will check set bit at ith position
				int bit = (num & mask) == 0 ? 0 : 1;
				// 1-bit is equal to ~1 or the inverse of bit
				// we can maximize the xor if the reverse bit is present
				if (node.nodes[1 - bit] != null) {
					node = node.nodes[1 - bit];
					// set the i'th bit in maxXor
					maxXor = maxXor | mask;
				} else {
					node = node.nodes[bit];
				}
				// so we have to use unsigned shift operator >>>
				// signed shift operator is not useful here
				mask = mask >>> 1;
			}
			return maxXor;
		}

		public void insert_deprecated̵(int n) {
			Node node = head;
			for (int i = BIT_SIZE; i >= 0; i--) {
				int bit = (n >> i) & 1;
				if (node.nodes[bit] == null)
					node.nodes[bit] = new Node();
				node = node.nodes[bit];
			}
		}

		public int getMaxXor_deprecated̵(int num) {
			Node node = head;
			int maxNum = 0;
			for (int i = BIT_SIZE; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (node.nodes[1 - bit] != null) {
					maxNum = maxNum | (1 << i);
					node = node.nodes[1 - bit];
				} else {
					node = node.nodes[bit];
				}
			}
			return maxNum;
		}


	}
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`

```java
	private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;
		for (int num1 : nums)
			for (int num2 : nums)
				xor = Math.max((num1 ^ num2), xor);

		System.out.println(xor);
	}

}
```
