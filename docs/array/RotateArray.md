# RotateArray

**Topic:** `array` | **File:** `com/problems/array/RotateArray.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/rotate-array/description/)
- [📄 LeetCode](https://leetcode.com/problems/find-the-encrypted-string/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/rotate-array_1230543)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wvcQg43_V8U)
- [▶ YouTube](https://www.youtube.com/watch?v=BHr381Guz3Y)
- [📄 takeUforward](https://takeuforward.org/data-structure/rotate-array-by-k-elements/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

For rotating to the right, change the index of the reverse method s = "dart", k = 3 ans = "tdar" (it is left rotation by k spaces) we can just do the same with little modification reverse(0,n-1) => reverse(0,n-k-1) => reverse(n-k,n-1) or we can compute k2 = n-k and compute the right rotation of k2 in a circle k right rotation means n-k left rotation and vice versa

```java
private static void type4() {
		String s = "dart";
		int k = 3;
		String ans = getEncryptedString(s, k);
		System.out.println(ans);
	}
	public static String getEncryptedString(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		if (n == 1) return s;
		k = k % n;
		reverse(arr, 0, n - 1);
		reverse(arr, 0, n - k - 1);
		reverse(arr, n - k, n - 1);
		return new String(arr);
	}
```

### Approach 3

Explain this in the interview lets say the numbers are 1, 2, 3, 4, 5, 6, 7 and after rotation k=3 left rotation it will be 5 6 7 1 2 3 4 lets make the intuition from the answer itself if we divide the array into 2 parts arr[0,k) arr[k,n) if we just reverse them individually then it would become 7 6 5 4 3 2 1 now it become something we have seen already it was the complete reverse of the array, so if we reverse the whole array we will get the original array so our answer will be like -> reverse(0,n-1) => reverse(0,k-1) => reverse(k,n-1) time complexity O(2n) space complexity O(1)

**Complexity:** Time: o(2n) | Space: o(1)

```java
private static void type3() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate3(k, nums);
	}
	private static void rotate3(int k, int[] nums) {
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
		print(nums);
	}
	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
```

### Approach 2

Reverse(0,n-1) => reverse(0,k-1) => reverse(k,n-1) todo do not try to explain it to the interview time complexity O(n*k) space complexity O(1)

**Complexity:** Time: o(n*k) | Space: o(1)

```java
private static void type2() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate2(nums, k);
		print(nums);
	}
	private static void rotate2(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		// shift k times
		for (int i = 0; i < k; i++) {
			// copy the last item first
			int last = nums[n - 1];
			// shift right all the elements by one step
			for (int j = n - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			// assign the last to zeroth items
			nums[0] = last;
		}
	}
```

### Approach 1 — Brute Force

Create one extra array copy elements to that array again copy to that original array space complexity O(n) time complexity O(2n)

**Complexity:** Time: o(2n) | Space: o(n)

```java
private static void type1() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate1(nums, k);
		print(nums);
	}
	private static void rotate1(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int[] copy = new int[n];
		for (int i = 0; i < n; i++) {
			int j = (i + k) % n;
			copy[j] = nums[i];
		}
		System.arraycopy(copy, 0, nums, 0, n);
	}
```
