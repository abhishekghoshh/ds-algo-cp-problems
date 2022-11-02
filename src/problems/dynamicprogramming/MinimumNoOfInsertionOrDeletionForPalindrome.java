package problems.dynamicprogramming;

/*
 * Problem link :
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=27
 * https://www.youtube.com/watch?v=AEcRW4ylm_c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31
 * 
 */
public class MinimumNoOfInsertionOrDeletionForPalindrome {

	public static void main(String[] args) {
		type3();
		type4();
		type5();
		type6();
	}

	// TODO check later
	private static void type6() {
		String s = "abcbcxcbe";
		int[] len = new int[s.length()];
		char[] charArr = s.toCharArray();
		len[0] = 1;
		int maxVal = 1;
		for (int i = 1; i < charArr.length; i++) {
			len[i] = 1;
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (charArr[i] != charArr[j]) {
					max = Math.max(len[j], max);
					continue;
				}
				int val = max + 2;
				max = Math.max(len[j], max);
				maxVal = Math.max(maxVal, val);
				len[j] = val;
			}
		}
		int count = s.length() - maxVal;
		System.out.println(count);
	}

	// TODO check later
	private static void type5() {
		String s = "abcbcxcbe";
		int count = getDp(s.toCharArray());
		System.out.println(count);
	}

	public static int getDp(char[] chars) {
		int N = chars.length;
		int[][] dp = new int[N][N];
		for (int i = 0; i < N - 1; i++) {
			dp[i][i + 1] = chars[i] == chars[i + 1] ? 0 : 1;
		}
		for (int i = N - 3; i >= 0; i--) {
			for (int j = i + 2; j < N; j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				if (chars[i] == chars[j]) {
					dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
				}
			}
		}
		return dp[0][N - 1];
	}

	public static int get(char[] chars, int L, int R) {
		if ((R - L) == 1) {
			return chars[L] == chars[R] ? 0 : 1;
		}
		int p1 = -1, p2 = 0, p3 = 0;
		if (chars[L] == chars[R]) {
			p1 = get(chars, L + 1, R - 1);
		} else {
			p2 = get(chars, L, R - 1) + 1;
			p3 = get(chars, L + 1, R) + 1;
		}
		return p1 == -1 ? Math.min(p2, p3) : Math.min(Math.min(p2, p3), p1);
	}

	// TODO check later
	private static void type4() {
		String s = "abcbcxcbe";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int[][] dp = new int[n][n];
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				if (arr[i] == arr[j]) {
					dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
				}
			}
		}
		int count = dp[0][n - 1];
		System.out.println(count);
	}

	private static void type3() {
		String s = "abcbcxcbe";
		char[] arr = s.toCharArray();
		int n = arr.length;
		char[] reversed = new char[n];
		for (int i = 0; i < n; i++) {
			reversed[i] = arr[n - 1 - i];
		}
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i - 1] == reversed[j - 1]) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		int count = n - memo[n][n];
		System.out.println(count);
	}
}
