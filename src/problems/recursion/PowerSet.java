package problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem links:
 * https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/subsets-ii/
 * 
 * 
 * Solution link
 * https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=54
 * 
 * */

// Similar problem
//All words made by the word in lexographic order
//ba -> "", "a","ab","b"
public class PowerSet {

	public static void main(String[] args) {
		type1();
	}

	// Given array has duplicate characters
	// With computation
	// here our intuition is that we will pick one unique item a time
	// from the remaining list
	// first we will make 0 item list then 1 item then 2 then n items
	private static void type1() {
		int[] nums = { 1, 2, 1, 3, 2, 4 };
		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);
		List<Integer> bucket = new ArrayList<>();
		powerSet(nums, 0, bucket, answer);
		System.out.println(answer);
	}

	private static void powerSet(int[] arr, int currentIndex, List<Integer> bucket, List<List<Integer>> answer) {
		// deep copy of the bucket
		answer.add(new ArrayList<>(bucket));
		for (int i = currentIndex; i < arr.length; i++) {
			// loop will not execute for the duplicate values
			if (i != currentIndex && arr[i] == arr[i - 1]) {
				continue;
			}
			// we are choosing arr[i] to be part of the bucket
			bucket.add(arr[i]);
			// computing the remaining
			powerSet(arr, i + 1, bucket, answer);
			// after computing again removing it
			bucket.remove(bucket.size() - 1);
		}
	}
}
