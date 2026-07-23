# MaximumSumSubarrayOfSizeK

**Topic:** `slidingwindow`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3)

## 📝 Problem Statement

Given an array of integers arr[]&nbsp; and a number k. Return&nbsp;the maximum sum of a subarray of size k.
Note: A subarray is a contiguous part of any given array.
Examples:
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 +

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

```java
	private static void type3() {
		int[] arr = {4, 1, 1, 2, 5, 2, 3, 1, 0, 3};
		int k = 4;
		int n = arr.length;
		int max = Integer.MIN_VALUE, sum = 0;
		int left = 0, right = 0;
		while (right < n) {
			if (right - left < k)
				sum += arr[right++];
			else
				sum = sum + arr[right++] - arr[left++];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
```

### Approach 2

we are letting the window until the the window size becomes k once it become k, in the next iteration it's coming to else so if the window size is 4 then now left will be 0 and right will be 4 and sum is arr[0]+arr[1]+arr[2]+arr[3] we are checking for the first window now left =0 and right =k now we will calculate sum our current window where right=k and left=1 so now we will add arr[4] and subtract arr[0] thus sum is arr[1]+arr[2]+arr[3]+arr[4] checking for the current window

```java
	private static void type2() {
		int[] arr = {4, 1, 1, 2, 5, 2, 3, 1, 0, 3};
		int k = 4;
		int n = arr.length;
		int max = Integer.MIN_VALUE, sum = 0;
		int left = 0, right = 0;
		// we are letting the window until the the window size becomes k
		while (right < k) {
			sum = sum + arr[right++];
		}
		// once it become k, in the next iteration it's coming to else
		// so if the window size is 4
		// then now left will be 0 and right will be 4
		// and sum is arr[0]+arr[1]+arr[2]+arr[3]
		// we are checking for the first window
		max = Math.max(max, sum);
		// now left =0 and right =k
		while (right < n) {
			// now we will calculate sum our current window
			// where right=k and left=1
			// so now we will add arr[4] and subtract arr[0]
			// thus sum is arr[1]+arr[2]+arr[3]+arr[4]
			sum = sum + arr[right++] - arr[left++];
			// checking for the current window
			max = Integer.max(max, sum);
		}
		System.out.println(max);
	}
```

### Approach 1: 🔨 Brute Force

Brute force approach

```java
	private static void type1() {
	}

}
```
