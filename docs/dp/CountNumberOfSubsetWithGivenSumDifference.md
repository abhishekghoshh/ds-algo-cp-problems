# CountNumberOfSubsetWithGivenSumDifference

**Topic:** `dp` | **File:** `com/problems/dp/CountNumberOfSubsetWithGivenSumDifference.java`

## Solution Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/partitions-with-given-difference_3751628)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1)
- [▶ YouTube](https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11)
- [▶ YouTube](https://www.youtube.com/watch?v=zoilQD1kYSg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=19)
- [📄 takeUforward](https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Exactly the same as the CountOfSubsetSum problem, but here the subset difference is given here we have to find the subset sum (s1) little optimization previous on how we are making subset sum 1 or s1

```java
private static void type2() {
		int target = -1;
		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};

		int n = nums.length;
		int sum = 0;
		for (int num : nums) sum += num;
		// one optimization we can think here is if we minimize the value of s1
		// then we will have to make less amount of dp and also less iteration.
		// 2 things we can notice is that
		// s1-s2 or the target can be negative or positive
		// s1 = (sum+target)/2 and s2 = (sum-target)/2
		// see if the target is negative, then s1 will be lesser.
		// and if the target is negative, then s2 will be lesser.
		// we can take either s1 or s2 for our computation, and both will give us the same answer
		int s1 = Math.min((sum - target) / 2, (sum + target) / 2);
		// TODO remaining part of the type1
	}
```

### Approach 1 — Brute Force

As per the question s1 - s2 = target, but we know one thing s1 + s2 = total sum [always] so s1 is (sum + target)/2 sum + target must be divisible by 2 and the sum should be lesser than diff otherwise it is not a valid input TODO works on greater than zero elements, but with zero element we have do the preprocessing, check the CountOfSubsetSum problem

```java
private static void type1() {
		int target = 1;
		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
		int count = findTargetSumWays1(nums, target);
		System.out.println(count);
	}
```
