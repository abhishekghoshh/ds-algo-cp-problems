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
public class CombinationSumWithRepeatElements {
	/*
	 * Given an array of distinct integers candidates and a target integer target,
	 * return a list of all unique combinations of candidates where the chosen
	 * numbers sum to target. You may return the combinations in any order.
	 * 
	 * The same number may be chosen from candidates an unlimited number of times.
	 * Two combinations are unique if the frequency of at least one of the chosen
	 * numbers is different.
	 * 
	 * 1 <= candidates.length <= 30. 2 <= candidates[i] <= 40. All elements of
	 * candidates are distinct.
	 */
	public static void main(String[] args) {
		type1();

	}

	private static void type1() {
		int[] candidates = {  3, 6, 2,7 };
		int target = 7;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		traverse(candidates, 0, target, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int[] candidates, int index, int target, List<Integer> bucket,
			List<List<Integer>> answer) {
		if (index == candidates.length) {
			if (target == 0) {
				answer.add(new ArrayList<>(bucket));
			}
			return;
		}
		if (candidates[index] <= target) {
			traverse(candidates, index + 1, target, bucket, answer);

			bucket.add(candidates[index]);
			traverse(candidates, index, target - candidates[index], bucket, answer);
			bucket.remove(bucket.size() - 1);
		} else {
			traverse(candidates, index + 1, target, bucket, answer);
		}
	}

}
