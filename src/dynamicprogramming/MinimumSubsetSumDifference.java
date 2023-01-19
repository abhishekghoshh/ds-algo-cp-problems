package dynamicprogramming;

/*
 * Problem link :
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
 * 
 */
public class MinimumSubsetSumDifference {

	public static void main(String args[]) {
		type2();
	}

	

	// only works with positive integer
	// We need a better solution
	private static void type2() {
		int nums[] = { 2, 2, 2, 2, 2 };
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
		}
		boolean[][] memo = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= sum; i++) {
			memo[0][i] = false;
		}
		for (int i = 0; i <= n; i++) {
			memo[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (nums[i - 1] <= j) {
					memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int minDiff = sum;
		int mid = sum / 2;
		for (int j = 1; j <= mid; j++) {
			if (memo[n][j]) {
				minDiff = minDiff > sum - 2 * j ? sum - 2 * j : minDiff;
			}
		}
		System.out.println(minDiff);
	}
}
