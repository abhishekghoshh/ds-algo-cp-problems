package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
/*
 * Problem link :
 * https://leetcode.com/problems/scramble-string
 * https://www.interviewbit.com/problems/scramble-string/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=SqA0o-DGmEw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=40
 * https://www.youtube.com/watch?v=VyHEglhbm-A&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=41
 * 
 */

/*
 * Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
 
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.



Given two strings A and B of the same length, determine if B is a scrambled string of S.
 * 
 * 
 * */
public class ScrambledString {

	// check https://leetcode.com/submissions/detail/834613357/
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {

	}

	private static void type3() {
		String s1 = "abcdem";
		String s2 = "baecdm";
		boolean isTrue = isScrambleOptimized(s1, s2, new HashMap<>());
		System.out.println(isTrue);
	}

	public static boolean isScrambleOptimized(String s1, String s2, Map<String, Boolean> memo) {
		String key = new StringBuilder().append(s1).append(s2).toString();
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		if (s1.equals(s2)) {
			memo.put(key, true);
			return true;
		}
		// we are checking that the both string have the same letters or not
		// if it has not then there is no way that they are scrambled
		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (letters[i] != 0) {
				// this means some character is either has in only one string
				memo.put(key, false);
				return false;
			}
		}
		for (int i = 1; i < s1.length(); i++) {
			// strings are not swapped
			if (isScrambleOptimized(s1.substring(0, i), s2.substring(0, i), memo)
					&& isScrambleOptimized(s1.substring(i), s2.substring(i), memo)) {
				memo.put(key, true);
				return true;
			}
			// strings are swapped
			if (isScrambleOptimized(s1.substring(0, i), s2.substring(s1.length() - i), memo)
					&& isScrambleOptimized(s1.substring(i), s2.substring(0, s1.length() - i), memo)) {
				memo.put(key, true);
				return true;
			}

		}
		memo.put(key, false);
		return false;
	}

	private static void type2() {
		String s1 = "abcdem";
		String s2 = "baecdm";
		if (s1.length() != s2.length()) {
			System.out.println(false);
		} else if ("".equalsIgnoreCase(s1)) {
			System.out.println(true);
		} else {
			Map<String, Boolean> memo = new HashMap<>();
			System.out.println(isScramble(s1, s2, memo));
		}
	}

	private static boolean isScramble(String s1, String s2, Map<String, Boolean> memo) {
		String key = new StringBuilder().append(s1).append(s2).toString();
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		if (s1.equals(s2)) {
			return true;
		}
		if (s1.length() <= 1) {
			return false;
		}
		int n = s1.length();
		for (int i = 1; i < n; i++) {
			// strings are not swapped
			if (isScramble(s1.substring(0, i), s2.substring(0, i), memo)
					&& isScramble(s1.substring(i), s2.substring(i), memo)) {
				memo.put(key, true);
				return true;
			}
			// strings are swapped
			if (isScramble(s1.substring(0, i), s2.substring(n - i, n), memo)
					&& isScramble(s1.substring(i), s2.substring(0, n - i), memo)) {
				memo.put(key, true);
				return true;
			}
		}
		memo.put(key, false);
		return false;
	}

	// brute force approach
	private static void type1() {
		String s1 = "abcdem";
		String s2 = "baecdm";
		if (s1.length() != s2.length()) {
			System.out.println(false);
		} else if ("".equalsIgnoreCase(s1)) {
			System.out.println(true);
		} else {
			System.out.println(isScramble(s1, s2));
		}
	}

	private static boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}
		if (s1.length() <= 1) {
			return false;
		}
		int n = s1.length();
		for (int i = 1; i < n; i++) {
			// strings are not swapped
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			// strings are swapped
			if (isScramble(s1.substring(0, i), s2.substring(n - i, n))
					&& isScramble(s1.substring(i), s2.substring(0, n - i))) {
				return true;
			}
		}
		return false;
	}
}
