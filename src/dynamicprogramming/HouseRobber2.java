package dynamicprogramming;

import util.SpaceUtil;

/*
 * Problem link :
 * https://leetcode.com/problems/house-robber-ii/
 * https://www.codingninjas.com/studio/problems/house-robber-ii_839733
 *
 * Solution link :
 * 
 *
 */
public class HouseRobber2 {

	public static void main(String[] args) {
		type1();

	}

	private static void type1() {
		int[] valueInHouse = { 6, 6, 4, 8, 4, 3, 3, 10 };
		valueInHouse = new int[] { 1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3 };
		int profits = rob(valueInHouse);
		System.out.println(profits);

	}

	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		else if (n == 2)
			return max(nums[0], nums[1]);
		else if (n == 3) {
			return max(nums[0], nums[1], nums[2]);
		} else {
			boolean[] hasUsedZeroHouse = new boolean[n];
			int[] profits = new int[n + 3];
			profits[0] = profits[1] = profits[2] = 0;
			for (int i = 0; i < n; i++) {
				int profitIndex = i + 3;
				int currentProfit = nums[i];
				if (i == 0) {
					profits[profitIndex] = currentProfit;
					hasUsedZeroHouse[i] = true;
				} else if (i == n - 1) {
					int j = i - 2;
					while (j > 0 && hasUsedZeroHouse[j]) {
						j--;
					}
					if (!hasUsedZeroHouse[j]) {
						profits[profitIndex] = currentProfit + profits[j + 3];
					}
				} else {
					if (profits[profitIndex - 2] >= profits[profitIndex - 3]) {
						profits[profitIndex] = currentProfit + profits[profitIndex - 2];
						if (i >= 2) {
							hasUsedZeroHouse[i] = hasUsedZeroHouse[i - 2];
						}
					} else {
						profits[profitIndex] = currentProfit + profits[profitIndex - 3];
						if (i >= 3) {
							hasUsedZeroHouse[i] = hasUsedZeroHouse[i - 3];
						}
					}
				}
			}
			debug(nums, hasUsedZeroHouse, profits);
			return max(profits[n - 1], profits[n], profits[n + 1], profits[n + 2]);
		}
	}

	private static void debug(int[] nums, boolean[] hasUsedZeroHouse, int[] profits) {
		System.out.print(SpaceUtil.withSpace("") + SpaceUtil.withSpace("") + SpaceUtil.withSpace(""));
		for (int i = 0; i < hasUsedZeroHouse.length; i++) {
			System.out.print(SpaceUtil.withSpace(hasUsedZeroHouse[i] ? 't' : 'f'));
		}
		System.out.println();
		System.out.print(SpaceUtil.withSpace("") + SpaceUtil.withSpace("") + SpaceUtil.withSpace(""));
		for (int i = 0; i < nums.length; i++) {
			System.out.print(SpaceUtil.withSpace(nums[i]));
		}
		System.out.println();
		for (int i = 0; i < profits.length; i++) {
			System.out.print(SpaceUtil.withSpace(profits[i]));
		}
		System.out.println();
	}

	public static int max(int... nums) {
		int max = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			max = max >= nums[i] ? max : nums[i];
		}
		return max;
	}

	
}
