package problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/letter-case-permutation/
 * 
 * Solution link
 * https://www.youtube.com/watch?v=J2Er5XceU_I&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=15
 * https://www.youtube.com/watch?v=4eOPYDOiwFo&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=16
 * */
public class LetterCasePermutation {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// If it is a letter
	// Here we have two choice either to use lower case or upper
	// here we are directly changing the character case
	private static void type2() {
		String s = "a1b2";
		List<String> answer = new ArrayList<>();
		traverse(s, 0, s.toCharArray(), answer);
		System.out.println(answer);
	}

	private static void traverse(String s, int index, char[] bucket, List<String> answer) {
		if (index == s.length()) {
			answer.add(new String(bucket));
			return;
		}
		if (Character.isLetter(bucket[index])) {
			bucket[index] = Character.toLowerCase(bucket[index]);
			traverse(s, index + 1, bucket, answer);
			bucket[index] = Character.toUpperCase(bucket[index]);
			traverse(s, index + 1, bucket, answer);
		} else {
			traverse(s, index + 1, bucket, answer);
		}
	}

	// If it is a letter
	// Here we have two choice either to use lower case or upper
	// we are using a bucket to store the previous results
	private static void type1() {
		String s = "a1b2";
		List<String> answer = new ArrayList<>();
		StringBuilder bucket = new StringBuilder();
		traverse(s, 0, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(String s, int index, StringBuilder bucket, List<String> answer) {
		if (index == s.length()) {
			answer.add(bucket.toString());
			return;
		}
		char ch = s.charAt(index);
		if (!Character.isLetter(ch)) {
			bucket.append(ch);
			traverse(s, index + 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		} else {
			bucket.append(Character.toLowerCase(ch));
			traverse(s, index + 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);

			bucket.append(Character.toUpperCase(ch));
			traverse(s, index + 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}

}
