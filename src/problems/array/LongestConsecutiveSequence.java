package problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * https://www.codingninjas.com/codestudio/problems/759408?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : https://www.youtube.com/watch?v=qgizvmgeyUM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=23
 * 
 * */
/*
 * Given an unsorted array of integers nums = [100,4,200,1,3,2], 
 * return the length of the longest consecutive elements sequence. 
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * */

//Special notice 
//In leetcode type1 approach is taking least time
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimal approach
	// find the least element method
	// time complexity O(3n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		if (nums.length == 0) {
			return;
		}
		int length = 0, maxLength = 0;
		Set<Integer> set = new HashSet<>();
		for (int item : nums) {
			set.add(item);
		}
		// we will check if the item is the lowest item or not
		// that means item-1 not present in the set
		// from that we will check that item+1 present or not
		for (int item : nums) {
			// item-1 not present it is lowest element in that series
			if (!set.contains(item - 1)) {
				length = 1;
				while (set.contains(item + 1)) {
					length++;
					item = item + 1;
				}
				maxLength = length > maxLength ? length : maxLength;
			}
		}
		System.out.println("max length is " + maxLength);
	}

	// brute force approach
	// sort the array
	// then linearly traverse
	// time complexity o(n*log(n))
	// space complexity o(n)
	// and we are distorting the array
	// we can make a copy then operate on that
	private static void type1() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		if (nums.length == 0) {
			return;
		}
		Arrays.sort(nums);
		int num = nums[0] - 1, length = 0, maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num) {
				continue;
			}
			if (nums[i] == num + 1) {
				length++;
				maxLength = length > maxLength ? length : maxLength;
			} else {
				length = 1;
			}
			num = nums[i];
		}
		System.out.println("max length is " + maxLength);
	}

}
