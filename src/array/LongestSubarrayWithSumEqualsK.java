package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 * 
 * Solution:
 * https://www.youtube.com/watch?v=cyu_nuW5utA&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7
 * https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=8
 * 
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 * https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/
 * */
public class LongestSubarrayWithSumEqualsK {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// efficient approach
	// works on negative numbers as
	// prefix sum approach
	// Time complexity O(n)
	// space complexity O(n)
	private static void type3() {
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

	// variable length sliding window technique
	// works on positive numbers only
	// A simple intuition for the optimal approach is that, while forming a subarray
	// if the sum as already greater than k, we can stop there and increase the
	// starting index. Because, already the sum has reached k, if we are still going
	// to add more elements, it would definitely go up.
	// time complexity O(2 *n)
	// space complexity O(1)
	private static void type2() {
		int[] nums = { 3, 8, 2, 4, 1, 0, 4, 1, 1, 1, 2, 0, 12 };
		int k = 5;
		int left = 0, right = 0, sum = 0, length = 0, n = nums.length;
		while (right < n) {
			sum += nums[right];
			if (sum < k) {
				right++;
			} else if (sum == k) {
				length = Math.max(length, right - left + 1);
				right++;
			} else if (sum > k) {
				while (sum > k) {
					sum -= nums[left];
					left++;
				}
				if (sum == k) {
					length = Math.max(length, right - left + 1);
				}
				right++;
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
