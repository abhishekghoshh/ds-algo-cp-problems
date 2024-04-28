package com.problems.array;

/*
 *
 * problem links:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://www.codingninjas.com/codestudio/problems/893405
 * https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_6194560
 *
 * Solution link:
 * https://www.youtube.com/watch?v=eMSfBgbiEjk
 *
 * https://takeuforward.org/data-structure/stock-buy-and-sell/
 * */
public class BuyAndSellStock {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// we will scan from the left to right and see store the least price
	// time complexity is o(n)
	private static void type3() {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int maxProfit = 0;
		int lowestPriceIndex = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[lowestPriceIndex]) {
				maxProfit = Math.max(maxProfit, prices[i] - prices[lowestPriceIndex]);
			} else {
				lowestPriceIndex = i;
			}
		}
		System.out.println("The maximum profit is " + maxProfit);
	}

	// we will scan from the left to right and see store the least price
	// time complexity is o(n)
	private static void type2() {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		System.out.println("The maximum profit is " + maxProfit);
	}

	// brute force approach
	// try to check for all i,j where i<j and arr[i]<arr[j]
	// o(n`2) time complexity
	private static void type1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = 0;
		int n = prices.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (prices[i] < prices[j] && maxProfit < prices[j] - prices[i]) {
					maxProfit = prices[j] - prices[i];
				}
			}
		}
		System.out.println("The maximum profit is " + maxProfit);
	}

}
