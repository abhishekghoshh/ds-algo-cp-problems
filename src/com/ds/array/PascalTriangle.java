package com.ds.array;

import com.util.PrintUtl;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * problem links:
 * https://leetcode.com/problems/pascals-triangle/
 * https://www.codingninjas.com/codestudio/problems/1089580
 * https://www.codingninjas.com/studio/problems/print-pascal-s-triangle_6917910
 *
 * Solution link:
 * https://www.youtube.com/watch?v=bR7mQgwQ_o8
 * https://www.youtube.com/watch?v=6FLvhQjZqvM&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=9
 *
 * https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
 * */
public class PascalTriangle {

	// for any row in pascal triangle,
	// the sum is 2^(n-1)
	public static void main(String[] args) {
		type1();
		type2();
		type3();

	}

	// print the specific row
	private static void type3() {
		int numRow = 5;
		List<Integer> row = new ArrayList<>();
		int denominator = 1;
		row.add(1);
		while (numRow != 1) {
			numRow--;
			row.add(row.get(row.size() - 1) * numRow / denominator);
			denominator++;
		}
		System.out.println("5th row is " + row);
	}

	// specific element on pascal triangle
	private static void type2() {
		int row = 5;
		int column = 3;
		// value is (r-1) C (c-1)
		int value = 1;
		for (int i = row - 1; i > column - 1; i--) {
			value = value * i;
		}
		for (int i = column - 1; i > 1; i--) {
			value = value / i;
		}
		System.out.println("5th row 3rd column value is " + value);
	}

	// Create all rows of pascal triangle
	private static void type1() {
		int numRows = 5;
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> previous = null, current = null;
		for (int i = 0; i < numRows; i++) {
			current = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				// for the first and last element in the row it is 1
				if (j == 0 || j == i) {
					current.add(1);
				} else {
					current.add(previous.get(j - 1) + previous.get(j));
				}
			}
			triangle.add(current);
			previous = current;
		}
		PrintUtl.print2D(triangle);
	}

}
