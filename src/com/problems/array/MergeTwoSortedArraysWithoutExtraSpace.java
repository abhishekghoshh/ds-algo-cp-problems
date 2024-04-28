package com.problems.array;

import java.util.Arrays;

import static com.util.PrintUtl.print;
import static com.util.ArrayUtil.swap;

/*
 * problem link:
 * https://leetcode.com/problems/merge-sorted-array/
 * https://www.codingninjas.com/codestudio/problems/1214628
 *
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=n7uwj04E0I4
 * https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5
 *
 * https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 * */

//1st -> brute force approach
//2nd -> two pointer
//3rd -> Insertion sort approach
//4th -> Gap Method
public class MergeTwoSortedArraysWithoutExtraSpace {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// Gap Method
	// without extra space swap sort approach
	// time complexity O(size*log(size))
	private static void type4() {
		int[] nums1 = { 1, 2, 4, 5, 6, 7, 8, 0, 0 };
		int[] nums2 = { 3, 9 };
		int m = nums1.length - nums2.length;
		int n = nums2.length;
		for (int i = 0; i < n; i++) {
			nums1[i + m] = nums2[i];
		}
		int length = (m + n);
		int gap = length;
		int left = 0, right = 0;
		while (gap != 0) {
			gap = (int) Math.ceil(gap / 2);
			left = 0;
			right = left + gap;
			while (right < length) {
				if (nums1[left] > nums1[right]) {
					swap(nums1, nums1, left, right);
				}
				left++;
				right++;
			}
		}
		print(nums1);
	}

	// two pointer approach
	// using a 3rd array for holding the answer
	// size of the array will be m+n
	// time complexity will be o(m+n)
	private static void type2() {
		int[] nums1 = {1, 3, 4, 0, 0, 0};
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		int[] answer = new int[m + n];
		int index = 0;
		int left = 0, right = 0;
		while (left < m && right < n) {
			if (nums1[left] <= nums2[right]) {
				answer[index++] = nums1[left++];
			} else {
				answer[index++] = nums2[right++];
			}
		}
		while (left < m) {
			answer[index++] = nums1[left++];
		}
		while (right < n) {
			answer[index++] = nums2[right++];
		}
		print(answer);
	}

	// without extra space
	// insertion sort approach
	// time complexity O(m*n)
	private static void type3() {
		int[] nums1 = { 1, 3, 4 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		int right = 0, temp = 0;
		for (int i = 0; i < m; i++) {
			if (nums1[i] > nums2[0]) {
				swap(nums1, nums2, i, 0);
				right = 0;
				temp = nums2[0];
				while (right < n - 1 && temp > nums2[right + 1]) {
					nums2[right] = nums2[right + 1];
					right++;
				}
				nums2[right] = temp;
			}
		}
		print(nums1, nums2);
	}


	// without extra space
	// brute force approach
	// time complexity O(log(m+n))
	private static void type1() {
		int[] nums1 = { 1, 3, 4, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		for (int i = 0; i < n; i++) {
			nums1[i + m] = nums2[i];
		}
		Arrays.sort(nums1);
		print(nums1);
	}


}
