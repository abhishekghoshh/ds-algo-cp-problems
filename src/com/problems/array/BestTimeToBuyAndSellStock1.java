package com.problems.array;

/*
 * problem links:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://www.codingninjas.com/codestudio/problems/893405
 * https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_6194560
 * https://www.naukri.com/code360/problems/stocks-are-profitable_893405
 *
 * Solution link:
 * https://www.youtube.com/watch?v=eMSfBgbiEjk
 * https://www.youtube.com/watch?v=excAOvwF_Wk&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=36
 *
 * https://takeuforward.org/data-structure/stock-buy-and-sell/
 * https://takeuforward.org/data-structure/stock-buy-and-sell-dp-35/
 * */
public class BestTimeToBuyAndSellStock1 {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// using dynamic programming
	// not necessarily required here, but it is a good practice to do a solution in a different way
	private static void type3() {
		int[] prices = {7, 11, 4, 1, 2};
		int n = prices.length;
		// finding for all 0..i profits
		int[] profits = new int[n];
		profits[0] = 0;
		int lowest = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] < lowest) lowest = prices[i];
			else profits[i] = prices[i] - lowest;
		}
		int proffit = 0;
		for (int cell : profits) if (proffit < cell) proffit = cell;
		System.out.println(proffit);
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
