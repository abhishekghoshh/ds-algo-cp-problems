package problems.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Problem link:
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
 * 
 * 
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 * */
public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// TODO study later
	private static void type3() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int n = nums.length;
		int[] answer = new int[n - k + 1];
		int index = 0;
		int indexLeft = 0;
		int indexRight = k - 1;
		int indexMax = findIMax(nums, indexLeft, indexLeft + k);
		answer[index++] = nums[indexMax];
		indexLeft++;
		indexRight++;

		while (indexRight < n) {
			if (nums[indexRight] >= nums[indexMax]) {
				indexMax = indexRight;
			} else if (indexLeft > indexMax) {
				// trouble. max is not in range
				if (nums[indexRight] >= nums[indexMax] - 1) {
					// if right is one less than maximum
					indexMax = indexRight;
				} else if (nums[indexLeft] >= nums[indexMax] - 1) {
					// if left is one less than maximum
					indexMax = indexLeft;
				} else {
					indexMax = findIMax(nums, indexLeft, indexRight + 1);
				}
			}
			answer[index++] = nums[indexMax];
			indexLeft++;
			indexRight++;
		}
		print(answer);

	}

	private static int findIMax(int[] nums, int start, int end) {
		int rt = start;
		for (int i = start + 1; i < end; i++) {
			if (nums[i] >= nums[rt]) {// biggest and rightmost
				rt = i;
			}
		}
		return rt;
	}

	// sliding window
	private static void type2() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int n = nums.length;
		int size = n - k + 1;
		int[] answer = new int[size];
		Deque<Integer> deque = new LinkedList<>();
		int left = 0, right = 0;
		while (right < k) {
			if (deque.isEmpty() || deque.peekLast() >= nums[right]) {
				deque.offerLast(nums[right]);
			} else {
				while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
					deque.pollLast();
				}
				deque.offerLast(nums[right]);
			}
			right++;
		}
		while (right <= n) {
			answer[left] = deque.peekFirst();
			if (deque.peekFirst() == nums[left]) {
				deque.pollFirst();
			}
			if (right < n) {
				if (deque.isEmpty() || deque.peekLast() >= nums[right]) {
					deque.offerLast(nums[right]);
				} else {
					while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
						deque.pollLast();
					}
					deque.offerLast(nums[right]);
				}
			}
			left++;
			right++;
		}
		print(answer);
	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	// brute force approach
	private static void type1() {

	}

}
