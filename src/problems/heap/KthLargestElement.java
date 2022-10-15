package problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/kth-smallest-and-largest-element-of-array_1115488?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : https://www.youtube.com/watch?v=edXdVwkYHF8
 * 
 * */
public class KthLargestElement {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] array = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.naturalOrder());
		for (int item : array) {
			if (pQueue.size() < k) {
				pQueue.offer(item);
			} else {
				if (pQueue.peek() < item) {
					pQueue.poll();
					pQueue.offer(item);
				}
			}
		}
		System.out.println(pQueue.peek());
	}
}
