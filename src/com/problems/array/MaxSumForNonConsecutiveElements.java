package com.problems.array;

import java.util.ArrayList;
import java.util.List;

import static com.util.ArrayUtil.maxN;
/*
 *
 * problem links:
 * https://leetcode.com/problems/house-robber
 * https://www.codingninjas.com/studio/problems/house-robber-ii_839733
 *
 *
 * Solution link:
 * https://www.youtube.com/watch?v=GrMBfJNk_NY
 *
 * https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
 * */

public class MaxSumForNonConsecutiveElements {
	public static void main(String[] args) {
		type1();
		type2();
	}

	// without using any extra array,
	// we will use three pointers to store the result
	// either we will take the current item or not
	// Time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		int[] nums = {5, 5, 10, 100, 10, 5};
		int n = nums.length;
		int prev2 = nums[0];
		int prev = Math.max(nums[0], nums[1]);
		int current, takeCurrentItem, notTakeCurrentItem;
		for (int i = 2; i < n; i++) {
			takeCurrentItem = nums[i] + prev2;
			notTakeCurrentItem = prev;
			current = Math.max(takeCurrentItem, notTakeCurrentItem);
			prev2 = prev;
			prev = current;
		}
		int answer = Math.max(prev, prev2);
		System.out.println(answer);
	}

	private static void type1() {
		int[] arr = {5, 5, 10, 100, 10, 5};
		int answer = FindMaxSum(arr, arr.length);
		System.out.println(answer);
	}

	public static int FindMaxSum(int[] arr, int n) {
		if (n == 1) return arr[0];
		if (n == 2) return maxN(arr[0], arr[1]);
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(arr[0]);
		list.add(arr[1]);
		for (int i = 2; i < n; i++) {
			int size = list.size();
			int highestLoot = maxN(list.get(size - 2), list.get(size - 3));
			list.add(arr[i] + highestLoot);
		}
		int size = list.size();
		return maxN(list.get(size - 1), list.get(size - 2), list.get(size - 3));
	}
}
