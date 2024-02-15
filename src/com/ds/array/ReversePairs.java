package com.ds.array;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/reverse-pairs/
 * https://www.codingninjas.com/codestudio/problems/1112652
 * https://www.codingninjas.com/studio/problems/team-contest_6840309
 *
 *
 * Solution link :
 * https://www.youtube.com/watch?v=0e4bZaP3MDI
 * https://www.youtube.com/watch?v=S6rsAlj_iB4&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=20
 *
 * https://takeuforward.org/data-structure/count-reverse-pairs/
 */

/*
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 * */
public class ReversePairs {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimal approach
	// using merge sort approach
	// in the merge function we will compute
	// we will have two sorted array left and right
	// we will use two pointer , we will move the right pointer
	// till the point we get nums1[left] > 2 * nums2[right]
	// suppose our two array is 5,7,9 and 3,4
	// for 3 it will go to 7 and we now both array are sorted
	// anything after 7 will also satisfy the upper condition
	// once we find for 3 then we search for 4
	// thus we will find the answer for all sub arrays in total
	private static void type2() {
		int[] nums = { 1, 3, 2, 3, 1 };
		int n = nums.length;
		int[] copy = new int[n];
		Data data = new Data();
		partition(nums, 0, n - 1, copy, data);
		System.out.println("count is " + data.data);
	}

	private static void partition(int[] nums, int i, int j, int[] copy, Data data) {
		if (i >= j) return;
		int mid = (i + j) / 2;
		partition(nums, i, mid, copy, data);
		partition(nums, mid + 1, j, copy, data);
		merge(nums, i, mid, j, copy, data);
	}

	private static void merge(int[] nums, int i, int mid, int j, int[] copy, Data data) {
		int left = i, right = mid + 1;
		long val;
		// the first pointer on a right side array
		// total complexity of this loops will go O(leftSize+rightSize) => O(n)
		while (right <= j) {
			// holding to long in case it overflows while multiplying by 2
			val = nums[right];
			val = 2 * val;
			// incrementing left until we find nums[left] > 2 * nums[right].
			while (left <= mid && nums[left] <= val) {
				left++;
			}
			if (left <= mid) {
				data.data = data.data + (mid - left + 1);
				right++;
			} else {
				break;
			}
		}
		left = i;
		right = mid + 1;
		int length = j - i + 1;
		int index = 0;
		while (left <= mid && right <= j) {
			if (nums[left] <= nums[right]) {
				copy[index++] = nums[left++];
			} else {
				copy[index++] = nums[right++];
			}
		}
		while (left <= mid) {
			copy[index++] = nums[left++];
		}
		while (right <= j) {
			copy[index++] = nums[right++];
		}
		for (index = 0; index < length; index++) {
			nums[index + i] = copy[index];
		}
	}

	private static class Data {
		int data = 0;
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 1, 3, 2, 3, 1 };
		int n = nums.length;
		int count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (nums[i] > 2 * (long) nums[j]) count++;

		System.out.println("count is " + count);
	}

}
