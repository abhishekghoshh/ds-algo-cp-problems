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
		type4();
	}

	// TODO stucy later
	// space complexity is O(2n)
	// for storing max from the right and max from the left
	// time complexity is (2n+k)
	private static void type4() {
		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 2;
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		for (int i = 0; i < n; i += k) {
			int max = Integer.MIN_VALUE;
			int rightBound = Math.min(i + k - 1, n - 1);
			for (int j = i; j <= rightBound; j++) {
				if (nums[j] > max) {
					max = nums[j];
				}
				left[j] = max;
			}
			max = Integer.MIN_VALUE;
			for (int j = rightBound; j >= i; j--) {
				if (nums[j] > max) {
					max = nums[j];
				}
				right[j] = max;
			}
		}
		int[] answer = new int[n - k + 1];
		for (int i = 0; i < n - k + 1; i++) {
			int j = i + k - 1;
			answer[i] = Math.max(right[i], left[j]);
		}
		print(nums);
		print(answer);

	}

	// TODO study later
	private static void type3() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int n = nums.length;
		int[] answer = new int[n - k + 1];
		int left = 0;
		int right = k - 1;
		int maxIndex = findMaxIndex(nums, left, right + 1);
		int r = 0;
		answer[r] = nums[maxIndex];
		r++;
		left++;
		right++;
		while (right < nums.length) {
			if (nums[right] >= nums[maxIndex])
				maxIndex = right;
			else if (left > maxIndex) {
				if (nums[right] >= nums[maxIndex] - 1)
					maxIndex = right;
				else if (nums[left] >= nums[maxIndex] - 1)
					maxIndex = left;
				else {
					maxIndex = findMaxIndex(nums, left, right + 1);
				}
			}
			answer[r++] = nums[maxIndex];
			left++;
			right++;
		}
		print(answer);

	}

	public static int findMaxIndex(int[] arr, int left, int right) {
		int ans = left;
		for (int i = left + 1; i < right; i++) {
			if (arr[ans] <= arr[i])
				ans = i;
		}
		return ans;
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
		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 2;
		int n = nums.length;
		// size of the result array
		int size = n - k + 1;
		int[] answer = new int[size];
		int max;
		for (int i = 0; i < n - k + 1; i++) {
			max = nums[i];
			for (int j = 1; j < k; j++) {
				max = max > nums[i + j] ? max : nums[i + j];
			}
			answer[i] = max;
		}
		print(nums);
		print(answer);
	}

}
