package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/running-median_625409?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Solution link : 
 * https://www.youtube.com/watch?v=itmhHWaHupI
 * */
public class MedianFromDataStream {
	// TODO check https://leetcode.com/submissions/detail/814989430/
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		MedianFinder medianFinder = new MedianFinder();
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

	private static class MedianFinder {
		// left part will be our max heap
		PriorityQueue<Integer> leftHalf;
		// right part will be our min heap
		PriorityQueue<Integer> rightHalf;

		public MedianFinder() {
			leftHalf = new PriorityQueue<>(Collections.reverseOrder());// max heap
			rightHalf = new PriorityQueue<>();// mean heap
		}

		// we will apply one policy leftSize<=rightSize
		// rightSize-leftSize will be at max 1
		public void addNum(int num) {
			// first we will blindly add num in left heap
			leftHalf.offer(num);
			// now we will check our condition
			// if left size is greater than right size
			// or the last item which we have just added is greater than the peek of the
			// right side
			// then we will pop from left and add it right
			if (leftHalf.size() > rightHalf.size() || leftHalf.peek() > rightHalf.peek()) {
				rightHalf.offer(leftHalf.poll());
			}
			// let say leftHalf.peek() > rightHalf.peek() this criteria holded
			// and we have added to right side
			// but in right there was already one extra element
			// now it has two extra element so we have to pop one from right
			// to make the size difference as 1
			if (rightHalf.size() - leftHalf.size() > 1) {
				leftHalf.offer(rightHalf.poll());
			}
		}

		public double findMedian() {
			if (leftHalf.size() == rightHalf.size()) {
				return ((double) leftHalf.peek() + rightHalf.peek()) / 2;
			} else {
				return rightHalf.peek();
			}
		}
	}

	private static void type1() {
		MedianFinderWithArray medianFinderWithArray = new MedianFinderWithArray();
		medianFinderWithArray.addNum(1);
		System.out.println(medianFinderWithArray.findMedian());
		medianFinderWithArray.addNum(3);
		System.out.println(medianFinderWithArray.findMedian());
		medianFinderWithArray.addNum(2);
		System.out.println(medianFinderWithArray.findMedian());
		medianFinderWithArray.addNum(7);
		System.out.println(medianFinderWithArray.findMedian());
		medianFinderWithArray.addNum(4);
		System.out.println(medianFinderWithArray.findMedian());
	}

	private static class MedianFinderWithArray {
		List<Integer> list;

		public MedianFinderWithArray() {
			list = new ArrayList<>();
		}

		public void addNum(int num) {
			if (list.isEmpty() || list.get(list.size() - 1) <= num) {
				list.add(num);
			} else {
				int i = 0;
				while (i < list.size()) {
					if (list.get(i) > num) {
						break;
					}
					i++;
				}
				list.add(i, num);
			}
		}

		public double findMedian() {
			int size = list.size();
			if (size == 0)
				return -1;
			if (size % 2 != 0) {
				return (double) list.get(size / 2);
			} else {
				return ((double) list.get(size / 2 - 1) + list.get(size / 2)) / 2;
			}
		}
	}
}
