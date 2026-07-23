# ThreeSumClosest

**Topic:** `array` | **File:** `com/problems/array/ThreeSumClosest.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/3sum-closest/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Optimal approach

```java
private static void type3() {
		int[] nums = {1, 1, 1, 0};
		int target = 2;
		int sum = Integer.MAX_VALUE >> 1;
		int n = nums.length;
		int tempSum;
		int left, right;
		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			left = i + 1;
			right = n - 1;
			while (left < right) {
				tempSum = nums[i] + nums[left] + nums[right];
//				if (tempSum == target) return tempSum;
				if (Math.abs(sum - target) > Math.abs(tempSum - target)) sum = tempSum;
				else if (tempSum > target) right--;
				else left++;
			}
		}
		System.out.println(sum);
	}
```

### Approach 2

Improved approach

```java
private static void type2() {
		int[] nums = { 1,1,1,0 };
		int target = 100;
		Arrays.sort(nums);
		int x = -1, y = -1, min = Integer.MAX_VALUE;
		int i = 0, j = nums.length - 1;
		boolean isNegative = false;
		while (i < j) {
			int tempMin = nums[i] + nums[j];
			if (Math.abs(tempMin) < min) {
				if (tempMin < 0) {
					isNegative = true;
				} else {
					isNegative = false;
				}
				min = Math.abs(tempMin);
				x = i;
				y = j;
			}
			if (tempMin < 0) {
				i++;
			} else if (tempMin > 0) {
				j--;
			} else {
				break;
			}
		}
		min = !isNegative ? min : -min;
		System.out.println(x + " " + y + " " + min);
		int answer = Integer.MAX_VALUE;
		for (i = 0; i < nums.length; i++) {
			if (i != x && i != y) {
				if (Math.abs(target - min - nums[i]) < answer) {
					answer = Math.abs(min + nums[i]);
				}
			}
		}
		System.out.println(answer);

	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

	}
```
