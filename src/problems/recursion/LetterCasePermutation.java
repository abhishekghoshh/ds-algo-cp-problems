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
		// we are just making the string to char array
		// so the char array will have all the elements
		// we dont have to add anything later
		traverse(s, 0, s.toCharArray(), answer);
		System.out.println(answer);
	}

	private static void traverse(String s, int index, char[] bucket, List<String> answer) {
		if (index == s.length()) {
			answer.add(new String(bucket));
			return;
		}
		if (Character.isLetter(bucket[index])) {
			// first we will consider the lower case
			// so changing the case to lower
			// whatever the case was previously
			bucket[index] = Character.toLowerCase(bucket[index]);
			traverse(s, index + 1, bucket, answer);
			// now will change the case to upper
			bucket[index] = Character.toUpperCase(bucket[index]);
			traverse(s, index + 1, bucket, answer);
		} else {
			// as this is a digit so we dont have to add anything
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
		// if the character is a letter then only we can change it's case
		if (Character.isLetter(ch)) {
			// first we will consider the lower case
			bucket.append(Character.toLowerCase(ch));
			traverse(s, index + 1, bucket, answer);
			// after the computation we will remove it
			bucket.deleteCharAt(bucket.length() - 1);

			// now will use the upper case
			bucket.append(Character.toUpperCase(ch));
			traverse(s, index + 1, bucket, answer);
			// after the computation we will remove it
			bucket.deleteCharAt(bucket.length() - 1);

		} else {
			// if its a index then we have dont have anything to do
			// just add it and increase the index
			bucket.append(ch);
			traverse(s, index + 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}

}
