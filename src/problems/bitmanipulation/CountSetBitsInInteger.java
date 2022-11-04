package problems.bitmanipulation;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Solution link :
 * https://www.codingninjas.com/codestudio/library/count-number-of-set-bits-in-an-integer
 * https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * 
 */
public class CountSetBitsInInteger {
	// Signed Right shift operator (>>)
	// Unsigned Right shift operator (>>>)
	// Left shift operator(<<)
	// Unsigned Left shift operator (<<<)
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
//		int n = 2147483647;
		int n = -2147483648;
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		System.out.println(ones);
	}

	// in case of negative it will fail as >> is a signed shift operator
	// in MSB of negative number there is one and by using >> it will not shift to
	// lsb, it will stay as it is, so in place of >> we can use >>>
	private static void type1() {
		int n = 2147483647;
		// int n = -2147483648;
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >> 1;
		}
		System.out.println(ones);
	}

}
