package problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/letter-case-permutation/
 * https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1
 * 
 * Solution link
 * https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
 * */
public class GenrateAllBalancedParenthesis {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 3;
		int openingBracesLeft = n, closingBracesLeft = n;
		List<String> answer = new ArrayList<>();
		StringBuilder bucket = new StringBuilder();
		traverse(openingBracesLeft, closingBracesLeft, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int openingBracesLeft, int closingBracesLeft, StringBuilder bucket,
			List<String> answer) {
		if (openingBracesLeft == 0 && closingBracesLeft == 0) {
			answer.add(bucket.toString());
		}
		if (openingBracesLeft < 0 || closingBracesLeft < 0)
			return;

		bucket.append("(");
		traverse(openingBracesLeft - 1, closingBracesLeft, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);

		if (openingBracesLeft < closingBracesLeft) {
			bucket.append(")");
			traverse(openingBracesLeft, closingBracesLeft - 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}

}
