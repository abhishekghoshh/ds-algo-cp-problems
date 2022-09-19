package problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
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
public class CombinationSumWithRepeatedElements {
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
		type2();

	}

	private static void type2() {
		int[] candidates = { 3, 6, 2, 7 };
		int target = 7;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		Arrays.sort(candidates);
		traverse2(candidates, 0, target, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse2(int[] candidates, int index, int target, List<Integer> bucket,
			List<List<Integer>> answer) {
		// we dont have to check for the index is length or not as we will not go to the
		// bottom of the recursion
		// as we have sorted the array
		if (index == candidates.length) {
			return;
		}
		if (target == 0) {
			answer.add(new ArrayList<>(bucket));
			return;
		}
		// if we can accommodate the element then we have two option either to include
		// it or not
		if (candidates[index] <= target) {

			// we will accommodate the element
			// but as we can use the same element so we will start again from index
			bucket.add(candidates[index]);
			traverse2(candidates, index, target - candidates[index], bucket, answer);
			bucket.remove(bucket.size() - 1);

			// we will not include the element to be a part of answer
			traverse2(candidates, index + 1, target, bucket, answer);
		}
		// if index element is not capable then we can not make the target with index+1
		/*
		 * else { // we can not accommodate that element we we will just go to the next
		 * element traverse2(candidates, index + 1, target, bucket, answer); }
		 */
	}

	private static void type1() {
		int[] candidates = { 3, 6, 2, 7 };
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
		// if we can accommodate the element then we have two option either to include
		// it or not
		if (candidates[index] <= target) {
			// we will accommodate the element
			// but as we can use the same element so we will start again from index
			bucket.add(candidates[index]);
			traverse(candidates, index, target - candidates[index], bucket, answer);
			bucket.remove(bucket.size() - 1);

			// we will not include the element to be a part of answer
			traverse(candidates, index + 1, target, bucket, answer);

		} else {
			// we can not accommodate that element we we will just go to the next element
			traverse(candidates, index + 1, target, bucket, answer);
		}
	}

}
