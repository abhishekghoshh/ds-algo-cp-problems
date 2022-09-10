package problems.array;

import java.util.Set;
import java.util.TreeSet;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/1102307?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Fm_p9lJ4Z_8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=44
 * 
 * */
public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// same two pointer approach
	// time complexity O(n)
	// space complexity O(1)
	private static void type3() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
		int i = 0, n = nums.length;
		// we are taking from j=1 as nums[0] is already in its place
		for (int j = 1; j < n; j++) {
			// when we find a new element at that time we are only changing nums[i]
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		print(nums);
		System.out.println("count is " + (i + 1));
	}

	// two pointer approach
	// time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
		int left = 0, right = 0, n = nums.length;
		while (right < n) {
			// we will increase the right until it found a new element
			// for the last element like 4, right will go till n and stops
			while (right < n && nums[left] == nums[right]) {
				right++;
			}
			left++;
			// left+1 will be position of the new element
			// for the last element right is n, that's why it terminates
			// so there is no new element
			if (right < n) {
				nums[left] = nums[right];
			}
		}
		print(nums);
		System.out.println("count is " + left);
	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	// brute force approach
	// time complexity O(n*log(n)+n)
	// space complexity O(n) for adding items a tree set
	// for every element it will check it's next element
	private static void type1() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
		Set<Integer> set = new TreeSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int index = 0;
		for (int item : set) {
			nums[index++] = item;
		}
		print(nums);
		System.out.println("count is " + index);
	}

}
