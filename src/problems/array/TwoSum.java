package problems.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		type1();
	}

	
	
	/*
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target. You may assume that each input
	 * would have exactly one solution, and you may not use the same element twice.
	 */
	private static void type1() {
		int[] nums = { 2, 7, 11, 15 };
		int length = nums.length;
		int target = 9;
		int diff;
		int[] answer = { -1, -1 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			diff = target - nums[i];
			if (map.containsKey(diff)) {
				answer[0] = map.get(diff);
				answer[1] = i;
			} else {
				map.put(nums[i], i);
			}
		}
	}
}
