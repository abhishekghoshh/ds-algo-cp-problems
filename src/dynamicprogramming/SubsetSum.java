package dynamicprogramming;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
 * 
 * */
public class SubsetSum {
	public static void main(String args[]) {
		type2();
	}

	// similar to knapsack problem
	// here we have to say subset sum is possible or not
	private static void type2() {
		int val[] = { 1, 3, 4, 5, 9, 12 };
		int n = val.length;
		int sum = 25;
		boolean[][] memo = new boolean[n + 1][sum + 1];
		// if we have 0 items then it not possible to create any subset sum
		for (int i = 1; i <= sum; i++) {
			memo[0][i] = false;
		}
		// if our target sum is zero the it is possible to create that
		// as we can anytime consider the empty set
		// so even with zero elements we can create a target sum 0
		for (int i = 0; i <= n; i++) {
			memo[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (val[i - 1] <= j) {
					memo[i][j] = memo[i - 1][j - val[i - 1]] || memo[i - 1][j];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		boolean isPossible = memo[n][sum];
		System.out.println(isPossible);
	}
}
