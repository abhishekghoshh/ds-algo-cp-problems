package problems.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

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
		// Use quick select algorithm with hoarse partition that is more complicated
		// than lomuto but more efficient.
		// https://www.geeksforgeeks.org/hoares-vs-lomuto-partition-scheme-quicksort/
		// https://www.techiedelight.com/quick-sort-using-hoares-partitioning-scheme/
		// https://www.youtube.com/watch?v=rI2EBUEMfTk
		// Did not use neetcode codes as it is too complicated and the time complexity
		// is slow.
		// https://github.com/neetcode-gh/leetcode/blob/main/java/973-K-Closest-Points-to-Origin.java
		int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { -3, 3 }, { 1, 3 } };
		int k = 3;
		int left = 0, right = points.length - 1;
		int length = points.length;
		while (length != k) {
			length = partition(points, left, right);
			if (length < k)
				left = length;
			else
				right = length;
		}
		int[][] answer = Arrays.copyOf(points, k);
		print(answer);
	}

	private static int partition(int[][] points, int left, int right) {
		int mid = left + (right - left) / 2;
		int distance = distance(points[mid]);

		while (left <= right) {
			if (distance(points[left]) >= distance) {
				// this mean in right there is closer point
				// so we will swap that and decrement right
				int[] temp = points[left];
				points[left] = points[right];
				points[right--] = temp;
			} else {
				left++;
			}
		}
		// after this we will have (0 to left) elements which are closest to origin
		return left;
	}

	private static int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

	// using maxHeap
	private static void type2() {
		int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { -3, 3 }, { 1, 3 } };
		int k = 3;
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(triplet1, triplet2) -> Integer.compare(triplet2[2], triplet1[2]));
		for (int[] point : points) {
			int distanceSquared = distance(point);
			if (maxHeap.size() < k) {
				maxHeap.offer(new int[] { point[0], point[1], distanceSquared });
			} else {
				if (distanceSquared < maxHeap.peek()[2]) {
					maxHeap.poll();
					maxHeap.offer(new int[] { point[0], point[1], distanceSquared });
				}
			}
		}
		int[][] answer = new int[k][2];
		for (int i = 0; i < k; i++) {
			int[] point = maxHeap.poll();
			answer[i][0] = point[0];
			answer[i][1] = point[1];
		}
		print(answer);
	}

	private static void print(int[][] answer) {
		for (int[] point : answer) {
			System.out.print("[" + point[0] + "," + point[1] + "]");
		}
		System.out.println();
	}
}
