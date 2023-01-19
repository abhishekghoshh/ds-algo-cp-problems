package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/combination-sum-ii/
 * https://www.codingninjas.com/codestudio/problems/1112622?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link
 * https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51
 * 
 * */
public class CombinationSumWithUniqueElements {
	/*
	 * Given a collection of candidate numbers (candidates) and a target number
	 * (target), find all unique combinations in candidates where the candidate
	 * numbers sum to target. Each number in candidates may only be used once in the
	 * combination. Note: The solution set must not contain duplicate combinations.
	 * 
	 * The output will be in lexicographical order
	 */
	public static void main(String[] args) {
		type1();
		type2();
	}

	// As there are some repeat elements in given array we have to follow this
	// subsequence approach
	// we will only pick unique elements in a loop
	private static void type2() {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		// we will sort the array then all the duplicate elements will come one after
		// another
		Arrays.sort(candidates);
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		traverseWithUniquePick(candidates, 0, target, bucket, answer);
		System.out.println(answer);
	}

	private static void traverseWithUniquePick(int[] candidates, int currentIndex, int target, List<Integer> bucket,
			List<List<Integer>> answer) {
		if (target == 0) {
			answer.add(new ArrayList<>(bucket));
			return;
		}
		for (int i = currentIndex; i < candidates.length; i++) {
			// this condition will skip the duplicate elements
			if (i != currentIndex && candidates[i] == candidates[i - 1])
				continue;
			// if current element is greater than target then there is no point to check
			// index+1 elements as the array is sorted
			if (candidates[i] > target)
				return;
			bucket.add(candidates[i]);
			traverseWithUniquePick(candidates, i + 1, target - candidates[i], bucket, answer);
			bucket.remove(bucket.size() - 1);
		}
	}

	// If there are no duplicate value in given array
	private static void type1() {
		int[] candidates = { 10, 1, 2, 7, 6, 5 };
		int target = 8;
		// for early computation we will sort the array
		Arrays.sort(candidates);
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		traverse(candidates, 0, target, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int[] candidates, int index, int target, List<Integer> bucket,
			List<List<Integer>> answer) {
		if (target == 0) {
			answer.add(new ArrayList<>(bucket));
		}
		// if index is length and target is not zero so we are not capable make target
		if (index == candidates.length)
			return;
		// we will add the element if it is less than the current target
		// and we know that if the item is not capable then index+1 element will also
		// unable to make it
		if (candidates[index] <= target) {
			// choosing the element
			bucket.add(candidates[index]);
			traverse(candidates, index + 1, target - candidates[index], bucket, answer);
			bucket.remove(bucket.size() - 1);
			// not choosing the element
			traverse(candidates, index + 1, target, bucket, answer);
		}
	}
}
