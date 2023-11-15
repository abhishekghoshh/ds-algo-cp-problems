package com.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Problem link :
 * https://leetcode.com/problems/find-the-duplicate-number/
 * https://www.codingninjas.com/codestudio/problems/1112602
 *
 *
 * Solution link :
 * https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=1
 *
 * https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/
 * */
public class FindDuplicateNumber {

	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// linked list cycle approach
	// it's same as cycle detection in linked list
	// we will take two pointer slow and fast
	// and move them by one and two
	// there will always be collision as for some point nums[i]=nums[j]
	// let say slow and fast pointer moves c+ml+x and c+nl+x
	// where c is common space, m and n is rotation taken before collision
	// l is the cycle length
	// x is collision distance from starting point of cycle
	// and let's say slow pointer goes d distance before collision
	// then fast pointer will be going 2d distance before collision
	// 2d-d = (c+nl+x) - (c+ml+x) => d = l*(n-m)
	// so d is multiple of cycle length
	// l*(n-m) = c+ml+x => c+x = l*(n-2m)
	// so c+x is also multiple of cycle length
	// that means after collision point if we go to x distance
	// then we will obviously get the starting of the cycle
	// which is also the duplicate number
	// time complexity of this more than O(n)
	// as it may rotate some cycles
	private static void type5() {
		// int nums[] = { 1, 3, 4, 2, 8, 6, 5, 9, 8, 10, 11 };
		int nums[] = { 1, 3, 4, 2, 2 };
		int slow, fast;
		slow = nums[0];
		fast = nums[0];
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast) {
				break;
			}
		}
		// at this point we detects the cycle
		slow = nums[0];
		// now slow points to first
		// fast points to collision
		// now move both pointers to one step
		// their collision point will be duplicate point
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		System.out.println("Duplicate element is " + slow);
	}

	// swap sort without using extra space
	// given array must be mutable
	private static void type4() {
		int[] nums = { 1, 3, 4, 2, 2 };
		int index = 0;
		int duplicateElement = 0;
		while (index < nums.length) {
			if (nums[index] == index + 1) {
				index++;
			} else if (nums[nums[index] - 1] == nums[index]) {
				duplicateElement = nums[index];
				break;
			} else {
				int temp = nums[index];
				nums[index] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}
		System.out.println("Duplicate element is " + duplicateElement);
	}

	// using set with extra space on single iteration
	private static void type3() {
		int[] nums = { 1, 3, 4, 2, 2 };
		int duplicateElement = 0;
		Set<Integer> set = new HashSet<>();
		for (int item : nums) {
			if (set.contains(item)) {
				duplicateElement = item;
				break;
			}
			set.add(item);
		}
		System.out.println("Duplicate element is " + duplicateElement);
	}

	// count sort using extra space on a single iteration
	private static void type2() {
		int[] nums = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		int[] frequency = new int[length];
		int duplicateElement = 0;
		for (int item : nums) {
			frequency[item - 1]++;
			if (frequency[item - 1] > 1) {
				duplicateElement = item;
				break;
			}
		}
		System.out.println("Duplicate element is " + duplicateElement);
	}

	/// sort the array and check linear
	// time complexity O(n + n*log(n))
	private static void type1() {
		int[] nums = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				System.out.println("Duplicate element is " + nums[i]);
				break;
			}
		}
	}

	// brute force approach o(n^2)
	private static void type0() {
		int[] nums = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] == nums[j]) {
					System.out.println("Duplicate element is " + nums[i]);
				}
			}
		}
	}

}
