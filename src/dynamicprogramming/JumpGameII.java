package dynamicprogramming;

import java.util.Arrays;

/*
 * Problem link : 
 * https://leetcode.com/problems/jump-game-ii/description/
 * 
 * Solution is :
 * 
 * */
public class JumpGameII {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] nums = { 2, 3, 1, 1, 4 };
		int n = nums.length;
		int[] minPath = new int[n];
		Arrays.fill(minPath, 10000);
		minPath[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			int max = nums[i];
			for (int j = max; j > 0; j--) {
				if (i + j < n) {
					minPath[i] = Math.min(minPath[i], 1 + minPath[i + j]);
				}
			}
		}
		System.out.println(minPath[0]);
	}

}
