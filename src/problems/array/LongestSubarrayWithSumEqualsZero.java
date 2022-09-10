package problems.array;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * problem links :
 * https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
 * https://www.codingninjas.com/codestudio/problems/920321?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * https://www.youtube.com/watch?v=xmguZ6GbatA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=24
 * 
 * */
public class LongestSubarrayWithSumEqualsZero {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// prefix sum approach
	// time complexity O(n)
	private static void type2() {
		int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = nums.length, maxLength = 0, sum = 0;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			// upto that point if sum is 0
			// then length will be i+1
			if (sum == 0) {
				maxLength = i + 1;
			} else {
				// we are checking that the same sum is present previously or not
				// if present then the sum of in between nums are 0
				if (prefixSum.containsKey(sum)) {
					maxLength = Math.max(maxLength, i - prefixSum.get(sum));
				} else {
					// else add the sum in the prefixsum map with the current index
					// we will not update the index of sum even if we find the same sum again
					prefixSum.put(sum, i);
				}
			}
		}
		System.out.println("max length is " + maxLength);
	}

	// brute force
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int sum, maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == 0) {
					maxLength = Math.max((j - i + 1), maxLength);
				}
			}
		}
		System.out.println("max length is " + maxLength);
	}

}
