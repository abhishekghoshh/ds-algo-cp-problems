package com.problems.heap;

import java.util.*;

import static com.util.PrintUtl.print;

/*
 * Problem link :
 * https://leetcode.com/problems/top-k-frequent-elements
 * https://www.codingninjas.com/studio/problems/k-most-frequent-elements_3167808
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
 * 
 * */
public class KMostFrequentElements {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// TODO check it later
	// not explainable in the interview
	private static void type5() {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > max) max = num;
			else if (num < min) min = num;
		}
		int range = max - min + 1;
		int[] freq = new int[range];
		for (int num : nums) freq[num - min]++;

		List<Integer>[] buckets = new List[nums.length + 1];
		for (int i = 0; i < range; i++) {
			int num = i + min;
			int frequency = freq[i];
			if (buckets[frequency] == null)
				buckets[frequency] = new ArrayList<>();
			buckets[frequency].add(num);
		}

		int[] result = new int[k];
		for (int i = buckets.length - 1; k > 0; i--) {
			if (buckets[i] != null) {
				for (int num : buckets[i]) {
					k -= 1;
					result[k] = num;
					if (k == 0) break;
				}
			}
		}
		print(result);
	}

	// same as previous
	// just here we will not store the frequency in the heap
	// it will be in the comparator
	// -104 <= nums[i] <= 104
	private static void type4() {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (i < min) min = i;
			if (i > max) max = i;
		}
		// we are using a frequency array instead of a map
		int[] freq = new int[max - min + 1];
		for (int i : nums) freq[i - min]++;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> freq[a]));
		for (int i = 0; i < freq.length; i++) {
			minHeap.offer(i);
			if (minHeap.size() > k) minHeap.poll();
		}
		int[] answer = new int[k];
		for (int i = k - 1; i >= 0; i--) answer[i] = minHeap.poll() + min;
		print(answer);
	}

	// Same as the previous type
	// just here we are using the frequency array to store the count
	private static void type3() {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (i < min) min = i;
			if (i > max) max = i;
		}
		// we are using a frequency array instead of a map
		int[] freq = new int[max - min + 1];
		for (int i : nums) freq[i - min]++;
		PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing(pair -> pair.second));
		for (int i = 0; i < freq.length; i++) {
			minHeap.offer(new Pair(i, freq[i]));
			if (minHeap.size() > k) minHeap.poll();
		}
		int[] answer = new int[k];
		for (int i = k - 1; i >= 0; i--) answer[i] = minHeap.poll().first + min;
		print(answer);
	}

	// Using heap
	// optimized approach
	private static void type2() {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		Map<Integer, Integer> freq = new HashMap<>();
		// first we will calculate all the frequency
		for (int item : nums)
			freq.put(item, freq.getOrDefault(item, 0) + 1);

		PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing(pair -> pair.second));
		// now we will store the num and its count to the minHeap
		// to get the k highest frequent numbers
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
			if (minHeap.size() > k) minHeap.poll();
		}
		int[] answer = new int[k];
		for (int i = k - 1; i >= 0; i--) answer[i] = minHeap.poll().first;
		print(answer);
	}

	// Brute force approach
	private static void type1() {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		Map<Integer, Integer> freq = new HashMap<>();
		// at first we will calculate all the frequency
		for (int item : nums)
			freq.put(item, freq.getOrDefault(item, 0) + 1);

		Pair[] pairs = new Pair[freq.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet())
			pairs[i++] = new Pair(entry.getKey(), entry.getValue());
		Arrays.sort(pairs, (p1, p2) -> p2.second - p1.second);
		int[] answer = new int[k];
		for (i = 0; i < k; i++) answer[i] = pairs[i].first;
		print(answer);
	}

	static class Pair {
		public int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}

}
