# MaximumOfMinimumForEveryWindowSize

**Topic:** `stack` | **File:** `com/problems/stack/MaximumOfMinimumForEveryWindowSize.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/max-of-min_982935)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=CK8PIAF-m2E)
- [▶ YouTube](https://www.youtube.com/watch?v=3tAB663q-nk)
- [▶ YouTube](https://www.youtube.com/watch?v=yRagSKdQgsc)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/)
- [📄 LeetCode](https://leetcode.com/problems/sliding-window-maximum/discuss/2059348/maximum-of-minimum-for-every-window-size)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Greedy approach. so we will consider each element and check its span, in what range it is minimum. to determine, we will compute a previous smaller element and the next smaller element find the span array → 10 20 30 50 10 70 30 minimum spans → 7 3 2 1 7 1 2 so if we look close, then the span of 10 is 7 means it is smallest in the array, the span of 70 is 1 means it is largest in the array

```java
private static void type2() {
		int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
		int n = arr.length;
		int[] ans = maxOfMin2(arr, n);
		print(ans);
	}
```

### Approach 1 — Brute Force

Previous smaller element index next smaller element index for let's take two indexes, i and j, where arr[i] is 10 and arr[j] is 20, the span of both is 5, so there will be atleast 2 windows of size 5 where 10 and 20 will be minimum, and we have to take the maximum of minimum, which is 20 in this case we are taking n+1 so that we can store 1 to n span, we could also take n, we just have to modify the for loop boundaries arr[i] is a possible answer for this span, check if arr[i] is more than max for span Some entries in ans[] may not be filled yet, we'll them by taking values from the right side of ans[] the intuition for this ans[i] = Math.max(ans[i], ans[i + 1]); arr = { 90, 100, 110, 120, 130, 140, 80 } lets say for array size is 7 and for span of size 7 the minimum is 80 which means 80 is the array minimum, but we haven't found anything for span 6, so we will copy the span for the span 7 for n=7 and w=6 where will be two windows [1,6] and [2,7] so here two things are known, from [2,6] there will be all greater elements so from i=1 to be the answer, 1'th next smaller index will have to be the 7th, so we will have atleast one element for which span will be 6 but if there is no span of 6 present means i=1 value must be lesser or equal than the i=7, so we can copy the ans for w=7 to w=6 and the array would be something like arr = { 70, 100, 110, 120, 130, 140, 80 } for [1,6] => 70 and [2,7] => 80 and the max is 80 so the ultimate answer will be 80 for w=2 so we can copy the ans for w[n+1] to w[n] if w[n] is not present brute force approach first we will fix a window size (1,n) we will compute the minimum in every window

```java
private static void type1() {
		int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
		int n = arr.length;
		int[] ans = maxOfMin1(arr, n);
		print(ans);
	}
```
