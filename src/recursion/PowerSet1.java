package recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/subsets/
 * https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236
 * https://practice.geeksforgeeks.org/problems/power-set4302/1
 *
 * Solution link
 * https://www.youtube.com/watch?v=b7AYbpM5YrE
 * https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=54
 * 
 * https://www.youtube.com/watch?v=Yg5a2FxU4Fo&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=12
 * https://www.youtube.com/watch?v=lfFqW1DTsqM&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=13
 *
 *
 * https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
 * */

public class PowerSet1 {
	// Similar problem
	// AllCombination problem
	// All words made by the word in lexicographic order
	// ba -> "", "a","ab","b"
	// Note
	// Substring is where all the elements are in order and continuous
	// subsequence is where all the elements are in order but not continuous
	// subset is where all the elements are not in order and not continuous
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// let's say our array is 1,2,3, n=3
	// so we will run a loop from 0 to 2^n -1
	// find the binary of the number i
	// suppose i => 101
	// so we will add the arr[index] such that binary[index]=1
	// 101 means we will add 1 and 3
	// time complexity O(n*2^n)
	// space complexity O(n)
	private static void type3() {
		int[] nums = {1, 2, 3};
		int n = nums.length;
		// size of power is 2^n
		// so we will run a loop 0 to 2^n -1
		int bound = 1 << n;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = null;
		int index, num;
		for (int i = 0; i < bound; i++) {
			bucket = new ArrayList<>(2 * n);
			index = 0;
			num = i;
			while (num != 0) {
				if ((num & 1) == 1) bucket.add(nums[index]);
				index++;
				num = num >> 1;
			}
			answer.add(bucket);
		}
		System.out.println(answer);
	}

	// Using backtracking
	private static void type2() {
		int[] nums = {1, 2, 3};
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		subsetsAll(0, list, ans, nums);
		System.out.println(ans);
	}

	public static void subsetsAll(int index, List<Integer> list, List<List<Integer>> ans, int[] nums) {
		if (index == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[index]);
		subsetsAll(index + 1, list, ans, nums);
		list.remove(list.size() - 1);
		subsetsAll(index + 1, list, ans, nums);
	}

	// only unique characters
	private static void type1() {
		String str = "abc";
		List<String> answer = new ArrayList<>();
		powerSet(new StringBuilder(), 0, str, answer);
		System.out.println(answer);
	}

	// we have two option either to choose it or not
	private static void powerSet(StringBuilder previous, int current, String actualString, List<String> answer) {
		if (current == actualString.length()) {
			answer.add(previous.toString());
			return;
		}
		// here we are not choosing it to be a part of the answer
		powerSet(previous, current + 1, actualString, answer);
		// here we are choosing the element to a part of the answer
		powerSet(previous.append(actualString.charAt(current)), current + 1, actualString, answer);
		// as previous is a StringBuilder so we are changing the actual object so we
		// need to delete the last character which we have added previously
		previous.deleteCharAt(previous.length() - 1);
	}
}
