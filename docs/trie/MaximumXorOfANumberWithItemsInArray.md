# MaximumXorOfANumberWithItemsInArray

**Topic:** `trie`  
**Tags:** Bit Manipulation, Tries

## 📝 Problem Statement

Find max XOR of a number with any element in the array.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using trie approach at the first time mask is 1<<31 which is negative, so we have to use unsigned shift operator >>> signed shift operator is not useful here it will check set bit at ith position 1-bit is equal to ~1 or the inverse of bit we can maximize the xor if the reverse bit is present set the i'th bit in maxXor

```java
	private static void type2() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int num = 325;
		int xor;
		Trie trie = new Trie();
		for (int item : nums) {
			trie.insert(item);
		}
		xor = trie.getMaxXor(num);
		System.out.println(xor);

	}

	public static class Trie {
		public static class Node {
			public Trie.Node[] nodes = new Trie.Node[2];
		}

		private int BIT_SIZE = 31;
		private final Trie.Node head = new Trie.Node();

		public Trie() {
		}

		public Trie(int bitSize) {
			this.BIT_SIZE = bitSize;
		}

		public void insert(int n) {
			Trie.Node node = head;
			// at the first time mask is 1<<31 which is negative,
			int mask = 1 << BIT_SIZE;
			for (int i = BIT_SIZE; i >= 0; i--) {
				int bit = (n & mask) == 0 ? 0 : 1;
				if (node.nodes[bit] == null)
					node.nodes[bit] = new Trie.Node();
				node = node.nodes[bit];
				// so we have to use unsigned shift operator >>>
				// signed shift operator is not useful here
				mask = mask >>> 1;
			}
		}

		public int getMaxXor(int num) {
			Trie.Node node = head;
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

	}
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n)`

```java
	private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int num = 325;
		int xor = 0;
		for (int item : nums) {
			xor = Math.max((item ^ num), xor);
		}
		System.out.println(xor);
	}

}
```
