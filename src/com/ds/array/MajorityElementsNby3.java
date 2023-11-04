package com.ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.util.ArrayUtil.swap;

/*
 * Problem link:
 * https://leetcode.com/problems/majority-element-ii/
 * https://www.codingninjas.com/codestudio/problems/893027
 * https://www.codingninjas.com/studio/problems/majority-element_6915220
 *
 *
 * Solution link:
 * https://www.youtube.com/watch?v=vwZj1K0e9U8
 * https://www.youtube.com/watch?v=yDbkQd9t2ig&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=18
 *
 * https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
 * */
/*
 * The majority element is the element that appears more than n / 3 times.
 * There can only be at most 2 of such a number in an array.
 * */
public class MajorityElementsNby3 {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// Quick sort approach
	//
	private static void type3() {
		int[] nums = {1, 2, 2, 3, 2};
		int n = nums.length;
		List<Integer> answer = new ArrayList<>();
		quickSort(nums, 0, nums.length - 1, n / 3, answer);
		System.out.println(answer);
	}

	public static void quickSort(int[] nums, int start, int end, int pivot, List<Integer> answer) {
		if (end - start < pivot) return;
		int left = start;
		int right = end;
		int i = start + 1;
		while (right >= i) {
			if (nums[left] > nums[i]) {
				swap(nums, left, i);
				i++;
				left++;
			} else if (nums[left] < nums[i]) {
				if (nums[i] > nums[right]) {
					swap(nums, i, right);
				}
				right--;
			} else {
				i++;
			}
		}
		if (right - left >= pivot) {
			answer.add(nums[right]);
		}
		quickSort(nums, start, left - 1, pivot, answer);
		quickSort(nums, right + 1, end, pivot, answer);

	}

	// Extended Moore's voting algorithm
	// time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		int[] nums = { 1, 2, 2, 3, 2 };
		List<Integer> answer = new ArrayList<>();
		int num1 = Integer.MIN_VALUE, count1 = 0;
		int num2 = Integer.MIN_VALUE, count2 = 0;
		int n = nums.length;
		for (int num : nums) {
			if (num == num1) {
				count1++;
			} else if (num == num2) {
				count2++;
			} else if (count1 == 0) {
				count1 = 1;
				num1 = num;
			} else if (count2 == 0) {
				count2 = 1;
				num2 = num;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for (int num : nums) {
			if (num == num1) count1++;
			if (num == num2) count2++;
		}
		if (count1 > (n / 3)) answer.add(num1);
		if (count2 > (n / 3)) answer.add(num2);
		System.out.println(answer);
	}

	// Frequency map approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type1() {
		int[] nums = { 1, 2, 2, 3, 2 };
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> frequency = new HashMap<>();
		int n = nums.length;
		for (int item : nums)
			if (!frequency.containsKey(item)) frequency.put(item, 1);
			else frequency.put(item, frequency.get(item) + 1);
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet())
			if (entry.getValue() > (n / 3)) answer.add(entry.getKey());
		System.out.println(answer);
	}

}
