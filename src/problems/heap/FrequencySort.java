package problems.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int arr[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		Map<Integer, Integer> frequencyMap = frequencyMap(arr);
		PriorityQueue<Pair> queue = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair1.second, pair2.second));
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			queue.offer(new Pair(entry.getKey(), entry.getValue()));
		}
		List<Integer> list = new ArrayList<>();
		while (queue.size() != 0) {
			Pair pair = queue.poll();
			for (int i = 0; i < pair.second; i++) {
				list.add(pair.first);
			}
		}
		System.out.println(list);
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
	private static class Pair {
		public int first;
		public int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
	}
}
