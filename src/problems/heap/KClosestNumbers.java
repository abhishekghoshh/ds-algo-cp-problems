package problems.heap;

import java.util.PriorityQueue;

import util.Pair;

public class KClosestNumbers {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int k = 4, number = 35;
		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int[] answer = new int[k];
		PriorityQueue<Pair<Integer,Integer>> maxHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair2.first, pair1.first));
		for (int item : arr) {
			int distance = Math.abs(item - number);
			if (distance == 0)
				continue;
			if (maxHeap.size() < k) {
				maxHeap.offer(new Pair<>(distance, item));
			} else {
				if (maxHeap.peek().first > distance) {
					maxHeap.poll();
					maxHeap.offer(new Pair<Integer,Integer>(distance, item));
				}
			}
		}
		int index = 0;
		while (!maxHeap.isEmpty()) {
			answer[index++] = maxHeap.poll().second;
		}
		print(answer);
	}

	private static void print(int[] answer) {
		for (int num : answer) {
			System.out.println(num + " ");
		}
		System.out.println();
	}
}
