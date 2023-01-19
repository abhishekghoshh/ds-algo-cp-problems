package heap;

import java.util.PriorityQueue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
 * 
 * */
public class ConnectNRopesToMinimizeCost {
	// There are given N ropes of different lengths, we need to connect these ropes
	// into one rope. The cost to connect two ropes is equal to sum of their
	// lengths. The task is to connect the ropes with minimum cost. Given N size
	// array arr[] contains the lengths of the ropes.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		long ropes[] = { 4, 3, 2, 6 };
		long totalCost = 0;
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		for (long item : ropes) {
			minHeap.offer(item);
		}
		while (minHeap.size() != 1) {
			long first = minHeap.poll();
			long second = minHeap.poll();
			totalCost = first + second + totalCost;
			minHeap.offer(first + second);
		}
		System.out.println(totalCost);
	}
}
