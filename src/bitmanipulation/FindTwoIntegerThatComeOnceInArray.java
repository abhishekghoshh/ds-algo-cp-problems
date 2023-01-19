package bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/single-number-iii/
 * https://practice.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1
 * 
 * Solution link :
 * 
 * 
 */
public class FindTwoIntegerThatComeOnceInArray {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// time complexity O(2n)
	// space complexity O(1)
	// suppose our array is 1, 1, 2, 2, 3, 4, 4, 5
	// in xor it will be 3^5 and remaining num will be cancelled
	// 3^5 => 110
	// if we look closely then we will find there should be some 1 bit
	// in xor result any bit 1 only when one of the bit is 1 and other one is 0
	// suppose in ith bit there is 1
	// so we can create a mask where all the bit is 0 except the ith bit
	// and will create two bucket
	// some element will fall in the first and some will fall in second bucket
	// but if the single elements are x and y then we will surely know that they
	// will not fall in same bucket
	// remaining elements are in twice
	// so it does not matter they fall in which bucket
	// eventually they will beacome 0 as num^num = 0
	// and 0 is identity in xor operation
	private static void type2() {
		int[] nums = { 1, 1, 2, 2, 3, 4, 4, 5 };
		// xor will hold the xor value of all the elements
		int xor = 0;
		for (int num : nums) {
			xor = xor ^ num;
		}
		// we will extract the right most set bit which will also act as the mask
		int mask = xor & (~(xor - 1));
		int bucket1 = 0, bucket2 = 0;
		for (int num : nums) {
			if ((num & mask) == 0) {
				bucket1 = bucket1 ^ num;
			} else {
				bucket2 = bucket2 ^ num;
			}
		}
		List<Integer> list = List.of(bucket1, bucket2);
		System.out.println(list);
	}

	// brute force
	// time complexity O(2n)
	// space complexity O(n)
	private static void type1() {
		int[] nums = { 1, 1, 2, 2, 3, 4, 4, 5 };
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			if (!freq.containsKey(num)) {
				freq.put(num, 1);
			} else {
				freq.put(num, freq.get(num) + 1);
			}
		}
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() == 1) {
				list.add(entry.getKey());
			}
		}
		System.out.println(list);
	}

}
