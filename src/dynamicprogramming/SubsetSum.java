package dynamicprogramming;

/*
 * Problem link :
 * https://www.codingninjas.com/studio/problems/subset-sum_630213
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
 * 
 * */
public class SubsetSum {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}


	// similar to knapsack problem
	// here we have to say a subset sum is possible or not
	private static void type3() {
		int[] nums = {1, 3, 4, 5, 9, 12};
		int n = nums.length;
		int k = 25;
		boolean[][] memo = new boolean[n + 1][k + 1];
		// if we have 0 items then it not possible to create any subset sum
		for (int i = 1; i <= k; i++) memo[0][i] = false;
		// if our target sum is zero, it is possible to create that
		// as we can anytime consider the empty set
		// so even with zero elements, we can create target sum 0
		for (int i = 0; i <= n; i++) memo[i][0] = true;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k; j++)
				if (nums[i - 1] <= j)
					memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
				else
					memo[i][j] = memo[i - 1][j];
		boolean isPossible = memo[n][k];
		System.out.println(isPossible);
	}

	// this is the same as the previous type, but here we will use memoization
	// TODO complete it
	private static void type2() {
	}

	// this is a simple recursion
	private static void type1() {
		int[] nums = {1, 3, 4, 5, 9, 12};
		int n = nums.length;
		int k = 25;

		boolean isPossible = isSubsetPresent(0, nums, k);
		System.out.println(isPossible);
	}

	public static boolean isSubsetPresent(int i, int[] nums, int remaining) {
		// Write your code here
		if (remaining == 0) return true;
		if (remaining < 0 || i == nums.length) return false;
		return isSubsetPresent(i + 1, nums, remaining) ||
				isSubsetPresent(i + 1, nums, remaining - nums[i]);
	}
}
