package array;

import java.util.Arrays;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/631055?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/sort-colors/
 * 
 * Solution link : https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2
 * 
 * */
public class SortZeroOneTwo {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// in place ordering using three pointer
	// Dutch national flag algorithm 3 pointer
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
				while (arr[high] == 2) {
					high--;
				}
				swap(arr, mid, high);
				high--;
			}
		}
		print(arr);
	}

	private static void swap(int[] arr, int i, int j) {
		if (i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	// counting sort
	// count the occurrence of 0,1,2
	// it will solve in o(n) but the loop will run twice
	private static void type2() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		int[] frequency = { 0, 0, 0 };
		for (int item : arr) {
			frequency[item]++;
		}
		int index = 0;
		int element = 0;
		while (index < arr.length) {
			if (frequency[element] == 0) {
				element++;
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

	private static void print(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
