package dynamicprogramming;

import java.util.Arrays;

/*
 * Problem link :
 * https://atcoder.jp/contests/dp/tasks/dp_b
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
 *
 */
public class FrogWithKJumps {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// Tabulation approach
	// Time Complexity: O(N*K)
	// Space Complexity: O(N)
	private static void type2() {
		int n = 10;
		int k = 4;
		int[] height = { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };
		
		int dp[] = new int[n];
		Arrays.fill(dp, -1);

		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			int mmSteps = Integer.MAX_VALUE;
			for (int j = 1; j <= k && (i >= j); j++) {
				int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
				mmSteps = Math.min(jump, mmSteps);
			}
			dp[i] = mmSteps;
		}
		System.out.println(dp[n - 1]);
	}

	// Memoization approach
	// Time Complexity: O(N*K)
	// Space Complexity: O(N)
	private static void type1() {
		int n = 10;
		int k = 4;
		int[] heights = { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };

		int dp[] = new int[n];
		Arrays.fill(dp, -1);

		System.out.println(frogJump(n - 1, heights, dp, k));
	}

	private static int frogJump(int i, int[] height, int[] dp, int k) {
		if (i == 0)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int mmSteps = Integer.MAX_VALUE;
		for (int j = 1; j <= k && (i >= j); j++) {
			int jump = frogJump(i - j, height, dp, k) + Math.abs(height[i] - height[i - j]);
			mmSteps = Math.min(jump, mmSteps);
		}
		return dp[i] = mmSteps;
	}

}
