package problems.array;
/*
 * Problem link:
 * 
 * Solution:
 * */
public class LongestSubarrayWithSumEqualsK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		
	}

	// brute force
	// time complexity O(n^2)
	// space complexity o(1)
	private static void type1() {
		int[] nums = {-5, 8, -14, 2, 4, 12};
		int k = -5;
		int length = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == k) {
					length = Math.max(length, j - i + 1);
				}
			}
		}
		System.out.println("max length is " + length);
	}

}
