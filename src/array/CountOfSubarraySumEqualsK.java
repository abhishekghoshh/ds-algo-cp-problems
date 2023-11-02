package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/subarray-sum-equals-k/submissions/
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=fFVZt-6sgyo
 * */
public class CountOfSubarraySumEqualsK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// prefix sum approach
	// time complexity O(n)
	// space complexity O(n)
	// suppose in a range of 0..x1..x2 the sum is x2
	// and in the same range 0..x1 the xor is x1
	// the xor of in between elements(x1+1..x2) is k
	// we can say that x1 + k = x2 => x1 = x2 - k
	// now we have everything just we have to find x1
	// we will compute sum in every element and store it in map with its count
	// Please Note
	// prefixSumMap.put(0, 1); and if(sum==k) count++ has the same purpose
	// if we include prefixSumMap.put(0, 1) then, at sum==k and reminder will be 0
	// then count = count + prefixSumMap.get(reminder); it will be automatically
	// added if we add if(sum==k) count++ then we will manually checking for k
	// equality, at that time prefixSum.containsKey(0) will return false
	// count = count + prefixSumMap.get(0);; will not be exexuted
	private static void type2() {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		int n = nums.length, sum = 0, reminder, count = 0;
		Map<Integer, Integer> prefixSumMap = new HashMap<>();
		prefixSumMap.put(0, 1);// zero prefix sum for empty sub array
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			reminder = sum - k;
			// if reminder exists that mean k also exists
			// the number of prefix sum of reminder is equals the number prefix sum of k
			if (prefixSumMap.containsKey(reminder)) {
				count = count + prefixSumMap.get(reminder);
			}
			// on every index we are updating the prefix sum count
			if (!prefixSumMap.containsKey(sum)) {
				prefixSumMap.put(sum, 1);
			} else {
				prefixSumMap.put(sum, 1 + prefixSumMap.get(sum));
			}
		}
		System.out.println("Count of subarry is " + count);
	}

	// brute force approach using two loops
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == k) {
					count++;
				}
			}
		}
		System.out.println("Count of subarry is " + count);
	}
}
