package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("abcdcbmnoona"));
	}

	public static String longestPalindromicSubstring(String str) {
		String rev = new StringBuilder().append(str).reverse().toString();
		int length = str.length();
		int longestLength = 0;
		int endingIndex = -1;
		int[][] memo = new int[length + 1][length + 1];
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= length; j++) {
				if (str.charAt(i - 1) == rev.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
					if (memo[i][j] > longestLength && str.charAt(i - memo[i][j]) == str.charAt(i - 1)) {
						longestLength = memo[i][j];
						endingIndex = i - 1;
					}
				} else {
					memo[i][j] = 0;
				}
			}
		}
		return str.substring(endingIndex - longestLength + 1, endingIndex + 1);
	}
}
