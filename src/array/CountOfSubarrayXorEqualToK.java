package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://www.interviewbit.com/problems/subarray-with-given-xor/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=lO9R5CaGRPY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=26
 * */
public class CountOfSubarrayXorEqualToK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// prefix xor
	// time complexity o(n)
	// space complexity O(n)
	// suppose in a range of 0..x1..x2 the xor is x2
	// and in the same range 0..x1 the xor is x1
	// the xor of in between elements(x1+1..x2) is k
	// we can say that x1 ^ k = x2
	// we can again xor both of the side by k
	// so x1 ^ k ^ k = x2 ^ k => x1 = x2 ^ k ( given that k ^ k = 0)
	// x1 = x2 ^ k
	// now we have everything just we have to find x1
	// we will compute xor in every element and store it in map with its count
	// also compute x1 and will check if its present in map or not
	// Please Note
	// prefixXor.put(0, 1); and if(xor==k) count++ has the same purpose
	// if we include prefixXor.put(0, 1) then, at xor==k and previousXor will be 0
	// then count = count + prefixXor.get(0); it will be automatically added
	// if we add if(xor==k) count++ then we will manually checking for k equality
	// at that time prefixXor.containsKey(0) will return false
	// count = count + prefixXor.get(0); will not be exexuted
	private static void type2() {
		int[] nums = { 4, 2, 2, 6, 4 };
		int k = 6;
		Map<Integer, Integer> prefixXor = new HashMap<>();
		int xor = 0, n = nums.length, count = 0, previousXor;
		prefixXor.put(0, 1);// zero prefix xor for empty sub array
		for (int i = 0; i < n; i++) {
			xor = xor ^ nums[i];
			previousXor = xor ^ k;
//			if (xor == k) {
//				count++;
//			}
			previousXor = xor ^ k;
			if (prefixXor.containsKey(previousXor)) {
				count = count + prefixXor.get(previousXor);
			}
			if (!prefixXor.containsKey(xor)) {
				prefixXor.put(xor, 1);
			} else {
				prefixXor.put(xor, prefixXor.get(xor) + 1);
			}
		}
		System.out.println("count is " + count);
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 4, 2, 2, 6, 4 };
		int k = 6;
		int xor = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = 0;
			for (int j = i; j < nums.length; j++) {
				xor = xor ^ nums[j];
				if (xor == k) {
					count++;
				}
			}
		}
		System.out.println("count is " + count);
	}

}
