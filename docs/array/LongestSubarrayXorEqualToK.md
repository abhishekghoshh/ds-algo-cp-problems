# LongestSubarrayXorEqualToK

**Topic:** `array`  
**Tags:** Arrays, hashing, prefix sum

## 📝 Problem Statement

Longest subarray with XOR K.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

```java
	private static void type3() {
		int[] nums = {5, 6, 7, 8, 9};
		int k = 5;
		Map<Integer, Integer> prefixXor = new HashMap<>();
		prefixXor.put(0, -1);
		int xor = 0, n = nums.length, maxLen = 0, previousXor;
		for (int i = 0; i < n; i++) {
			xor = xor ^ nums[i];
			previousXor = xor ^ k;
			if (prefixXor.containsKey(previousXor))
				maxLen = Math.max(maxLen, i - prefixXor.get(previousXor));
			if (!prefixXor.containsKey(xor))
				prefixXor.put(xor, i);
		}
		System.out.println("length is " + maxLen);
	}
```

### Approach 2

prefix xor suppose in a range of 0..x1..x2 the xor is x2 and in the same range 0..x1 the xor is x1 the xor of in between elements(x1+1..x2) is k we can say that x1 ^ k = x2 we can again xor both of the side by k so x1 ^ k ^ k = x2 ^ k => x1 = x2 ^ k ( given that k ^ k = 0) x1 = x2 ^ k now we have everything just we have to find x1 we will compute xor in every element and store it in map with its index also compute x1 and will check if its present in map or not

**Space Complexity:** `O(n)`

```java
	private static void type2() {
		int[] nums = { 5, 6, 7, 8, 9 };
		int k = 5;
		Map<Integer, Integer> prefixXor = new HashMap<>();
		int xor = 0, n = nums.length, length = 0, previousXor;
		for (int i = 0; i < n; i++) {
			xor = xor ^ nums[i];
			if (xor == k)
				length = i + 1;
			previousXor = xor ^ k;
			if (prefixXor.containsKey(previousXor))
				length = Math.max(length, i - prefixXor.get(previousXor));
			if (!prefixXor.containsKey(xor))
				prefixXor.put(xor, i);
		}
		System.out.println("length is " + length);
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int[] nums = { 5, 6, 7, 8, 9 };
		int k = 5;
		int xor = 0, maxLen = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			xor = 0;
			for (int j = i; j < n; j++) {
				xor = xor ^ nums[j];
				if (xor == k)
					maxLen = Math.max(maxLen, j - i + 1);
			}
		}
		System.out.println("length is " + maxLen);
	}

}
```
