# MaxConsecutiveOnes

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/max-consecutive-ones/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/traffic_6682625)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=bYWLJb3vCWY)
- [▶ YouTube](https://www.youtube.com/watch?v=Mo33MjjMlyA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=45)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

optimized approach on every 0 we are checking the previous 1's series is the largest or not if the array is ended with 1 then we are also checking the largest once again

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type3() {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		int max = 0, length = 0;
		for (int num : nums) {
			if (num == 1) {
				length++;
			} else {
				max = Math.max(length, max);
				length = 0;
			}
		}
		max = Math.max(length, max);
		System.out.println("max length is " + length);
	}
```

### Approach 2

optimized approach on every 1 we are calculating length from its start

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		int n = nums.length, length = 0, start = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1)
				length = Math.max(length, i - start + 1);
			else
				start = i + 1;
		}
		System.out.println("max length is " + length);
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		int n = nums.length, length = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++) {
				if (nums[j] == 0) break;
				length = Math.max(length, j - i + 1);
			}
		System.out.println("max length is " + length);
	}

}
```
