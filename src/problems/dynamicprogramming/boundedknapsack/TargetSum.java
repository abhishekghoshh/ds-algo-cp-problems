package problems.dynamicprogramming.boundedknapsack;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/target-sum/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
 * 
 */
public class TargetSum {

	// You are given an integer array nums and an integer target.
	// You want to build an expression out of nums by adding one of the symbols '+'
	// and '-' before each integer in nums and then concatenate all the integers.
	// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
	// and concatenate them to build the expression "+2-1".
	// Return the number of different expressions that you can build, which
	// evaluates to target.
	public static void main(String[] args) {
		type2();
		// for explanation from type3 to type5 see leetcode solution section
		// https://leetcode.com/problems/target-sum/solution/
		type3();
		type4();
		type5();
		type6();
	}

	private static void type6() {

	}

	// 2D Dynamic Programming
	private static void type5() {
		int[] nums = { 1, 1, 1, 2, 3 };
		int target = 2;
		int n = nums.length;
		int total = Arrays.stream(nums).sum();
		int[][] dp = new int[nums.length][2 * total + 1];
		dp[0][nums[0] + total] = 1;
		dp[0][-nums[0] + total] += 1;

		for (int i = 1; i < n; i++) {
			for (int sum = -total; sum <= total; sum++) {
				if (dp[i - 1][sum + total] > 0) {
					dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
					dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
				}
			}
		}
		int count = Math.abs(target) > total ? 0 : dp[nums.length - 1][target + total];
		System.out.println(count);
	}

	// Recursion with Memoization
	// In the last approach, we can observe that a lot of redundant function calls
	// were made with the same value of i as the current index and the same value of
	// sum as the current sum, since the same values could be obtained through
	// multiple paths in the recursion tree. In order to remove this redundancy, we
	// make use of memoization as well to store the results which have been
	// calculated earlier.

	// Thus,for every call to calculate(nums, i, sum, S), we store the result
	// obtained in memo[i][sum + total], where total stands for the sum of all the
	// elements from the input array. The factor of total has been added as an
	// offset to the sumsum value to map all the sumsums possible to positive
	// integer range. By making use of memoization, we can get the result of each
	// redundant function call in constant time.

	// Time complexity: O(t *n)). The memo array of size O(t*n) has been filled just
	// once. Here, tt refers to the sum of the numsnums array and nn refers to the
	// length of the nums array.
	// Space complexity: O(t*n). The depth of recursion tree can go up to nn. The
	// memo array contains t*n elements.
	private static void type4() {
		int[] nums = { 1, 1, 1, 2, 3 };
		int target = 2;
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum = sum + num;
		}
		// 0 <= nums[i] <= 1000 criteria is in the input
		// if all num is less than zero then we can just use Math.abs(sum)
		// we will add sum as offset
		// as at some point there be an situation where current sum can be less than
		// zero, so to tackle that we will increase the array size by sum
		// so if all the element will be minus then also the current sum will get 0
		int[][] memo = new int[n][2 * sum + 1];
		for (int[] row : memo) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		int count = calculate(nums, 0, 0, target, memo, sum);
		System.out.println(count);
	}

	public static int calculate(int[] nums, int i, int sum, int S, int[][] memo, int total) {
		if (i == nums.length) {
			return sum == S ? 1 : 0;
		} else {
			if (memo[i][sum + total] != Integer.MIN_VALUE) {
				return memo[i][sum + total];
			}
			// int add = calculate(nums, i + 1, sum + nums[i], S, memo,total);
			// int subtract = calculate(nums, i + 1, sum - nums[i], S, memo,total);
			memo[i][sum + total] = calculate(nums, i + 1, sum + nums[i], S, memo, total)
					+ calculate(nums, i + 1, sum - nums[i], S, memo, total);
			return memo[i][sum + total];
		}
	}

	// brute force approach
	// The brute force approach is based on recursion. We need to try to put both
	// the + and - symbols at every location in the given numsnums array and find
	// out the assignments which lead to the required result
	// For this, we make use of a recursive function calculate(nums, i, sum, S),
	// which returns the assignments leading to the sum SS, starting from the ith
	// index onwards, provided the sum of elements up to the ith element is sumsum.
	// This function appends a + sign and a - sign both to the element at the
	// current index and calls itself with the updated sumsum as sum +
	// nums[i]sum+nums[i] and sum - nums[i]sum−nums[i] respectively along with the
	// updated current index as i+1i+1. Whenever we reach the end of the array, we
	// compare the sum obtained with SS. If they are equal, we increment the
	// countcount value to be returned.
	// Time complexity: O(2^n) as Size of recursion tree will be 2^n
	// Space complexity: O(n). The depth of the recursion tree can go up to n.
	private static void type3() {
		int[] nums = { 1, 1, 1, 2, 3 };
		int target = 2;
		int count = calculate(nums, 0, 0, target);
		System.out.println(count);
	}

	public static int calculate(int[] nums, int i, int sum, int target) {
		if (i == nums.length) {
			return sum == target ? 1 : 0;
		} else {
			return calculate(nums, i + 1, sum + nums[i], target) + calculate(nums, i + 1, sum - nums[i], target);
		}
	}

	// works on positive and greater than zero elements
	// this algorithm will fail if there is any zero or negative element found
	private static void type2() {
		int target = 2;
		int[] nums = { 1, 1, 1, 2, 3 };
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum = sum + num;
		}
		if ((sum + target) % 2 != 0) {
			System.out.println(0);
			return;
		}

		int s1 = (sum + target) / 2;
		// int s2 = (sum - target) / 2;

		int[][] memo = new int[n + 1][s1 + 1];
		for (int i = 1; i < s1; i++) {
			memo[0][i] = 0;
		}
		for (int i = 0; i < n; i++) {
			memo[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= s1; j++) {
				if (nums[i - 1] <= j) {
					memo[i][j] = memo[i - 1][j - nums[i - 1]] + memo[i - 1][j];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int count = memo[n][s1];
		System.out.println(count);
	}
}
