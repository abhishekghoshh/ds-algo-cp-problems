package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualsK {

	public static void main(String[] args) {
		type1();
		type2();

	}

	//TODO
	// prefix sum approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 1, -1, 0 };
		int k = 0;
		int n = nums.length, reminder = 0, maxSize = 0, count = 0, length;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();
		prefixSum.put(0, -1);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			reminder = sum - k;
			if (prefixSum.containsKey(reminder)) {
				length = i - prefixSum.get(reminder);
				maxSize = length > maxSize ? length : maxSize;
				count++;
				list.add(Arrays.asList(prefixSum.get(reminder) + 1, i));
			}
			if(!prefixSum.containsKey(sum)) {
				prefixSum.put(sum, i);
			}
		}
		print(nums);
		System.out.println("given sum is " + k);
		System.out.println("All subarrays are " + list);
		System.out.println("Maximum size of subarray is " + maxSize);
		System.out.println("count of subarrays is " + count);
	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	// brute force approach using two loops
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {

	}
}
