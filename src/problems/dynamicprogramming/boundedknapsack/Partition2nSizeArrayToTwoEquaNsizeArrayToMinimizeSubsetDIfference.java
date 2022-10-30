package problems.dynamicprogramming.boundedknapsack;

/*
 * Problem link :
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=R9n_Hq2YDhs
 * https://www.youtube.com/watch?v=JUFHwaZjO_M
 * 
 */
public class Partition2nSizeArrayToTwoEquaNsizeArrayToMinimizeSubsetDIfference {

	// You are given an integer array nums of 2 * n integers. You need to partition
	// nums into two arrays of length n to minimize the absolute difference of the
	// sums of the arrays. To partition nums, put each element of nums into one of
	// the two arrays.
	// Return the minimum possible absolute difference.
	// 1 <= nums.length <= 20
	// 0 <= nums[i] <= 1000
	// 0 <= sum(nums[i]) <= 1000
	// -1000 <= target <= 1000
	// Input: nums = [3,9,7,3]
	// Explanation: One optimal partition is: [3,9] and [7,3].
	// The absolute difference between the sums of the arrays is abs((3 + 9) - (7 +
	// 3)) = 2.
	// Output: 2
	public static void main(String[] args) {
		type1();
		type2();
	}
	// Meet-in-the-Middle technique

	// The target sum for the two partitions is sum(nums) / 2.
	private static void type2() {
		int[] nums = { 3, 9, 7, 3 };
	}

	// brute force technique
	private static void type1() {

	}

}
