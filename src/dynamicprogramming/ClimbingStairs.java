package dynamicprogramming;

/*
 * Problem link :
 * https://leetcode.com/problems/climbing-stairs/
 * https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650
 *
 * Solution link :
 * https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=3
 * 
 * https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		
	}

	private static void type1() {
		int n = 10;
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		System.out.println(climbStairs(dp, n));
	}

	public static int climbStairs(int[] dp, int n) {
		if (n < 0)
			return 0;
		if (dp[n] != 0)
			return dp[n];
		return dp[n] = climbStairs(dp, n - 1) + climbStairs(dp, n - 2);
	}

}
