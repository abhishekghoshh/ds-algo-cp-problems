package problems.heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import util.Pair;

/*
 * Problem link :
 * https://leetcode.com/problems/top-k-frequent-elements
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
 * 
 * */
public class TopKFrequentNumbers {
	public static void main(String[] args) {
		type1();
		type2();

	}

	// see leetcode solutions
	// https://leetcode.com/submissions/detail/829211677/
	private static void type2() {

	}

	private static void type1() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k = 4;
		Map<Integer, Integer> frequencyMap = frequencyMap(nums);
		PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair1.second, pair2.second));
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			// System.out.println(entry.getKey() +" : "+ entry.getValue()+" "+queue);
			if (minHeap.size() < k) {
				minHeap.offer(new Pair<>(entry.getKey(), entry.getValue()));
			} else {
				if (entry.getValue() > minHeap.peek().second) {
					minHeap.poll();
					minHeap.offer(new Pair<>(entry.getKey(), entry.getValue()));
				}
			}
		}
		List<Pair<Integer, Integer>> list = buildPairList(minHeap);
		System.out.println(list);
	}

	private static List<Pair<Integer, Integer>> buildPairList(PriorityQueue<Pair<Integer, Integer>> queue) {
		LinkedList<Pair<Integer, Integer>> list = new LinkedList<>();
		while (queue.size() > 0) {
			list.addFirst(queue.poll());
		}
		return list;
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
}
