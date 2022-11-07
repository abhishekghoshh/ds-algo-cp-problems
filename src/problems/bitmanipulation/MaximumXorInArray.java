package problems.bitmanipulation;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 
 * Solution link :
 * 
 * 
 */
public class MaximumXorInArray {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// TODO see the leetcode discussion section
	private static void type2() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
	}

	private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					xor = Math.max(xor, nums[i] ^ nums[j]);
				}
			}
		}
		System.out.println(xor);
	}
}
