package problems.dynamicprogramming;

/*
 * Problem link :
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Solution link :
 * 
 * 
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimal approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type2() {
		String s = "babad";
		int maxSize = 0, start = 0, end = 0, left, right, n = s.length();
		// if you are using java
		// don't directly operate on string
		// rather create one array of character
		// otherwise it will long time
		char[] arr = s.toCharArray();
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				left = i;
				right = i + 1;
				while (left >= 0 && right < n && arr[left] == arr[right]) {
					left--;
					right++;
				}
				left++;
				right--;
				if (right - left + 1 > maxSize) {
					maxSize = right - left + 1;
					start = left;
					end = right;
				}
			}
			left = i;
			right = i;
			while (left >= 0 && right < n && arr[left] == arr[right]) {
				left--;
				right++;
			}
			left++;
			right--;
			if (right - left + 1 > maxSize) {
				maxSize = right - left + 1;
				start = left;
				end = right;
			}
		}
		s = s.substring(start, end + 1);
		System.out.println(s);
	}

	public static void type1() {
		String s = "abcdcbmnoona";
		int longestLength = 0;
		int endingIndex = -1;
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
					if (memo[i][j] > longestLength && arr[i - memo[i][j]] == arr[i - 1]) {
						longestLength = memo[i][j];
						endingIndex = i - 1;
					}
				} else {
					memo[i][j] = 0;
				}
			}
		}
		String longestPalindromicSubstring = s.substring(endingIndex - longestLength + 1, endingIndex + 1);
		System.out.println(longestPalindromicSubstring);
	}
}
