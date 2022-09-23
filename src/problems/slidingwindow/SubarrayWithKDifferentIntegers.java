package problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

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

	// TODO solve it later
	// sliding window
	private static void type2() {
//		int[] nums = { 1, 2, 1, 2, 3 };
//		int k = 2;
		int[] nums = { 1, 2, 1, 3, 4 };
		int k = 3;
		int left = 0, right = 0, n = nums.length, count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		// we are going while we find our find window of k
		while (right < n && map.keySet().size() < k) {
			if (!map.containsKey(nums[right])) {
				map.put(nums[right], 0);
			}
			map.put(nums[right], map.get(nums[right]) + 1);
			right++;
		}
		count = 1;
		while (right < n) {
			if (!map.containsKey(nums[right])) {
				map.put(nums[right], 0);
			}
			map.put(nums[right], map.get(nums[right]) + 1);
			if (map.keySet().size() > k) {
				while (map.keySet().size() != k) {
					int c = map.get(nums[left]);
					if (c == 1) {
						map.remove(nums[left]);
					} else {
						map.put(nums[left], c - 1);
					}
					left++;
					count++;
				}
			}
			count++;
			right++;
		}
		System.out.println(count);
	}

	// brute force
	private static void type1() {

	}

}
