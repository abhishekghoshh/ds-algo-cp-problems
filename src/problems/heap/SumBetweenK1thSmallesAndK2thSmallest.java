package problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SumBetweenK1thSmallesAndK2thSmallest {
	public static void main(String[] args) {
		int k1 = 3;
		int k2 = 6;
		int array[] = { 20, 8, 22, 4, 12, 10, 14 };
		PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
		for (int item : array) {
			if (queue1.size() < k1) {
				queue1.offer(item);
			} else {
				if (queue1.peek() > item) {
					queue1.poll();
					queue1.offer(item);
				}
			}
			if (queue2.size() < k2) {
				queue2.offer(item);
			} else {
				if (queue2.peek() > item) {
					queue2.poll();
					queue2.offer(item);
				}
			}
		}
		int k1thSmallest = queue1.peek();
		int k2thSmallest = queue2.peek();
		System.out.println(Arrays.stream(array).filter(item -> item > k1thSmallest && item < k2thSmallest).reduce(0,
				Integer::sum));
	}
}
