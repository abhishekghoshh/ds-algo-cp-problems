package com.ds.array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/majority-element/
 * https://www.codingninjas.com/codestudio/problems/842495
 * https://www.codingninjas.com/studio/problems/majority-element_6783241
 *
 * Solution link:
 * https://www.youtube.com/watch?v=nP_ns3uSh80
 * https://www.youtube.com/watch?v=AoX3BPWNnoE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=17
 * https://www.youtube.com/watch?v=OtCsBK7e4rk
 *
 * Https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 * */
/*
 * The majority element is the element that appears more than n / 2 times.
 * You may assume that the majority element always exists in the array.
 * */
public class MajorityElementsNby2 {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// moore's voting algorithm
	// let x is majority element means x is least n/2 + 1
	// so after all the calculation of count++ and count--
	// there will least be one element for which count will not be 0 at last
	// time complexity O(n)
	// space complexity O(1)
	private static void type3() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int answer = 0;
		int count = 0;
        for (int num : nums) {
            if (count == 0) {
                count = 1;
                answer = num;
            } else {
                if (answer == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
		System.out.println("Item is " + answer);
	}

	// frequency map approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int num = 0;
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int item : nums)
			if (!frequency.containsKey(item)) frequency.put(item, 1);
			else frequency.put(item, frequency.get(item) + 1);

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
		int answer = 0;
		int n = nums.length / 2;
		for (int num1 : nums) {
			int count = 0;
			for (int num2 : nums)
				if (num1 == num2)
					count++;
			if (count > n) {
				answer = num1;
				break;
			}
		}
		System.out.println("Item is " + answer);
	}

}
