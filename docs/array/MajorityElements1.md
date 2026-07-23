# MajorityElements1

**Topic:** `array`  
**Tags:** Arrays, Boyer Moore's voting algorithm

## 📝 Problem Statement

The majority element is the element that appears more than n / 2 times.
You may assume that the majority element always exists in the array.

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/majority-element/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/842495)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/majority-element_6783241)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=nP_ns3uSh80)
- [▶ YouTube](https://www.youtube.com/watch?v=AoX3BPWNnoE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=17)
- [▶ YouTube](https://www.youtube.com/watch?v=OtCsBK7e4rk)
- Https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

moore's voting algorithm let x is majority element means x is least n/2 + 1 so after all the calculation of count++ and count-- there will least be one element for which count will not be 0 at last

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type3() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int answer = majorityElement3(nums);
		System.out.println("Item is " + answer);
	}

	private static int majorityElement3(int[] nums) {
		int ans = 0;
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				count = 1;
				ans = num;
			} else {
				if (ans == num) {
					count++;
				} else {
					count--;
				}
			}
		}
		return ans;
	}
```

### Approach 2

frequency map approach calculating the freq of the elements

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

```java
	private static void type2() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int num = majorityElement2(nums);
		System.out.println("Item is " + num);
	}

	private static int majorityElement2(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> freq = new HashMap<>();
		// calculating the freq of the elements
		for (int num : nums)
			freq.put(num, 1 + freq.getOrDefault(num, 0));

		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			int num = entry.getKey(), f = entry.getValue();
			if (f > n / 2) return num;
		}
		return -1;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach checking all the numbers and check their frequencies

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int ans = majorityElement1(nums);
		System.out.println(ans);
	}

	private static int majorityElement1(int[] nums) {
		int n = nums.length / 2;
		for (int num1 : nums) {
			int count = 0;
			for (int num2 : nums)
				if (num1 == num2) count++;
			if (count > n) return num1;
		}
		return -1;
	}

}
```
