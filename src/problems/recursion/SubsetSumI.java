package problems.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {

	public static void main(String[] args) {
		type1();
	}

	// brute force approach will be to find the power set and then find all the sum
	// of the sets in power set
	// But we will not do it
	// we compute the sum while traversing and in that we will wither choose the
	// number or we don't
	// at last we will sort the answer array
	// time complexity will be O(2^n) + sort of 2^n elements
	private static void type1() {
		int[] arr = { 5, 1, 2 };
		List<Integer> answer = new ArrayList<>();
		treverse(arr, 0, 0, answer);
		Collections.sort(answer);
		System.out.println(answer);

	}

	private static void treverse(int[] arr, int i, int sum, List<Integer> answer) {
		if (i == arr.length) {
			answer.add(sum);
		} else {
			treverse(arr, i + 1, sum, answer);
			treverse(arr, i + 1, sum + arr[i], answer);
		}
	}

}
