package com.ds.array;

import java.util.Arrays;

import static com.util.ArrayUtil.print;
import static com.util.ArrayUtil.swap;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/sort-colors/
 * https://www.codingninjas.com/studio/problems/sort-an-array-of-0s-1s-and-2s_892977
 * https://www.codingninjas.com/codestudio/problems/631055
 *
 * Solution link :
 * https://www.youtube.com/watch?v=tp8JIuCXBaU&t=1s
 * https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2
 *
 * https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
 * */
public class SortZeroOneTwo {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// in place ordering using three pointer
	// Dutch national flag algorithm 3 pointer
	// TODO this solution is failing for some test cases in leetcode
	private static void type3() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;
		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				while (mid <= high && arr[high] == 2) {
					high--;
				}
				swap(arr, mid, high);
				high--;
			}
		}
		print(arr);
	}

	// counting sort
	// count the occurrence of 0,1,2
	// it will solve in o(n) but the loop will run twice
	private static void type2() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		int[] frequency = { 0, 0, 0 };
		for (int item : arr)
			frequency[item]++;
		int index = 0;
		int element = 0;
		while (index < arr.length) {
			if (frequency[element] == 0) {
				element++;
				continue;
			}
			arr[index++] = element;
			frequency[element]--;
		}
		print(arr);
	}

	// brute force approach
	// sort the array with o(nlogn) complexity
	private static void type1() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		Arrays.sort(arr);
		print(arr);
	}

}
