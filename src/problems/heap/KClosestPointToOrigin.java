package problems.heap;

import java.util.PriorityQueue;

import util.Pair;

/*
 * Problem link :
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=XC4EotTewro&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8
 * 
 * */
public class KClosestPointToOrigin {

	public static void main(String[] args) {
		type2();
		type3();
	}

	private static void type3() {

	}

	// using maxHeap
	private static void type2() {
		int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { -3, 3 }, { 1, 3 } };
		int k = 3;
		PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> maxHeap = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair2.first, pair1.first));// max heap
		for (int[] point : points) {
			int distanceSquared = point[0] * point[0] + point[1] * point[1];
			if (maxHeap.size() < k) {
				maxHeap.offer(new Pair<>(distanceSquared, new Pair<>(point[0], point[1])));
			} else {
				if (distanceSquared < maxHeap.peek().getFirst()) {
					maxHeap.poll();
					maxHeap.offer(new Pair<>(distanceSquared, new Pair<>(point[0], point[1])));
				}
			}
		}
		int[][] answer = new int[k][2];
		for (int i = 0; i < k; i++) {
			Pair<Integer, Integer> point = maxHeap.poll().second;
			answer[i][0] = point.first;
			answer[i][1] = point.second;
		}
	}
}
