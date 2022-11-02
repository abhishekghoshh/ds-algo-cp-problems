package problems.dynamicprogramming;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
 * 
 * https://www.codingninjas.com/codestudio/library/count-of-subsets-with-sum-equal-to-x
 */
public class CountOfSubsetSum {

	public static void main(String args[]) {
		type1();
		type2();
	}

	// similar to equal sum partition
	// using top down approach
	private static void type2() {
		int nums[] = { 1, 3, 4, 5, 9, 12 };
		int target = 25;
		int n = nums.length;
		int[][] memo = new int[n + 1][target + 1];
		// with n equal to 0 we can not make any target sum
		for (int i = 0; i <= target; i++) {
			memo[0][i] = 0;
		}
		// but to make taget sum equal to 0 we have always one option
		// that is empty set
		for (int i = 0; i <= n; i++) {
			memo[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j) {
					memo[i][j] = memo[i - 1][j - nums[i - 1]] + memo[i - 1][j];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int count = memo[n][target];
		System.out.println(count);
	}

	// using memoization
	// TODO do it later
	private static void type1() {
		// TODO Auto-generated method stub

	}

}
