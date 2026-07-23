# FindMissingNumberInAnArray

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/FindMissingNumberInAnArray.java`

**Tags:** Arrays, Hashing, Bit manipulation

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/missing-number/description/)
- [📄 NeetCode](https://neetcode.io/problems/missing-number)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=bYWLJb3vCWY&t=64s)
- [📄 takeUforward](https://takeuforward.org/arrays/find-the-missing-number-in-an-array/)
- [▶ YouTube](https://www.youtube.com/watch?v=WnPLSRLSANE)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Most optimized approach time complexity O(n) Space complexity O(1) find the summation of [0,n] number in O(1) time then subtract the array items one by one, and you will have the exact number

**Complexity:** Time: o(n) | Space: o(1)

```java
private static void type3() {
		int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		int sum = missingNumber3(nums);
		System.out.println(sum);
	}
	private static int missingNumber3(int[] nums) {
		int n = nums.length;
		int sum = (n * (n + 1)) / 2;
		for (int num : nums) {
			sum -= num;
		}
		return sum;
	}
```

### Approach 2

Optimized approach as 1^1 = 0, so if we xor all numbers in array and also with the 0-n then we will do xor for 2n+1 number out of which only one number is occurring 1 times time complexity O(2n) Space complexity O(1)

**Complexity:** Time: o(2n) | Space: o(1)

```java
private static void type2() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int res = missingNumber2(nums);
		System.out.println(res);
	}
	private static int missingNumber2(int[] nums) {
		int n = nums.length;
		// xor1 will contain all the xor of nums
		int xor1 = 0;
		for (int num : nums) {
			xor1 = xor1 ^ num;
		}
		// xor2 will contain all the xor of 0 to n
		int xor2 = 0;
		for (int num = 0; num <= n; num++) {
			xor2 = xor2 ^ num;
		}
		// xor1 ^ xor2 will give the missing number
		return (xor1 ^ xor2);
	}
```

### Approach 1 — Brute Force

Brute force approach Using a Set to check if the value exists or not Time complexity O(2n) Space complexity O(n)

**Complexity:** Time: o(2n) | Space: o(n)

```java
private static void type1() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int res = missingNumber1(nums);
		System.out.println(res);
	}
	private static int missingNumber1(int[] nums) {
		int n = nums.length;
		// adding elements to the set
		boolean[] set = new boolean[n + 1];
		for (int num : nums) {
			set[num] = true;
		}
		// checking from the set
		for (int num = 0; num <= n; num++) {
			if (!set[num]) return num;
		}
		return -1;
	}
```
