package problems.dynamicprogramming.longestcommonsubsequence;
/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
 * 
 */

public class SequencePatternMatching {
	public static void main(String[] args) {
		type2();
		type3();
	}

	private static void type3() {
		String s1 = "abcdefgh";
		String s2 = "bcfgh";
		int n1 = s1.length();
		int n2 = s2.length();
		int j = 0;
		for (int i = 0; i < n1; i++) {
			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
			}
		}
		boolean isPossible = j == n2;
		System.out.println(isPossible);
	}

	private static void type2() {
		String s1 = "abcdefgh";
		String s2 = "bcfgh";
		boolean isPossible = false;
		int n1 = s1.length();
		int n2 = s2.length();
		System.out.println(isPossible);
		int[][] memo = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		isPossible = memo[n1][n2] == n2;
		System.out.println(isPossible);
	}
}
