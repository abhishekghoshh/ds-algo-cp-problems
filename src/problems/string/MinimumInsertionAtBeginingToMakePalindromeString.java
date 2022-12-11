package problems.string;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
 * https://www.codingninjas.com/codestudio/problems/893000?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=rLq2vMILp-c
 * 
 * https://www.youtube.com/watch?v=j-1NLHybCSg
 * 
 * 
 * https://www.youtube.com/watch?v=pE4D55Yti7o
 * https://www.youtube.com/watch?v=y1o7ygP-VpQ
 * 
 */
public class MinimumInsertionAtBeginingToMakePalindromeString {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// using manacher's algorithm
	// time complexity O(2n)
	private static void type3() {
		String s = "AACECAAAA";
		int maxPalindromeFromStart = 0;
		int n = 2 * s.length() + 3;
		// initializing the transformed array
		char[] arr = new char[n];
		arr[0] = '@';
		arr[n - 1] = '&';
		arr[n - 2] = '#';
		for (int i = 0; i < s.length(); i++) {
			arr[2 * i + 1] = '#';
			arr[2 * i + 2] = s.charAt(i);
		}
		int[] lps = new int[n];
		int center = 0, right = 0;
		for (int i = 2; i < n - 2; i++) {
			int reflectionIndex = center - (i - center);
			if (i < right)
				lps[i] = Math.min(lps[reflectionIndex], right - i);
			while (arr[i + 1 + lps[i]] == arr[i - 1 - lps[i]]) {
				lps[i]++;
			}
			if (i + lps[i] > right) {
				center = i;
				right = i + lps[i];
			}
			// modification on manacher's algorithm
			// when the left window is from start
			if (arr[i - 1 - lps[i]] == '@') {
				maxPalindromeFromStart = Math.max(maxPalindromeFromStart, lps[i]);
			}
		}
		int answer = s.length() - maxPalindromeFromStart;
		System.out.println(answer);
	}

	// two pointer approach
	// slightly better than previous approach
	private static void type2() {
		String s = "abcd";
		char[] arr = s.toCharArray();
		int start = 0, end = arr.length - 1;
		int last = end;
		int count = 0;
		while (start < end) {
			if (arr[start] == arr[end]) {
				start++;
				end--;
			} else {
				count++;
				end = --last;
				start = 0;
			}
		}
		System.out.println(count);
	}

	// brute force approach
	private static void type1() {
		String s = "abcd";
		char[] arr = s.toCharArray();
		int n = arr.length - 1;
		int count = 0;
		while (n > 0) {
			if (isPalindrome(arr, 0, n - count))
				break;
			count++;
		}
		System.out.println(count);
	}

	private static boolean isPalindrome(char[] arr, int start, int end) {
		while (start < end) {
			if (arr[start] != arr[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

}
