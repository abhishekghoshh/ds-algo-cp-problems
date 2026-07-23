# FindTheNumberAppearsOnlyOnce

**Topic:** `array`  
**Tags:** Hashing, Bit Manipulation

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/single-number/description/)
- [📄 NeetCode](https://neetcode.io/problems/single-number)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/find-the-odd-occurence4820/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/find-the-single-element_6680465)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/one-odd-occurring_4606074)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=bYWLJb3vCWY&t=1369s)
- [📄 takeUforward](https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/)
- [▶ YouTube](https://www.youtube.com/watch?v=qMPX1AOa83k)

## 📝 Problem Statement

Find the element that appears exactly once (others appear twice).

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimize approach as all the numbers appear twice, and we know that a^a =0 we can use this property

```java
	private static void type2() {
		int[] nums = { 4, 1, 2, 1, 2 };
		int xor = singleNumber2(nums);
		System.out.println(xor);
	}

	private static int singleNumber2(int[] nums) {
		int xor = 0;
		for (int num : nums)
			xor = xor ^ num;
		return xor;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

```java
	private static void type1() {
		int[] nums = { 4, 1, 2, 1, 2 };
		int ans = singleNumber1(nums);
		System.out.println(ans);
	}

	private static int singleNumber1(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		int ans = -1;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
```
