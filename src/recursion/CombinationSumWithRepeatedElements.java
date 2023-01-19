package recursion;

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
		type3();

	}

	// count the number of subset
	private static void type3() {
		int[] nums = { 3, 1, 4, 2 };
		int target = 7;
		Arrays.sort(nums);
		int count = count(nums, 0, target);
		System.out.println(count);
	}

	private static int count(int[] nums, int i, int target) {
		if (target == 0)
			return 1;
		if (i == nums.length)
			return 0;
		// if current num is less than equal to target then we have 2 condition
		// either to add it or ignore it
		// so if we add it then we will not increase the index
		// as we will also check for the same index 
		// if num then is not capable then there is no point that next element will also
		// able to make it, as we have sorted the array
		return nums[i] <= target ? count(nums, i, target - nums[i]) + count(nums, i + 1, target) : 0;
	}

	private static void type2() {
		int[] nums = { 3, 1, 4, 2 };
		int target = 7;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		Arrays.sort(nums);
		traverse2(nums, 0, target, bucket, answer);
		System.out.println(answer);
		System.out.println(answer.size());
	}

	private static void traverse2(int[] nums, int index, int target, List<Integer> bucket, List<List<Integer>> answer) {
		// we don't have to check only for the index is length
		// and add it to answer
		// as we are also considering the same elements so when i=n-1
		// on that time also we are calling with n-1, we are not increasing the index
		// so target==0 is enough base condition to handle it
		// on index===nums.length there is a chance that target=0 but that is already
		// handled in another base case
		// this is valid only if we have sorted the array
		if (index == nums.length) {
			return;
		}
		if (target == 0) {
			answer.add(new ArrayList<>(bucket));
			return;
		}
		// if we can accommodate the element then we have two option either to include
		// it or not
		if (nums[index] <= target) {

			// we will accommodate the element
			// but as we can use the same element so we will start again from index
			bucket.add(nums[index]);
			traverse2(nums, index, target - nums[index], bucket, answer);
			bucket.remove(bucket.size() - 1);

			// we will not include the element to be a part of answer
			traverse2(nums, index + 1, target, bucket, answer);
		}
		// if index element is not capable then we can not make the target with index+1
		/*
		 * else { // we can not accommodate that element we we will just go to the next
		 * element traverse2(candidates, index + 1, target, bucket, answer); }
		 */
	}

	private static void type1() {
		int[] nums = { 3, 6, 2, 7 };
		int target = 7;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = new ArrayList<>();
		traverse(nums, 0, target, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(int[] nums, int index, int target, List<Integer> bucket, List<List<Integer>> answer) {
		if (index == nums.length) {
			if (target == 0) {
				answer.add(new ArrayList<>(bucket));
			}
			return;
		}
		// if we can accommodate the element then we have two option either to include
		// it or not
		if (nums[index] <= target) {
			// we will accommodate the element
			// but as we can use the same element so we will start again from index
			bucket.add(nums[index]);
			traverse(nums, index, target - nums[index], bucket, answer);
			bucket.remove(bucket.size() - 1);

			// we will not include the element to be a part of answer
			traverse(nums, index + 1, target, bucket, answer);

		} else {
			// we can not accommodate that element we we will just go to the next element
			traverse(nums, index + 1, target, bucket, answer);
		}
	}

}
