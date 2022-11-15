package problems.string;

/*
 * Problem link : 
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * https://www.codingninjas.com/codestudio/problems/longest-palindromic-substring_758900?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link:
 * 
 * */
public class LongestPalindrome {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		String s = "babad";
		int maxSize = 0, start = 0, end = 0, left, right, n = s.length();
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
		String answer = s.substring(start, end + 1);
		System.out.println(answer);
	}

	private static void type2() {
		String s = "babad";
		char[] chars = s.toCharArray();
		int start = 0;
		int end = 0;
		for (int i = 0; i < chars.length; i++) {
			int len1 = expand(i, i, chars);
			int len2 = expand(i, i + 1, chars);
			int length = Math.max(len1, len2);
			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = start + length - 1;
			}
		}
		String answer = s.substring(start, end + 1);
		System.out.println(answer);
	}

	static int expand(int l, int r, char[] chars) {
		while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	private static void type1() {
		String s = "babad";
		int st = 0, en = 0;
		for (int i = 0; i < s.length(); i++) {
			int l1 = check(s, i, i + 1);
			int l2 = check(s, i, i);
			int l = Math.max(l1, l2);
			if (en - st < l) {
				st = i - (l - 1) / 2;
				en = i + (l / 2);
			}
		}
		String answer = s.substring(st, en + 1);
		System.out.println(answer);
	}

	static int check(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}

}
