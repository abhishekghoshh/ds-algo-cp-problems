package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import util.Pair;

/*
 * Problem link :
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7
 * 
 * */
public class FrequencySort {
	// Given an array of integers nums, sort the array in increasing order based on
	// the frequency of the values. If multiple values have the same frequency, sort
	// them in decreasing order.
	public static void main(String[] args) {
		type1();
		type2();
		type3();

	}

	// 1 <= nums.length <= 100
	// -100 <= nums[i] <= 100
	// so we could use this
	private static void type3() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int n = nums.length;
		int[] freq = new int[201];
		for (int i = 0; i < n; i++)
			freq[nums[i] + 100]++;
		for (int i = 0; i < n; i++)
			nums[i] = freq[nums[i] + 100] * 1000 + (100 - nums[i]);
		Arrays.sort(nums);
		for (int i = 0; i < n; i++)
			nums[i] = 100 - nums[i] % 1000;
		print(nums);
	}

	// same as previous
	// just little compact
	private static void type2() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		PriorityQueue<Integer> heap = new PriorityQueue<>(
				(a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));
		heap.addAll(map.keySet());
		int j = 0;
		while (!heap.isEmpty()) {
			int n = heap.poll();
			for (int i = 0; i < map.get(n); i++)
				nums[j++] = n;
		}
		print(nums);
	}

	private static void type1() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		Map<Integer, Integer> frequencyMap = frequencyMap(nums);
		PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((p1, p2) -> {
			int val = Integer.compare(p1.second, p2.second);
			if (val == 0)
				return Integer.compare(p2.first, p1.first);// as decreasing order required
			return val;
		});
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			heap.offer(new Pair<>(entry.getKey(), entry.getValue()));
		}
		int[] answer = new int[nums.length];
		int j = 0;
		while (heap.size() != 0) {
			Pair<Integer, Integer> pair = heap.poll();
			for (int i = 0; i < pair.second; i++) {
				answer[j++] = pair.first;
			}
		}
		print(answer);
	}

	private static Map<Integer, Integer> frequencyMap(int[] arr) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int item : arr) {
			if (!frequencyMap.containsKey(item)) {
				frequencyMap.put(item, 1);
			} else {
				frequencyMap.put(item, frequencyMap.get(item) + 1);
			}
		}
		return frequencyMap;
	}

	private static void print(int[] answer) {
		for (int nums : answer) {
			System.out.print(nums + " ");
		}
		System.out.println();
	}

}
