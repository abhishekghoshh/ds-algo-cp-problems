package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/842495?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/majority-element/
 * 
 * Solution link : https://www.youtube.com/watch?v=AoX3BPWNnoE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=17
 * 
 * */
/*
 * The majority element is the element that appears more than n / 2 times. You may assume that the majority element always exists in the array.
 * */
public class MajorityElementsNby2 {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// moore's voting algorithm
	// let x is majority element means x is atleast n/2 + 1
	// so after all the calculation of count++ and count--
	// there will atleast be one element for which count will not be 0 at last
	// time complexity O(n)
	// space complexity O(1)
	private static void type3() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int num = 0;
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				count = 1;
				num = nums[i];
			} else {
				if (num == nums[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		System.out.println("Item is " + num);
	}

	// frequency map approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int num = 0;
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int item : nums) {
			if (!frequency.containsKey(item)) {
				frequency.put(item, 1);
			} else {
				frequency.put(item, frequency.get(item) + 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			if (entry.getValue() > nums.length / 2) {
				num = entry.getKey();
				break;
			}
		}
		System.out.println("Item is " + num);
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
			if (count > nums.length / 2) {
				num = nums[i];
				break;
			}
		}
		System.out.println("Item is " + num);
	}

}
