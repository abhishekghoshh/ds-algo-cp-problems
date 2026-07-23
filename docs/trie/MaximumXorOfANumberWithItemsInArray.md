# MaximumXorOfANumberWithItemsInArray

**Topic:** `trie` | **File:** `com/problems/trie/MaximumXorOfANumberWithItemsInArray.java`

**Tags:** Bit Manipulation, Tries

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using trie approach

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
```

### Approach 1 — Brute Force

At the first time mask is 1<<31 which is negative, so we have to use unsigned shift operator >>> signed shift operator is not useful here at the first time mask is 1<<31 which is negative, it will check set bit at ith position 1-bit is equal to ~1 or the inverse of bit we can maximize the xor if the reverse bit is present set the i'th bit in maxXor so we have to use unsigned shift operator >>> signed shift operator is not useful here brute force approach time complexity O(n)

**Complexity:** Time: o(n)

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
```
