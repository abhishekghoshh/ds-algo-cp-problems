package com.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/super-egg-drop/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=S49zeUjeUL0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=42
 * https://www.youtube.com/watch?v=gr2NtY-2QUY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=43
 * https://www.youtube.com/watch?v=jkygQmOiCCI&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=44
 * 
 */
public class EggDropping {
	// You are given k identical eggs and you have access to a building with n
	// floors labeled from 1 to n.
	// You know that there exists a floor f where 0 <= f <= n such that any egg
	// dropped at a floor higher than f will break, and any egg dropped at or below
	// floor f will not break.
	// Each move, you may take an unbroken egg and drop it from any floor x
	// (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if
	// the egg does not break, you may reuse it in future moves.
	// Return the minimum number of moves that you need to determine with certainty
	// what the value of f is.
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// TODO check leetcode solution
	// https://leetcode.com/problems/super-egg-drop/solution/
	private static void type3() {

	}

	private static void type2() {
		int floors = 10;
		int eggs = 2;
		Map<String, Integer> memo = new HashMap<>();
		int[][] dp = new int[floors][eggs];
		int minAttempts = eggDropping(floors, eggs, memo, dp);
		System.out.println(minAttempts);
	}

	private static int eggDropping(int floors, int eggs, Map<String, Integer> memo, int[][] dp) {
		String key = floors + "_" + eggs;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		if (floors <= 1) {
			return floors;
		}
		if (eggs == 1) {
			return floors;
		}
		int minAttempts = Integer.MAX_VALUE;
		for (int i = 1; i <= floors; i++) {
			int tempWorstAttemps = Math.max(eggDropping(i - 1, eggs - 1, memo, dp),
					eggDropping(floors - i, eggs, memo, dp));
			if (tempWorstAttemps < minAttempts) {
				minAttempts = tempWorstAttemps;
			}
		}
		memo.put(key, minAttempts + 1);
		return minAttempts + 1;
	}

	private static void type1() {
		int floors = 10;
		int eggs = 2;
		int minAttempts = eggDropping(floors, eggs);
		System.out.println(minAttempts);
	}

	private static int eggDropping(int floors, int eggs) {
		if (floors <= 1) {
			return floors;
		}
		if (eggs == 1) {
			return floors;
		}
		int minAttempts = Integer.MAX_VALUE;
		for (int i = 1; i <= floors; i++) {
			int tempWorstAttemps = Math.max(eggDropping(i - 1, eggs - 1), eggDropping(floors - i, eggs));
			if (tempWorstAttemps < minAttempts) {
				minAttempts = tempWorstAttemps;
			}
		}
		return minAttempts + 1;
	}
}
