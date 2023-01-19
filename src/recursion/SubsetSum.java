package recursion;

/*
 * Problem links:
 * https://www.codingninjas.com/codestudio/problems/subset-sum_3843086?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/subset-sums2234/1
 * 
 * 
 * Solution link
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=53
 * 
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSum {

	public static void main(String[] args) {
		type1();
		type2();
	}


	// pick non pick method
	// same as previous just that we are taking set
	// so there will be no duplicate sum
	private static void type2() {
		int[] arr = { 1, 2, 1, 3, 2, 4, 5 };
		Set<Integer> answer = new HashSet<>();
		treverseWithSet(arr, 0, 0, answer);
		List<Integer> allSubsetSum = new ArrayList<>(answer);
		Collections.sort(allSubsetSum);
		System.out.println(allSubsetSum);
	}

	private static void treverseWithSet(int[] arr, int i, int sum, Set<Integer> answer) {
		if (i == arr.length) {
			answer.add(sum);
		} else {
			// we have 2 choices either to take it or not to tke it
			// here we are not taking it
			treverseWithSet(arr, i + 1, sum, answer);
			// here we are taking the arr[i]
			treverseWithSet(arr, i + 1, sum + arr[i], answer);
		}
	}

	// pick non pick method
	// Given array has non unique characters
	// brute force approach will be to find the power set and then find all the sum
	// of the sets in power set
	// But we will not do it
	// we compute the sum while traversing and in that we will wither choose the
	// number or we don't and save the sum in list
	// at last we will sort the answer list
	// time complexity will be O(2^n) + sort of 2^n elements
	// list may contain some duplicate as 1+2 is 3 and the if we take only 3 then
	// also sum will be 3
	private static void type1() {
		int[] arr = { 5, 1, 2, 3 };
		List<Integer> answer = new ArrayList<>();
		treverse(arr, 0, 0, answer);
		Collections.sort(answer);
		System.out.println(answer);

	}

	private static void treverse(int[] arr, int i, int sum, List<Integer> answer) {
		if (i == arr.length) {
			answer.add(sum);
		} else {
			// we have 2 choices either to take it or not to tke it
			// here we are not taking it
			treverse(arr, i + 1, sum, answer);
			// here we are taking the arr[i]
			treverse(arr, i + 1, sum + arr[i], answer);
		}
	}

}
