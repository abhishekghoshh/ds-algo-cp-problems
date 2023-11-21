package com.ds.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem link:
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=CBSeilNvZHs
 * */
public class SubarrayWithKDifferentIntegers {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// time complexity O(2n)
	// sliding window
	private static void type2() {
		int[] nums = {1, 2, 1, 2, 3};
		int k = 2;
		int n = nums.length;
//		if (n < k) return 0;
		int[] freq = new int[20001];
		int left = 0, right = 0, num, itemToRemove, types = 0;
		int count = 0;
		while (right < n) {
			num = nums[right++];
			if (freq[num] == 0) types++;
			freq[num]++;
			while (left < n && types > k) {
				itemToRemove = nums[left++];
				freq[itemToRemove]--;
				if (freq[itemToRemove] == 0) types--;
				if (types > k) count++;
			}
			if (types == k) count++;
		}
		System.out.println(count);
	}

	// brute force
	// time complexity O(n^2)
	private static void type1() {
		int[] nums = {1, 2, 1, 2, 3};
		int k = 2;
		int count = 0, n = nums.length;
		Set<Integer> set;
		for (int i = 0; i < n; i++) {
			set = new HashSet<>();
			for (int j = i; j < n; j++) {
				if (set.size() == k && !set.contains(nums[j])) break;
				set.add(nums[j]);
				if (set.size() == k) count++;
			}
		}
		System.out.println(count);
	}

}
