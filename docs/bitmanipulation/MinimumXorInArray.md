# MinimumXorInArray

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/MinimumXorInArray.java`

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		int[] nums = { 3, 10, 5, 25, 2, 8 };
		Arrays.sort(nums);
		int xor = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			xor = Math.min(xor, nums[i] ^ nums[i + 1]);
		}
		System.out.println(xor);
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		int[] nums = { 3, 10, 5, 25, 2, 8 };
		int xor = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					xor = Math.min(xor, nums[i] ^ nums[j]);
				}
			}
		}
		System.out.println(xor);
	}
```
