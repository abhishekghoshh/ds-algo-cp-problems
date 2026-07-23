# MajorityElements2

**Topic:** `array`  
**Tags:** Arrays, Moore's voting algorithm

## 📝 Problem Statement

The majority element is the element that appears more than n / 3 times.
There can only be at most 2 of such a number in an array.

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/majority-element-ii/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/893027)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/majority-element_6915220)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=vwZj1K0e9U8)
- [▶ YouTube](https://www.youtube.com/watch?v=yDbkQd9t2ig&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=18)
- [📄 takeUforward](https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/)

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

Extended Moore's voting algorithm exactly same the Majority elements 1 but here we will be checking for 2 elements it is possible that the item1 and item2 is not a majority element that's why are checking the freq of num1 and num2 again lastly adding into answer if the freq is greater than n/3

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		int[] nums = { 1, 2, 2, 3, 2 };
		List<Integer> answer = majorityElement2(nums);
		System.out.println(answer);
	}

	private static List<Integer> majorityElement2(int[] nums) {
		List<Integer> answer = new ArrayList<>();
		int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
		int freq1 = 0, freq2 = 0;
		int n = nums.length;
		for (int num : nums) {
			// exactly same the Majority elements 1
			// but here we will be checking for 2 elements
			if (num == num1) {
				freq1++;
			} else if (num == num2) {
				freq2++;
			} else if (freq1 == 0) {
				freq1 = 1;
				num1 = num;
			} else if (freq2 == 0) {
				freq2 = 1;
				num2 = num;
			} else {
				freq1--;
				freq2--;
			}
		}
		freq1 = freq2 = 0;
		// it is possible that the item1 and item2 is not a majority element
		// that's why are checking the freq of num1 and num2 again
		for (int num : nums) {
			if (num == num1) freq1++;
			if (num == num2) freq2++;
		}
		// lastly adding into answer if the freq is greater than n/3
		if (freq1 > (n / 3)) answer.add(num1);
		if (freq2 > (n / 3)) answer.add(num2);
		return answer;
	}
```

### Approach 1: 🔨 Brute Force

brute force using frequency map calculating the freq of the elements now checking entries one by one and checking if the freq is more than n/3 or not

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

```java
	private static void type1() {
		int[] nums = { 1, 2, 2, 3, 2 };
		List<Integer> answer = majorityElement1(nums);
		System.out.println(answer);
	}

	private static List<Integer> majorityElement1(int[] nums) {
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> freq = new HashMap<>();
		int n = nums.length;
		// calculating the freq of the elements
		for (int num : nums)
			freq.put(num, 1 + freq.getOrDefault(num, 0));
		// now checking entries one by one and checking if the freq is more than n/3 or not
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			int num = entry.getKey(), f = entry.getValue();
			if (f > (n / 3)) answer.add(num);
		}
		return answer;
	}

}
```
