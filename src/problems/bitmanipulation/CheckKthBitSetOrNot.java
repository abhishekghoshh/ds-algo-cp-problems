package problems.bitmanipulation;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
 * 
 * Solution link :
 * 
 * 
 */
public class CheckKthBitSetOrNot {
	// Given a number N and a bit number K, check if Kth bit of N is set or not. A
	// bit is called set if it is 1. Position of set bit '1' should be indexed
	// starting with 0 from LSB side in binary representation of the number.
	// Input: N = 4, K = 2
	// Output: Yes
	// Explanation: Binary representation of 4 is 100,
	// in which 2nd bit from LSB is set.
	// So, return true.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 4;
		int k = 2;
		int setBit = (n >> k) & 1;
		System.out.println(setBit);

	}

}
