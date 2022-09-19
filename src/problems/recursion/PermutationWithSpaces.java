package problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1
 * 
 * Solution link
 * https://www.youtube.com/watch?v=1cspuQ6qHW0&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=14
 * */
public class PermutationWithSpaces {

	public static void main(String[] args) {
		type1();
	}

	// we have two option either to add space after any character or not
	// at the last index we don't have to add anything
	// we can just return from that
	// that is our base condition
	private static void type1() {
		String s = "ABC";
		List<String> answer = new ArrayList<>();
		StringBuilder bucket = new StringBuilder();
		traverse(s, 0, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(String s, int index, StringBuilder bucket, List<String> answer) {
		// we are at the last character
		if (index == s.length() - 1) {
			bucket.append(s.charAt(index));
			answer.add(bucket.toString());
			bucket.deleteCharAt(bucket.length() - 1);
			return;
		}
		// here we are choosing character and space to part of answer
		bucket.append(s.charAt(index));
		bucket.append(" ");
		traverse(s, index + 1, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);
		bucket.deleteCharAt(bucket.length() - 1);

		// here we are only choosing character
		bucket.append(s.charAt(index));
		traverse(s, index + 1, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);
	}

}
