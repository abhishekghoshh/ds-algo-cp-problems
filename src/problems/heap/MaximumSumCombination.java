package problems.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/k-max-sum-combinations_975322?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://www.interviewbit.com/problems/maximum-sum-combinations/
 * Solution link : 
 * 
 * */
public class MaximumSumCombination {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}
	
	private static void type3() {
		Integer[] arr1 = { 1, 4, 2, 3 };
		Integer[] arr2 = { 2, 5, 1, 6 };
		int c = 4;
		PriorityQueue<Point> maxHeap = new PriorityQueue<>((point1, point2) -> Integer.compare(point2.sum, point1.sum));
		Arrays.sort(arr1, Collections.reverseOrder());
		Arrays.sort(arr2, Collections.reverseOrder());

		Point point = new Point(0, 0, arr1[0] + arr2[0]);
		List<Integer> list = new ArrayList<>(c);
		maxHeap.offer(point);
		Set<Point> set = new HashSet<>();
		set.add(point);
		while (list.size() < c) {
			point = maxHeap.poll();
			list.add(point.sum);
			Point point1 = new Point(point.left + 1, point.right, arr1[point.left + 1] + arr2[point.right]);
			Point point2 = new Point(point.left, point.right + 1, arr1[point.left] + arr2[point.right + 1]);
			if (!set.contains(point1)) {
				set.add(point1);
				maxHeap.offer(point1);
			}
			if (!set.contains(point2)) {
				set.add(point2);
				maxHeap.offer(point2);
			}
		}
		System.out.println(list);
	}

	private static class Point {
		public int left;
		public int right;
		public int sum;

		public Point(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + left;
			result = prime * result + right;
			result = prime * result + sum;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (left != other.left)
				return false;
			if (right != other.right)
				return false;
			if (sum != other.sum)
				return false;
			return true;
		}

	}

	// using priority queue
	private static void type2() {
		int[] arr1 = { 1, 4, 2, 3 };
		int[] arr2 = { 2, 5, 1, 6 };
		int c = 4;
		List<Integer> list = new ArrayList<>();
		// minheap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
		for (int item1 : arr1) {
			for (int item2 : arr2) {
				if (minHeap.size() < c) {
					minHeap.offer(item1 + item2);
				} else {
					if (minHeap.peek() < (item1 + item2)) {
						minHeap.poll();
						minHeap.offer(item1 + item2);
					}
				}
			}
		}
		while (!minHeap.isEmpty()) {
			list.add(minHeap.poll());
		}
		Collections.reverse(list);
		System.out.println(list);
	}

	// brute force
	// time complexity (n^2 + n^2*log(n^2) + c)
	//space complexity O(c
	private static void type1() {
		int[] arr1 = { 1, 4, 2, 3 };
		int[] arr2 = { 2, 5, 1, 6 };
		int c = 4;
		List<Integer> list = new ArrayList<>();
		for (int item1 : arr1) {
			for (int item2 : arr2) {
				list.add(item1 + item2);
			}
		}
		Collections.sort(list, (a, b) -> Integer.compare(b, a));
		list = list.subList(0, c);
		System.out.println(list);
	}

}
