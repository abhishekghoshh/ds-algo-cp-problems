package problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
 * 
 * Solution link
 * https://www.youtube.com/watch?v=U81n0UYtk98&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=18
 * 
 * https://www.geeksforgeeks.org/print-n-bit-binary-numbers-1s-0s-prefixes/
 * https://leetcode.com/discuss/interview-question/1517199/print-n-bit-binary-numbers-having-more-1s-than-0s-java-recursion
 * */
public class GenerateNBitBinaryNumberHavingMore1sInAllPrefixes {
	// for n=3
	// numbers can be 111,110,101
	// for 111 prefixes can be 1,11,111
	// for 110 prefixes can e 1,10,110
	// for 101 prefixes can e 1,10,101
	// if we look closely for any moment we can easily add 1
	// but to to add 0, there must be having more one before
	public static void main(String[] args) {
		type1();
		type2();
	}

	// in place change
	// we can create array of 1's then on our need we can add and remove zero
	private static void type2() {
		int n = 3;
		List<String> answer = new ArrayList<>();
		// we will create a bucket of 1
		// so for 5 digit we will make 11111
		char[] bucket = new char[n];
		for (int i = 0; i < n; i++) {
			bucket[i] = '1';
		}
		traverse(0, 0, n, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int numberOfOne, int numberOfZero, int n, char[] bucket, List<String> answer) {
		if (numberOfOne + numberOfZero == n) {
			answer.add(new String(bucket));
			return;
		}
		// as the bucket has already all ones so we don't have to add one to bucket
		// externally again, we will just increase the one's counter
		traverse(numberOfOne + 1, numberOfZero, n, bucket, answer);
		if (numberOfOne > numberOfZero) {
			// as we are considering 0 here so we are changing that position to 1
			bucket[numberOfOne + numberOfZero] = '0';
			traverse(numberOfOne, numberOfZero + 1, n, bucket, answer);
			// again after computation we are changing it back to 1
			bucket[numberOfOne + numberOfZero] = '1';
		}
	}

	private static void type1() {
		int n = 3;
		List<String> answer = new ArrayList<>();
		traverse(0, 0, n, new StringBuilder(), answer);
		System.out.println(answer);
	}

	private static void traverse(int numberOfOne, int numberOfZero, int n, StringBuilder bucket, List<String> answer) {
		if (numberOfOne + numberOfZero == n) {
			answer.add(bucket.toString());
			return;
		}
		// as we can add 1 anytime
		// so we are adding to be a part of answer
		bucket.append("1");
		traverse(numberOfOne + 1, numberOfZero, n, bucket, answer);
		bucket.deleteCharAt(bucket.length() - 1);

		// if number of one greater than number of zeros then only we will be adding 0
		if (numberOfOne > numberOfZero) {
			bucket.append("0");
			traverse(numberOfOne, numberOfZero + 1, n, bucket, answer);
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}
}
