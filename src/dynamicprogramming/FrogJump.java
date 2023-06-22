package dynamicprogramming;

import java.util.Arrays;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
 * https://atcoder.jp/contests/dp/tasks/dp_a
 *
 * Solution link :
 * https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 *
 */
public class FrogJump {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// Iterative way
	// tabultaion with two variable
	private static void type3() {
		int height[] = { 7, 4, 4, 2, 6, 6, 3, 4 };
		int n = height.length;

		int prev = 0;
		int prev2 = 0;
		for (int i = 1; i < n; i++) {
			int jumpTwo = Integer.MAX_VALUE;
			int jumpOne = prev + Math.abs(height[i] - height[i - 1]);
			if (i > 1)
				jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);

			int cur_i = Math.min(jumpOne, jumpTwo);
			prev2 = prev;
			prev = cur_i;

		}
		System.out.println(prev);
	}

	// Iterative way
	// tabultaion with array
	private static void type2() {
		int height[] = { 7, 4, 4, 2, 6, 6, 3, 4 };
		int n = height.length;

		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int ind = 1; ind < n; ind++) {
			int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);
			int jumpTwo = Integer.MAX_VALUE;
			if (ind > 1)
				jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);

			dp[ind] = Math.min(jumpOne, jumpTwo);
		}
		System.out.println(dp[n - 1]);
	}

	// Recursive way
	// memoization
	private static void type1() {
		int[] heights = { 7, 4, 4, 2, 6, 6, 3, 4 };
		int n = heights.length;

		int[] dp = new int[n + 1];
		System.out.println(frogJump(dp, n, heights));
	}

	public static int frogJump(int[] dp, int n, int heights[]) {
		if (n == 1)
			return 0;
		if (dp[n] != 0)
			return dp[n];
		int second = Integer.MAX_VALUE;
		int first = Math.abs(heights[n - 1] - heights[n - 2]) + frogJump(dp, n - 1, heights);
		if (n > 2)
			second = Math.abs(heights[n - 1] - heights[n - 3]) + frogJump(dp, n - 2, heights);
		return dp[n] = first < second ? first : second;
	}

}
