package problems.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeOverlappingSubintervals {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		// int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 11 }, { 9, 10 }, { 15, 18 } };
		int[][] intervals = { { 1, 4 }, { 0, 4 } };
		// given than intervals are sorted by their starting time
		// else we have to sort it manually
		PriorityQueue<int[]> queue = new PriorityQueue<>((first, second) -> Integer.compare(first[0], second[0]));
		for (int[] interval : intervals) {
			queue.offer(interval);
		}
		List<int[]> newIntervals = new ArrayList<>();
		newIntervals.add(queue.poll());
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int[] last = newIntervals.get(newIntervals.size() - 1);
			if (last[1] >= current[0]) {
				last[1] = Math.max(last[1], current[1]);
			} else {
				newIntervals.add(current);
			}
		}
		int[][] answer = new int[newIntervals.size()][2];
		for (int i = 0; i < newIntervals.size(); i++) {
			answer[i] = newIntervals.get(i);
		}
	}

}
