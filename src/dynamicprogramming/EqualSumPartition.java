package dynamicprogramming;


/*
 * Problem link :
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
 * 
 */
public class EqualSumPartition {

	// Given a non-empty array nums containing only positive integers, find if the
	// array can be partitioned into two subsets such that the sum of elements in
	// both subsets is equal.
	public static void main(String args[]) {
		type1();
		type2();
		type3();
	}

	// TODO check the discussion section
	// https://leetcode.com/submissions/detail/829825912/
	private static void type3() {
//		
	}

	// type 2 is taking more time than type1 in leetcode
	// same as subset sum problem
	// just here target sum is total sum divide by 2
	// time complexity is O(n^2 + 2n)
	// space complexity is O(n^2)
	private static void type2() {
//		int nums[] = { 1, 3, 4, 5, 9, 12 };
		int nums[] = { 1, 5, 11, 5 };
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum = sum + num;
		}
		// if total is even then we can partition else it is not possible to distribute
		// to sum equally
		if (sum % 2 != 0) {
			System.out.println(false);
			return;
		}
		int target = sum / 2;
		boolean[][] memo = new boolean[n + 1][target + 1];
		for (int j = 0; j <= target; j++) {
			memo[0][j] = false;
		}
		// if our target sum is zero the it is possible to create that
		// as we can anytime consider the empty set
		// so even with zero elements we can create a target sum 0
		for (int i = 0; i <= n; i++) {
			memo[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				if (nums[i - 1] <= j) {
					memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		boolean isPossible = memo[n][target];
		System.out.println(isPossible);
	}

	// memoization technique
	private static void type1() {
		int nums[] = { 1, 5, 11, 5 };
		int n = nums.length;
		int sum = 0;
		for (int num : nums) {
			sum = sum + num;
		}
		// if total is even then we can partition else it is not possible to distribute
		// to sum equally
		if (sum % 2 != 0) {
			System.out.println(false);
			return;
		}
		int target = sum / 2;
		boolean[][] memo = new boolean[n + 1][target + 1];
		// we will use a visited cache
		boolean[][] visited = new boolean[n + 1][target + 1];
		for (int j = 0; j <= target; j++) {
			visited[0][j] = true;
			memo[0][j] = false;
		}
		for (int i = 0; i <= n; i++) {
			visited[i][0] = true;
			memo[i][0] = true;
		}
		boolean isPossible = targetSum(nums, n, target, memo, visited);
		System.out.println(isPossible);
	}

	private static boolean targetSum(int[] nums, int n, int target, boolean[][] memo, boolean[][] visited) {
		if (visited[n][target])
			return memo[n][target];
		if (nums[n - 1] <= target) {
			memo[n][target] = targetSum(nums, n - 1, target - nums[n - 1], memo, visited)
					|| targetSum(nums, n - 1, target, memo, visited);
		} else {
			memo[n][target] = targetSum(nums, n - 1, target, memo, visited);
		}
		visited[n][target] = true;
		return memo[n][target];
	}
}
