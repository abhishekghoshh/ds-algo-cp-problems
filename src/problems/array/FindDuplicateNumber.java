package problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/1112602?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=1
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
	// if two links matches 
	private static void type5() {
		// int nums[] = { 1, 3, 4, 2, 8, 6, 5, 9, 8, 10, 11 };
		int nums[] = { 1, 3, 4, 2, 2 };
		int slow, fast;
		slow = nums[0];
		fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		System.out.println("Duplicate element is " + slow);
	}

	// swap sort without using extra space
	// given array must be mutable
	private static void type4() {
		int nums[] = { 1, 3, 4, 2, 2 };
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
		int nums[] = { 1, 3, 4, 2, 2 };
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
		int nums[] = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		int frequency[] = new int[length];
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

	/// sort the array and check linearly
	// time complexity O(n*log(n))
	private static void type1() {
		int nums[] = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				System.out.println("Duplicate element is " + nums[i]);
				break;
			}
		}
	}

	// brute force approach o(n`2)
	private static void type0() {
		int nums[] = { 1, 3, 4, 2, 2 };
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
