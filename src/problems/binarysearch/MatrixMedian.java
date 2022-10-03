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
 * */
public class MatrixMedian {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {

	}

	private static void type1() {
		int[][] matrix = { { 1, 3, 6 }, { 2, 6, 9 }, { 3, 6, 9 } };
		List<Integer> list = new ArrayList<>();
		for (int[] row : matrix) {
			for (int item : row) {
				list.add(item);
			}
		}
		Collections.sort(list);
		int size = list.size();
		if (size % 2 == 0) {
			System.out.println((list.get(size / 2 - 1) + list.get(size / 2)) / 2);
		} else { 
			System.out.println(list.get(size / 2));
		}
	}

}
