package com.problems.array;

import java.util.*;
/*
 * 
 * problem links :
 * https://leetcode.com/problems/two-sum/description/
 * https://neetcode.io/problems/two-integer-sum
 * https://www.naukri.com/code360/problems/pair-sum_697295
 *
 * Solution link :
 * https://www.youtube.com/watch?v=UXDSeD9mN-k&t=1s
 * https://www.youtube.com/watch?v=dRUpbt8vHpo&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=3
 *
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
 * 
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 * */

/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 */
/*
 * Tags:
 * Array, Hashing
 * */
public class TwoSum {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static void type5() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = twoSum5(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}

	private static int[] twoSum5(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		int i = 0;
		int n = nums.length;
		while (i < n && !set.contains(target - nums[i])) {
            set.add(nums[i++]);
        }
		for (int j = 0; j < n; j++) {
			if (nums[i] + nums[j] == target)
				return new int[]{i, j};
        }
		return new int[]{-1, -1};
	}

	// two pointer technique
	// time complexity O(n*log(n)) + O(n)
	// space complexity O(1)
	private static void type4() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = twoSum4(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}

	private static int[] twoSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] answer = {-1, -1};
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int sum = nums[low] + nums[high];
			if (sum == target) {
				return new int[]{low, high};
			}
			if (sum < target) {
				low++;
			} else {
				high--;
			}
		}
		return answer;
	}

	// binary search approach
	// time complexity O(n*log(n)) + O(n*log(n))
	// space complexity O(1)
	private static void type3() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = twoSum3(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}

	private static int[] twoSum3(int[] nums, int target) {
		int diff;
		int n = nums.length;
		int low, high, mid;
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			diff = target - nums[i];
			low = i + 1;
			high = n - 1;
			while (low <= high) {
				mid = low + (high - low) / 2;
				if (nums[mid] == diff) return new int[]{i, mid};
				if (nums[mid] < diff) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return new int[2];
	}

	// hashmap reminder approach
	// Time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = twoSum2(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}

	private static int[] twoSum2(int[] nums, int target) {
		int n = nums.length, diff;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[]{i, map.get(diff)};
			}
			map.put(nums[i], i);
		}
		return new int[2];
	}

	// Time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = twoSum1(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}

	private static int[] twoSum1(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[2];
	}
}
