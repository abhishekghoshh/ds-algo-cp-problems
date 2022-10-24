package problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2
 * 
 * */
public class KthLowestElement {
	public static void main(String[] args) {
		type1();
	}

	// using heap
	// we will use max heap
	// and only store the k largest elements in the heap
	// after all the iteration we will return the heap top element
	private static void type1() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0 };
		int k = 6;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums) {
			if (maxHeap.size() < k) {
				maxHeap.offer(num);
			} else {
				if (maxHeap.peek() > num) {
					maxHeap.poll();
					maxHeap.offer(num);
				}
			}
		}
		System.out.println(maxHeap.peek());
	}
}
