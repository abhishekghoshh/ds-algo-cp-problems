package problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/combination-sum/
 * https://www.codingninjas.com/codestudio/problems/759331?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link
 * https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
 * 
 * */
public class CombinationSum {

	public static void main(String[] args) {
		type1();

	}

	private static void type1() {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		int bucketSum = 0;
		int currentIndex = 0;
		combinationSum(candidates, currentIndex, bucketSum, target, bucket, answer);
	}

	private static void combinationSum(int[] candidates, int currentIndex, int bucketSum, int target,
			List<Integer> bucket, List<List<Integer>> answer) {
		if (bucketSum == target) {
			answer.add(new ArrayList<>(bucket));
			return;
		}
		if (currentIndex == candidates.length || bucketSum > target) {
			return;
		}
		combinationSum(candidates, currentIndex + 1, bucketSum, target, bucket, answer);

		bucket.add(candidates[currentIndex]);
		combinationSum(candidates, currentIndex + 1, bucketSum + candidates[currentIndex], target, bucket, answer);
		bucket.remove(bucket.size() - 1);
	}

}
