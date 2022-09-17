package problems.recursion;

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
			if (i != currentIndex && candidates[i] == candidates[i - 1])
				continue;
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
		Arrays.sort(candidates);
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		traverse(candidates, 0, target, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int[] candidates, int i, int target, List<Integer> bucket,
			List<List<Integer>> answer) {
		if (target == 0) {
			answer.add(new ArrayList<>(bucket));
		}
		if (i == candidates.length)
			return;
		if (candidates[i] <= target) {
			bucket.add(candidates[i]);
			traverse(candidates, i + 1, target - candidates[i], bucket, answer);
			bucket.remove(bucket.size() - 1);

			traverse(candidates, i + 1, target, bucket, answer);
		}
	}
}
