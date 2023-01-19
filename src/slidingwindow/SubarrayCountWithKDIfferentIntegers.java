package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem link :
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 * 
 * Solution link :
 * 
 * 
 */

public class SubarrayCountWithKDIfferentIntegers {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int[] nums = { 1, 2, 1, 2, 3 };
		int k = 2;
//		int[] nums = { 1, 2, 1, 3, 4 };
//		int k = 3;/
		int count = 0, n = nums.length;
	}

	// optimized approach
	// using frequency map
	private static void type2() {
		int[] nums = { 1, 2, 1, 2, 3 };
		int k = 2;
//		int[] nums = { 1, 2, 1, 3, 4 };
//		int k = 3;/
		int count = 0, n = nums.length;
		Map<Integer, Integer> frequency = new HashMap<>();
		int left = 0, right = 0;
		while (right < n) {
			right++;
		}
		System.out.println(count);
	}

	// brute force
	// time complexity O(n^2)
	private static void type1() {
		int[] nums = { 1, 2, 1, 2, 3 };
		int k = 2;
//		int[] nums = { 1, 2, 1, 3, 4 };
//		int k = 3;/
		int count = 0, n = nums.length;
		Set<Integer> set;
		for (int i = 0; i < n; i++) {
			set = new HashSet<>();
			for (int j = i; j < n; j++) {
				if (set.size() == k && !set.contains(nums[j])) {
					break;
				}
				set.add(nums[j]);
				if (set.size() == k)
					count++;
			}
		}
		System.out.println(count);
	}

}
