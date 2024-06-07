package com.problems.array;

/*
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
	}
	// optimized approach
	// traverse from the last
	// keeps track of the previous highest selling day
	private static void type2() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int max = 0;
		// storing the previous highest
		int highest = Integer.MIN_VALUE;
		for (int i = prices.length - 1; i >= 0; i--) {
			// the current price is greater than the previous price then
			if (prices[i] > highest) {
				highest = prices[i];
			} else {
				// the current price is lower than the previous price then
				// we can set the current index as the buying day as previous highest as the selling day
				// and calculate the profit
				max = Math.max(max, highest - prices[i]);
			}
		}
		System.out.println(max);

	}

	// brute force approach
	// for everyday we are checking its next highest day and calculate temporary profits
	// try to check for all i,j where i<j and arr[i]<arr[j]
	// o(n^2) time complexity
	private static void type1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int max = 0;
		int n = prices.length;
		// we will go from the last index and check for each day starting from 0th day to i-1 th day
		// and if jth price < ith price then we can buy at jth and sell at ith day
		for (int i = n - 1; i > 0; i--) {
			// now for ith day we will check for all day starting from 0th to i-1th day
			for (int j = 0; j < i; j++)
				if (prices[j] < prices[i]) // buy and sell possible
					max = Math.max(max, (prices[i] - prices[j]));// calculating the profit
		}
		System.out.println(max);
	}
}
