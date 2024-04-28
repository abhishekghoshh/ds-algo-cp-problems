package com.problems.array;
/*
 * problem link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Solution link :
 * 
 * Blog :
 * 
 * */

public class MaxProfit {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int buy = prices[0];
		int max = 0;
		for (int i : prices) {
			if (i < buy) buy = i;
			max = Math.max(max, i - buy);
		}
		System.out.println(max);
	}

	private static void type3() {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		System.out.println(maxProfit);
	}

	// optimized approach
	// traverse from the last
	// keeps track of the previous highest selling day
	private static void type2() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = 0;
		int prevHighest = Integer.MIN_VALUE;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (prices[i] > prevHighest) {
				prevHighest = prices[i];
			} else {
				if (prevHighest - prices[i] > maxProfit) {
					maxProfit = prevHighest - prices[i];
				}
			}
		}
		System.out.println(maxProfit);

	}

	// brute force approach
	// for everyday we are checking its next highest day and calculate temporary profits
	private static void type1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = 0;
		int n = prices.length;
		for (int i = 0; i < n - 1; i++) {
			int tempProfit = 0;
			for (int j = i + 1; j < n; j++)
				if (prices[j] > prices[i])
					tempProfit = Math.max(tempProfit, (prices[j] - prices[i]));
			maxProfit = Math.max(maxProfit, tempProfit);
		}
		System.out.println(maxProfit);
	}

}
