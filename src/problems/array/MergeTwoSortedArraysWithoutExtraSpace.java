package problems.array;

import java.util.Arrays;

/*
 * problem link:
 * https://www.codingninjas.com/codestudio/problems/1214628?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5
 * */
public class MergeTwoSortedArraysWithoutExtraSpace {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// without extra space insertion sort approach
	// time complexity O(m*n)
	private static void type3() {
		int[] nums1 = { 1, 3, 4 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		print(nums1);
	}

	// without extra space brute force approach
	// time complexity O(log(m+n))
	private static void type2() {
		int[] nums1 = { 1, 3, 4, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		for (int i = 0; i < n; i++) {
			nums1[i + n] = nums2[i];
		}
		Arrays.sort(nums1);
		print(nums1);
	}

	// using a 3rd array for holding the answer
	// size of the array will be m+n
	// time complexity will be o(m+n)
	private static void type1() {
		int[] nums1 = { 1, 3, 4 };
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

	private static void print(int[] answer) {
		for (int num : answer) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
