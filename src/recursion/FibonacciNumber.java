package recursion;
/*
 * Problem link :
 *
 *
 * Solution link :
 *
 *
 */
public class FibonacciNumber {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static class Solution {
		private static final int[] mem = new int[31];
		static {
			mem[0] = 0;
			mem[1] = 1;
		}

		public int fib(int n) {
			if (n == 0)
				return 0;
			else if (mem[n] != 0)
				return mem[n];
			else
				return mem[n] = fib(n - 1) + fib(n - 2);
		}
	}

	private static void type5() {
		Solution solution = new Solution();
		System.out.println(solution.fib(10));
	}

	private static void type4() {
		int n = 10;
		int last = 0;
		int prev = 1;
		int current = 0;
		for (int i = 2; i <= n; i++) {
			current = prev + last;
			last = prev;
			prev = current;
		}
		System.out.println(current);
	}

	private static void type3() {
		int n = 10;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}

	private static void type2() {
		int n = 10;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(fib(n, dp));
	}

	private static int fib(int n, int[] dp) {
		if (n <= 1)
			return n;
		if (dp[n] != 0)
			return dp[n];
		return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
	}

	private static void type1() {
		int n = 10;
		System.out.println(fib(n));
	}

	private static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

}
