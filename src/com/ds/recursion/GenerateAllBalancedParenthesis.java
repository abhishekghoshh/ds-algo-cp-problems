package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/generate-parentheses/
 * https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1
 * 
 * Solution link
 * https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
 * */
public class GenerateAllBalancedParenthesis {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// same as type1
	// we are nt using string buffer here
	// rather we are using array
	private static void type2() {
		int n = 3;
		char[] bucket = new char[2 * n];
		List<String> answer = new ArrayList<>();
		traverse(answer, bucket, 0, 0, n);
		System.out.println(answer);
	}

	private static void traverse(List<String> list, char[] bucket, int open, int close, int n) {
		if (open > n) {
			return;
		}
		if (open == n && close == n) {
			list.add(new String(bucket));
			return;
		}
		bucket[open + close] = '(';
		traverse(list, bucket, open + 1, close, n);
		if (open > close) {
			bucket[open + close] = ')';
			traverse(list, bucket, open, close + 1, n);
		}
	}

	private static void type1() {
		int n = 3;
		List<String> answer = new ArrayList<>();
		StringBuilder bucket = new StringBuilder();
		// we will start with 0 braces
		// we will just count how much is remaining to use
		// at this point there is n opening and n closing parenthesis can be added
		traverse(n, n, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int open, int close, StringBuilder bucket,
			List<String> answer) {
		// if both are zero, then it is a balancing parenthesis
		if (open == 0 && close == 0) answer.add(bucket.toString());
		// if anyone is less than zero, there is no possible way to make any balanced parenthesis
		// closingBracesLeft will never be less zero, but we are only adding it for safety
		if (open < 0 || close < 0) return;
		// at any point of time we can add opening parenthesis
		bucket.append("(");
		traverse(open - 1, close, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);

		// we can only add closing parenthesis when there is least one opening
		// parenthesis before; that means the count of remaining opening parenthesis is less
		// than the count of remaining closing parenthesis
		if (open < close) {
			bucket.append(")");
			traverse(open, close - 1, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}

}
