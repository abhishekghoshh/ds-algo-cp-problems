package com.problems.array;

import com.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.util.ArrayUtil.max;
import static com.util.ArrayUtil.min;

/*
 * Problem links:
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * https://www.codingninjas.com/codestudio/problems/759408
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=qgizvmgeyUM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=23
 * https://www.youtube.com/watch?v=oO5uLE7EUlM&t=1s
 *
 * https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/
 * */
/*
 * Given an unsorted array of integers nums = [100,4,200,1,3,2], 
 * return the length of the longest consecutive elements sequence. 
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * */

//Special notice 
//In leetcode type1 approach is taking the least time
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}


	// same as previous type 3
	// there is a change of getting memory limit exceed
	private static void type4() {
		int[] nums = {100, 4, 200, 1, 3, 2};
		int maxLen = 0;
		int min = min(nums);
		int max = max(nums);
		boolean[] set = new boolean[max - min + 1];
		for (int num : nums)
			set[num - min] = true;
		int current = 0;
		for (boolean bit : set)
			if (bit) {
				current++;
			} else {
				if (current > maxLen)
					maxLen = current;
				current = 0;
			}
		if (current > maxLen)
			maxLen = current;
		System.out.println("max length is " + maxLen);
	}

	// same as previous type 2
	// there is a change of getting memory limit exceed
	private static void type3() {
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int len, maxLen = 0, start;
		int min = min(nums);
		int max = max(nums);
		boolean[] set = new boolean[max - min + 1];
		for (int num : nums) set[num - min] = true;
		for (int num : nums) {
			start = (num - min) - 1;
			if (start < 0 || !set[start]) {
				start = start + 1;
				len = 0;
				while (start <= (max - min) && set[start]) {
					start++;
					len++;
				}
				maxLen = Math.max(maxLen, len);
			}
		}
		System.out.println("max length is " + maxLen);
	}

	// optimal approach
	// finds the least element method
	// time complexity O(3n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int len = 0, maxLen = 0;
		Set<Integer> set = new HashSet<>();
		for (int item : nums)
			set.add(item);
		// we will check if the item is the lowest item or not
		// that means item-1 not present in the set
		// from that we will check that item+1 present or not
		for (int item : nums) {
			// item-1 not present it is the lowest element in that series
			if (!set.contains(item - 1)) {
				len = 1;
				while (set.contains(item + 1)) {
					len++;
					item = item + 1;
				}
				maxLen = Math.max(len, maxLen);
			}
		}
		System.out.println("max length is " + maxLen);
	}

	// brute force approach
	// sort the array
	// then linearly traverse
	// time complexity o(n*log(n))
	// space complexity o(n) if we copy the original array
	private static void type1() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int[] copy = ArrayUtil.copy(nums);
		Arrays.sort(copy);
		int num = copy[0] - 1, len = 0, maxLen = 0;
		for (int item : copy) {
			// this will make sure that no same element will be considered twice
			if (item == num)
				continue;
			if (item == num + 1) {
				len++;
				maxLen = Math.max(len, maxLen);
			} else {
				len = 1;
			}
			num = item;
		}
		System.out.println("max length is " + maxLen);
	}

}
