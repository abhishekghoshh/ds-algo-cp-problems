package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
 * https://www.interviewbit.com/problems/evaluate-expression-to-true/
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=pGVguAcWX4g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=38
 * https://www.youtube.com/watch?v=bzXM1Zond9U&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=39
 * 
 * Blog :
 * https://www.codingninjas.com/codestudio/library/evaluate-expression-to-true
 */
public class EvaluateExpressionToTrue {

	// TODO check later all the solution and geekforgeeks solution and problem link
	// it is failing in geeksforgeeks
	public static void main(String[] args) {
		type1();
		type2();
		type2_();
		type3();
	}

	// O(N ^ 3), where �N� is the length of the given string.
	// In the worst-case scenario, after performing N ^ 3 calls, all of the states
	// will be investigated, and we will be able to use the �MEMO� result to find
	// our final answer.
	// O(N^2), where �N� is the length of the given string.
	// As a 3-D array of size N * N * 2 is being used.
	private static void type3() {
		String s = "T|T&F^T";
		int n = s.length();
		char[] arr = s.toCharArray();
		int[][][] dp = new int[n][n][2];
		// Initialization
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'T') {
				dp[i][i][1] = 1;
			} else if (arr[i] == 'F') {
				dp[i][i][0] = 1;
			}
		}
		// Filling the dp array.
		for (int gap = 2; gap < n; gap += 2) {
			for (int j = 0; j + gap < n; j += 2) {
				for (int k = j; k < j + gap; k += 2) {
					if (arr[k + 1] == '|') {
						// T | T = T, T | F = T, F | T = T, F | F = F.
						dp[j][j + gap][1] += dp[j][k][0] * dp[k + 2][j + gap][1] + dp[j][k][1] * dp[k + 2][j + gap][0]
								+ dp[j][k][1] * dp[k + 2][j + gap][1];
						dp[j][j + gap][0] += dp[j][k][0] * dp[k + 2][j + gap][0];
					} else if (arr[k + 1] == '&') {
						// T & T = T, T & F = F, F & T = F , F | F = F.
						dp[j][j + gap][1] += dp[j][k][1] * dp[k + 2][j + gap][1];
						dp[j][j + gap][0] += dp[j][k][0] * dp[k + 2][j + gap][1] + dp[j][k][1] * dp[k + 2][j + gap][0]
								+ dp[j][k][0] * dp[k + 2][j + gap][0];
					} else if (arr[k + 1] == '^') {
						// T ^ T = F, T ^ F = T, F ^ T = T, F ^ F = F
						dp[j][j + gap][1] += dp[j][k][1] * dp[k + 2][j + gap][0] + dp[j][k][0] * dp[k + 2][j + gap][1];
						dp[j][j + gap][0] += dp[j][k][0] * dp[k + 2][j + gap][0] + dp[j][k][1] * dp[k + 2][j + gap][1];
					}
				}
			}
		}
		int countWays = dp[0][n - 1][1];
		System.out.println(countWays);
	}

	// memoization
	private static void type2_() {
//		String s = "T|T&F^T";
		String s = "T^F|F";
		int n = s.length();
		char[] arr = s.toCharArray();
		int[][][] memo = new int[n][n][2];
		// Initialization
		for (int[][] matrix : memo) {
			for (int[] row : matrix) {
				Arrays.fill(row, -1);
			}
		}
		int countWays = countWays_(arr, 0, n - 1, 1, memo);
		System.out.println(countWays);
	}

	private static int countWays_(char[] arr, int i, int j, int flag, int[][][] memo) {
		if (i > j) {
			return 0;
		} else if (j - i == 2) {
			boolean first = arr[i] == 'T';
			boolean second = arr[j] == 'T';
			boolean val;
			if (arr[i + 1] == '|') {
				val = first | second;
			} else if (arr[i + 1] == '&') {
				val = first & second;
			} else {
				val = first ^ second;
			}
			if (flag == 1) {
				return val ? 1 : 0;
			} else {
				return !val ? 1 : 0;
			}
		} else if (memo[i][j][flag] != -1) {
			return memo[i][j][flag];
		} else {
			int ans = 0;
			for (int k = i + 1; k <= j - 1; k += 2) {
				// The number of ways expression left to 'K' will be true.
				int leftTrue = countWays_(arr, i, k - 1, 1, memo);
				// The number of ways expression left to 'K' will be false.
				int leftFalse = countWays_(arr, i, k - 1, 0, memo);
				// The number of ways expression right to 'K' will be true.
				int rightTrue = countWays_(arr, k + 1, j, 1, memo);
				// The number of ways expression right to 'K' will be false.
				int rightFalse = countWays_(arr, k + 1, j, 0, memo);
				if (arr[k] == '|') {
					// T | T = T, T | F = T, F | T = T , F | F = F.
					if (flag == 1) {
						ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
					} else {
						ans += leftFalse * rightFalse;
					}
				} else if (arr[k] == '&') {
					// T & T = T, T & F = F, F & T = F , F | F = F.
					if (flag == 1) {
						ans += leftTrue * rightTrue;
					} else {
						ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
					}
				} else {
					// T ^ T = F, T ^ F = T, F ^ T = T , F ^ F = F.
					if (flag == 1) {
						ans += leftTrue * rightFalse + leftFalse * rightTrue;
					} else {
						ans += leftTrue * rightTrue + leftFalse * rightFalse;
					}
				}
			}
			memo[i][j][flag] = ans;
			return ans;
		}
	}

	// memoization
	private static void type2() {
		String s = "T|T&F^T";
		int n = s.length();
		char[] arr = s.toCharArray();
		int[][][] memo = new int[n][n][2];
		// Initialization
		for (int[][] matrix : memo) {
			for (int[] row : matrix) {
				Arrays.fill(row, -1);
			}
		}
		int countWays = countWays(arr, 0, n - 1, 1, memo);
		System.out.println(countWays);
	}

	private static int countWays(char[] arr, int i, int j, int flag, int[][][] memo) {
		if (i > j) {
			return 0;
		} else if (i == j) {
			if (flag == 1) {
				return arr[i] == 'T' ? 1 : 0;
			} else {
				return arr[i] == 'F' ? 1 : 0;
			}
		} else if (memo[i][j][flag] != -1) {
			return memo[i][j][flag];
		} else {
			int ans = 0;
			for (int k = i + 1; k <= j - 1; k += 2) {
				// The number of ways expression left to 'K' will be true.
				int leftTrue = countWays(arr, i, k - 1, 1, memo);
				// The number of ways expression left to 'K' will be false.
				int leftFalse = countWays(arr, i, k - 1, 0, memo);
				// The number of ways expression right to 'K' will be true.
				int rightTrue = countWays(arr, k + 1, j, 1, memo);
				// The number of ways expression right to 'K' will be false.
				int rightFalse = countWays(arr, k + 1, j, 0, memo);
				if (arr[k] == '|') {
					// T | T = T, T | F = T, F | T = T , F | F = F.
					if (flag == 1) {
						ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
					} else {
						ans += leftFalse * rightFalse;
					}
				} else if (arr[k] == '&') {
					// T & T = T, T & F = F, F & T = F , F | F = F.
					if (flag == 1) {
						ans += leftTrue * rightTrue;
					} else {
						ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
					}
				} else {
					// T ^ T = F, T ^ F = T, F ^ T = T , F ^ F = F.
					if (flag == 1) {
						ans += leftTrue * rightFalse + leftFalse * rightTrue;
					} else {
						ans += leftTrue * rightTrue + leftFalse * rightFalse;
					}
				}
			}
			memo[i][j][flag] = ans;
			return ans;
		}
	}

	// O(4 ^ N), Where �N� is the length of the string.
	// At each step, we are making 4 calls and at that particular call, we are
	// making 4 calls again thus, bringing the time complexity to O(4^N).
	// O(4^ N), Where �N� is the length of the string.
	// As this is the amount of space that the recursion stack will utilize to store
	// 4 ^ N calls.
	private static void type1() {
		String s = "T|T&F^T";
		int n = s.length();
		char[] arr = s.toCharArray();

		int countWays = countWays(arr, 0, n - 1, 1);
		System.out.println(countWays);

	}

	private static int countWays(char[] arr, int i, int j, int flag) {
		if (i > j) {
			return 0;
		} else if (i == j) {
			if (flag == 1) {
				return arr[i] == 'T' ? 1 : 0;
			} else {
				return arr[i] == 'F' ? 1 : 0;
			}
		} else {
			int ans = 0;
			for (int k = i + 1; k <= j - 1; k += 2) {
				// The number of ways expression left to 'K' will be true.
				int leftTrue = countWays(arr, i, k - 1, 1);
				// The number of ways expression left to 'K' will be false.
				int leftFalse = countWays(arr, i, k - 1, 0);
				// The number of ways expression right to 'K' will be true.
				int rightTrue = countWays(arr, k + 1, j, 1);
				// The number of ways expression right to 'K' will be false.
				int rightFalse = countWays(arr, k + 1, j, 0);
				if (arr[k] == '|') {
					// T | T = T, T | F = T, F | T = T , F | F = F.
					if (flag == 1) {
						ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
					} else {
						ans += leftFalse * rightFalse;
					}
				} else if (arr[k] == '&') {
					// T & T = T, T & F = F, F & T = F , F | F = F.
					if (flag == 1) {
						ans += leftTrue * rightTrue;
					} else {
						ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
					}
				} else {
					// T ^ T = F, T ^ F = T, F ^ T = T , F ^ F = F.
					if (flag == 1) {
						ans += leftTrue * rightFalse + leftFalse * rightTrue;
					} else {
						ans += leftTrue * rightTrue + leftFalse * rightFalse;
					}
				}
			}
			return ans;
		}
	}

}
