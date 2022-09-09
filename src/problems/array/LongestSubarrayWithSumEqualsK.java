package problems.array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * 
 * Solution:
 * */
public class LongestSubarrayWithSumEqualsK {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		// TODO Auto-generated method stub

	}

	// efficient approach
	// works on negative numbers as
	// prefix sum approach
	// Time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 3, -5, 8, -14, 2, 4, 0, -1, -3, 4, 12 };
		int k = 5;
		// int[] nums = { 10, 5, 2, 7, 1, 9 };
		// int k = 15;
		int length = 0, sum = 0, reminder, n = nums.length;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			// upto that point if sum is 0
			// then length will be i+1
			if (sum == k) {
				length = i + 1;
			} else {
				// we are checking that the reminder is present previously or not
				// if present then the sum of in between nums are 0
				reminder = sum - k;
				// if reminder is present means the sum of in between elements are k
				if (prefixSum.containsKey(reminder)) {
					length = Math.max(length, i - prefixSum.get(reminder));
				}
				// if sum is already present then we will not update it
				// sum present means the in between numbers sum is zero
				// so we will update the index as we will loose some in between values
				if (!prefixSum.containsKey(sum)) {
					prefixSum.put(sum, i);
				}
			}
		}
		System.out.println("max length is " + length);
	}

	// brute force
	// time complexity O(n^2)
	// space complexity o(1)
	private static void type1() {
		int[] nums = { 3, -5, 8, -14, 2, 4, 0, -1, -3, 4, 12 };
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
