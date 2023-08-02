package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem link :
 * https://leetcode.com/problems/missing-number
 * 
 * Solution link :
 * 
 * 
 * */
public class MissingNumber {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// as 1^1 = 0
	// so if we xor all number in array and 
	// also with the 0-n 
	// then we will do xor for 2n+1 number
	// out of which only one number is occurring 1 times
	private static void type2() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int n = nums.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = res ^ nums[i];
		}
		for (int i = 0; i <= n; i++) {
			res = res ^ i;
		}
		System.out.println(res);
	}

	private static void type1() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int n = nums.length;
		int res = -1;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
		}
		for (int i = 0; i <= n; i++) {
			if (!set.contains(i)) {
				res = i;
			}
		}
		System.out.println(res);
	}

}
