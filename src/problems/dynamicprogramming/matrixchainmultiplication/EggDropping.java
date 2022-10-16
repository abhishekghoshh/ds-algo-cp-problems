package problems.dynamicprogramming.matrixchainmultiplication;

import java.util.HashMap;
import java.util.Map;

public class EggDropping {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int floors = 10;
		int eggs = 2;
		Map<String, Integer> memo = new HashMap<>();
		int minAttempts = eggDropping(floors, eggs, memo);
		System.out.println(minAttempts);
	}

	private static int eggDropping(int floors, int eggs, Map<String, Integer> memo) {
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
			int tempWorstAttemps = Math.max(eggDropping(i - 1, eggs - 1, memo), eggDropping(floors - i, eggs, memo));
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
