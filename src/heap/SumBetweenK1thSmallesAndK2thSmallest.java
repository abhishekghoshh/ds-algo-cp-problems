package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=3ioQQQrnw4Q&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=10
 * 
 * */
public class SumBetweenK1thSmallesAndK2thSmallest {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		long k1 = 3;
		long k2 = 6;
		long array[] = { 20, 8, 22, 4, 12, 10, 14 };
		PriorityQueue<Long> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Long> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
		for (long item : array) {
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
		long k1thSmallest = queue1.peek();
		long k2thSmallest = queue2.peek();
		long sum = Arrays.stream(array).filter(item -> item > k1thSmallest && item < k2thSmallest).reduce(0, Long::sum);
		System.out.println(sum);

	}
}
