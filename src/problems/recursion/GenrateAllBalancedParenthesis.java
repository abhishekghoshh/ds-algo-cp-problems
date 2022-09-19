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
		// we will start with 0 braces
		// we will just count how much is remaining to to use
		// at this point there is n opening and n closing parenthesis can be added
		traverse(openingBracesLeft, closingBracesLeft, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int openingBracesLeft, int closingBracesLeft, StringBuilder bucket,
			List<String> answer) {
		// if the both is zero then it is a balancing parenthesis
		if (openingBracesLeft == 0 && closingBracesLeft == 0) {
			answer.add(bucket.toString());
		}
		// if any one is less then zero then there is no possible way to make any
		// balanced parenthesis
		// closingBracesLeft will never be less zero but we are only adding it for
		// safety
		if (openingBracesLeft < 0 || closingBracesLeft < 0)
			return;

		// at any point of time we can add opening parenthesis
		bucket.append("(");
		traverse(openingBracesLeft - 1, closingBracesLeft, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);

		// we can only add closing parenthesis when there is atleast one opening
		// parenthesis before, that means count of remaining opening parenthesis is less
		// than count of remaining closing parenthesis
		if (openingBracesLeft < closingBracesLeft) {
			bucket.append(")");
			traverse(openingBracesLeft, closingBracesLeft - 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}

}
