package problems.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Problem link : 
 * https://www.interviewbit.com/problems/matrix-median/
 * https://www.codingninjas.com/codestudio/problems/873378?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution is :
 * https://www.youtube.com/watch?v=63fPPOdIr2c&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=63
 * 
 * https://www.youtube.com/watch?v=_4rxBuhyLXw
 * https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/#:~:text=Simple%20Method%3A%20The%20simplest%20method,O(r*c).
 * */
public class MatrixMedian {

	public static void main(String[] args) {
		type1();
		type2();
//		System.out.println(search(new int[] { 1, 3, 6, 6, 6, 7, 8 }, 1));
	}

	// TODO check the
	// https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/#:~:text=Simple%20Method%3A%20The%20simplest%20method,O(r*c).
	// url later and study one more time
	private static void type2() {
		int[][] matrix = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		int r = matrix.length, c = matrix[0].length;
		int low = Integer.MAX_VALUE, high = Integer.MAX_VALUE;
		for (int i = 0; i < r; i++) {
			if (low > matrix[i][0]) {
				low = matrix[i][0];
			}
			if (high < matrix[i][c - 1]) {
				high = matrix[i][c - 1];
			}
		}
		//
		int medianIndex = (r * c + 1) / 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int position = 0;
			for (int i = 0; i < r; i++) {
				position = position + upperBoundIndex(matrix[i], mid);
			}
			if (position < medianIndex) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(low);
	}

	private static int upperBoundIndex(int[] row, int item) {
		int low = 0, high = row.length - 1, mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (row[mid] < item) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	// brute force approach
	// if r is row and c is column and n=r*c
	// then time complexity is O(n+n*log(n))
	// O(n) to put it in list
	// O(n*log(n)) to sort the list
	// space complexity O(n) for the list
	private static void type1() {
		int[][] matrix = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		List<Integer> list = new ArrayList<>();
		for (int[] row : matrix) {
			for (int item : row) {
				list.add(item);
			}
		}
		Collections.sort(list);
		System.out.println(list);
		int size = list.size();
		if (size % 2 == 0) {
			System.out.println((list.get(size / 2 - 1) + list.get(size / 2)) / 2);
		} else {
			System.out.println(list.get(size / 2));
		}
	}

}
