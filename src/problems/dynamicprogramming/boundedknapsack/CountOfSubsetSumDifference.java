package problems.dynamicprogramming.boundedknapsack;

/*
 * Problem link :
 * https://leetcode.com/problems/target-sum/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
 * 
 */
public class CountOfSubsetSumDifference {
	// 1 <= n <= 15
	// nums.length == 2 * n
	// -107 <= nums[i] <= 107
	public static void main(String[] args) {
		type2();
	}

	// works on positive and greater than zero elements
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
		System.out.print(count);
	}
}
