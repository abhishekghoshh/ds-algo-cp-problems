package com.ds.array;

import static com.util.PrintUtl.print;

/*
 * Problem link : 
 * https://leetcode.com/problems/rotate-array/
 * https://www.codingninjas.com/studio/problems/rotate-array_1230543
 *
 * Solution is :
 * https://www.youtube.com/watch?v=wvcQg43_V8U
 *
 * https://takeuforward.org/data-structure/rotate-array-by-k-elements/
 * */
public class LeftRotateArray {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// time complexity O(2n)
	// space complexity O(1)
	private static void type3() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		print(nums);
	}


	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	// time complexity O(n*k)
	// space complexity O(1)
	private static void type2() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int n = nums.length;
		k = k % n;
		// shift k times
		for (int i = 0; i < k; i++) {
			// copy the last item first
			int last = nums[n - 1];
			// shift right all the elements by one step
			for (int j = n - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			// assign the last to zeroth items
			nums[0] = last;
		}
		print(nums);
	}

	// create one extra array
	// copy elements to that array
	// again copy to that original array
	// space complexity O(n)
	// time complexity O(2n)
	private static void type1() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int n = nums.length;
		k = k % n;
		int[] copy = new int[n];
		for (int i = 0; i < n; i++) {
			copy[(i + k) % n] = nums[i];
		}
		for (int i = 0; i < n; i++) {
			nums[i] = copy[i];
		}
		print(nums);
	}

}
