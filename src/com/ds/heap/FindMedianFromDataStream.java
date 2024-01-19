package com.ds.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/find-median-from-data-stream/
 * https://www.codingninjas.com/codestudio/problems/running-median_625409
 *
 * Solution link :
 * https://www.youtube.com/watch?v=itmhHWaHupI
 * */
public class FindMedianFromDataStream {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}


	private static void type3() {
		MedianFinder3 medianFinder = new MedianFinder3();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
	}

	static class MedianFinder3 {
		PriorityQueue<Integer> right, left;

		public MedianFinder3() {
			left = new PriorityQueue<>((a, b) -> b - a);
			right = new PriorityQueue<>();
		}

		// here we are not fixing anything
		// +1 element can be either on the left side or on the right side
		// but the difference has to be lesser than equal to 1
		public void addNum(int num) {
			if (right.isEmpty() || num > right.peek())
				right.offer(num);
			else
				left.offer(num);

			if (right.size() - left.size() > 1)
				left.offer(right.poll());

			if (left.size() - right.size() > 1)
				right.offer(left.poll());
		}

		public double findMedian() {
			int n1 = left.size(), n2 = right.size();
			if (n1 != n2)
				return (double) (n2 > n1 ? right.peek() : left.peek());
			else
				return (right.peek() + left.peek()) / 2.0;
		}
	}

	private static void type2() {
		MedianFinder2 medianFinder = new MedianFinder2();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
	}

	private static class MedianFinder2 {
		// the left part will be our max heap
		PriorityQueue<Integer> left;
		// the right part will be our min heap
		PriorityQueue<Integer> right;

		public MedianFinder2() {
			// this is the left series with max heap property
			left = new PriorityQueue<>(Collections.reverseOrder());
			// this is the right series min heap property
			right = new PriorityQueue<>();
		}

		// we will apply one policy leftSize<=rightSize
		// right heap Size - left heap Size will be at max 1
		public void addNum(int num) {
			// at first, we will blindly add num in left heap
			left.offer(num);
			// Now we will check our condition.
			// If left size is greater than right size
			// or the last item which we have just added is greater than the peek of the
			// right side, then we will pop from the left and add it right
			if (left.size() > right.size() || left.peek() > right.peek())
				right.offer(left.poll());
			// let say leftHalf.peek() > rightHalf.peek() this criteria held,
			// and we have added to the right side,
			// but in the right there was already one extra element
			// now it has two extra elements so, we have to pop one from the right
			// to make the size difference as 1
			if (right.size() - left.size() > 1)
				left.offer(right.poll());
		}

		public double findMedian() {
			if (left.size() == right.size())
				return ((double) left.peek() + right.peek()) / 2;
			else return right.peek();
		}
	}

	private static void type1() {
		MedianFinder1 medianFinder = new MedianFinder1();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
	}

	private static class MedianFinder1 {
		List<Integer> list;

		public MedianFinder1() {
			list = new ArrayList<>();
		}

		// insertion method from the insertion sort
		public void addNum(int num) {
			int n = list.size();
			if (n == 0 || list.get(n - 1) <= num) {
				list.add(num);
				return;
			}
			int i = 0;
			while (i < n) {
				if (list.get(i) > num) break;
				i++;
			}
			list.add(i, num);
		}

		public double findMedian() {
			int size = list.size();
			if (size == 0) return -1;
			if (size % 2 != 0) return (double) list.get(size / 2);
			else return ((double) list.get(size / 2 - 1) + list.get(size / 2)) / 2;
		}
	}
}
